package kr.or.ddit.basic.coll;

import java.util.Scanner;

import kr.or.ddit.basic.service.IMemberService;
import kr.or.ddit.basic.service.MemberServiceImPl;
import kr.or.ddit.basic.vo.MemberVO;

public class MemberMain {
	Scanner sc = new Scanner(System.in);
	private static IMemberService service; 
	
	public static void main(String[] args) {
		service= MemberServiceImPl.getInstance();
		MemberMain con = new MemberMain();
		con.start();
	}
	
	public void start() {
		int menu=0;
		
		
		do {
		System.out.println("입력하세요");
		System.out.println("1 입력");
		System.out.println("2 전체 조회");
		System.out.println("3 검색");
		menu= Integer.parseInt(sc.nextLine());
		
		switch (menu) {
		case 1:
			service.InsertMember();
			break;
		case 2:
			service.selectAll();
			break;
		case 3:
			service.seachMember();
			break;
		
		default:
			System.out.println("히히");
			
		}
		
		}while(menu != 0);
	}

	private void InsertMember() {
		
		
	}
}
