package org.kh.spring.member.service;

import java.util.List;

import org.kh.spring.member.domain.Member;

public interface MemberService {

	
	/**
	 * 회원 목록 조회 service
	 * @return List
	 */
	public List<Member> selectMembers();
	
	
	/**
	 * 회원 아이디로 상세조회 service
	 * @param memberId
	 * @return Member
	 */
	public Member selectOneById(String memberId);
	
	
	/**
	 * 회원 로그인 service
	 * @param member
	 * @return Member
	 */
	public Member checkMemberLogin(Member member);




}