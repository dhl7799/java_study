package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.io.PrintWriter;

import java.net.Socket;
import java.net.SocketException;

import java.util.ArrayList;


public class ChatServerThread extends Thread {
	static ArrayList<Socket> userlist = new ArrayList<Socket>(); 
	Socket socket = null;
	
	public ChatServerThread(Socket socket) {
		this.socket = socket; 
		userlist.add(socket); 
	}
	@Override
	public void run() {
		try {
        	// 연결 확인용
			System.out.println("서버 : " + socket.getInetAddress() 
            						+ " IP의 클라이언트와 연결되었습니다");
			
			// InputStream - 클라이언트에서 보낸 메세지 읽기
			InputStream input = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			
			// OutputStream - 서버에서 클라이언트로 메세지 보내기
			OutputStream out = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(out, true);
			
			// 클라이언트에게 연결되었다는 메세지 보내기
			writer.print("닉네임>>");
			
			String data = null; // Client에서 보낸 값 저장
			String name = null; // 클라이언트 이름 설정용
			boolean identify = false;
			
            // 클라이언트가 메세지 입력시마다 수행
			while((data = reader.readLine()) != null ) {
				if(!identify) { // 연결 후 한번만 노출
					name = data; // 이름 할당
					identify = true;
					writer.println(name + "님이 입장하였습니다 즐거운 채팅되세요.");
					continue;
				}
				
                // list 안에 클라이언트 정보가 담겨있음
				for(int i = 0; i<userlist.size(); i++) { 
					out = userlist.get(i).getOutputStream();
					writer = new PrintWriter(out, true);
                    // 클라이언트에게 메세지 발송
					writer.println(name + " : " + data); 
				}
			}
		} catch(SocketException ex) {
			System.out.println("[server] suddenly closed by client");
		} catch(IOException ex) {
			log("error:" + ex);
		} finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}   		
    }
	private static void log(String message) {
		System.out.println("[EchoServer] " + message);
	}

}

