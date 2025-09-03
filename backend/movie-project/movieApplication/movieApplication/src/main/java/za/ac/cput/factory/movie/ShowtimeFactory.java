package za.ac.cput.factory.movie;

import za.ac.cput.domain.movie.Movie;
import za.ac.cput.domain.movie.Showtime;
import java.time.LocalDate;
import java.time.LocalDateTime;
import za.ac.cput.util.ShowtimeValidationHelper;

public class ShowtimeFactory {
    public static Showtime createShowtime(String showtimeId, Movie movie, LocalDateTime startTime, LocalDate date) {
        if (ShowtimeValidationHelper.isEmptyOrNullString(showtimeId)
                || !ShowtimeValidationHelper.isValidMovie(movie)
                // || ShowtimeValidationHelper.isEmptyOrNullString(movie)
                || !ShowtimeValidationHelper.isValidStartTime(startTime)
                || !ShowtimeValidationHelper.isValidDate(date)){
            return null;
        }

        return new Showtime.Builder()
                .setShowtimeId(showtimeId)
                .setMovie(movie)
                .setStartTime(startTime)
                .setDate(date)
                .build();
    }
}

//But on git, it's still like this:
//if (ShowtimeValidationHelper.isEmptyOrNullString(showtimeId)
//                || ShowtimeValidationHelper.isEmptyOrNullString(movie)
//                ||ShowtimeValidationHelper.isValidStartTime(startTime)
//                || ShowtimeValidationHelper.isValidDate(date)){
//        return null;
//        }


//Don't know what this below is
//        if (
//                ShowtimeValidationHelper.isEmptyOrNullString(showtimeId)
//                        || movie == null
//                        || startTime == null
//                        || date == null
//        ) {
//            return null;
//        }
