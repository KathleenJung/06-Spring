package com.ssafy.movie.dto;

public class Movie {
	private int id;
	private String title;
	private String directorId;
	private int year;
	
	private Director director; // 1:1
	
	public Movie() {
		super();
	}

	public Movie(int id, String title, String directorId, int year) {
		super();
		this.id = id;
		this.title = title;
		this.directorId = directorId;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirectorId() {
		return directorId;
	}

	public void setDirectorId(String directorId) {
		this.directorId = directorId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	
	
	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", directorId="
				+ directorId + ", year=" + year + ", director=" + director
				+ "]";
	}


	
	
	

	
}
