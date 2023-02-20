package com.kh.spring.member.store;

import org.apache.ibatis.session.SqlSession;

import com.kh.spring.member.domain.Member;

public interface MemberStore {
	
	/**
	 * 멤버 등록 Store
	 * @param session
	 * @param member
	 * @return int
	 */
	public int insertMember(SqlSession session, Member member); 
	
	
	/**
	 * 멤버 로그인 Store
	 * @param member
	 * @return Member
	 */
	public Member checkMemberLogin(SqlSession session, Member member);

	/**
	 * 아이디로 멤버 조회 Store
	 * @param session
	 * @param member
	 */
	public Member selectOneById(SqlSession session, String memberId);
}
