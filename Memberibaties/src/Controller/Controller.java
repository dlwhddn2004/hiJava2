package Controller;

import java.util.Scanner;

import Service.IService;
import Service.ServiceImpl;

public class Controller {
	
	private static IService service;
	
	private Controller() {
		service = ServiceImpl.getInstance();
	}
	
	public static void main(String[] args) {
		
		Controller controller = new Controller();
		
		controller.start();
		
	}
	
	public void start() {
		
		Scanner s = new Scanner(System.in);
		
		int input = 0;
		
		do {
			System.out.println("====================================");
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 삭제");
			System.out.println("3. 회원 수정");
			System.out.println("4. 회원 검색");
			System.out.println("5. 회원 조회");
			System.out.println("0. 프로그램 종료");
			System.out.println("====================================");
			System.out.print  ("입력 : ");
			
			input = Integer.parseInt(s.nextLine());
			
			if(input == 1) {
				service.insert();
			}else if(input == 2) {
				service.delete();
			}else if(input == 3) {
				service.update();
			}else if(input == 4) {
				service.search();
			}else if(input == 5) {
				service.showAll();
			}else if(input == 0) {
				System.out.println("프로그램을 종료합니다.");
			}else {
				System.out.println("잘못된 번호를 입력하였습니다.");
			}
		} while (input != 0);
	}

}
