package za.ac.cput.util;

import za.ac.cput.domain.movie.Movie;
import za.ac.cput.domain.review.Review;
import za.ac.cput.domain.user.User;

import java.time.LocalDateTime;

public class ReviewValidationHelper {

//    public static boolean isEmptyOrNull(String reviewId) {
//        return reviewId == null || reviewId.isEmpty();
//    }
public static boolean isEmptyOrNull(String s) {
    return s == null || s.trim().isEmpty();
}

//    public static boolean isValidUser(User user) { //got it from payment class, don't fully understand why we have it cause showtime doesn't have it
//        return user != null;
//    }
public static boolean isValidUser(User user) {
    return user != null && user.getUserId() != null && !user.getUserId().isEmpty();
}

//    public static boolean isValidMovie(Movie movie) { //got it from payment class, don't fully understand why we have it cause showtime doesn't have it
//        return movie != null;
//    }
public static boolean isValidMovie(Movie movie) {
    return movie != null && movie.getMovieId() != null && !movie.getMovieId().isEmpty();
}

    public static boolean isRatingValid(double rating) {
        return rating >= 1 && rating <= 5;
    }
//        {
//            return false;
//        }
//        return true;
//    }

//    public static boolean isEmptyOrNull(String comment){
//        return comment == null || comment.isEmpty();
//    }

//    public static boolean isValidTimeStamp(java.time.LocalDateTime startTime) {
//        return startTime != null && startTime.isAfter(java.time.LocalDateTime.now());
//    }
public static boolean isValidTimeStamp(LocalDateTime timestamp) {
    return timestamp != null && !timestamp.isAfter(java.time.LocalDateTime.now().plusMinutes(1));
}

    public static boolean isValidSpoilerWarning(Review.Spoiler spoiler) {
        return spoiler == Review.Spoiler.SPOILER || spoiler == Review.Spoiler.NOT_SPOILER;
    }


}
