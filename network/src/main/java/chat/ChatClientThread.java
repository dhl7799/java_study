package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class ChatClientThread extends Thread{
	private static Scanner scanner = new Scanner(System.in);
	Socket socket = null;
	
	public ChatClientThread(Socket socket) { 
		this.socket = socket; 
		new ChatClientReadThread().start();
	}
	
	@Override
    public void run() {
		try {
			while(true) { 
				sendMessage();
			}
			
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	
	}
	
	private class ChatClientReadThread extends Thread{
		@Override
		public void run() {
			try {
				InputStreamReader isr = new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8);
				BufferedReader reader = new BufferedReader(isr);
		
				while(true) { 
					System.out.println(reader.readLine());
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
    }
	private void sendMessage() {
        PrintWriter pw;
        try {
        	OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
            pw = new PrintWriter(out, true);
            String message = scanner.nextLine();
            if(message.equals("!quit")) {
            	String request = "quit\r\n";
                pw.println(request);
                System.exit(0);
            }
            else {
            	String request = "message:" + message + "\r\n";
                pw.println(request);
            }
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
