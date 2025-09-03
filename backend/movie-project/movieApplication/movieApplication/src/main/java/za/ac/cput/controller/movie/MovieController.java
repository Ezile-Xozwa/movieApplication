
package za.ac.cput.controller.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.movie.Movie;
import za.ac.cput.factory.movie.MovieFactory;
import za.ac.cput.service.movie.MovieService;

import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/create")
    public Movie create(@RequestBody Movie movie) {
        Movie newMovie = MovieFactory.createMovie(
                movie.getTitle(),
                movie.getMovieId(),
                movie.getGenre(),
                movie.getDuration()
        );
        return movieService.create(newMovie);
    }

    @GetMapping("/read/{id}")
    public Movie read(@PathVariable String id) {
        return movieService.read(id);
    }

    @PutMapping("/update")
    public Movie update(@RequestBody Movie movie) {
        return movieService.update(movie);
    }

    @GetMapping("/all")
    public Set<Movie> getAll() {
        return movieService.getMovies();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        movieService.delete(id);
    }

    @GetMapping("/generate")
    public Set<Movie> generateMovies() {
        movieService.generateMovies();
        return movieService.getMovies();
    }
}