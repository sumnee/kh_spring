package com.kh.marchpring.ajax.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kh.marchpring.ajax.domain.Member;

@Controller
public class AjaxController {

	//아래 두가지 방법의 결과는 같음
	
	@RequestMapping(value = "/ajax/sample", method = RequestMethod.GET)
	public String showAjaxWrapUp(Model model) {		
		return "ajax/wrapup";
	}
	@RequestMapping(value = "/ajax/wrapup", method = RequestMethod.GET)
	public ModelAndView showAjaxWrapUp(ModelAndView mv) {		
		mv.setViewName("ajax/wrapup");
		return mv;
	}
	
	// ResponseBody 적는거 ajax에서 왕중요! 
	@ResponseBody
	@RequestMapping(value = "/ajax/first", method = RequestMethod.GET)
	public void ajaxFirst(@RequestParam("msg") String msg) {
		System.out.println("전송 받은 데이터 : " + msg);
	}
	
	@ResponseBody
	@RequestMapping(value = "/ajax/second", method = RequestMethod.GET)
	public void ajaxSecond(@RequestParam("msg") String msg) {
		System.out.println("전송 받은 데이터 : " + msg);
	}
	
	// ResponseBody 적는거 ajax에서 왕중요! viewResolve 태우지 않음
	// 아니면 /WEB-INF/views/"return값".jsp 로 이동해서 404에러 뜸
	@ResponseBody
	@RequestMapping(value = "/ajax/third", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
	public String ajaxThird() {
		//  produces = "text/plain;charset=utf-8" 한글 안깨지게
		return "서버에서 왔음";
	}
	
	@ResponseBody
	@RequestMapping(value = "/ajax/fourth", method = RequestMethod.GET)
	public String ajaxFourth(
			@RequestParam Integer numOne,
			@RequestParam Integer numTwo) {
		Integer result = numOne + numTwo;
		return String.valueOf(result);
	}
	
	//5번 6번 소현언니꺼! 내가 복습하기 3/28
	@ResponseBody
	@RequestMapping(value="/ajax/fifth", method=RequestMethod.GET, produces = "application/json;charset=utf-8")	// 키값을 requestParam에 적어주는거야
	public String ajaxFifth(@RequestParam("memberId") String memberId) {
		List<Member> mList = new ArrayList<Member>();
		mList.add(new Member("khuser01", "pass01"));
		mList.add(new Member("khuser02", "pass02"));
		mList.add(new Member("khuser03", "pass03"));
		mList.add(new Member("khuser04", "pass04"));
		mList.add(new Member("khuser05", "pass05"));	// DB에서 가져온 값이라고 생각하자(지금 DB랑 연결을 안했으니까)
		Member member = null;
		for(Member mOne : mList) {
			if(mOne.getMemberId().equals(memberId)) {
				member = mOne;
				break;
			}
		}
		// JSONObject(데이터타입을 객체에서 json으로 바꿀때는 저걸 써야해. 수동으로 해주는 방법)
		JSONObject jsonObj = new JSONObject();	// json 객체 생성 -> { } 생성 완료
		jsonObj.put("memberId", member.getMemberId());	// "memberId"라는 키값에 member.getMemberId() = "khuser01"인 밸류값
		jsonObj.put("memberPw", member.getMemberPw());	// {memberId : "khuser01", memberPw : "pass01"}
		return jsonObj.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/ajax/sixth", method=RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String ajaxSixth(@RequestParam("memberId") String memberId) {
		List<Member> mList = new ArrayList<Member>();
		mList.add(new Member("khuser01", "pass01"));
		mList.add(new Member("khuser02", "pass02"));
		mList.add(new Member("khuser03", "pass03"));
		mList.add(new Member("khuser04", "pass04"));
		mList.add(new Member("khuser05", "pass05"));
		boolean checkFlag = false;
		Member member = null;
		JSONArray jsonArr = new JSONArray();	// [ ]을 생성해줌(데이터가 있는경우 하나의 값만, 없는경우 5개의 값을 보내주게 함)
		for(Member mOne : mList) {
			if(mOne.getMemberId().equals(memberId)) {
//				member = mOne;
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("memberId", mOne.getMemberId());
				jsonObj.put("memberPw", mOne.getMemberPw());
				jsonArr.add(jsonObj);	// {memberId : "khuser01", memberPw : "pass01"}
				checkFlag = true;
				break;
			}
		}
		// '데이터가 없으면'을 처리하기 위함
		if(!checkFlag) {
			for(Member mOne : mList) {
				JSONObject jOne = new JSONObject();
				jOne.put("memberId", mOne.getMemberId());
				jOne.put("memberPw", mOne.getMemberPw());
				jsonArr.add(jOne);
			}	// [ {}, {}, {}, {}, {} ]처럼 json이 여러개가 들어가게 되는거야
		}
		return jsonArr.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/ajax/seventh", method=RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String ajaxSeventh() {
		List<Member> mList = new ArrayList<Member>();
		mList.add(new Member("khuser01", "pass01"));
		mList.add(new Member("khuser02", "pass02"));
		mList.add(new Member("khuser03", "pass03"));
		mList.add(new Member("khuser04", "pass04"));
		mList.add(new Member("khuser05", "pass05"));
//		JSONArray jsonArr = new JSONArray();
//		for(Member mOne : mList) {
//			JSONObject jsonObj = new JSONObject();
//			jsonObj.put("memberId", mOne.getMemberId());
//			jsonObj.put("memberPw", mOne.getMemberPw());
//			jsonArr.add(jsonObj);
//		}
//		return jsonArr.toString();
		//위에 6줄을 아래 한줄로 대체 가능, 자동으로!
		//pom.xml에 gson <dependency> 추가해서 사용 가능한거임
		return new Gson().toJson(mList);
	}
	
	
	
}
