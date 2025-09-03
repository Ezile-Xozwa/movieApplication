package za.ac.cput.factory.booking;


import za.ac.cput.domain.booking.Booking;
import za.ac.cput.domain.movie.Seat;
import za.ac.cput.domain.movie.Showtime;
import za.ac.cput.domain.user.User;
import za.ac.cput.util.BookingValidationHelper;


public class BookingFactory {

    public static Booking createBooking(String bookingId, User user, Showtime showtime, Seat seat) {

        if (BookingValidationHelper.IsEmptyOrNullString(bookingId)
            || !BookingValidationHelper.isValidUser(user)
            || !BookingValidationHelper.isValidShowtime(showtime)
            || !BookingValidationHelper.isValidSeat(seat)){
            return null;
        }

//        if (user == null || showtime == null || seat == null)
//            throw new IllegalArgumentException("User, Showtime, and Seat cannot be null");

        return new Booking.Builder()
                .setBookingId(bookingId)
                .setUser(user)
                .setShowtime(showtime)
                .setSeat(seat)
                .build();
    }
}
