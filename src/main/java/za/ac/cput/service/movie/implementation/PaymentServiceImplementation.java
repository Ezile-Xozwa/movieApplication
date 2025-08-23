package za.ac.cput.service.movie.implementation;

/* Payment Controller.java

     Author: Herold M Ubisi (222662786)

     Date: 20 August 2025 */


import za.ac.cput.entity.Payment;
import za.ac.cput.repository.implementation.PaymentRepository;
import za.ac.cput.service.PaymentService;

import java.util.List;

public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository repository;

    public PaymentServiceImpl() {
        this.repository = PaymentRepository.getRepository();
    }

    @Override
    public Payment create(Payment payment) {
        return repository.create(payment);
    }

    @Override
    public Payment read(String paymentId) {
        return repository.read(paymentId);
    }

    @Override
    public Payment update(Payment payment) {
        return repository.update(payment);
    }

    @Override
    public boolean delete(String paymentId) {
        return repository.delete(paymentId);
    }

    @Override
    public List<Payment> getAll() {
        return repository.findAll();
    }
}
