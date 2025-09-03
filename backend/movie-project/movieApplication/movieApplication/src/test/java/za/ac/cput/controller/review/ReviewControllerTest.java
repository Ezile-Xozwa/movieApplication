package za.ac.cput.controller.review;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.movie.Movie;
import za.ac.cput.domain.review.Review;
import za.ac.cput.domain.user.User;
import za.ac.cput.factory.review.ReviewFactory;
import za.ac.cput.util.GenericHelper;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ReviewControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseUrl = "http://localhost:8080/review";

    static LocalDate birth = LocalDate.of(2025, 3, 27);

    static LocalDateTime timeStamp = LocalDateTime.of(2025, 7, 27, 14, 30);

    static User user = new User.Builder()
            .setUserId(GenericHelper.generateID())
            .setName("Mbali")
            .setSurname("Banda")
            .setPhoneNumber("")
            .setDateOfBirth(birth)
            .setGender("Female")
            .build();

    static Movie movie = new Movie.Builder()
            .setMovieId(GenericHelper.generateID())
            .setTitle("Inception")
            .setDuration("2h5m")
            .setGenre("Sci-Fi")
            .build();

    private static Review review = ReviewFactory.createReview(GenericHelper.generateID(), user, movie, 4.5, "It was good", timeStamp, Review.Spoiler.NOT_SPOILER);

    @Test
    @Order(1)
    void create() {
        String url = baseUrl + "/reviews";
        System.out.println("Post data: " + review);
        ResponseEntity<Review> postResponse = restTemplate.postForEntity(url, review, Review.class);
        System.out.println("Save data: " + review);
        assertNotNull(postResponse.getBody());
    }

    @Test
    @Order(2)
    void read() {
        String url = baseUrl + "/reviews/" + review.getReviewId();
        System.out.println("URL: " + url);
        ResponseEntity<Review> postResponse = restTemplate.getForEntity(url, Review.class);
        assertNotNull(postResponse.getBody());
    }

    @Test
    @Order(3)
    void update() {
        Review updated = new Review.Builder().copy(review).setReviewId(review.getReviewId()).build();
        //String url = baseUrl + "/reviews/" + review.getReviewId();
        String url = baseUrl + "/reviews/";
        System.out.println("Post data: " + updated);
        ResponseEntity<Review> response = restTemplate.postForEntity(url, updated, Review.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Order(4)
    void getAll() {
        String url = baseUrl + "All";
        System.out.println("URL: " + url);
    }

    @Test
    @Order(5)
    void delete() {
        String url = baseUrl + "/reviews/" + review.getReviewId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }
}