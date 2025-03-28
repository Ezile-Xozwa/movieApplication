package za.ac.cput.factory;

import za.ac.cput.domain.Seat;
import za.ac.cput.util.SeatValidationHelper;

public class SeatFactory {

    public static Seat createSeat(String seatId, char row, int seatNumber, Seat.Status status) {

        if (SeatValidationHelper.IsEmptyOrNullString(seatId)
                || !SeatValidationHelper.isValidSeatNumber(seatNumber)
                || !SeatValidationHelper.isValidRow(row)
                || !SeatValidationHelper.isValidSeatStatus(status)) {
            return null;

        }

        return new Seat.Builder()
                .setSeatId(seatId)
                .setRow(row)
                .setSeatNumber(seatNumber)
                .setStatus(status)
                .build();

    }

}
