package za.ac.cput.controller.movie;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.movie.Seat;
import za.ac.cput.factory.movie.SeatFactory;
import za.ac.cput.service.movie.implememtation.SeatServiceImplementation;

import java.util.Set;

public class SeatController {

    private SeatServiceImplementation seatService;

    @PostMapping("/create")
    public Seat create(@RequestBody Seat seat) {
        Seat newSeat = SeatFactory.createSeat(seat.getSeatId(), seat.getRow(), seat.getSeatNumber(), seat.getStatus());
        return seatService.create(newSeat);
    }

    @GetMapping("/read{id}")
    public Seat read(@PathVariable String id) {
        return seatService.read(id);
    }

    @PostMapping("/update")
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

}

