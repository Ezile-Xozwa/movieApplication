package za.ac.cput.util;

import za.ac.cput.domain.movie.Seat;

public class SeatValidationHelper {

    public static boolean IsEmptyOrNullString (String seatId){
        if ( seatId.isEmpty() || seatId == null )
            return true;
        return false;
    }

    public static boolean isValidSeatNumber(int seatNumber) {
        return seatNumber > 0;
    }

    public static boolean isValidSeatRow(char row) {
        return row >= 'A' && row <= 'Z';
    }

    public static boolean isValidSeatStatus(Seat.Status status) {
        return status == Seat.Status.Available || status == Seat.Status.Booked;
    }
}
