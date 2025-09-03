package za.ac.cput.repository.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.booking.SnackOrder;
import za.ac.cput.domain.movie.Seat;

@Repository
public interface SnackOrderRepository extends JpaRepository<SnackOrder, String> {

}
