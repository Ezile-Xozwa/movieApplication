package za.ac.cput.factory;
/* Booking.java

     Booking POJO class

     Author: Herold M Ubisi (222662786)

     Date: 17 May 2025 */
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.User;
import za.ac.cput.domain.Showtime;
import za.ac.cput.domain.Seat;

public class BookingFactory {

    public static Booking createBooking(String bookingId, User user, Showtime showtime, Seat seat) {
        if (user == null || showtime == null || seat == null)
            throw new IllegalArgumentException("User, Showtime, and Seat cannot be null");

        return new Booking.Builder()
                .setBookingId(bookingId)
                .setUser(user)
                .setShowtime(showtime)
                .setSeat(seat)
                .build();
    }
}
