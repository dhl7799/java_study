package chat;

import java.io.IOException;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class ChatServer {
	public static final int PORT = 8000;
	

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
            
            serverSocket = new ServerSocket(); // 서버 소켓
            serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT), 10); //바인드
            // 서버 오픈
            log("starts...[port:" + PORT + "]");
	
            
            while(true) {
                Socket socketUser = serverSocket.accept(); // 클라이언트 접속
                
                Thread thd = new ChatServerThread(socketUser);
                thd.start(); // ChatServerThread 시작
            }                 
  
		} catch (IOException e) {
			log("error:" + e);
		} finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void log(String message) {
		System.out.println("[EchoServer] " + message);
	}

}
