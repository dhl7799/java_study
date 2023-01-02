package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

import echo.EchoServer;

public class ChatClient extends Thread{
	private static final String SERVER_IP = "127.0.0.1";
	Socket socket = null;
	Scanner scanner = new Scanner(System.in); // 채팅용 Scanner
	
	public ChatClient(Socket socket) { // 생성자
    		// 받아온 Socket Parameter를 해당 클래스 Socket에 넣기
		this.socket = socket; 
	}
	
	public void run() {
		try {
			// OutputStream - 클라이언트에서 Server로 메세지 발송 
            		// socket의 OutputStream 정보를 OutputStream out에 넣은 뒤
			OutputStream out = socket.getOutputStream();
            		// PrintWriter에 위 OutputStream을 담아 사용
			PrintWriter writer = new PrintWriter(out, true);
			
			while(true) { // 무한반복
				writer.println(scanner.nextLine()); // 입력한 메세지 발송
			}
			
		} catch (Exception e) {
			e.printStackTrace(); // 예외처리
		}
		
		
	}
	public static void main(String[] args) {
		try {
			Socket socket = null;
            		// 소켓 서버에 접속
			socket = new Socket(SERVER_IP, ChatServer.PORT); 
			System.out.println("입장하였습니다. 즐거운 채팅되세요"); // 접속 확인용
			
            // 서버에서 보낸 메세지 읽는 Thread
			//ListeningThread t1 = new ListeningThread(socket);
			//WritingThread t2 = new WritingThread(socket); // 서버로 메세지 보내는 Thread
			ChatClient cc = new ChatClient(socket);
			ChatClientThread ct = new ChatClientThread(socket);
			//t1.start(); // ListeningThread Start
			//t2.start(); // WritingThread Start
			cc.start();
			ct.start();
            
		} catch (IOException e) {
			e.printStackTrace(); // 예외처리
		}
	}
	
}
