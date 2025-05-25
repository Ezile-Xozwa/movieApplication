package za.ac.cput.factory;
/*ShowtimeFactory.java

     ShowtimeFactoryclass

     Author: Katie Khezani Tolo (222831960)

     Date: 17 May 2025 */
import za.ac.cput.domain.Showtime;
import java.time.LocalDate;
import java.time.LocalDateTime;
import za.ac.cput.util.ShowtimeValidationHelper;

public class ShowtimeFactory {
    public static Showtime createShowtime(String showtimeId, String movie, LocalDateTime startTime, LocalDate date) {
        if (ShowtimeValidationHelper.isEmptyOrNullString(showtimeId)
                || ShowtimeValidationHelper.isEmptyOrNullString(movie)
                ||ShowtimeValidationHelper.isValidStartTime(startTime)
                || ShowtimeValidationHelper.isValidDate(date)){
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
