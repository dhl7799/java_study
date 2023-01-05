package chat;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChatClient{
    private static final String SERVER_IP = "0.0.0.0";
    private static final int SERVER_PORT = 8000;
    private static Scanner scanner = new Scanner(System.in);
    
    
    public ChatClient() {}
  
    public static void main(String[] args) {
        String name = null;
        Socket socket = null;
        
        while( true ) {
            System.out.println("닉네임을 입력하세요.");
            System.out.print(">>> ");
            name = scanner.nextLine();

            if (name.isEmpty() == false ) {
                break;
            }
            System.out.println("똑바로 입력하세요.\n");
        }
        try {
        	socket = new Socket();
        
            socket.connect( new InetSocketAddress(SERVER_IP, SERVER_PORT) );
            consoleLog("채팅방에 입장하였습니다.");
            ChatClientThread chat = new ChatClientThread(socket);
            chat.start();
            OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
            PrintWriter pw = new PrintWriter(out, true);
            String request = "join:" + name + "\r\n";
            pw.println(request);
            
            
        }catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    private static void consoleLog(String log) {
        System.out.println(log);
    }
    
    
}