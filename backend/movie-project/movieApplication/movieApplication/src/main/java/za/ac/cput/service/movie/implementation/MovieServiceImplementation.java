
package za.ac.cput.service.movie.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.movie.Movie;
import za.ac.cput.repository.movie.MovieRepository;
import za.ac.cput.service.movie.MovieService;
import za.ac.cput.util.GenericHelper;

import java.util.HashSet;
import java.util.Set;

@Service
public class MovieServiceImplementation implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public void generateMovies() {
        String[][] movieData = {
                {"Inception", "Sci-Fi", "2h 28min"},
                {"The Dark Knight", "Action", "2h 32min"},
                {"Interstellar", "Sci-Fi", "2h 49min"},
                {"Pulp Fiction", "Crime", "2h 34min"},
                {"The Godfather", "Crime", "2h 55min"},
                {"Forrest Gump", "Drama", "2h 22min"},
                {"The Matrix", "Sci-Fi", "2h 16min"},
                {"Joker", "Thriller", "2h 2min"},
                {"Parasite", "Drama", "2h 12min"},
                {"Avengers: Endgame", "Action", "3h 1min"}
        };

        for (String[] data : movieData) {
            String id = GenericHelper.generateID();
            Movie movie = new Movie.Builder()
                    .setMovieId(id)
                    .setTitle(data[0])
                    .setGenre(data[1])
                    .setDuration(data[2])
                    .build();
            // Only create if movie with this title doesn't exist
            if (movieRepository.findByTitle(movie.getTitle()).isEmpty()) {
                create(movie);
            }
        }
    }

    @Override
    public Set<Movie> getAll() {
        return getMovies();
    }
    @Override
    public Set<Movie> getMovies() {
        return new HashSet<>(movieRepository.findAll());
    }

    @Override
    public Movie create(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie read(String id) {
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    public Movie update(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void delete(String id) {
        movieRepository.deleteById(id);
    }
}