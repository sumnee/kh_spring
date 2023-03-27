package com.kh.marchpring.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	
	// ResponseBody 적는거 ajax에서 왕중요! 
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
	
}
