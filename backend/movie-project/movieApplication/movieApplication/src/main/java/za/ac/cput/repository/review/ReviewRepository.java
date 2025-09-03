package za.ac.cput.repository.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.review.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, String> {
    // You can add custom queries later, e.g.
    // List<Review> findByMovie_MovieId(String movieId);

}