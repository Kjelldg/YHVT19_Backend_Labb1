package com.example.YHVT19_Backend_Labb1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		API_Parser api_Parser = new API_Parser();

		ArrayList<Movie> moviesArrayList = api_Parser.arrayListReturner();

		while (true) {

			System.out.println("Press 1 for viewing the most popular movies. "
					+ "\nPress 2 for sorting the movies in alphabetical order."
					+ "\nPress 3 for sorting movies after release date." + "\nPress 4 for reversing your movies list.");
			int answer = Integer.parseInt(bufferedReader.readLine());

			switch (answer) {
			case 1:
				for (Movie movie : moviesArrayList) {
					System.out.println(movie.movieTitle + "\n" + movie.releaseDate + "\n" + movie.vote_average);
				}
				break;
			case 2:
				Collections.sort(moviesArrayList, (m1, m2) -> m1.movieTitle.compareTo(m2.movieTitle));
				break;
			case 3:
				Collections.sort(moviesArrayList, (m1, m2) -> m1.releaseDate.compareTo(m2.releaseDate));
				break;
			case 4:
				Collections.reverse(moviesArrayList);
				break;
			default:
				break;

			}

		}

	}

}
