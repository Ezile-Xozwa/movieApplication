package za.ac.cput.repository;

import za.ac.cput.domain.Showtime;

import java.util.Set;

public interface ShowtimeRepository {
    Set<Showtime> getAll();
}
