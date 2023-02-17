package org.kh.spring.member.service.logic;

import java.util.List;

import org.kh.spring.member.domain.Member;
import org.kh.spring.member.service.MemberService;
import org.kh.spring.member.store.MemberStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberStore mStore;
	
	@Override
	public List<Member> selectMembers() {
		List<Member> mList = mStore.selectMembers();
		return mList;
	}

	@Override
	public Member checkMemberLogin(Member member) {
		Member result = mStore.checkMemberLogin(member);
		return result;
	}

	@Override
	public Member selectOneById(String memberId) {
		Member member = mStore.selectOneById(memberId);
		return member;
	}
	

}
