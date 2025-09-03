package za.ac.cput.repository.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.movie.Movie;

import java.util.Optional;


@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {
    // You can add custom queries later, e.g.
    Optional<Movie> findByTitle(String title);
}