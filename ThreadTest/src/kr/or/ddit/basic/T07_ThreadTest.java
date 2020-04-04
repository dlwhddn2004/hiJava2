package kr.or.ddit.basic;

import java.awt.im.InputContext;

import javax.swing.JOptionPane;
import javax.xml.crypto.Data;

import org.omg.CORBA.UnknownUserException;

/*
 *  컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
 *  
 *  캄퓨터의 가위 바위 보는 난수를 이용하여 구하고
 *  사용자의 가위 바위 보는 showInputDialog()메서드를 이용하여 입력받는다.
 *  
 *  입력시간은 5초로 제한하고 카운트 다운을 진행한다.
 *  5초안에 입력이 없으면 게임을 진 것으로 처리한다.
 *  
 *  5초안에 입력이 완료되면 승패를 출력한다.
 *  
 *  결과 예씨)
 *  ===결과===
 *  컴퓨터 : 가위
 *  사용자 : 바위
 *  결  과 : 당신이 이겼습니다.
 */
public class T07_ThreadTest {
		public static boolean inputcheck = false;
		
		public static void main(String[] args) {
			Timer game = new Timer();
			
			String[] data = {"가위","바위","보"};
			int index = (int)(Math.random()*3);
			
			String computer = data[index];
			
			String user= null;
			
			game.start();
			
			do {
				user = JOptionPane.showInputDialog("가위,바위,보 중 하나를 입력하시오");
				
			}while(!user.equals("가위") && !user.equals("바위") && !user.equals("보"));
			
			inputcheck= true;
			
			String result ="";
			if(computer.equals(user)) {
				result="비겼습니다.";
			}else if ((computer.equals("가위") && user.equals("바위"))||
					(computer.equals("바위") && user.equals("보")) ||
					(computer.equals("보") && user.equals("가위"))) {
				result="당신이 이겼습니다.";
			}else {
				result="당신이 졌습니다.";
			}
			System.out.println("결과 출력");
			System.out.println("User :" + user);
			System.out.println("computer :" + computer);
			System.out.println(result);
		}

}

class Timer extends Thread{
	
	@Override
	public void run() {
			for(int i=5; i>=1; i--) {
				
				if(T07_ThreadTest.inputcheck) {
					return;
				}
				System.out.println(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("제한시간이 초과되었습니다.");
			System.exit(0);
	}
}