package za.ac.cput.repository;
/* Payment.java

     Payment Repo class

     Author: Herold M Ubisi (222662786)

     Date: 18 May 2025 */

import za.ac.cput.domain.Payment;

import java.util.*;

public class PaymentRepository implements IRepository<Payment, String> {
    private final Map<String, Payment> payments = new HashMap<>();

    @Override
    public Payment create(Payment payment) {
        payments.put(payment.getPaymentId(), payment);
        return payment;
    }

    @Override
    public Payment read(String id) {
        return payments.get(id);
    }

    @Override
    public Payment update(Payment payment) {
        if (payments.containsKey(payment.getPaymentId())) {
            payments.put(payment.getPaymentId(), payment);
            return payment;
        }
        return null;
    }

    @Override
    public void delete(String id) {
        payments.remove(id);
    }

    @Override
    public List<Payment> findAll() {
        return new ArrayList<>(payments.values());
    }
}