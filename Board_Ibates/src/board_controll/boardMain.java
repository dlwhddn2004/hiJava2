package board_controll;

import java.util.List;
import java.util.Scanner;

import board_dao.IDao;
import board_dao.ImplDao;
import board_service.IService;
import board_service.ImplService;
import board_vo.BoardVO;

public class boardMain {

	private IService service = ImplService.getInstance();
	private Scanner sc = new Scanner(System.in);
	
	public void BoardShow() {
		int menu =0;
		do {
		
		System.out.println("------------------");
		System.out.println("게\t시\t판");
		System.out.println("1. 게시판 입력");
		System.out.println("2. 게시판 수정");
		System.out.println("3. 게시판 삭제");
		System.out.println("4. 게시판 검색");
		System.out.println("5. 전체 게시판 출력");
		System.out.println("0. 종료");
		System.out.println("------------------");
		System.out.print("원하는 작업 선택");
		
		
		menu = Integer.parseInt(sc.nextLine());
		
		switch (menu) {
		case 1:
			inserBoard(); //입력
			break;
		
		case 2:
			updateBoard(); //수정
			break;
		
		case 3:
			deleteBoard(); //삭제
			break;
			
		case 4:
			searchBoard(); //검색
			break;
			
		case 5:
			displayboardAll(); //전체 게시판 출력
			break;
			
		case 0:
			System.out.println("종료");
			break;
		default:
			System.out.println("다시 입력");;
		}
		
		}while(menu != 0);
		
	}

	private void displayboardAll() {
		System.out.println();
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("게시판 번호\t게시판 제목\t게시판 작성자\t게시판 내용\t게시판작성시간");
		System.out.println("----------------------------------------------------");
		
		List<BoardVO> list = service.BoardAllList();
	
		for(BoardVO bv2 : list) {
			System.out.println(bv2.getBoard_no()+ "\t" 
			+bv2.getBoard_title()+ "\t"
			+bv2.getBoard_writer()+ "\t" 
			+bv2.getBoard_content()+ "\t" 
			+bv2.getBoard_date());
		}
		System.out.println("끝");	
		
	}

	private void searchBoard() {
		
		System.out.println("검색할 게시판 번호 입력");
		int num = Integer.parseInt(sc.nextLine());
		
		System.out.println("검색할 게시판 제목 입력");
		String title = sc.nextLine().trim();
		
		System.out.println("검색할 게시판 작성자");
		String wirter = sc.nextLine().trim();
		
	
		
		BoardVO bv = new BoardVO();
		bv.setBoard_no(num);
		bv.setBoard_title(title);
		bv.setBoard_writer(wirter);
		
		
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("게시판 번호\t게시판 제목\t게시판 작성자\t게시판 내용\t게시판작성시간");
		System.out.println("----------------------------------------------------");
		
		List<BoardVO> list = service.SearchBoard(bv);
	
		for(BoardVO bv2 : list) {
			System.out.println(bv2.getBoard_no()+ "\t" 
			+bv2.getBoard_title()+ "\t"
			+bv2.getBoard_writer()+ "\t" 
			+bv2.getBoard_content()+ "\t" 
			+bv2.getBoard_date());
			
			System.out.println("---------------------------------");
			
		}
	}

	private void deleteBoard() {
		System.out.println();
		System.out.println("삭제할 게시판 번호를 입력하시오"); 
		int boardnum = Integer.parseInt(sc.nextLine());
		
		int cnt = service.deleteBoard(boardnum);
		if(cnt >0) {
			System.out.println("게시판 삭제 성공");
		}else {
			System.out.println("게시판 삭제 실패");
		}
	}

	private void updateBoard() {
		boolean chk= false;
		int boardnum;
		
		do {
			System.out.println();
			System.out.println("수정할 게시판 번호를 입력");
			boardnum = Integer.parseInt(sc.nextLine());
			
			chk = service.getBoard(boardnum);
			if(chk == false) {
				System.out.println(boardnum+" 게시판번호가 다름");
			}
			
		}while(chk==false);
		
		System.out.println("수정할 게시판 제목 입력");
		String title = sc.nextLine();
		System.out.println("수정하신 작성자 이름 입력");
		String writer = sc.nextLine();
		System.out.println("수정할 내용 입력");
		String content = sc.nextLine();
		
		BoardVO bv = new BoardVO();
		bv.setBoard_no(boardnum);
		bv.setBoard_title(title);
		bv.setBoard_writer(writer);
		bv.setBoard_content(content);
		
		int cnt = service.update(bv);
		
		if(cnt >0) {
			System.out.println("게시판수정 완료");
		}else {
			System.out.println("게시판 수정 실패");
		}
	}

	private void inserBoard() {

		
		System.out.println("제목");
		String title = sc.nextLine();
		
		System.out.println("작성자 이름");
		String writer = sc.nextLine();
		
		System.out.println("내용 입력");
		String content = sc.nextLine();
		
		BoardVO bv = new BoardVO();
		bv.setBoard_title(title);
		bv.setBoard_writer(writer);
		bv.setBoard_content(content);
		
		int cnt = service.insertMember(bv);
		
		if(cnt > 0) {
			System.out.println("게시판 입력 완료");
		}else {
			System.out.println("게시판 입력 실패");
		}
	}	

	public static void main(String[] args) {
		new boardMain().BoardShow();
	}
	
	
	
}
