package com.example.YHVT19_Backend_Labb1;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TMDB_Retriever {

	// Returns an array of movies from TMDB.
	public ArrayList<Movie> returnMovieArray(JSONArray movies) {

		ArrayList<Movie> moviesArray = new ArrayList<>();

		for (int i = 0; i < movies.length(); i++) {

			JSONObject product = movies.getJSONObject(i);
			moviesArray.add(new Movie(product.getString("title"), product.getString("release_date"),
					product.getInt("vote_average"), product.getInt("id")));
		}
		return moviesArray;
	}

	// Returns a list of the most popular movie titles from TMDB.
	public List<String> get_Movie_Titles(JSONArray movies) {

		List<String> popularTitles = new ArrayList<>();

		for (int i = 0; i < movies.length(); i++) {
			JSONObject product = movies.getJSONObject(i);
			popularTitles.add(product.getString("title"));
		}

		return popularTitles;
	}

	// Returns a list of the URLs for the movie thumbnails, 154 px wide.
	public List<String> get_Movie_Thumb(JSONArray movies) {

		String url = "http://image.tmdb.org/t/p/w154";

		List<String> popularTitles_Thumbs = new ArrayList<>();

		for (int i = 0; i < movies.length(); i++) {
			JSONObject product = movies.getJSONObject(i);
			popularTitles_Thumbs.add(url + product.getString("poster_path"));
		}

		return popularTitles_Thumbs;
	}

}
