package com.ssafy.board.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor		// 기본 생성자
@AllArgsConstructor 	// 모든 변수를 사용하는 생성자
@RequiredArgsConstructor// 특정 변수를 활용해서 생성자를 자동 생성
@ToString
public class BoardDto {

	@NonNull
	private int articleNo;
	@NonNull
	private String userId;
	@NonNull
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
