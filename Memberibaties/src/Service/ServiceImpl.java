package Service;

import java.util.List;
import java.util.Scanner;

import DAO.DaoImpl;
import DAO.IDao;
import VO.MemberVO;

public class ServiceImpl implements IService{
	
	private static IDao dao;
	
	private static ServiceImpl instance;
	
	private ServiceImpl() {
		dao = DaoImpl.getInstance();
	}
	
	public static ServiceImpl getInstance() {
		if(instance == null) {
			instance = new ServiceImpl();
		}
		return instance;
	}

	@Override
	public void insert() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("====================================");
		System.out.print  ("아이디 : ");
		String mem_id = s.nextLine();
		
		boolean chk1 = dao.duplicate(mem_id);
		if(chk1 == true) {
			System.out.println("해당 아이디는 이미 존재합니다.");
			return;
		}
		
		System.out.print  ("이름 : ");
		String mem_name = s.nextLine();
		System.out.print  ("전화번호 : ");
		String mem_tel = s.nextLine();
		System.out.print  ("주소 : ");
		String mem_addr = s.nextLine();
		System.out.println("====================================");
		
		MemberVO member = new MemberVO();
		member.setMem_id(mem_id);
		member.setMem_name(mem_name);
		member.setMem_tel(mem_tel);
		member.setMem_addr(mem_addr);
		
		int chk = dao.insert(member);
		
		if(chk > 0) {
			System.out.println("회원 등록 성공!");
		}else {
			System.out.println("회원 등록 실패!");
		}
	}

	@Override
	public void delete() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("====================================");
		System.out.print  ("삭제할 아이디 : ");
		String mem_id = s.nextLine();
		
		boolean chk1 = dao.duplicate(mem_id);
		if(chk1 == false) {
			System.out.println("해당 아이디는 존재하지 않습니다.");
			return;
		}
		
		System.out.println("====================================");
		
		int chk = dao.delete(mem_id);
		
		if(chk > 0) {
			System.out.println("회원 삭제 성공!");
		}else {
			System.out.println("회원 삭제 실패!");
		}
	}

	@Override
	public void update() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("====================================");
		System.out.print  ("수정할 아이디 : ");
		String mem_id = s.nextLine();
		
		boolean chk1 = dao.duplicate(mem_id);
		if(chk1 == false) {
			System.out.println("해당 아이디는 존재하지 않습니다.");
			return;
		}
		
		System.out.print  ("새로운 이름 : ");
		String mem_name = s.nextLine();
		System.out.print  ("새로운 전화번호 : ");
		String mem_tel = s.nextLine();
		System.out.print  ("새로운 주소 : ");
		String mem_addr = s.nextLine();
		System.out.println("====================================");
		
		MemberVO member = new MemberVO();
		member.setMem_id(mem_id);
		member.setMem_name(mem_name);
		member.setMem_tel(mem_tel);
		member.setMem_addr(mem_addr);
		
		int chk = dao.update(member);
		
		if(chk > 0) {
			System.out.println("회원 수정 성공!");
		}else {
			System.out.println("회원 수정 실패!");
		}
	}

	@Override
	public void search() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("====================================");
		System.out.print  ("아이디 : ");
		String mem_id = s.nextLine();
		System.out.println("====================================");
		
		List<MemberVO> member = dao.search(mem_id);
		
		if(member == null) {
			System.out.println("검색하신 회원을 찾을 수 없습니다.");
		}
		
		System.out.println("====================================");
		System.out.println(member);
		System.out.println("====================================");
	}

	@Override
	public void showAll() {
		List<MemberVO>list = dao.showAll();
		
		System.out.println("====================================");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("====================================");
		
	}

}
