package za.ac.cput.domain;
/*Showtime.java

     Showtime POJO class

     Author: Katie Khezani Tolo (222831960)

     Date: 11 May 2025 */
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Showtime {
    private String showtimeId;
    private String movie;
    private LocalDateTime startTime;
    private LocalDate date;

    public Showtime() {
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

    public String getMovie() {
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
                "showtimeId=" + showtimeId +
                ", movie='" + movie + '\'' +
                ", startTime=" + startTime +
                ", date=" + date +
                '}';
    }

    public static class Builder {
        private String showtimeId;
        private String movie;
        private LocalDateTime startTime;
        private LocalDate date;


        public Builder setShowtimeId(String showtimeId) {
            this.showtimeId = showtimeId;
            return this;
        }

        public Builder setMovie(String movie) {
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
