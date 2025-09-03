package za.ac.cput.util;

import za.ac.cput.domain.booking.Booking;
import za.ac.cput.domain.booking.Payment;

public class PaymentValidationHelper {
    public static boolean IsEmptyOrNullString(String paymentId) {
       return paymentId == null || paymentId.isEmpty();
    }

    public static boolean isValidBooking(Booking booking) {
        return booking != null;
    }

    public static boolean isValidAmount(double amount) {
        return amount > 0;
    }

    public static boolean isValidPaymentStatus(Payment.PaymentStatus status) {
        return status == Payment.PaymentStatus.SUCCESS || status == Payment.PaymentStatus.FAILED;
    }
}
