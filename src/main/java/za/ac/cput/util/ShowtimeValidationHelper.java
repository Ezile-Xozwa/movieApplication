package za.ac.cput.util;

import za.ac.cput.domain.Showtime;

public class ShowtimeValidationHelper {

    public static boolean isEmptyOrNullString(String showtimeId) {
        return showtimeId == null || showtimeId.isEmpty();
    }

    public static boolean isValidStartTime(java.time.LocalDateTime startTime) {
        return startTime != null && startTime.isAfter(java.time.LocalDateTime.now());
    }

    public static boolean isValidDate(java.time.LocalDate date) {
        return date != null && !date.isBefore(java.time.LocalDate.now());
    }

}
