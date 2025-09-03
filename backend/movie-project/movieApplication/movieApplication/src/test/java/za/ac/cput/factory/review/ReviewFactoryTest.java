package za.ac.cput.factory.review;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.movie.Movie;
import za.ac.cput.domain.review.Review;
import za.ac.cput.domain.user.User;
import za.ac.cput.util.GenericHelper;

import java.time.LocalDate;
import java.time.LocalDateTime;

//import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class ReviewFactoryTest {

    @Test
    void createReview() {
        LocalDateTime timeStamp = LocalDateTime.of(2025, 7, 27, 14, 30);

        LocalDate birth = LocalDate.of(2025, 3, 27);

        Movie movie = new Movie.Builder()
                .setMovieId(GenericHelper.generateID())
                .setTitle("Inception")
                .setGenre("Sci-Fi")
                .setDuration("2h5m")
                .build();

        User user = new User.Builder()
                .setUserId(GenericHelper.generateID())
                .setName("Mbali")
                .setSurname("Banda")
                //.setEmail("")
                //.setPassword("")
                .setPhoneNumber("")
                .setDateOfBirth(birth)
                .setGender("Female")
                .build();


        Review review = ReviewFactory.createReview(GenericHelper.generateID(), user, movie, 4, "It was good", timeStamp, Review.Spoiler.NOT_SPOILER);

        System.out.println(review);

        assertNotNull(review);
    }
}