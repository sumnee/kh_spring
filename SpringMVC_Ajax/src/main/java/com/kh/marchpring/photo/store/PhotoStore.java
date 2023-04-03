package com.kh.marchpring.photo.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.marchpring.photo.domain.Photo;

public interface PhotoStore {

	
	int insertPhoto(SqlSession session, Photo photo);

	List<Photo> morePhoto(SqlSession session, Integer start);

}
