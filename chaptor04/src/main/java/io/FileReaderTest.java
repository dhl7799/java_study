package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class FileReaderTest {

	public static void main(String[] args) {
		Reader in = null;
		InputStream is = null;
		try {
			in = new FileReader("text.txt");
			
			int count = 0;
			int data = -1;
			while((data = in.read()) != -1) {
				System.out.print((char)data);
				count++;
			}
			
			System.out.println("\n" + "count: " + count);
			System.out.println("=============================");
			/*
			count = 0;
			data = -1;
			is = new FileInputStream("text.txt");
			byte[] code = new byte[3];
			int c = -1;
			while((data = is.read()) != -1) {
				c++;
				code[c] = (byte)data;
				if(c == 2) {
					System.out.print((char)data);
					code[0] = 0;
					code[1] = 0;
					code[2] = 0;
					c = -1;
				}
				count++;
			}
			System.out.println("\n" + "count: " + count);*/
			
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found:" + e);
		} catch(IOException e) {
			System.out.println("Error:" +e);
		}
		finally {
			try {
				if(in !=null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
