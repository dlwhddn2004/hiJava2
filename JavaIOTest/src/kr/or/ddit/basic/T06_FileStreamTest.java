package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class T06_FileStreamTest {
	public static void main(String[] args) {
		//파일에 출력하기
		FileOutputStream fos = null;
		
		try {
			//출력용 OutputStream객체 생성
			fos = new FileOutputStream("c:/C_Other/out.txt");
			for(char ch='A'; ch<='Z'; ch++) {
				fos.write(ch);
			}
		System.out.println("파일에 쓰기 작업 완료");
		//쓰기 작업 완료후 스트림 닫기
		fos.close();
		//=======================================
		
		
		//저장된 파일의 내용을 읽어와 화면에 출력하기
		FileInputStream fis = new FileInputStream("c:/C_Other/out.txt");
		
		int c;
		while ((c= fis.read()) != -1) {
			System.out.print((char) c);
			
		}
		
		System.out.println();
		System.out.println("출력 끝...");
		fis.close();
	
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
