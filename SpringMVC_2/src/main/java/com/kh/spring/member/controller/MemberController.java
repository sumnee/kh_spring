package com.kh.spring.member.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring.member.domain.Member;
import com.kh.spring.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService mService;
	
	@RequestMapping(value="/member/registerView.kh", method=RequestMethod.GET)
	public String registerView() {
		return "member/register";
	}
	
	//등록 버튼 누를 때 동작 - 회원가입
	/*
	 *  1. @RequestParam("name"값) String 변수명
	 * 
	 *  2. @RequestParam("name"값) 생략/ String 변수명 만 적기
	 *  	-매개변수명이 jsp의 input 태그 name과 같다면 생략 가능
	 *  
	 *  3. @ModelAttribute 사용하여  String 변수명 생략
	 *  	-Domain에 기본생성자가 존재해야함
	 *  	-Setter메소드가 존재해야함
	 *  	-form태그 name값이 Domain 클래스 멤버 변수명과 일치해야함
	 */
	@RequestMapping(value="/member/register.kh", method=RequestMethod.POST)
	public String memberRegister(
			HttpServletRequest request
			, @ModelAttribute Member member
//			, String memberId
//			, String memberPw
//			, String memberName
//			, String memberEmail
//			, String memberPhone
//			, String memberAddr
			, Model model) {
		try {
//			request.setCharacterEncoding("UTF-8");
//			String memberId = request.getParameter("member-id");
//			String memberPw = request.getParameter("member-pw");
//			String memberName = request.getParameter("member-name");
//			String memberEmail = request.getParameter("member-email");
//			String memberPhone = request.getParameter("member-phone");
//			String memberAddr = request.getParameter("member-addr");
			//requestparam으로 대체
//			Member mParam = new Member(memberId, memberPw, memberName, memberEmail, memberPhone, memberAddr);
			//ModelAttribute로 대체
			int result = mService.insertMember(member);
			if(result>0) {
				return "redirect:/index.jsp";
			} else {
				model.addAttribute("msg", "회원가입 실패");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "common/error";
		}
		
	}
	
	//로그인
	@RequestMapping(value="/member/login.kh", method=RequestMethod.POST)
	public String memberLogin(
			HttpServletRequest request
			, @RequestParam("member-id") String memberId
			, @RequestParam("member-pw") String memberPw
			, Model model) {
		try {
			//requestparam으로 대체해봄!
			Member mParam = new Member(memberId, memberPw);
			Member member = mService.checkMemberLogin(mParam);
			HttpSession session = request.getSession();
			if(member != null) {
				session.setAttribute("loginUser", member);
				return "redirect:/index.jsp";
			} else {
				model.addAttribute("msg", "로그인 정보 없음");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}	
	}
	
	//로그아웃
	@RequestMapping(value="/member/logout.kh", method=RequestMethod.GET)
	public String memberLogout(HttpSession session, Model model) {
		if(session != null) {
			session.invalidate();
			return "redirect:/index.jsp";
		} else {
			model.addAttribute("msg", "로그아웃 실패");
			return "common/error";
		}
	}
	
	@RequestMapping(value="/member/mypage.kh", method=RequestMethod.GET)
	public String showMypage(HttpSession session, Model model) {
		String memberId = ((Member)session.getAttribute("loginUser")).getMemberId();
		Member member = mService.selectOneById(memberId);
		model.addAttribute("member", member);
		return "member/mypage";	
	}

}