package za.ac.cput.service.booking.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.booking.Booking;
import za.ac.cput.domain.booking.Payment;
import za.ac.cput.domain.review.Review;
import za.ac.cput.repository.booking.PaymentRepository;
import za.ac.cput.service.booking.PaymentService;
import za.ac.cput.util.GenericHelper;

import java.util.*;

@Service
public class PaymentServiceImplementation implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

//    @Autowired
//    private za.ac.cput.service.booking.BookingService bookingService; // Optional: if you have it

    @Override
    public Set<Payment> getAll() {
        return getPayments();
    }

    @Override
    public Set<Payment> getPayments() {
        return new HashSet<>(paymentRepository.findAll());
    }

    @Override
    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment read(String id) {
        return paymentRepository.findById(id).orElse(null);
    }

    @Override
    public Payment update(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public void delete(String id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public void generatePayments() {
        // For testing: generate 5 sample payments
        List<Double> amounts = Arrays.asList(199.99, 89.50, 150.00, 245.75, 99.99);

        for (Double amount : amounts) {
            String id = GenericHelper.generateID();

            // Only create if it doesn't exist
            if (read(id) == null) {
                Payment payment = new Payment.Builder()
                        .setPaymentId(id)
                        .setAmount(amount)
                        .setStatus(Math.random() > 0.2 ? Payment.PaymentStatus.SUCCESS : Payment.PaymentStatus.FAILED)
                        .build();

                create(payment);
            }
        }
    }
}
