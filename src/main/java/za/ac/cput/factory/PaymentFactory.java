package za.ac.cput.factory;
/* Payment.java

     Payment Factory class

     Author: Herold M Ubisi (222662786)

     Date: 17 May 2025 */

import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Payment;

public class PaymentFactory {

    public static Payment createPayment(String paymentId, Booking booking, double amount, Payment.PaymentStatus status) {
        if (paymentId == null || paymentId.isEmpty())
            throw new IllegalArgumentException("Payment ID is required.");
        if (booking == null)
            throw new IllegalArgumentException("Booking cannot be null.");
        if (amount <= 0)
            throw new IllegalArgumentException("Amount must be greater than 0.");
        if (status == null)
            throw new IllegalArgumentException("Status cannot be null.");

        return new Payment.Builder()
                .setPaymentId(paymentId)
                .setBooking(booking)
                .setAmount(amount)
                .setStatus(Payment.PaymentStatus.PENDING)
                .build();
    }
}
