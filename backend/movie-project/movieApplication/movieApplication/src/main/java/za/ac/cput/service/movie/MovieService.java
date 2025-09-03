package za.ac.cput.service.movie;

import za.ac.cput.domain.movie.Movie;
import za.ac.cput.domain.movie.Seat;
import za.ac.cput.service.Service;

import java.util.Set;

public interface MovieService extends Service<Movie, String>{
    Set<Movie> getMovies();
    void generateMovies();
}

