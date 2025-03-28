package za.ac.cput.factory;

import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.PaymentStatus;

// PaymentFactory Class (creates Payment objects)
public class PaymentFactory {

    public static Payment createPayment(int paymentId, Booking booking, double amount, PaymentStatus status) {
        return new Payment.Builder()
                .setPaymentId(paymentId)
                .setBooking(booking)
                .setAmount(amount)
                .setStatus(status)
                .build();
    }
}
