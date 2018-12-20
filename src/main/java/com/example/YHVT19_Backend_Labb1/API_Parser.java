package com.example.YHVT19_Backend_Labb1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

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
	static String API_Key = "eecc8ae5b1c378032fe7a8ca2ce11da9";
	static String TMDB_URL = "https://api.themoviedb.org/3/movie/popular?api_key=";
	static String LANGUAGE_AND_PAGES = "&language=en-US&page=1";

	public ArrayList<Movie> arrayListReturner() {

		ArrayList<Movie> moviesArrayList = null;

		TMDB_Retriever movie_Info_Retriever = new TMDB_Retriever();

		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/octet-stream");
		RequestBody body = RequestBody.create(mediaType, "{}");
		Request request = new Request.Builder().url(TMDB_URL + API_Key + LANGUAGE_AND_PAGES).get().build();

		try {
			Response response = client.newCall(request).execute();

			String responseData = response.body().string();
			JSONObject jsonObject = new JSONObject(responseData);

			// The array for all the popular movies on page 1.
			JSONArray moviesArray = jsonObject.getJSONArray("results");

			moviesArrayList = movie_Info_Retriever.returnMovieArray(moviesArray);

//			// Returns a list of the most popular movie titles thumbnails from TMDB.
//			for (Movie movie : moviesArrayList) {
//				System.out.println("Objects from the movie array: \n" + movie.movieTitle + "\n" + movie.releaseDate);
//			}
//
//			Collections.sort(moviesArrayList, (m1, m2) -> m1.movieTitle.compareTo(m2.movieTitle));
//
//			// Returns a list of the most popular movie titles thumbnails from TMDB.
//			for (Movie movie : moviesArrayList) {
//				System.out.println(
//						"Objects from the ****NEW**** movie array: \n" + movie.movieTitle + "\n" + movie.releaseDate);
//			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return moviesArrayList;

	}

}
