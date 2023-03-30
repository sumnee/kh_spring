package com.kh.marchpring.board.domain;

import java.sql.Timestamp;

public class Reply {
	
	private int replyNo;
	private int refBoardNo;
	private String replyContents;
	private String replyWriter;
	private Timestamp rCreateDate;
	private Timestamp rUpdateDate;
	private String rStatus;
	
	
	
	public int getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
	public String getReplyContents() {
		return replyContents;
	}
	public void setReplyContents(String replyContents) {
		this.replyContents = replyContents;
	}
	public int getRefBoardNo() {
		return refBoardNo;
	}
	public void setRefBoardNo(int refBoardNo) {
		this.refBoardNo = refBoardNo;
	}
	public String getReplyWriter() {
		return replyWriter;
	}
	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}
	public Timestamp getrCreateDate() {
		return rCreateDate;
	}
	public void setrCreateDate(Timestamp rCreateDate) {
		this.rCreateDate = rCreateDate;
	}
	public Timestamp getrUpdateDate() {
		return rUpdateDate;
	}
	public void setrUpdateDate(Timestamp rUpdateDate) {
		this.rUpdateDate = rUpdateDate;
	}
	public String getrStatus() {
		return rStatus;
	}
	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}
	
	
	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", replyContents=" + replyContents + ", refBoardNo=" + refBoardNo
				+ ", replyWriter=" + replyWriter + ", rCreateDate=" + rCreateDate + ", rUpdateDate=" + rUpdateDate
				+ ", rStatus=" + rStatus + "]";
	}	
	
}
