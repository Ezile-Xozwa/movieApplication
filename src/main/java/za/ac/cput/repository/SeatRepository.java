package za.ac.cput.repository;

import za.ac.cput.domain.Seat;

import java.util.Set;

public interface SeatRepository extends Repository<Seat, Integer> {
    Set<Seat> getAll();
}
