package za.ac.cput.factory;

import za.ac.cput.domain.*;

// BookingFactory Class (creates Booking objects)
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
