package za.ac.cput.util;
/* Payment.java

     Payment Helper class

     Author: Herold M Ubisi (222662786)

     Date:  May 2025 */
import za.ac.cput.domain.Booking;

public class PaymentValidationHelper {

    public static boolean isValidBooking(Booking booking) {
        return booking != null;
    }

    public static boolean isValidAmount(double amount) {
        return amount > 0;
    }
}
