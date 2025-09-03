package za.ac.cput.repository.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.booking.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {
    // You can add custom queries later, e.g.
    // List<Payment> findByStatus(Payment.PaymentStatus status);
}