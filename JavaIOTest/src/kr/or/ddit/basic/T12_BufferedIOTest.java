package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class T12_BufferedIOTest {

	public static void main(String[] args) {
		//문자기반의 BufferedStream 사용 예제
		
		try {
			//이클립스에서 만든 자바 프로그램이 실행되는 기본 위치는
			//해당 '프로젝트폴더'가 기본 위치가 된다.
			FileReader fr = new FileReader("./src/kr/or/ddit/basic/T11_BufferedIOTest.java");
			
		/*	int c;
			while((c=fr.read()) != -1) {
				System.out.print((char)c);
			} */
			
			//한줄씩 읽을 수 있도록 해주는 readLine을 이용하기 위해 BufferedReader사용
			BufferedReader br = new BufferedReader(fr); //보조 reader 문자
			String temp = "";
			
			for(int i=1; (temp=br.readLine())!= null; i++) {
				System.out.printf("%4d : %s\n", i, temp);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
