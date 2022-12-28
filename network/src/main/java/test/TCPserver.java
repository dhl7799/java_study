package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPserver {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			//1. 서버소캣 생성
			serverSocket = new ServerSocket();
			
			//2. 바인딩
			// 서버소켓에 InetSocketAddress(ip address + port)를 바인딩한다
			// 젤 좋은건 0.0.0.0으로 해놓는것, 다른건 아이피 달라지면 연결안됨
			// IPAddress: 0.0.0.0 특정 호스트 ip에 바인딩하지 않는다
			//serverSocket.bind(new InetSocketAddress(InetAddress.getLocalHost().getHostAddress(),5000)); //해당되는 ip 넣어주기
			serverSocket.bind(new InetSocketAddress("0.0.0.0",5000)); //모든걸로 다됨
			
			//3. accept
			//serverSocket는 accept 하는 용임 이후는 socket으로함
			Socket socket = serverSocket.accept(); //blocking
			
			
			try {
					InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress(); //다운캐스트
					
					String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
					int remotePort = inetRemoteSocketAddress.getPort();
					System.out.println("[server] connected by client[ " + remoteHostAddress + ", " + remotePort +" ]");
					
					//4. IO Stream 받아오기
					OutputStream os = socket.getOutputStream();
					InputStream is = socket.getInputStream();
					
					//5. 데이터 읽기
					while(true) {
						byte[] buffer = new byte[256];
						
						int readbytecount = is.read(buffer); //blocking
						if(readbytecount == -1) {
							System.out.println("[server] closed by client");
							break;
						}
						String data = new String(buffer,0,readbytecount,"UTF-8");
						System.out.println("[server] received: " + data);
					}
					
				} catch(IOException ex) {
					System.out.println("[server] error: " + ex);
				} finally {
					try {
						if(socket != null && !socket.isClosed())
							socket.close();
					} catch(IOException ex) {
						ex.printStackTrace();
					}
				}
		} catch (IOException e) {
			System.out.println("[server] error: " + e);
		} finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed())
					serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
