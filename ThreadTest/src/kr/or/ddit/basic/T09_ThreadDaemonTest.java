package kr.or.ddit.basic;

public class T09_ThreadDaemonTest {

	public static void main(String[] args) {
		AutoSaveThread ast = new AutoSaveThread();
		
		//데몬쓰레드로 설정하기 (start()메서드 호출하기 전에 설정한다.)
		ast.setDaemon(true);
		ast.start(); //ast 쓰레드 시작
		
		try { //메인쓰레드
			for(int i=0; i<=20; i++) {
				System.out.println("작업"+i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("메인메서드 종료...");
	}
}

/**
 * 자동 저장하는 쓰레드(3초에 한번씩 저장하기)
 * @author 이종우
 *
 */
class AutoSaveThread extends Thread{
	public void save() {
		System.out.println("작업 내용을 저장합니다.");
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			save(); //저장기능 호출
		}
	}
}