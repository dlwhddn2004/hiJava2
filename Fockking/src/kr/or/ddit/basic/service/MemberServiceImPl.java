package kr.or.ddit.basic.service;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.basic.dao.IMemberDao;
import kr.or.ddit.basic.dao.MemberDaoImPl;
import kr.or.ddit.basic.vo.MemberVO;

public class MemberServiceImPl implements IMemberService{
	private static IMemberDao dao;
	private static MemberServiceImPl instance;
	Scanner sc = new Scanner(System.in);
	
	private MemberServiceImPl() {
	 dao = MemberDaoImPl.getInstance();
	}
	
	public static IMemberService getInstance() {
		if(instance == null) {
			instance = new MemberServiceImPl();
		}
		return instance;
	}
	
	
	@Override
	public void InsertMember() {
		
		boolean chk= false;
		String mem_id= null;
		while(!chk) {
		
			System.out.println("아이디");
			 mem_id = sc.nextLine();
			chk = dao.getMember(mem_id);
			
			if(chk ==false) {
				System.out.println("아이디가 중복됩니다.");
			}
		}
		System.out.println("이름 입력");
		String mem_name = sc.nextLine();
		
		System.out.println("번호 입력");
		String mem_tel = sc.nextLine();
		
		System.out.println("주소 입력");
		String mem_addr = sc.nextLine();
		
		MemberVO mv = new MemberVO();
		
		mv.setMem_id(mem_id);
		mv.setMem_name(mem_name);
		mv.setMem_tel(mem_tel);
		mv.setMem_addr(mem_addr);
		
		int cnt = dao.InsertMemVO(mv);
		if(cnt >0) {
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
		
		
	}

	@Override
	public void updateMember() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectAll() {
	List<MemberVO> list =dao.selectAll();
		for(MemberVO mv : list) {
			System.out.println(mv);
		}
	}

	@Override
	public void getMember() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seachMember() {
		System.out.println("아이디를 입력하시오");
		String mem_id = sc.nextLine();
		MemberVO member = dao.seachMemer(mem_id);
		
		System.out.println(member);
	}

}
