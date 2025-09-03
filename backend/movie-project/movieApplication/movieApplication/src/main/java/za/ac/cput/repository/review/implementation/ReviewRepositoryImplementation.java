//package za.ac.cput.repository.review.implementation;
//
//import za.ac.cput.domain.review.Review;
//import za.ac.cput.repository.review.ReviewRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class ReviewRepositoryImplementation implements ReviewRepository {
//
//    private Set<Review> reviewsDB;
//
//    private static ReviewRepository reviewRepository;
//
//    public ReviewRepositoryImplementation() {
//        this.reviewsDB = new HashSet<Review>();
//    }
//
//    public static ReviewRepository reviewRepository() {
//        if (reviewRepository == null) {
//            reviewRepository = new ReviewRepositoryImplementation();
//        }
//        return reviewRepository;
//    }
//
//    @Override
//    public Review create (Review review) {
//        this.reviewsDB.add(review);
//        return review;
//    }
//
//    @Override
//    public Review read(String reviewId) {
//        Review review = this.reviewsDB.stream()
//                .filter(r -> r.getReviewId().equals(reviewId))
//                .findAny()
//                .orElse(null);
//        return review;
//    }
//
//    @Override
//    public Review update(Review updatereview) {
//        Review review = read(updatereview.getReviewId());
//        if (review == null) {
//            this.reviewsDB.remove(review);
//            this.reviewsDB.add(review);
//        }
//        return review;
//    }
//
//    @Override
//    public void delete(String reviewId) {
//        Review review = read(reviewId);
//        if (review != null) {
//            this.reviewsDB.remove(review);
//        }
//    }
//
//    @Override
//    public Set<Review> getAll() {
//        return this.reviewsDB;
//    }
//
//}
