package com.example.YHVT19_Backend_Labb1;

public class Movie {

	String movieTitle;
	String releaseDate;

	public Movie(String movieTitle, String releaseDate) {
		this.movieTitle = movieTitle;
		this.releaseDate = releaseDate;
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

}
