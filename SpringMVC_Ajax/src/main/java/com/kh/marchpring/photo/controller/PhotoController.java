package com.kh.marchpring.photo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kh.marchpring.common.file.FileUtil;
import com.kh.marchpring.photo.domain.Photo;
import com.kh.marchpring.photo.service.PhotoService;

@Controller
@RequestMapping("/photo")
public class PhotoController {
	
	@Autowired
	private PhotoService pService;
	
	@Autowired
	@Qualifier("fileUtil")
	private FileUtil fileUtil;

	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public ModelAndView viewPhotoInsert(ModelAndView mv) {
		mv.setViewName("photo/insert");
		return mv;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public ModelAndView viewPhotoInsert(
			ModelAndView mv
			, @RequestParam(name="uploadFile", required=false) MultipartFile multi
			, HttpServletRequest request
			, @ModelAttribute Photo photo) {
		Map<String, String> fileInfo = null;
		try {
			fileInfo = fileUtil.saveFile(multi, request);
			photo.setPhotoFilename(fileInfo.get("original"));
			photo.setPhotoFileRename(fileInfo.get("rename"));
			photo.setPhotoFilepath(fileInfo.get("renameFilepath"));
			int result = pService.insertPhoto(photo);
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage()).setViewName("common/error");
		}
		mv.setViewName("redirect:/photo/list");
		return mv;
	}
	
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public String viewPhotoList() {
		return "photo/list";
	}

	// 위에꺼랑 이거랑 두가지 방법
//	@RequestMapping(value = "/list", method=RequestMethod.GET)
//	public ModelAndView viewPhotoList(ModelAndView mv) {
//		mv.setViewName("photo/list");
//		return mv;
//	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "/more", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String viewPhotoList(Integer start) {
		List<Photo> pList = pService.morePhoto(start);
		return new Gson().toJson(pList);
		//그냥 리턴하면 jsp에서 List를 받을 수 없으니까 Gson 사용
	}
	
	
	
}
