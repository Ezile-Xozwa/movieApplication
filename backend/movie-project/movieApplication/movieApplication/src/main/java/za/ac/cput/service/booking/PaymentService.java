// File: za.ac.cput.service.booking.PaymentService
package za.ac.cput.service.booking;

import za.ac.cput.domain.booking.Payment;
import za.ac.cput.service.Service;

import java.util.Set;

public interface PaymentService extends Service<Payment, String> {
    Set<Payment> getPayments();
    void generatePayments(); // Optional: for testing
}