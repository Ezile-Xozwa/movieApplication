package za.ac.cput;
/* Booking.java

     Booking Tester class

     Author: Herold M Ubisi (222662786)

     Date:  */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;
import za.ac.cput.factory.BookingFactory;

import static org.junit.jupiter.api.Assertions.*;

class BookingFactoryTest {

    @Test
    void createBooking_success() {
        User user = new User.Builder()
                .setUserId("1")
                .setName("Jane Doe")
                .build();

        Showtime showtime = new Showtime.Builder()
                .setShowtimeId("101")
                .build();

        Seat seat = new Seat.Builder()
                .setSeatNumber(5)
                .build();

        Booking booking = BookingFactory.createBooking(1, user, showtime, seat);

        assertNotNull(booking);
        assertEquals(1, booking.getBookingId());
        assertEquals("Jane Doe", booking.getUser().getName());
        assertEquals("A5", booking.getSeat().getSeatNumber());
    }

    @Test
    void createBooking_nullSeat_shouldThrow() {
        User user = new User.Builder().setUserId("2").setName("Tom").build();
        Showtime showtime = new Showtime.Builder().setShowtimeId("202").build();

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                BookingFactory.createBooking("2", user, showtime, null)
        );
        assertEquals("Invalid seat", exception.getMessage());
    }
}
