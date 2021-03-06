package com.example.YHVT19_Backend_Labb1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		// Bufferedreader is used for registering user input.
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		API_Parser api_Parser = new API_Parser(); // Class instantiating for API_Parser

		// This list is populated from the API_Parser class, it contains the most
		// popular movies.
		ArrayList<Movie> moviesArrayList = api_Parser.popularMoviesReturner();
		boolean loop = true;

		// This loop allows the user to perform the actions below:
		while (loop == true) {
			System.out.println("Press 1 for viewing the most popular movies. "
					+ "\nPress 2 to search for a movie in the TMDB database."
					+ "\nPress 3 to view top rated movies in the TMDB database."
					+ "\nPress 4 for searching for similar movies to a movie of your choice."
					+ "\nPress 5 for retrieving a hero image of the most popular movie."
					+ "\nPress 6 for sorting the movies in alphabetical order."
					+ "\nPress 7 for sorting movies after release date."
					+ "\nPress 8 for sorting movies after vote average."
					+ "\nPress 9 for reversing the order of your movies list."
					+ "\nPress 10 for exiting the program. ");
			int answer = Integer.parseInt(bufferedReader.readLine());

			switch (answer) {
			case 1:
				for (Movie movie : moviesArrayList) {
					System.out.println("Movie title: " + movie.movieTitle + "\nRelease date: " + movie.releaseDate
							+ "\nVote average: " + movie.vote_average + "\nMovie id: " + movie.movieID + "\n********");
				}
				break;
			case 2:
				System.out.println("Please enter the name of the movie you want to search for: ");
				ArrayList<Movie> searchedMoviesArrayList = api_Parser.searchMoviesReturner(bufferedReader.readLine());
				for (Movie movie : searchedMoviesArrayList) {
					System.out.println("Movie title: " + movie.movieTitle + "\nRelease date: " + movie.releaseDate
							+ "\nVote average: " + movie.vote_average + "\n********");
				}
				break;
			case 3:
				ArrayList<Movie> upcomingMoviesArrayList = api_Parser.topRatedMoviesReturner();
				for (Movie movie : upcomingMoviesArrayList) {
					System.out.println("Movie title: " + movie.movieTitle + "\nRelease date: " + movie.releaseDate
							+ "\nVote average: " + movie.vote_average + "\n********");
				}
				break;
			case 4:
				System.out.println("Please enter the name of the movie you want to get similar movies for: ");
				ArrayList<Movie> searchedMoviesArrayListForID = api_Parser
						.searchMoviesReturner(bufferedReader.readLine());
				int movieID = searchedMoviesArrayListForID.get(0).movieID;
				ArrayList<Movie> similarMoviesArrayList = api_Parser.similarMoviesReturner(movieID);
				for (Movie movie : similarMoviesArrayList) {
					System.out.println("Movie title: " + movie.movieTitle + "\nRelease date: " + movie.releaseDate
							+ "\nVote average: " + movie.vote_average + "\n********");
				}
				break;
			case 5:
				String heroImage = api_Parser.get_Hero_Image();
				System.out.println(heroImage);
				break;
			case 6:
				Collections.sort(moviesArrayList, (m1, m2) -> m1.movieTitle.compareTo(m2.movieTitle));
				break;
			case 7:
				Collections.sort(moviesArrayList, (m1, m2) -> m1.releaseDate.compareTo(m2.releaseDate));
				break;
			case 8:
				moviesArrayList.sort((m1, m2) -> Integer.compare(m2.vote_average, m1.vote_average));
				break;
			case 9:
				Collections.reverse(moviesArrayList);
				break;
			case 10:
				System.out.println("Goodbye!");
				loop = false;
				break;
			default:
				System.out.println("Invalid command.");
				break;
			}

		}

		System.out.println("Program exited.");

	}

}
