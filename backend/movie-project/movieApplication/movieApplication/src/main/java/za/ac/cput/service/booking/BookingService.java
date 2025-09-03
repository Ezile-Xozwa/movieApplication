// File: za.ac.cput.service.booking.BookingService
package za.ac.cput.service.booking;

import za.ac.cput.domain.booking.Booking;
import za.ac.cput.service.Service;

import java.util.Set;

public interface BookingService extends Service<Booking, String> {
    Set<Booking> getBookings();
    // Optional: add methods like findByShowtimeId(String showtimeId)
}