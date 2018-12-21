package com.example.YHVT19_Backend_Labb1;

public class Movie {

	String movieTitle;
	String releaseDate;
	int vote_average;
	int runtime;
	String tagline;

	public Movie(String movieTitle, String releaseDate, int vote_average) {
		this.movieTitle = movieTitle;
		this.releaseDate = releaseDate;
		this.vote_average = vote_average;
		this.runtime = runtime;
		this.tagline = tagline;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getVote_average() {
		return vote_average;
	}

	public void setVote_average(int vote_average) {
		this.vote_average = vote_average;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

}
