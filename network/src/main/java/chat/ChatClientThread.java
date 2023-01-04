package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


public class ChatClientThread extends Thread{
	private String name = null;
	Socket socket = null;
	
	public ChatClientThread(Socket socket, String name) { 
		this.socket = socket; 
		this.name = name;
	}
	
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
	
			while(true) { 
				System.out.println(reader.readLine());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
