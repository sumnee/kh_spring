package com.kh.spring.notice.service;

import java.util.List;

import com.kh.spring.member.domain.PageInfo;
import com.kh.spring.notice.domain.Notice;
import com.kh.spring.notice.domain.Search;

public interface NoticeService {
	
	/**
	 * 공지글 등록 Service
	 * @param notice
	 * @return int
	 */
	public int insertNotice(Notice notice);

	/**
	 * 공지사항 수정 Service
	 * @param notice
	 * @return int
	 */
	public int updateNotice(Notice notice);

	/**
	 * 공지사항 삭제 Service
	 * @param noticeNo
	 * @return int
	 */
	public int deleteNotice(int noticeNo);

	/**
	 * 공지글 목록 Service
	 * @return List<Notice>
	 */
	public List<Notice> selectNoticeList(PageInfo pi);

	/**
	 * 공지사항 상세 조회 Service
	 * @param noticeNo
	 * @return Notice
	 */
	public Notice selectOneById(int noticeNo);

	/**
	 * 공지사항 검색 Service
	 * @param pi 
	 * @param search
	 * @return List<Notice>
	 */
	public List<Notice> selectListByKeyword(PageInfo pi, Search search);

	/**
	 * 공지사항 전체 개수 Service
	 * @return int
	 */
	public int getListCount();

	/**
	 * 검색된 공지사항 전체 개수 Service
	 * @param search
	 * @return int
	 */
	public int getListCount(Search search);
	//오버로딩(변수,메소드 다름) 오버라이딩(완전 똑같)

}
