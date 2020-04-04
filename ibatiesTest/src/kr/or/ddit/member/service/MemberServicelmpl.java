package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.basic.MemberIbartisTest;
import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;


public class MemberServicelmpl implements IMemberService{

	  // 사용할 DAO의 객체 변수를 선언한다.
	   private IMemberDao memDao;
	   private static MemberServicelmpl service;
	 
	   public static MemberServicelmpl getInstance() {
		  if(service ==null) {
			  service = new MemberServicelmpl();
		  }
		  return service;
	   }
	   
	   private  MemberServicelmpl() {
		
	      memDao =  MemberDaoImpl.getInstance();
	   }

	@Override
	public int insertMember(MemberVO mv) {
		
		return memDao.insertMember(mv);
	}

	@Override
	public boolean getMember(String memId) {
		
		return memDao.getMember(memId);
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		
		return memDao.getAllMemberList();
	}

	@Override
	public int updateMember(MemberVO mv) {
		
		return memDao.updateMember(mv);
	}

	@Override
	public int deleteMember(String memId) {
		// TODO Auto-generated method stub
		return memDao.deleteMember(memId);
	}

	@Override
	public List<MemberVO> getSearchMember(MemberVO mv) {
		
		return memDao.getSearchMember(mv);
	}

	
}
   
   