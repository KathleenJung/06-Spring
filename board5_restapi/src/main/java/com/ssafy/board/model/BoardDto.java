package com.ssafy.board.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardDto {

	private int articleNo;
	private String userId;
	private String userName;
	private String subject;
	private String content;
	private int hit;
	private String registerTime;
	private List<FileInfoDto> fileInfos;

	@Override
	public String toString() {
		return "BoardDto [articleNo=" + articleNo + ", userId=" + userId + ", userName=" + userName + ", subject="
				+ subject + ", content=" + content + ", hit=" + hit + ", registerTime=" + registerTime + ", fileInfos="
				+ fileInfos + "]";
	}

}
