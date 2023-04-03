package com.kh.marchpring.photo.service;

import java.util.List;

import com.kh.marchpring.photo.domain.Photo;

public interface PhotoService {

	/**
	 * 사진 첨부 Service
	 * @param photo
	 * @return int
	 */
	public int insertPhoto(Photo photo);

	/**
	 * 사진 목록보기 Service
	 * @param start
	 * @return List<Photo>
	 */
	public List<Photo> morePhoto(Integer start);



}
