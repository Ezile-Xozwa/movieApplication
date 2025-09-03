package za.ac.cput.factory.booking;

import za.ac.cput.domain.booking.Booking;
import za.ac.cput.domain.booking.Payment;
import za.ac.cput.util.PaymentValidationHelper;

// PaymentFactory Class (creates Payment objects)

public class PaymentFactory {

    public static Payment createPayment(String paymentId, Booking booking, double amount, Payment.PaymentStatus status) {

        if(PaymentValidationHelper.IsEmptyOrNullString(paymentId)
            || !PaymentValidationHelper.isValidBooking(booking)
            || !PaymentValidationHelper.isValidAmount(amount)
            || !PaymentValidationHelper.isValidPaymentStatus(status)){
            return null;
        }

//        if (booking == null)
//            throw new IllegalArgumentException("Booking cannot be null");
//        if (amount <= 0)
//            throw new IllegalArgumentException("Amount must be greater than 0");

        return new Payment.Builder()
                .setPaymentId(paymentId)
                .setBooking(booking)
                .setAmount(amount)
                .setStatus(Payment.PaymentStatus.PENDING)
                //.setStatus(status)
                .build();
    }
}

