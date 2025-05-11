
package za.ac.cput.util;

import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Seat;
import za.ac.cput.domain.Showtime;
import za.ac.cput.domain.User;

public class BookingValidationHelper {
    public static boolean isValidUser(User user) {
        return user != null;
    }

    public static boolean isValidShowtime(Showtime showtime) {
        return showtime != null;
    }

    public static boolean isValidSeat(Seat seat) {
        return seat != null;
    }

    public static boolean isValidStatus(Booking.BookingStatus status) {
        return status == Booking.BookingStatus.CONFIRMED || status == Booking.BookingStatus.CANCELLED;
    }
}
