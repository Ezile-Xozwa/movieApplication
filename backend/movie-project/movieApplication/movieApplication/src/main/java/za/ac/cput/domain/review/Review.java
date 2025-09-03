package za.ac.cput.domain.review;

import jakarta.persistence.*;
import za.ac.cput.domain.movie.Movie;
import za.ac.cput.domain.user.User;

import java.time.LocalDateTime;

@Entity
public class Review {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String reviewId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn (name = "movie_id")
    private Movie movie;

    private double rating;
    private String comment;
    private LocalDateTime timestamp;

    public enum Spoiler {SPOILER, NOT_SPOILER};
    private Spoiler spoiler;
    //apparently isSpoiler should Spoiler

    protected Review() {

    }

    public Review(Builder builder) {
        this.reviewId = builder.reviewId;
        this.user = builder.user;
        this.movie = builder.movie;
        this.rating = builder.rating;
        this.comment = builder.comment;
        this.timestamp = builder.timestamp;
        this.spoiler = builder.spoiler;

    }

    public String getReviewId() {
        return reviewId;
    }
    public User getUser() {
        return user;
    }
    public Movie getMovie() {
        return movie;
    }
    public double getRating() {
        return rating;
    }
    public String getComment() {
        return comment;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public Spoiler getSpoiler() {
        return spoiler;
    }

    @Override
    public String toString() {
        return "Review{" +
                "comment='" + comment + '\'' +
                ", reviewId='" + reviewId + '\'' +
                ", user='" + user + '\'' +
                ", movie='" + movie + '\'' +
                ", rating=" + rating +
                ", timestamp=" + timestamp +
                ", spoiler=" + spoiler +
                '}';
    }

    public static class Builder {
        private String reviewId;
        private User user;
        private Movie movie;
        private double rating;
        private String comment;
        private LocalDateTime timestamp;
        private Spoiler spoiler;

        public Builder setReviewId(String reviewId) {
            this.reviewId = reviewId;
            return this;
        }
        public Builder setUser(User user) {
            this.user = user;
            return this;
        }
        public Builder setMovie(Movie movie) {
            this.movie = movie;
            return this;
        }
        public Builder setRating(double rating) {
            this.rating = rating;
            return this;
        }
        public Builder setComment(String comment) {
            this.comment = comment;
            return this;
        }
        public Builder setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }
        public Builder setSpoiler(Spoiler spoiler) {
            this.spoiler = spoiler;
            return this;
        }

        public Builder copy(Review review){
            this.reviewId = review.getReviewId();
            this.user = review.getUser();
            this.movie = review.getMovie();
            this.rating = review.getRating();
            this.comment = review.getComment();
            this.timestamp = review.getTimestamp();
            this.spoiler = review.getSpoiler();
            return this;
        }

        public Review build() {
            return new Review(this);
        }

    }


}
