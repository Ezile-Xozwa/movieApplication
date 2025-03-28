package za.ac.cput.repository.implementation;

import za.ac.cput.domain.Seat;
import za.ac.cput.repository.SeatRepository;

import java.util.HashSet;
import java.util.Set;

public class SeatRepositoryImplementation implements SeatRepository {
    private Set<Seat> seatsDB;

    public SeatRepositoryImplementation() {
        this.seatsDB = new HashSet<>();
    }

    @Override
    public Seat create (Seat seat) {
        this.seatsDB.add(seat);
        return seat;
    }

    @Override
    public Seat read(Integer seatNumber) {
        Seat seat = this.seatsDB.stream()
                .filter(s -> s.getSeatNumber() == seatNumber)
                .findAny()
                .orElse(null);
        return seat;
    }

    @Override
    public Seat update(Seat updateseat) {
        Seat seat = read(updateseat.getSeatNumber());
        if(seat!=null) {
            this.seatsDB.remove(seat);
            this.seatsDB.add(seat);
        }
        return seat;
    }

    @Override
    public void delete(Integer seatNumber) {
        Seat seat = read(seatNumber);
        if (seat != null) {
            this.seatsDB.remove(seat);
        }
    }

    @Override
    public Set<Seat> getAll() {
        return this.seatsDB;
    }

}
