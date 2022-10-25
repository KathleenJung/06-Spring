package com.ssafy.movie.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.movie.dto.Director;


//@Mapper
@Repository
public interface DirectorDAO {
	//감독 정보 등록
	void insertDirector(Director director);
	//감독 정보 수정
	void updateDirector(Director director);
	//감독 정보 삭제
	void deleteDirector(String id);
	//감독 이름 선택하면 감독 정보 보여주기
	Director selectDirector(String id);
	//list 페이지에 감독 목록 보여주기
	List<Director> selectDirectorList();
	//감독 이름 선택하면 감독 정보와 함께 감독의 영화 리스트 함께 보여주기
	Director selectDirectorWithMovieList(String id);
	//이름or나이로 검색 시 조건에 맞는 감독 리스트 보여주기
	List<Director> selectDirectorWithMultiCondition(
			HashMap<String, Object> conditions);

}
