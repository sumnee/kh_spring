package com.kh.spring.member.service.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring.member.domain.Member;
import com.kh.spring.member.service.MemberService;
import com.kh.spring.member.store.MemberStore;

@Repository
public class MemberServiceImpl implements MemberService{

	@Autowired
	private SqlSession session;
	
	@Autowired
	private MemberStore mStore;
	
	@Override
	public int insertMember(Member member) {
		int result = mStore.insertMember(session, member);
		return result;
	}

	@Override
	public Member checkMemberLogin(Member member) {
		Member mOne = mStore.checkMemberLogin(session, member);
		return mOne;
	}

	@Override
	public Member selectOneById(String memberId) {
		Member member = mStore.selectOneById(session, memberId);
		return member;
	}
	
	

}
