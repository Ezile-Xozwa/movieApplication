package za.ac.cput.service.review;

import za.ac.cput.domain.review.Review;
import za.ac.cput.service.Service;

import java.util.Set;

public interface ReviewService extends Service<Review, String> {
    // You can add review-specific methods here later
    // e.g., Set<Review> findByMovieId(String movieId);
    Set<Review> getReviews(); // Add this
}