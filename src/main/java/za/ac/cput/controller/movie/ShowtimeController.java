package za.ac.cput.controller;
/*ShowtimeController.java

     Author: Katie Khezani Tolo (222831960)

     Date: 25 May 2025 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Showtime;
import za.ac.cput.repository.ShowtimeRepository;

import java.util.Set;

@RestController
@RequestMapping("/api/showtime")
public class ShowtimeController {

    private final ShowtimeRepository showtimeRepository;

    @Autowired
    public ShowtimeController(ShowtimeRepository showtimeRepository) {
        this.showtimeRepository = showtimeRepository;
    }

    @PostMapping
    public Showtime create(@RequestBody Showtime showtime) {
        return showtimeRepository.create(showtime);
    }

    @GetMapping("/{id}")
    public Showtime read(@PathVariable String id) {
        return showtimeRepository.read(id);
    }

    @PutMapping
    public Showtime update(@RequestBody Showtime showtime) {
        return showtimeRepository.update(showtime);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        showtimeRepository.delete(id);
    }

    @GetMapping
    public Set<Showtime> getAll() {
        return showtimeRepository.getAll();
    }
}
