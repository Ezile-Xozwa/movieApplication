package za.ac.cput.util;

import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.PaymentStatus;

// PaymentHelper Class (Helper methods for Payment)
public class PaymentHelper {

    // Method to generate a random Payment ID
    public static int generatePaymentId() {
        return (int) (Math.random() * 1000); // Random ID for illustration
    }

    // Method to create a test Payment
    public static Payment createTestPayment(Booking booking) {
        return new Payment.Builder()
                .setPaymentId(generatePaymentId())
                .setBooking(booking)
                .setAmount(250.00)
                .setStatus(PaymentStatus.PENDING)
                .build();
    }
}
