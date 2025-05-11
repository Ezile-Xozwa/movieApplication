package za.ac.cput;

import org.junit.Test;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;
import za.ac.cput.factory.BookingFactory;
import za.ac.cput.util.BookingGenericHelper;

import static junit.framework.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

class BookingFactoryTest {

    @Test
    void createBooking_Success() {

        User user = new User();
        Showtime showtime = new Showtime();
        Seat seat = new Seat.Builder()
                .setSeatId(BookingGenericHelper.generateID())
                .setRow('A')
                .setSeatNumber(10)
                .setStatus(Seat.Status.Available)
                .build();

        // Create a Booking
        Booking booking = BookingFactory.createBooking(1, user, showtime, seat, Booking.BookingStatus.Confirmed);

        assertNotNull(booking);
        assertEquals(1, booking.getBookingId());
        assertEquals(user, booking.getUser());
        assertEquals(showtime, booking.getShowtime());
        assertEquals(seat, booking.getSeat());
        assertEquals(Booking.BookingStatus.Confirmed, booking.getStatus());

        System.out.println(booking);
    }

    @Test
    void createBooking_Failure_NullValues() {
        Booking booking = BookingFactory.createBooking(2, null, null, null, null);
        assertNull(booking, "Booking should be null when invalid data is provided.");
    }
}
