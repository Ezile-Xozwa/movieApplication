package za.ac.cput.controller.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.review.Review;
import za.ac.cput.factory.review.ReviewFactory;
import za.ac.cput.service.review.ReviewService;

import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/create")
    public Review create(@RequestBody Review review) {
        Review newReview = ReviewFactory.createReview(
                review.getReviewId(),
                review.getUser(),
                review.getMovie(),
                review.getRating(),
                review.getComment(),
                review.getTimestamp(),
                review.getSpoiler()
        );
        return reviewService.create(newReview);
    }

    @GetMapping("/read/{id}")
    public Review read(@PathVariable String id) {
        return reviewService.read(id);
    }

    @PutMapping("/update")  // ← Use PUT for updates
    public Review update(@RequestBody Review review) {
        return reviewService.update(review);
    }

    @GetMapping("/all")
    public Set<Review> getAll() {
        return reviewService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        reviewService.delete(id);
    }

    @GetMapping("/movie/{movieId}")
    public Set<Review> getReviewsByMovie(@PathVariable String movieId) {
        // You'll need to add this method to ReviewRepository first
        // return reviewService.findByMovieId(movieId);
        return new HashSet<>();
    }
}