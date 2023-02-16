package org.kh.spring.member.service;

import org.kh.spring.member.domain.Member;

public interface MemberService {

	/**
	 * 회원 로그인 service
	 * @param member
	 * @return Member
	 */
	public Member checkMemberLogin(Member member);
}
