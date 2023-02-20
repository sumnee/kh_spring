package com.kh.spring.member.service;

import com.kh.spring.member.domain.Member;

public interface MemberService {

	/**
	 * 회원 가입 Service
	 * @param member
	 * @return int
	 */
	public int insertMember(Member member);
	
	
	/**
	 * 멤버 로그인 Service
	 * @param member
	 * @return Member
	 */
	public Member checkMemberLogin(Member member);

	/**
	 * 아이디로 멤버 조회 Service
	 * @param memberId
	 * @return Member
	 */
	public Member selectOneById(String memberId);



}
