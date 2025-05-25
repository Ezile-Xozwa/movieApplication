package za.ac.cput.util;

/* Payment.java
   Payment Helper class
   Author: Herold M Ubisi (222662786)
   Date: 18 May 2025*/

import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Payment;

public class PaymentHelper {

    public static String generatePaymentId() {
        return java.util.UUID.randomUUID().toString();
    }

    public static Payment createTestPayment(Booking booking) {
        return new Payment.Builder()
                .setPaymentId(generatePaymentId())
                .setBooking(booking)
                .setAmount(300.00)
                .setStatus("PENDING")
                .build();
    }
}