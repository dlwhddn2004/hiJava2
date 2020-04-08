package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 기본 타입 입출력 보조 스트림 예제
 */
public class T13_DataIOStreamTest {

	public static void main(String[] args) {
		try {
			FileOutputStream fos= new FileOutputStream("c:/C_Other/test.dat");
		
			//DataOutputStream은 출력용 데이터를 자료형에 맞게 출력해 준다.
			 DataOutputStream dos = new DataOutputStream(fos);
			 
			 dos.writeUTF("홍길동"); //문자열 데이터 출력 데이터를 타입별로 읽어줘서 손쉽게 파일처리가능
			 dos.writeInt(17); 		//정수형으로 데이터 출력
			 dos.writeFloat(3.14f); //실수형(Float)으로 출력
			 dos.writeDouble(3.14); //실수형(Double)으로 출력
			 dos.writeBoolean(true); //논리형으로 출력
			 System.out.println("출력 완료");
			 
			 //출력한 자료 읽어오기
			 FileInputStream fis = new FileInputStream("c:/C_Other/test.dat");
			 DataInputStream dis = new DataInputStream(fis);
			 
			 System.out.println("문자열 자료 " + dis.readUTF()); 
			 System.out.println("정수형 자료 "+ dis.readInt());
			 System.out.println("실수형 자료(Float)"+ dis.readFloat());
			 System.out.println("실수형 자료double : " + dis.readDouble());
			 System.out.println("논리형 자료 : " + dis.readBoolean());
			 
			 dis.close();
			 dos.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
