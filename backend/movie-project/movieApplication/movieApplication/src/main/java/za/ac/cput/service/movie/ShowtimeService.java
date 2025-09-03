package za.ac.cput.service.movie;

import za.ac.cput.domain.movie.Showtime;
import za.ac.cput.service.Service;

import java.util.Set;

public interface ShowtimeService extends Service<Showtime, String> {
    Set<Showtime> getShowtimes();
    void generateShowtimes();
    Set<Showtime> findByMovieId(String movieId); // Useful later
}
