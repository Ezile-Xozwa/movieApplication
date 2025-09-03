
package za.ac.cput.util;

import za.ac.cput.domain.movie.Seat;
import za.ac.cput.domain.movie.Showtime;
import za.ac.cput.domain.user.User;

public class BookingValidationHelper {
    public static boolean IsEmptyOrNullString(String bookingId) {
        return bookingId == null || bookingId.isEmpty();
    }

    public static boolean isValidUser(User user) {
        return user != null;
    }

    public static boolean isValidShowtime(Showtime showtime) {
        return showtime != null;
    }

    public static boolean isValidSeat(Seat seat) {
        return seat != null;
    }

//    public static boolean isValidBookingStatus(Booking.BookingStatus status) {
//        return status == Booking.BookingStatus.Confirmed || status == Booking.BookingStatus.Cancelled;
//    }
}
