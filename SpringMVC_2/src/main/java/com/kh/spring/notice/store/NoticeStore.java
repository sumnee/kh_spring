package com.kh.spring.notice.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.spring.notice.domain.Notice;

public interface NoticeStore {
	
	/**
	 * 공지글 등록 Store
	 * @param session
	 * @param notice
	 * @return int
	 */
	public int insertNotice(SqlSession session, Notice notice);

	/**
	 * 공지글 목록 Store
	 * @return List<Notice>
	 */
	public List<Notice> selectNoticeList(SqlSession session);

	/**
	 * 공지사항 상세 조회 Store
	 * @param session
	 * @param noticeNo
	 * @return Notice
	 */
	public Notice selectOneById(SqlSession session, int noticeNo);

	/**
	 * 공지사항 삭제 Store
	 * @param session
	 * @param noticeNo
	 * @return int
	 */
	public int deleteNotice(SqlSession session, int noticeNo);

}
