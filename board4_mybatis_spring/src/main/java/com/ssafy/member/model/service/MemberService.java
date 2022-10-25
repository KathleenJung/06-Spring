package com.ssafy.member.model.service;

import java.sql.SQLException;
import java.util.Map;

import com.ssafy.member.model.MemberDto;

public interface MemberService {

	int idCheck(String userId) throws Exception;

	void joinMember(MemberDto memberDto) throws Exception;

	MemberDto loginMember(Map<String, String> map) throws Exception;

	MemberDto getMember(String userId) throws SQLException;

	void updateMember(MemberDto memberDto) throws SQLException;

	void deleteMember(String userId) throws SQLException;

}
