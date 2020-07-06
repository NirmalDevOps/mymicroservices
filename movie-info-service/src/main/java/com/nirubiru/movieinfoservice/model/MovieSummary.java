package com.nirubiru.movieinfoservice.model;

public class MovieSummary {
	
	private String Id;
	private String title;
	private String overview;
	public MovieSummary() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MovieSummary(String id, String title, String overview) {
		super();
		Id = id;
		this.title = title;
		this.overview = overview;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	
}
