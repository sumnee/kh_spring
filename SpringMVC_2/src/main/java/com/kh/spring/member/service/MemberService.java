package com.kh.spring.member.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.spring.member.domain.Member;

public interface MemberService {

	/**
	 * 회원 가입 Service
	 * @param member
	 * @return int
	 */
	public int insertMember(Member member);
	
	/**
	 * 멤버 수정 Service
	 * @param member
	 * @return int
	 */
	public int updateMember(Member member); 
	
	/**
	 * 멤버 탈퇴 Service
	 * @param member
	 * @return int
	 */
	public int deleteMember(String memberId);
	
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

	/**
	 * 멤버 리스트 조회 Service
	 * @return List<Member>
	 */
	public List<Member> selectMemberList();



}
