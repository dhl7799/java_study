package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ChatServerThread extends Thread{
    private String nickname = null;
    private Socket socket = null;
    List<PrintWriter> userlist = null;
    List<String> usernames = null;
    public ChatServerThread(Socket socket, List<PrintWriter> listWriters, List<String> usernames) {
        this.socket = socket;
        this.userlist = listWriters;
        this.usernames = usernames;
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
                	if(this.nickname.equals(usernames.get(0))) {
                		if(tokens[1].equals("ban"))
            			{
            				ban(tokens[2]);
            			}
            			else if(tokens[1].equals("quite"))
            			{
            				quite(tokens[2]);
            			}
            			else if(tokens[1].equals("cancel"))
            			{
            				cancel(tokens[2]);
            			}
                		else {
                    			doMessage(tokens[1]);
                		}
                	}
                	else{
                		doMessage(tokens[1]);
                	}
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
    
    private int getNameIndex(String name) {
    	return usernames.indexOf(name);
    }
    
    private void removeWriter(PrintWriter writer) {
    	synchronized (usernames) {
        	usernames.remove(nickname);
        }
        synchronized (userlist) {
        	userlist.remove(writer);
        }
        
    }

    private void doMessage(String data) {
    	if(this.nickname.equals(usernames.get(0))) {
    		broadcast(this.nickname + "(방장):" + data);
    	}
    	else {
    		broadcast(this.nickname + ":" + data);
    	}
        
    }
    
    private void doJoin(String nickname, PrintWriter writer) {
    	String duplicated = "@";
    	synchronized (usernames) {
        	while(usernames.contains(nickname)) {
        		nickname += duplicated;
        	}
        	usernames.add(nickname);
        }
        this.nickname = nickname;
        String data = nickname + "님이 입장하였습니다.";
        consoleLog(data);
        broadcast(data);
        addWriter(writer);
        synchronized (userlist) {
        	if(userlist.size()==1) {
        		String data1 = nickname + "님이 방장입니다.";
        		consoleLog(data1);
                broadcast(data1);
        		userlist.get(0).println("ban:닉네임 = 강퇴, quite:닉네임 = 벙어리, cancel:닉네임 = 벙어리 해제");
                
                
        	}
        }
        
    }
    
    private void setquitename(String name) {
    	int index = getNameIndex(name);
    	synchronized (userlist) {
        	userlist.get(index).println("!@#quite!@#");
        }
    }
    private void setquiteCancelname(String name) {
    	int index = getNameIndex(name);
    	synchronized (userlist) {
        	userlist.get(index).println( "!@#cancel!@#");
        }
    }
   
    private void quite(String name) {
    	int index = usernames.indexOf(name);
    	if(index == -1) {
			userlist.get(0).println("없는 유저입니다");
			userlist.get(0).flush();
		}
		else {
			broadcast("방장이 " + usernames.get(index) + "님을 벙어리 하였습니다.");
			setquitename(usernames.get(index));
		}
    }
    
    private void cancel(String name) {
    	int index = usernames.indexOf(name);
    	if(index == -1) {
			userlist.get(0).println("없는 유저입니다");
			userlist.get(0).flush();
		}
		else {
			broadcast("방장이 " + usernames.get(index) + "님을 벙어리 해제 하였습니다.");
			setquiteCancelname(usernames.get(index));
		}
    }

    private void ban(String name) {
    	int index = usernames.indexOf(name);
		if(index == -1) {
			userlist.get(0).println("없는 유저입니다");
			userlist.get(0).flush();
		}
		else {
			broadcast("방장이 " + usernames.get(index) + "님을 강퇴하였습니다.");
			String request = "!@#BAN!@#";
			userlist.get(index).println(request);
		}
		
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