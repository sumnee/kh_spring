package org.kh.spring.member.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.kh.spring.member.domain.Member;
import org.kh.spring.member.store.MemberStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberStoreLogic implements MemberStore{

	@Autowired
	private SqlSession session; 
	
	@Override
	public Member checkMemberLogin(Member member) {
		Member result = session.selectOne("MemberMapper.checkMemberLogin", member);
		return result;
	}

}
