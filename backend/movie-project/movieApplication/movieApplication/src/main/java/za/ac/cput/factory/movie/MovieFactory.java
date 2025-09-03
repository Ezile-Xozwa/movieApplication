package za.ac.cput.factory.movie;

import za.ac.cput.domain.movie.Movie;
import za.ac.cput.util.MovieValidationHelper;

public class MovieFactory {
    public static Movie createMovie(String title, String movieId, String genre, String duration) {

        if (MovieValidationHelper.IsEmptyOrNullString(title) ||
                MovieValidationHelper.IsEmptyOrNullString(movieId) ||
                MovieValidationHelper.IsEmptyOrNullString(genre) ||
                MovieValidationHelper.IsEmptyOrNullString(duration))
                {
            return null;
        }

        return new Movie.Builder()
                .setMovieId(movieId)
                .setTitle(title)
                .setGenre(genre)
                .setDuration(duration)
                .build();
    }

}

