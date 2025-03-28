package za.ac.cput.repository;

import za.ac.cput.domain.Payment;

import java.util.*;

// PaymentRepository Class (stores and manages Payment entities)
public class PaymentRepository implements IRepository<Payment, Integer> {
    private Map<Integer, Payment> payments = new HashMap<>();

    @Override
    public Payment create(Payment payment) {
        payments.put(payment.getPaymentId(), payment);
        return payment;
    }

    @Override
    public Payment read(Integer id) {
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
    public void delete(Integer id) {
        payments.remove(id);
    }

    @Override
    public List<Payment> findAll() {
        return new ArrayList<>(payments.values());
    }
}
