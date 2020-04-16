package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileTest {

	public static void main(String[] args) {
			FileReader a=null;
			FileWriter b =null;
		
			try {
			a = new FileReader("c:/C_Other/Tulips.jpg");
			
		
			b = new FileWriter("c:/C_Other/복사본_Tulips.jpg");
			
			int c;
			
			while((c= a.read()) != -1) {
				b.write(c);
			}
			System.out.println("작업 끝");
			
			a.close();
			b.close();
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		
	}
}
