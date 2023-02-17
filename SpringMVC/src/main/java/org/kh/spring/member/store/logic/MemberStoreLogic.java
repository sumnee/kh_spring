package org.kh.spring.member.store.logic;

import java.util.List;

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
	public List<Member> selectMembers() {
		List<Member> mList = session.selectList("MemberMapper.selectMembers");
		return mList;
	}

	@Override
	public Member checkMemberLogin(Member member) {
		Member result = session.selectOne("MemberMapper.checkMemberLogin", member);
		return result;
	}

	@Override
	public Member selectOneById(String memberId) {
		Member member = session.selectOne("MemberMapper.selectOneById", memberId);
		return member;
	}

}
