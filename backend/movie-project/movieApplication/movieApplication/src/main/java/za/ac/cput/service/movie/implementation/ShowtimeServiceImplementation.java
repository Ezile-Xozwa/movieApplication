package za.ac.cput.service.movie.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.booking.SnackOrder;
import za.ac.cput.domain.movie.Movie;
import za.ac.cput.domain.movie.Showtime;
import za.ac.cput.repository.movie.ShowtimeRepository;
import za.ac.cput.service.movie.MovieService;
import za.ac.cput.service.movie.ShowtimeService;
import za.ac.cput.util.GenericHelper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Service
public class ShowtimeServiceImplementation implements ShowtimeService {

    @Autowired
    private ShowtimeRepository showtimeRepository;
    @Autowired
    private MovieService movieService;

    @Override
    public Set<Showtime> getAll() {
        return getShowtimes();
    }
    @Override
    public Set<Showtime> getShowtimes() {
        return new HashSet<>(showtimeRepository.findAll());
    }

    @Override
    public Showtime create(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    @Override
    public Showtime read(String id) {
        return showtimeRepository.findById(id).orElse(null);
    }

    @Override
    public Showtime update(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    @Override
    public void delete(String id) {
        showtimeRepository.deleteById(id);
    }

    @Override
    public void generateShowtimes() {
        // Get all real movies
        Set<Movie> movies = movieService.getMovies();

        if (movies.isEmpty()) {
            System.out.println("❌ No movies found! Run /movies/generate first.");
            return;
        }

        // For each movie, generate 3 days of showtimes
        for (Movie movie : movies) {
            for (int dayOffset = 0; dayOffset < 3; dayOffset++) {
                LocalDate date = LocalDate.now().plusDays(dayOffset + 1);

                // Morning, Afternoon, Evening
                for (int hour : new int[]{12, 15, 18}) {
                    LocalDateTime startTime = LocalDateTime.of(date, LocalTime.of(hour, 0));
                    String showtimeId = GenericHelper.generateID();

                    Showtime showtime = new Showtime.Builder()
                            .setShowtimeId(showtimeId)
                            .setMovie(movie)  // ← Real movie!
                            .setDate(date)
                            .setStartTime(startTime)
                            .build();

                    create(showtime);
                }
            }
        }

    }

    public Set<Showtime> findByMovieId(String movieId) {
        return showtimeRepository.findByMovie_MovieId(movieId);
    }
}