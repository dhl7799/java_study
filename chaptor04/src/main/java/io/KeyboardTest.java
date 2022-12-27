package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class KeyboardTest {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
		//1. 기반스트림(표준입력,stdin,System.in)
		
		//2.보조 스트림(byte|byte|byte -> char)
		 
		
		 InputStreamReader isr = new InputStreamReader(System.in,"UTF-8");
		
		
		//3.보조 스트림2(char|char|char|char|char|\n -> "char1char2char3char4")
		br = new BufferedReader(isr);
		
		String line = null;
		while((line = br.readLine()) != null) {
			if("quit".equals(line)) {
				break;
			}
			System.out.println(line);
		}
		
		} catch (IOException e) {
			System.out.println("Error: " + e);
		} finally {
			try {
				if(br != null)
					br.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

	}

}
