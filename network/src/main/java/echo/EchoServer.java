package echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static final int PORT = 8000;
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			
			serverSocket = new ServerSocket();
			
			
			serverSocket.bind(new InetSocketAddress("0.0.0.0",PORT)); 
			System.out.println("[server] starts....[port:" + PORT +"]");
			
			
			Socket socket = serverSocket.accept(); 
			
			
			
			try {
					InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress(); //다운캐스트
					
					String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
					int remotePort = inetRemoteSocketAddress.getPort();
					System.out.println("[server] connected by client[ " + remoteHostAddress + ", " + remotePort +" ]");
					
					
					OutputStream os = socket.getOutputStream();
					InputStream is = socket.getInputStream();
					
					
					while(true) {
						byte[] buffer = new byte[256];
						
						int readbytecount = is.read(buffer); //blocking
						if(readbytecount == -1) {
							System.out.println("[server] closed by client");
							break;
						}
						String data = new String(buffer,0,readbytecount,"UTF-8");
						System.out.println("[server] received: " + data);
						
						os.write(data.getBytes("UTF-8"));
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
