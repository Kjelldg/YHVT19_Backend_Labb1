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
	static String TMDB_SIMILAR_MOVIES = "https://api.themoviedb.org/3/movie/6977/similar?api_key=";
	static String API_Key = "eecc8ae5b1c378032fe7a8ca2ce11da9";
	static String LANGUAGE_AND_PAGES = "&language=en-US&page=1";

	// This method returns the most popular movies as an arraylist.
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

	/*
	 * Returns the image path for the most popular movie, usable for creating hero
	 * images for the website.
	 */
	public String get_Hero_Image() {

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

			String url = "http://image.tmdb.org/t/p/w1280";
			JSONObject firstMovie = moviesArray.getJSONObject(0);
			String popular_Movie_HeroImage = firstMovie.getString("backdrop_path");

			return url + popular_Movie_HeroImage;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return "Error.";

	}

	/*
	 * This method allows the user to search for movies. A string is sent from the
	 * Main class and used here for searching for a movie. An arraylist is then
	 * returned with the results.
	 */
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

	// This method returns the high rated movies as an arraylist.
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

	/*
	 * This method allows the user to retrieve a movie similar to the movie searched
	 * for. It takes an int, movieID which is passed to the URL in Request. The int
	 * is retrieved from the "searchMoviesReturner" method. This is because you can
	 * only use an int to search for similar movies. The searchMoviesReturner allows
	 * you to use String.
	 */
	public ArrayList<Movie> similarMoviesReturner(int movieID) {

		ArrayList<Movie> moviesArrayList = null;

		TMDB_Retriever movie_Info_Retriever = new TMDB_Retriever();

		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/octet-stream");
		RequestBody body = RequestBody.create(mediaType, "{}");
		Request request = new Request.Builder().url(
				"https://api.themoviedb.org/3/movie/" + movieID + "/similar?api_key=" + API_Key + LANGUAGE_AND_PAGES)
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

}
