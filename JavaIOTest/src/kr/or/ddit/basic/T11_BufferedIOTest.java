package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class T11_BufferedIOTest {

	public static void main(String[] args) {
		//입출력의 성능향상을 위해서 버퍼를 이용하는 보조 스트림 byte기반
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null; //buffer 임시저장
		
		try {
			fos = new FileOutputStream("c:/C_Other/bufferTest.txt");
			
			//버퍼의 크기를 지정하지 않으면 기본적으로 버퍼크기가 
			//8192byte(8kb)로 설정된다.
			
			//버퍼크기가 5인 스트림 생성  fos는 기본스트림 , 보조는 무조건 기본스트림이 있어야함
			bos = new BufferedOutputStream(fos, 5);
			for(int i='1'; i<='9'; i++) {
				bos.write(i); //기본스트림인 FileOutputStream은 봐로 파일에 입력되지만 
							  // 보조인 버퍼는 5개의 저장공간을 가지고있어서 저장공간이 Full이 되면 파일에 입력하고 다시 받는다.
							  // 하지만 그럴경우 1~9 에서 1~5/ 6 ~ 10 이 되야 출력지만 저장공간에 1곳이남아있어서 출력안함.
							  // 그럴때 꽉 안찾지만 강제로 방출시키는 flush 메소드를 이용한다.
			}
		
			bos.flush(); //작업을 종료하기 전에 버퍼에 남아있는 데이터를 모두 출력시킨다.
			
			bos.close();
			System.out.println("작업 끝");
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
