package com.ssafy.movie.service;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.movie.dto.Director;
import com.ssafy.movie.mapper.DirectorDAO;

@Service
public class DirectorServiceImpl implements DirectorService {

	private DirectorDAO directorDao;
	
	@Autowired
	public void setDirectorDao(DirectorDAO directorDao) {
		this.directorDao = directorDao;
	}
	@Override
	public void addDirector(Director director) {
		directorDao.insertDirector(director);
	}

	@Override
	public void modifyDirector(Director director) {
		directorDao.updateDirector(director);
	}

	@Override
	public void removeDirector(String id) {
		directorDao.deleteDirector(id);
	}

	@Override
	public Director findDirector(String id) {
		return directorDao.selectDirector(id);
	}

	@Override
	public List<Director> findDirectorList() {
		return directorDao.selectDirectorList();
	}
	@Override
	public Director findDirectorWithMovieList(String id) {
		// TODO Auto-generated method stub
		return directorDao.selectDirectorWithMovieList(id);
	}
	@Override
	public List<Director> findDirectorWithMultiCondition(HashMap<String, Object> conditions) {
		// TODO Auto-generated method stub
		return directorDao.selectDirectorWithMultiCondition(conditions);
	}

}
