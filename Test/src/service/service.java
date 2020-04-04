package service;

import java.util.List;
import java.util.Scanner;

import dao.Dao;
import dao.IDao;
import vo.MemberVO;

public class service implements Iservice{
	private static IDao dao;
	private static service instance;
	
	private service() {
		dao = Dao.getInstance();
	}
	
	public static service getInstance() {
		if(instance ==null) {
			instance = new service();
		}
		return instance;
	}
	
	@Override
	public void insert() {
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디 입력");
		String mem_id = sc.nextLine();
		
		System.out.println("이름입력");
		String mem_name = sc.nextLine();

		System.out.println("전화 입력");
		String mem_tel = sc.nextLine();
		
		System.out.println("주소 입력");
		String mem_addr = sc.nextLine();
		
		MemberVO mv = new MemberVO();
		mv.setMem_id(mem_id);
		mv.setMem_name(mem_name);
		mv.setMem_addr(mem_addr);
		mv.setMem_tel(mem_tel);
		
		int cnt = dao.insert(mv);
		if(cnt >0) {
			System.out.println("회원가입성공");
		}else {
			System.out.println("회원가입 실패");
		}
	}

	@Override
	public void selectALL() {
		List<MemberVO> list = dao.selectALL();
		
		for(MemberVO mv : list) {
			System.out.println(mv);
		}
		
	}

	@Override
	public void search() {
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디 입력");
		String mem_id = sc.nextLine();
			List<MemberVO> list = dao.search(mem_id);
			if(list ==null) {
				System.out.println("아이디가 없음");
			}
			System.out.println(list);
		
	}

}
