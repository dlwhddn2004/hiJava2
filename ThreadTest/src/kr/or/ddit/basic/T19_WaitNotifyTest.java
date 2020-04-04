package kr.or.ddit.basic;

import javax.swing.plaf.SliderUI;

/*
	wait()메서드 => 동기화 영역에서 락을 풀고 Wait-Set영역(공유객체별 존재)으로 이동시킨다.
	
	notify() 또는 notifyAll() 메서드 => Wait-Set영역에 있는 쓰레드를 깨워서 실행될 수
									있도록 한다. 
								(notify()는 하나, notifyAll()은 Wait-Set에 있는 전부를 깨운다.)
	
	=> wait()와 notify(), notifyAll()메서드는 동기화 영역에서만 실행 할 수 있고,
	   object클래스에서 제공하는 메서드 이다.
 */
public class T19_WaitNotifyTest {

	public static void main(String[] args) {
		WorkObject obj = new WorkObject();
		ThreadA thA = new ThreadA(obj);
		ThreadB thB = new ThreadB(obj);
		
		thA.start();
		thB.start();
	}
}


//공통으로 사용할 객체
class WorkObject {
	public synchronized void methodA() { //A 랑 B 메소드는 동기화 처리 되어있음 
		System.out.println("methodA()메서드 작업중...");
		
		notify();
		
		try {
			wait();
			//wait(10) 이렇게 제한시간을 줘야 둘다 빠져나올수있음
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void methodB() {
		System.out.println("methodB()메서드 작업중...");
		
		notify();
		
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


//WorkObject의 methodA()메서드만 호출하는 쓰레드
class ThreadA extends Thread{
	private WorkObject workobj;
	
	public ThreadA(WorkObject workObj) {
		this.workobj = workObj;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <=10; i++) {
			workobj.methodA();
		}
		System.out.println("ThreadA 종료");
	}
}




//WorkObject의 methodB()메서드만 호출하는 쓰레드
class ThreadB extends Thread{
	private WorkObject workobj;
	
	public ThreadB(WorkObject workObj) {
		this.workobj = workObj;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <=10; i++) {
			workobj.methodB();
		}
		System.out.println("ThreadB 종료");
	}
}



























