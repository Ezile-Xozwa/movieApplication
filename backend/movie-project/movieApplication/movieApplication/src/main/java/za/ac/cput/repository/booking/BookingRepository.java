// File: za.ac.cput.repository.booking.BookingRepository
package za.ac.cput.repository.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.booking.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {
    // You can add custom queries later, e.g.
    // List<Booking> findByShowtime_ShowtimeId(String showtimeId);
    // List<Booking> findByUser_UserId(String userId);
}