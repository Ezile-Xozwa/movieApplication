package za.ac.cput.factory;
/* Payment.java

     Payment Factory class

     Author: Herold M Ubisi (222662786)

     Date: 17 May 2025 */

import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Payment;

public class PaymentFactory {

    public static Payment createPayment(int paymentId, Booking booking, double amount) {
        if (booking == null)
            throw new IllegalArgumentException("Booking cannot be null");
        if (amount <= 0)
            throw new IllegalArgumentException("Amount must be greater than 0");

        return new Payment.Builder()
                .setPaymentId(paymentId)
                .setBooking(booking)
                .setAmount(amount)
                .build();
    }
}
