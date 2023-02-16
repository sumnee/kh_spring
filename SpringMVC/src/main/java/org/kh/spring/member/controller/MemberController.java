package org.kh.spring.member.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.spring.member.domain.Member;
import org.kh.spring.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	@Autowired
	private MemberService mService;
	
	@RequestMapping(value="/member/login.do", method=RequestMethod.POST)
	public String memberLogin(HttpServletRequest request, Model model) {
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		Member mParan = new Member(memberId, memberPw);
		Member member = mService.checkMemberLogin(mParan);
		if(member != null) {
			model.addAttribute("msg", "성공");
			return "common/success";
		} else {
			model.addAttribute("msg", "실패");
			return "common/failed";
		}
	}
	
	@RequestMapping(value="/member/logout.do", method = RequestMethod.GET)
	public String memberLogout(HttpServletResponse response) throws Exception {
		//response.sendRedirect("index.jsp"); 원래는 이거 쓰는데 이제 아님
		return "redirect:/index.jsp";
	}
}
