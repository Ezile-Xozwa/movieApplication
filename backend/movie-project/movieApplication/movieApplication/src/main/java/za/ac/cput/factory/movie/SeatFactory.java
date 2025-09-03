package za.ac.cput.factory.movie;

import za.ac.cput.domain.movie.Seat;
import za.ac.cput.util.GenericHelper;
import za.ac.cput.util.SeatValidationHelper;

public class SeatFactory {

    public static Seat createSeat(String seatId, char seatRow, int seatNumber, Seat.Status status) {

        // for debugging
        System.out.println("SeatFactory: Validating seat...");
        System.out.println("  seatId: '" + seatId + "' -> " + !SeatValidationHelper.IsEmptyOrNullString(seatId));
        System.out.println("  seatRow: '" + seatRow + "' -> " + SeatValidationHelper.isValidSeatRow(seatRow));
        System.out.println("  seatNumber: " + seatNumber + " -> " + SeatValidationHelper.isValidSeatNumber(seatNumber));
        System.out.println("  status: " + status + " -> " + SeatValidationHelper.isValidSeatStatus(status));
        System.out.println("---");


        if (SeatValidationHelper.IsEmptyOrNullString(seatId)){
            seatId= GenericHelper.generateID();
        }

        if (SeatValidationHelper.IsEmptyOrNullString(seatId)
                || !SeatValidationHelper.isValidSeatNumber(seatNumber)
                || !SeatValidationHelper.isValidSeatRow(seatRow)
                || !SeatValidationHelper.isValidSeatStatus(status)){
                //|| !SeatValidationHelper.isValidSeatStatus(Seat.Status.Available)) {
            return null;

        }

        return new Seat.Builder()
                .setSeatId(seatId)
                .setSeatRow(seatRow)
                .setSeatNumber(seatNumber)
                .setStatus(status)
                .build();

    }

}
