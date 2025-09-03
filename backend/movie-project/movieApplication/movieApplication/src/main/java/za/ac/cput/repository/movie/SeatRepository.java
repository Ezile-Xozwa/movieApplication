package za.ac.cput.repository.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.movie.Seat;
import org.springframework.stereotype.Repository;
//import za.ac.cput.repository.Repository;

import java.util.Set;

//public interface SeatRepository extends Repository<Seat, String> {
//    Set<Seat> getAll();
//}

@Repository
public interface SeatRepository extends JpaRepository<Seat, String> {
    // You can add custom queries here later
    // e.g. List<Seat> findByRow(char seatRow);
}
