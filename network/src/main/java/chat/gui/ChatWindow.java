package chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ChatWindow {
    private String name;
    private Frame frame;
    private Panel pannel;
    private Button buttonSend;
    private TextField textField;
    private TextArea textArea;
    private boolean quite = false;
    private Socket socket;

    public ChatWindow(String name, Socket socket) {
        this.name = name;
        frame = new Frame(this.name);
        pannel = new Panel();
        buttonSend = new Button("Send");
        textField = new TextField();
        textArea = new TextArea(30, 80);
        this.socket = socket;

        new ChatClientReadThread(socket).start();
    }

    public void show() {
        // Button
        buttonSend.setBackground(Color.GRAY);
        buttonSend.setForeground(Color.WHITE);
        buttonSend.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent actionEvent ) {
                sendMessage();
            }
        });


        // Textfield
        textField.setColumns(80);
        textField.addKeyListener( new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                char keyCode = e.getKeyChar();
                if (keyCode == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });

        // Pannel
        pannel.setBackground(Color.LIGHT_GRAY);
        pannel.add(textField);
        pannel.add(buttonSend);
        frame.add(BorderLayout.SOUTH, pannel);

        // TextArea
        textArea.setEditable(false);
        frame.add(BorderLayout.CENTER, textArea);

        // Frame
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                PrintWriter pw;
                try {
                    pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
                    String request = "quit\r\n";
                    pw.println(request);
                    System.exit(0);
                }
                catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        frame.setVisible(true);
        frame.pack();
    }

   
    private void sendMessage() {
        PrintWriter pw;
        try {
            pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
            String message = textField.getText();
            
            if(message.equals("!quit")) {
            	String request = "quit\r\n";
                pw.println(request);
                System.exit(0);
            }
            else if(quite) {
            	String request = "message:" + "벙어리된 메세지입니다." + "\r\n";
                pw.println(request);
                textField.setText("");
                textField.requestFocus();
            }
            else {
            	String request = "message:" + message + "\r\n";
                pw.println(request);
                textField.setText("");
                textField.requestFocus();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ChatClientReadThread extends Thread{
        Socket socket = null;

        ChatClientReadThread(Socket socket){
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
				PrintWriter pw = new PrintWriter(out, true);
                while(true) { 
					String line = reader.readLine();
					if(line.equals("!@#BAN!@#")) {
						String request = "quit\r\n";
		                pw.println(request);
		                System.exit(0);
					}
					else if(line.equals("!@#quite!@#")) {
						quite = true;
					}
					else if(line.equals("!@#cancel!@#")) {
						quite = false;
					}
					else {
						System.out.println(line);
						textArea.append(line);
	                    textArea.append("\n");
					}
				}
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}