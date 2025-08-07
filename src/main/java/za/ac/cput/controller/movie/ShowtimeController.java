package za.ac.cput.controller.movie;

/* ShowtimeController.java
   Author: Katie Khezani Tolo (222831960)
   Date: 25 May 2025
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Showtime;
import za.ac.cput.factory.ShowtimeFactory;
import za.ac.cput.service.implementation.ShowtimeServiceImplementation;

import java.util.Set;

@RestController
@RequestMapping("/api/showtime")
public class ShowtimeController {

    @Autowired
    private ShowtimeServiceImplementation showtimeService;

    @PostMapping("/create")
    public Showtime create(@RequestBody Showtime showtime) {
        Showtime newShowtime = ShowtimeFactory.createShowtime(
                showtime.getShowtimeId(),
                showtime.getMovieId(),
                showtime.getDateTime()
        );
        return showtimeService.create(newShowtime);
    }

    @GetMapping("/read/{id}")
    public Showtime read(@PathVariable String id) {
        return showtimeService.read(id);
    }

    @PostMapping("/update")
    public Showtime update(@RequestBody Showtime showtime) {
        return showtimeService.update(showtime);
    }

    @GetMapping("/all")
    public Set<Showtime> getAll() {
        return showtimeService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        showtimeService.delete(id);
    }
}

