package kr.or.ddit.basic;

import java.awt.FontFormatException;

public class T02_ThreadTest {

	public static void main(String[] args) {
		//멀티 쓰레드 프로그래밍 방식
		
		//방법 1 : Thread클래스를 상속한 class의 인스턴스를 생성한 후 이 인스턴스의 start()메서드를 호출한다. 
		MyThread th1 = new MyThread();
		th1.start();
		
		//방법 2 : Runnable인터페이스를 구현한 class의 인스턴스를 생성한 후 이 인스턴스를 Thread객체의 인스턴스를
		//		생성 할때 생성자의 매개변수로 넘겨준다. 이때 생성된 Thread객체의 인스턴스의 start()메서드를 호출한다.
		MyThread2 r1 = new MyThread2();
		Thread th2 = new Thread(r1);
		th2.start();
				
		//방법 3 : 익명클래스를 이용하는 방법
		// 		  Runnable인터페이스를 구현한 익명클래스를 Thread인스턴스를 생성할 때 매개변수로 넘겨준다.
		Thread th3 = new Thread(new Runnable() {
					
			//3번째 방법은 임시성으로 클래스를 따로 만들지 않고, 재사용할 일이 없을때 쓴다.
			@Override
			public void run() {
				for (int i = 1; i <=200; i++) {
					System.out.print("@");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		th3.start();
	}
}

//방법 1
class MyThread extends Thread{
	
	@Override
	public void run() {
		for (int i = 1; i <=200; i++) {
			System.out.print("*");
			try {
				//Thread.sleep(시간) => 주어진 시간동안 작업을 잠시 멈춘다.
				//시간은 밀리세컨드 단위를 사용한다.
				//즉, 100은 1초를 의미한다.
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


//방법 2
class MyThread2 implements Runnable{

	@Override
	public void run() {
		for (int i = 1; i <=200; i++) {
			System.out.print("$");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}