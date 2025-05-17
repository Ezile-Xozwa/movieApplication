package za.ac.cput;
/* Payment.java

     Payment Tester class

     Author: Herold M Ubisi (222662786)

     Date:  */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.PaymentFactory;

import static org.junit.jupiter.api.Assertions.*;

class PaymentFactoryTest {

    @Test
    void createPayment_success() {
        Booking booking = new Booking.Builder()
                .setBookingId("1")
                .build();

        Payment payment = PaymentFactory.createPayment(1001, booking, 200.00);

        assertNotNull(payment);
        assertEquals(1001, payment.getPaymentId());
        assertEquals(200.00, payment.getAmount());
        assertEquals(1, payment.getBooking().getBookingId());
    }

    @Test
    void createPayment_withInvalidAmount_shouldThrow() {
        Booking booking = new Booking.Builder()
                .setBookingId("1")
                .build();

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                PaymentFactory.createPayment(1002, booking, -20.00)
        );
        assertEquals("Amount must be greater than 0", exception.getMessage());
    }

    @Test
    void createPayment_withNullBooking_shouldThrow() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                PaymentFactory.createPayment(1003, null, 120.00)
        );
        assertEquals("Booking cannot be null", exception.getMessage());
    }
}
