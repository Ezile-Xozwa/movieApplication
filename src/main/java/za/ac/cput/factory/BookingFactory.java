package za.ac.cput.factory;

import za.ac.cput.domain.*;

import za.ac.cput.domain.Booking;
import za.ac.cput.util.BookingGenericHelper;

public class BookingFactory {

    public static Booking createBooking(int bookingId, User user, Showtime showtime, Seat seat, BookingStatus status) {
        return new Booking.Builder()
                .setBookingId(bookingId)
                .setUser(user)
                .setShowtime(showtime)
                .setSeat(seat)
                .setStatus(status)
                .build();
    }
}
