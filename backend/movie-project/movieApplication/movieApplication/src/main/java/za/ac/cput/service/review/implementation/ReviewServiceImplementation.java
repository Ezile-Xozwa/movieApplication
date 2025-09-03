package za.ac.cput.service.review.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.review.Review;
import za.ac.cput.repository.review.ReviewRepository;
import za.ac.cput.service.review.ReviewService;

import java.util.Set;
import java.util.HashSet;

@Service
public class ReviewServiceImplementation implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review create(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review read(String id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public Review update(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public void delete(String id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public Set<Review> getAll() {
        return getReviews(); // Delegate
    }
    @Override
    public Set<Review> getReviews() {
        return new HashSet<>(reviewRepository.findAll());
    }

}