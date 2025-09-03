package za.ac.cput.service.movie;

import za.ac.cput.domain.movie.Seat;
import za.ac.cput.service.Service;

import java.util.Set;

public interface SeatService extends Service<Seat, String> {
    //Set<Seat> getAll();
    Set<Seat> getSeats();
    void generateSeats();  // Add this method

    //seats in the B row, then you would need to go implement it
    //Set<Seat> getSeatsInRowB();
}
