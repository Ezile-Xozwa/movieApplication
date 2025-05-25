package za.ac.cput.util;
/* Booking.java

     Booking POJO class

     Author: Herold M Ubisi (222662786)

     Date:  */
import za.ac.cput.domain.User;
import za.ac.cput.domain.Showtime;
import za.ac.cput.domain.Seat;

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
}
