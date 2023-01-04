package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    public static final int PORT = 8000;
    public static final String hostAddress = "0.0.0.0";
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        List<PrintWriter> userlist = new ArrayList<PrintWriter>();

        try {
     
            serverSocket = new ServerSocket();

            
            serverSocket.bind( new InetSocketAddress(hostAddress, PORT) );
            consoleLog("연결 기다림 - " + hostAddress + ":" + PORT);

            
            while(true) {
                Socket socket = serverSocket.accept();
                ChatServerThread CST = new ChatServerThread(socket, userlist);
                CST.start();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if( serverSocket != null && !serverSocket.isClosed() ) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void consoleLog(String log) {
        System.out.println("[server " + Thread.currentThread().getId() + "] " + log);
    }
}