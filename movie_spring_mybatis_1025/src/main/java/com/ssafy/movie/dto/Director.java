package com.ssafy.movie.dto;

import java.util.List;

public class Director {
	private String id;
	private String name;
	private int age;
	private int winnerCount;
	
	private List<Movie> movies; // 1:n
	
	public Director() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Director(String id, String name, int age, int winnerCount) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.winnerCount = winnerCount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWinnerCount() {
		return winnerCount;
	}

	public void setWinnerCount(int winnerCount) {
		this.winnerCount = winnerCount;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Director [id=" + id + ", name=" + name + ", age=" + age
				+ ", winnerCount=" + winnerCount + "]";
	}
	
}
