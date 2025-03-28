package za.ac.cput.domain;

public class Home {
    private final String movieId;
    private final String title;
    private final String genre;
    private final String duration;

    private Home(Builder builder) {
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
        return "Home{" +
                "movieId='" + movieId + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", duration='" + duration + '\'' +
                '}';
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

        public Builder copy(Home home) {
            this.movieId = home.movieId;
            this.title = home.title;
            this.genre = home.genre;
            this.duration = home.duration;
            return this;
        }

        public Home build() {
            return new Home(this);
        }
    }
}
