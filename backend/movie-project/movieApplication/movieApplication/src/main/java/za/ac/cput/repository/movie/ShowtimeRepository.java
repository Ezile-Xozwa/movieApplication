package za.ac.cput.repository.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.movie.Movie;
import za.ac.cput.domain.movie.Showtime;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, String> {
    Set<Showtime> findByMovie_MovieId(String movieId);
    // You can add custom queries later, e.g.

}