package com.ssafy.movie.service;

import java.util.HashMap;
import java.util.List;

import com.ssafy.movie.dto.Director;

public interface DirectorService {
	void addDirector(Director director);
	void modifyDirector(Director director);
	void removeDirector(String id);
	Director findDirector(String id);
	List<Director> findDirectorList();
	Director findDirectorWithMovieList(String id);
	List<Director> findDirectorWithMultiCondition(HashMap<String, Object> conditions);

}










