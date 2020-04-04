package kr.or.ddit.basic;

public class T15_SyncThreadTest {

	public static void main(String[] args) {
		ShareObject sObj = new ShareObject();
		WorkerThread th1 = new WorkerThread("1번쓰레드", sObj);
		WorkerThread th2 = new WorkerThread("2번쓰레드", sObj);
		th1.start();
		th2.start();
	}
}

//공통으로 사용할 객체
class ShareObject{
	private int sum =0;
	
	//동기화 하는 방법 1 : 메서드 자체에 동기화 설정하기 synchronized 넣어줌 but 메소드에 동기화블럭을넣으면 100개의 프로그램들이 1놈작업끝날떄까지 기다린다
	//					public synchronized void add() {
	public  void add() {
	//동기 하는 방법  2 : 동기화 블럭으로 설정
		synchronized (this) {
			int n= sum;
			n+=10; //10 증가
			sum =n;
			
			System.out.println(Thread.currentThread().getName() + "합계 : " +sum);
			
		}	
		
	}
	
	public int getSum() {
		return sum;
	}
	
}


//작업을 수행하는 메서드
class WorkerThread extends Thread{
	ShareObject sOjb;
	
	public WorkerThread(String name, ShareObject sOjb) {
		super(name);
		this.sOjb = sOjb;
	}
	public void run() {
		for(int i=1; i<=10; i++) {
			sOjb.add();
		}
	}
}


