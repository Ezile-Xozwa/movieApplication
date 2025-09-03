package za.ac.cput.controller.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.movie.Showtime;
import za.ac.cput.factory.movie.ShowtimeFactory;
import za.ac.cput.service.movie.ShowtimeService;

import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/showtimes")
public class ShowtimeController {

    @Autowired
    private ShowtimeService showtimeService;

    @PostMapping("/create")
    public Showtime create(@RequestBody Showtime showtime) {
        return showtimeService.create(showtime);
    }

    @GetMapping("/read/{id}")
    public Showtime read(@PathVariable String id) {
        return showtimeService.read(id);
    }

    @PutMapping("/update")
    public Showtime update(@RequestBody Showtime showtime) {
        return showtimeService.update(showtime);
    }

    @GetMapping("/all")
    public Set<Showtime> getAll() {
        return showtimeService.getShowtimes();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        showtimeService.delete(id);
    }

    @GetMapping("/generate")
    public Set<Showtime> generateShowtimes() {
        showtimeService.generateShowtimes();
        return showtimeService.getShowtimes();
    }

    @GetMapping("/movie/{movieId}")
    public Set<Showtime> getShowtimesByMovie(@PathVariable String movieId) {
        return showtimeService.findByMovieId(movieId);
    }
}