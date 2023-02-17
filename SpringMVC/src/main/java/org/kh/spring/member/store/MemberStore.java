package org.kh.spring.member.store;

import java.util.List;

import org.kh.spring.member.domain.Member;

public interface MemberStore {

	/**
	 * 회원 목록 조회 store
	 * @return
	 */
	public List<Member> selectMembers();
	
	
	/**
	 * 회원 아이디로 상세조회 service
	 * @param memberId
	 * @return Member
	 */
	public Member selectOneById(String memberId);
	
	
	/**
	 * 회원 로그인 store
	 * @param member
	 * @return Member
	 */
	public Member checkMemberLogin(Member member);
}
