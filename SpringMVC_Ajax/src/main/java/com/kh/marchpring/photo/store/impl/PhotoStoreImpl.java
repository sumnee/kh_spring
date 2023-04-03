package com.kh.marchpring.photo.store.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.marchpring.photo.domain.Photo;
import com.kh.marchpring.photo.store.PhotoStore;

@Repository
public class PhotoStoreImpl implements PhotoStore{

	@Override
	public int insertPhoto(SqlSession session, Photo photo) {
		int result = session.insert("PhotoMapper.insertPhoto", photo);
		return result;
	}

	@Override
	public List<Photo> morePhoto(SqlSession session, Integer start) {
		int limit = 3; //한페이지에 몇개?
		int offset = (start - 1) * limit; 
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Photo> pList = session.selectList("PhotoMapper.morePhotoList", null, rowBounds);
		return pList;
	}

}
