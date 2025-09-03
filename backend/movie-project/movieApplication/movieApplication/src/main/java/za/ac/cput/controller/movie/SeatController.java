package za.ac.cput.controller.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.movie.Seat;
import za.ac.cput.factory.movie.SeatFactory;
import za.ac.cput.service.movie.SeatService; //added coz AI

import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:5173")  //coz AI
@RequestMapping("/seats") //added coz AI and it says "THIS LINE IS CRITICAL"
public class SeatController {

    @Autowired
    private SeatService seatService;

    @PostMapping("/create")
    public Seat create(@RequestBody Seat seat) {
        Seat newSeat = SeatFactory.createSeat(seat.getSeatId(), seat.getSeatRow(), seat.getSeatNumber(), seat.getStatus());
        return seatService.create(newSeat);
    }

    @GetMapping("/read/{id}") //added "/" after "read"
    public Seat read(@PathVariable String id) {
        return seatService.read(id);
    }

    @PutMapping("/update")
    //@PostMapping("/update")
    public Seat update(@RequestBody Seat seat) {
        return seatService.update(seat);
    }

    @GetMapping("/all")
    public Set<Seat> getAll() {
        return seatService.getSeats();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        seatService.delete(id);
    }

    @GetMapping("/generate")
    public Set<Seat> generateSeats() {
        seatService.generateSeats();
        return seatService.getSeats();
    }

}
