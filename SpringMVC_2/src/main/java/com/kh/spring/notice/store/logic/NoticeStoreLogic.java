package com.kh.spring.notice.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.spring.member.domain.PageInfo;
import com.kh.spring.notice.domain.Notice;
import com.kh.spring.notice.domain.Search;
import com.kh.spring.notice.store.NoticeStore;

@Repository
public class NoticeStoreLogic implements NoticeStore{

	@Override
	public int insertNotice(SqlSession session, Notice notice) {
		int result = session.insert("NoticeMapper.insertNotice", notice);
		return result;
	}

	@Override
	public int updateNotice(SqlSession session, Notice notice) {
		int result = session.update("NoticeMapper.updateNotice", notice);
		return result;
	}

	@Override
	public int deleteNotice(SqlSession session, int noticeNo) {
		int result = session.delete("NoticeMapper.deleteNotice", noticeNo);
		return result;
	}

	@Override
	public List<Notice> selectNoticeList(SqlSession session, PageInfo pi) {
		/*
		 * RowBounds : 쿼리문을 변경하지 않고도 페이징처리 할 수 있게 해주는 클래스
		 * RowBounds 동작 : offset, limit 값을 이용하여 동작
		 * offset : 변하는 값(건너뛰어야할 값) / limit : 고정값(한페이지 당 게시물 수)
		 * ex> limit 10, offset = 0, 1~10
		 * ex> limit 10, offset = 10, 11~20
		 * 		int offset = (currentPage - 1) * limit;
		 */
		int limit = pi.getBoardLimit();
		int currentPage = pi.getCurrenPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Notice> nList = session.selectList("NoticeMapper.selectNoticeList", null, rowBounds);
		return nList;
	}

	@Override
	public Notice selectOneById(SqlSession session, int noticeNo) {
		Notice notice = session.selectOne("NoticeMapper.selectOneById", noticeNo);
		return notice;
	}

	@Override
	public List<Notice> selectListByKeyword(SqlSession session, PageInfo pi, Search search) {
		int limit = pi.getBoardLimit();
		int currentPage = pi.getCurrenPage();
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Notice> searchList = session.selectList("NoticeMapper.selectListByKeyword", search, rowBounds);
		return searchList;
	}

	@Override
	public int getListCount(SqlSession session) {
		int result = session.selectOne("NoticeMapper.getListCount");
		return result;
	}

	@Override
	public int getListCount(SqlSession session, Search search) {
		int result = session.selectOne("NoticeMapper.searchListCount", search);
		return result;
	}

}
