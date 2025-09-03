package za.ac.cput.domain.movie;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Showtime {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String showtimeId;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    private LocalDateTime startTime;
    private LocalDate date;

    protected Showtime() {

    }

    private Showtime(Builder builder){
        this.showtimeId = builder.showtimeId;
        this.movie = builder.movie;
        this.startTime = builder.startTime;
        this.date = builder.date;
    }

    public String getShowtimeId() {
        return showtimeId;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Showtime{" +
                "ShowtimeId: " + showtimeId + "\n"
                + "Movie: " + movie + "\n"
                + "Start Time: " + startTime + "\n"
                + "Date: " + date + "\n";
    }

    public static class Builder {
        private String showtimeId;
        private Movie movie;
        private LocalDateTime startTime;
        private LocalDate date;


        public Builder setShowtimeId(String showtimeId) {
            this.showtimeId = showtimeId;
            return this;
        }

        public Builder setMovie(Movie movie) {
            this.movie = movie;
            return this;
        }

        public Builder setStartTime(LocalDateTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder copy(Showtime showtime){
            this.showtimeId = showtime.showtimeId;
            this.movie = showtime.movie;
            this.startTime = showtime.startTime;
            this.date = showtime.date;
            return this;
        }
        public Showtime build(){
            return new Showtime(this);
        }

    }
}
