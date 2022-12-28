package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {

	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			System.out.println(inetAddress.getLocalHost());
			//컴퓨터 이름, String
			System.out.println(inetAddress.getHostName());
			System.out.println(inetAddress.getHostAddress());
			System.out.println(inetAddress.getAddress());
			
			byte[] IpAddresses = inetAddress.getAddress();
			for(int i=0; i<IpAddresses.length;i++) {
				System.out.print(IpAddresses[i]&0x000000ff);
				if(i != IpAddresses.length-1)
					System.out.print(".");
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
