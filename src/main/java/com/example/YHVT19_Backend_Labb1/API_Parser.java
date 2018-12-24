package com.example.YHVT19_Backend_Labb1;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class API_Parser {

	// These static strings are used instead of inserting them below, to reduce
	// clutter.
	static String TMDB_POPULAR_MOVIES = "https://api.themoviedb.org/3/movie/popular?api_key=";
	static String TMDB_SEARCH_MOVIES = "https://api.themoviedb.org/3/search/movie?api_key=";
	static String TMDB_UPCOMING_MOVIES = "https://api.themoviedb.org/3/movie/top_rated?api_key=";
	static String API_Key = "eecc8ae5b1c378032fe7a8ca2ce11da9";
	static String LANGUAGE_AND_PAGES = "&language=en-US&page=1";

	public ArrayList<Movie> popularMoviesReturner() {

		ArrayList<Movie> moviesArrayList = null;

		TMDB_Retriever movie_Info_Retriever = new TMDB_Retriever();

		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/octet-stream");
		RequestBody body = RequestBody.create(mediaType, "{}");
		Request request = new Request.Builder().url(TMDB_POPULAR_MOVIES + API_Key + LANGUAGE_AND_PAGES).get().build();

		try {
			Response response = client.newCall(request).execute();

			String responseData = response.body().string();
			JSONObject jsonObject = new JSONObject(responseData);

			// The array for all the popular movies on page 1.
			JSONArray moviesArray = jsonObject.getJSONArray("results");

			moviesArrayList = movie_Info_Retriever.returnMovieArray(moviesArray);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return moviesArrayList;

	}

	public ArrayList<Movie> searchMoviesReturner(String userQuery) {

		ArrayList<Movie> moviesArrayList = null;

		TMDB_Retriever movie_Info_Retriever = new TMDB_Retriever();

		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/octet-stream");
		RequestBody body = RequestBody.create(mediaType, "{}");
		Request request = new Request.Builder().url(
				TMDB_SEARCH_MOVIES + API_Key + "&language=en-US&query=" + userQuery + "&page=1&include_adult=false")
				.get().build();

		try {
			Response response = client.newCall(request).execute();

			String responseData = response.body().string();
			JSONObject jsonObject = new JSONObject(responseData);

			// The array for all the popular movies on page 1.
			JSONArray moviesArray = jsonObject.getJSONArray("results");

			moviesArrayList = movie_Info_Retriever.returnMovieArray(moviesArray);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return moviesArrayList;

	}

	public ArrayList<Movie> topRatedMoviesReturner() {

		ArrayList<Movie> moviesArrayList = null;

		TMDB_Retriever movie_Info_Retriever = new TMDB_Retriever();

		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/octet-stream");
		RequestBody body = RequestBody.create(mediaType, "{}");
		Request request = new Request.Builder().url(TMDB_UPCOMING_MOVIES + API_Key + LANGUAGE_AND_PAGES).get().build();

		try {
			Response response = client.newCall(request).execute();

			String responseData = response.body().string();
			JSONObject jsonObject = new JSONObject(responseData);

			// The array for all the popular movies on page 1.
			JSONArray moviesArray = jsonObject.getJSONArray("results");

			moviesArrayList = movie_Info_Retriever.returnMovieArray(moviesArray);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return moviesArrayList;

	}

}
