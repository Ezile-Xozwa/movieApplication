package za.ac.cput.domain.movie;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String movieId;

    private String title;
    private String genre;
    private String duration;

    protected Movie() {

    }

    private Movie(Builder builder) {
        this.movieId = builder.movieId;
        this.title = builder.title;
        this.genre = builder.genre;
        this.duration = builder.duration;
            }

    public String getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDuration() {
        return duration;
    }


    @Override
    public String toString() {
        return    "Movie Id: " + movieId + "\n"
                + "Title: " + title + "\n"
                + "Genre: " + genre + "\n"
                + "Duration: " + duration + "\n";
    }

    public static class Builder {
        private String movieId;
        private String title;
        private String genre;
        private String duration;


        public Builder setMovieId(String movieId) {
            this.movieId = movieId;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder setDuration(String duration) {
            this.duration = duration;
            return this;
        }

        public Builder copy(Movie home) {
            this.movieId = home.movieId;
            this.title = home.title;
            this.genre = home.genre;
            this.duration = home.duration;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }
}
