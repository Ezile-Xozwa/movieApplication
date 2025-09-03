package za.ac.cput.factory.review;

import za.ac.cput.domain.movie.Movie;
import za.ac.cput.domain.review.Review;
import za.ac.cput.domain.user.User;
import za.ac.cput.util.ReviewValidationHelper;

import java.time.LocalDateTime;

public class ReviewFactory {

    public static Review createReview(
            String reviewId,
            User user,
            Movie movie,
            double rating,
            String comment,
            LocalDateTime timestamp,
            Review.Spoiler spoiler) {

        System.out.println("🔧 Creating review...");
        System.out.println("  reviewId: " + reviewId);
        System.out.println("  user: " + user + " → userId: " + (user != null ? user.getUserId() : "null"));
        System.out.println("  movie: " + movie + " → movieId: " + (movie != null ? movie.getMovieId() : "null"));
        System.out.println("  rating: " + rating);
        System.out.println("  comment: " + comment);
        System.out.println("  timestamp: " + timestamp);
        System.out.println("  spoiler: " + spoiler);

        if (ReviewValidationHelper.isEmptyOrNull(reviewId)
            || !ReviewValidationHelper.isValidUser(user)
            || !ReviewValidationHelper.isValidMovie(movie)
            || !ReviewValidationHelper.isRatingValid(rating)
            || ReviewValidationHelper.isEmptyOrNull(comment)
            || !ReviewValidationHelper.isValidTimeStamp(timestamp)
            || !ReviewValidationHelper.isValidSpoilerWarning(spoiler)){
            return null;
        }

        //minimal User
        User userRef;
        if (user != null && user.getUserId() != null) {
            userRef = new User.Builder().setUserId(user.getUserId()).build();
        } else {
            System.err.println("❌ Invalid user data: userId is null");
            return null;
        }

//minimal Movie
        Movie movieRef;
        if (movie != null && movie.getMovieId() != null) {
            movieRef = new Movie.Builder().setMovieId(movie.getMovieId()).build();
        } else {
            System.err.println("❌ Invalid movie data: movieId is null");
            return null;
        }

        return new Review.Builder()
                .setReviewId(reviewId)
                .setUser(userRef)
                .setMovie(movieRef)
                .setRating(rating)
                .setComment(comment)
                .setTimestamp(timestamp)
                .setSpoiler(spoiler)
                .build();
    }
}
