package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class PhoneList01 {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			File file = new File("phone.txt");
		
			System.out.println("=======파일정보=======");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + " bytes"); //byte 단위
			System.out.println(file.lastModified());
			//Date d = new Date(file.lastModified());
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//String date = sdf.format(d);
			//System.out.println(date);
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified())));

			System.out.println("=======전화번호=======");
		
			//1.기반 스트림(FileInputStream)
			FileInputStream fis = new FileInputStream(file);
			
			//2.보조 스트림(byte|byte|byte -> char)
			InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
			
			//3.보조 스트림2(char|char|char|char|char|\n -> "char1char2char3char4")
			br = new BufferedReader(isr);
			
			//4. 처리
			String line = null;
			while((line = br.readLine()) != null) {
				//System.out.println(line);
				StringTokenizer st = new StringTokenizer(line, "\t ");
				int index = 0;
				while(st.hasMoreElements()) {
					String token = st.nextToken();
					//이름
					if(index ==0) {
						System.out.print(token + ":");
					}
					//전화번호 1
					else if(index == 1){
						System.out.print(token + ":");
					}
					//전화번호 2
					else if(index == 2){
						System.out.print(token + ":");
					}
					//전화번호 3
					else{
						System.out.print(token);
					}
					
					
					index++;
				}
				System.out.println();
			}
			
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("Error: " + e);
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}  finally{
			try {
				if(br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
