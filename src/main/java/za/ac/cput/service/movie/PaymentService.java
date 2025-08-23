package za.ac.cput.service.movie;

/* Payment Controller.java

     Author: Herold M Ubisi (222662786)

     Date: 20 August 2025 */

import za.ac.cput.entity.Payment;
import java.util.List;

public interface PaymentService {
    Payment create(Payment payment);
    Payment read(String paymentId);
    Payment update(Payment payment);
    boolean delete(String paymentId);
    List<Payment> getAll();
}
