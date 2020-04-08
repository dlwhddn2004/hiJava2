package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class T16_NonSerializableParentTest {

	/*
	 	부모클래스가 Serializable 인터페이스를 구현하고 있지 않을 경우
	 	부모객체의 필드값 퍼리 방법
	 	
	 	1. 부모가 Serializable 인터페이스를 구현하도록 해야한다.
	 	2. 자식 클래스에 wirteObject()와 readObject()메서드를 이용하여 부모 객체의
	 		필드값을 처리 할 수 있도록 직접 구현해야한다.
	 */
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("c:/C_Other/nonSerializeTest.bin");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Child child = new Child();
		
		child.setParentname("부모");
		child.setChildName("자식");
		oos.writeObject(child); //직렬화
		
		oos.flush(); //생략가능
		oos.close();
		//fos.close(); 생략가능
		
		FileInputStream fis = new FileInputStream("c:/C_Other/nonSerializeTest.bin");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Child child2 = (Child) ois.readObject(); //역직렬화
		
		System.out.println("ParentNmae : " + child2.getParentname());
		System.out.println("childName : " + child2.getChildName());
		
		ois.close();
		fis.close(); //생략가능
		
	}
}


//Serializable
class Parent{
	
	private String parentname;

	public String getParentname() {
		return parentname;
	}

	public void setParentname(String parentname) {
		this.parentname = parentname;
	}

	
	
}


class Child extends Parent implements Serializable{
	
	private String childName;

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}
	
	/**
	 * 직렬화 될때 자동으로 호출됨
	 * (접근 제한자가 private이 아니면 호출되지 않음)
	 * @param out
	 * @throws IOException
	 */
	private void writeObject(ObjectOutputStream out) throws IOException{
		out.writeUTF(getParentname()); //부모 객체 필드값 처리
		out.defaultWriteObject();
	}
	
	
	/**
	 * 역직렬화 될 때 자동으로 호출됨.
	 * (접근 제한자가 private 아니면 자동호출 안됨)
	 * @param input
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException{
		
		setParentname(input.readUTF()); //부모 객체 필드값 처리
		input.defaultReadObject();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}