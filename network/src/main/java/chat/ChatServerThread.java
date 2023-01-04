package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ChatServerThread extends Thread{
    private String nickname = null;
    private Socket socket = null;
    List<PrintWriter> userlist = null;

    public ChatServerThread(Socket socket, List<PrintWriter> listWriters) {
        this.socket = socket;
        this.userlist = listWriters;
    }
    @Override
    public void run() {
        try {
        	InputStreamReader isr = new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8);
            BufferedReader buffereedReader = new BufferedReader(isr);
            OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
            PrintWriter printWriter = new PrintWriter(out);

            while(true) {
                String request = buffereedReader.readLine();

                if( request == null) {
                    consoleLog("클라이언트로부터 연결 끊김");
                    doQuit(printWriter);
                    break;
                }

                String[] tokens = request.split(":");
                if("join".equals(tokens[0])) {

                    doJoin(tokens[1], printWriter);
                }
                else if("message".equals(tokens[0])) {
                    doMessage(tokens[1]);
                }
                else if("quit".equals(tokens[0])) {
                    doQuit(printWriter);
                }
            }
        }
        catch(IOException e) {
            consoleLog(this.nickname + "님이 채팅방을 나갔습니다.");
        }
    }

    private void doQuit(PrintWriter writer) {
        removeWriter(writer);

        String data = this.nickname + "님이 퇴장했습니다.";
        broadcast(data);
    }

    private void removeWriter(PrintWriter writer) {
        synchronized (userlist) {
        	userlist.remove(writer);
        }
    }

    private void doMessage(String data) {
        broadcast(this.nickname + ":" + data);
    }

    private void doJoin(String nickname, PrintWriter writer) {
        this.nickname = nickname;

        String data = nickname + "님이 입장하였습니다.";
        consoleLog(data);
        broadcast(data);
        addWriter(writer);
    }

    private void addWriter(PrintWriter writer) {
        synchronized (userlist) {
        	userlist.add(writer);
        }
    }

    private void broadcast(String data) {
        synchronized (userlist) {
            for(PrintWriter writer : userlist) {
                writer.println(data);
                writer.flush();
            }
        }
    }

    private void consoleLog(String log) {
        System.out.println(log);
    }
}