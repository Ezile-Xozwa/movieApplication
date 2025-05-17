package za.ac.cput;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;
import za.ac.cput.factory.BookingFactory;

import static org.junit.jupiter.api.Assertions.*;

class BookingFactoryTest {

    @Test
    void createBooking_success() {
        User user = new User.Builder()
                .setUserId("1")
                .setName("John Doe")
                .build();

        Showtime showtime = new Showtime.Builder()
                .setShowtimeId("101")
                .build();

        Seat seat = new Seat.Builder()
                .setSeatNumber(12)
                .build();

        Booking booking = BookingFactory.createBooking("1", user, showtime, seat);

        assertNotNull(booking);
        assertEquals(1, booking.getBookingId());
        assertEquals("John Doe", booking.getUser().getName());
        assertEquals("C12", booking.getSeat().getSeatNumber());
    }

    @Test
    void createBooking_withNullUser_shouldThrow() {
        Showtime showtime = new Showtime.Builder().setShowtimeId("1").build();
        Seat seat = new Seat.Builder().setSeatNumber(1).build();

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                BookingFactory.createBooking("1", null, showtime, seat)
        );
        assertEquals("User, Showtime, and Seat cannot be null", exception.getMessage());
    }
}
