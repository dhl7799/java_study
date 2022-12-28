package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		try {
			String line = null;
			//InetAddress inetAddress = InetAddress.getLocalHost();
			boolean notquit = true;
			while(notquit) {
				System.out.println("주소를 입력하세요(종료하려면 quit 입력)");
				line = sc.nextLine();
				String Addressline = "";
				if(line.equals("quit")){
					notquit = false;
					System.out.println("프로그램을 종료합니다");
				}
				else {
					InetAddress[] inetAddresses = InetAddress.getAllByName(line);
					
					
					for(int i=0; i<inetAddresses.length;i++) {
						Addressline += inetAddresses[i];
					}
					String[] forprint = Addressline.split("/");
					System.out.println("서버:\t" + forprint[0]);
					System.out.println("Address: " + forprint[1]);
				}
				
				
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sc != null)
				sc.close();
		}
		
	}

}
