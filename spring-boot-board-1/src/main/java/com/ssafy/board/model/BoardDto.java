package com.ssafy.board.model;

import java.util.List;

public class BoardDto {
	private int articleNo;
	private String userId;
	private String userName;
	private String subject;
	private String content;
	private int hit;
	private String registerTime;
	private List<FileInfoDto> fileInfos;
	public int getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}
	public List<FileInfoDto> getFileInfos() {
		return fileInfos;
	}
	public void setFileInfos(List<FileInfoDto> fileInfos) {
		this.fileInfos = fileInfos;
	}
	public BoardDto() {
		super();
	}
	public BoardDto(int articleNo, String userId, String userName, String subject, String content, int hit,
			String registerTime, List<FileInfoDto> fileInfos) {
		super();
		this.articleNo = articleNo;
		this.userId = userId;
		this.userName = userName;
		this.subject = subject;
		this.content = content;
		this.hit = hit;
		this.registerTime = registerTime;
		this.fileInfos = fileInfos;
	}
}
