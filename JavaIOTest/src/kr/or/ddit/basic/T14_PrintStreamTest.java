package kr.or.ddit.basic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

public class T14_PrintStreamTest {

	public static void main(String[] args) throws IOException {
	
		FileOutputStream fos = new FileOutputStream("c:/C_Other/print.txt");
		FileOutputStream fos2 = new FileOutputStream("c:/C_Other/print2.txt");
		
		//PrintStream은 모든 자료형을 출력할 수 있는 기능을 제공하는 OutputStream의 서브 클래스
		// 또한 PrintStream은 IOException을 발생시키지 않는다.
		//println()과 print()등 메서드 호출시마다 autoflush 기능 제공됨
		PrintStream out = new PrintStream(fos);
		//PrintStream out = new PrintStream(System.out); // 콘솔 출력스트림으로 사용
		
		out.print("안녕하세요 PrintStream입니다 \n");
		out.println("안녕하세요 PrintStream입니다.2");
		out.println("안녕하세요 PrintStream입니다.3");
		out.println(out);
		
		out.close();
		
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(fos2, "UTF-8")); //인코딩을 미리 해줄수있음
		writer.print("안녕하세요 PrintWriter 입니다 \r\n"); //윈도우에서 한줄 엔터
		writer.println("안녕하세요 PrintWriter 입니다2.");
		writer.println("안녕하세요 PrintWriter 입니다3.");
		
		writer.close();
		
	}
}
