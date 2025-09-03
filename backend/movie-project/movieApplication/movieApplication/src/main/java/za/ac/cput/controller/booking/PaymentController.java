package za.ac.cput.controller.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.booking.Payment;
import za.ac.cput.factory.booking.PaymentFactory;
import za.ac.cput.service.booking.PaymentService;

import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public Payment create(@RequestBody Payment payment) {
        return paymentService.create(payment);
    }

    @GetMapping("/read/{id}")
    public Payment read(@PathVariable String id) {
        return paymentService.read(id);
    }

    @PutMapping("/update")
    public Payment update(@RequestBody Payment payment) {
        return paymentService.update(payment);
    }

    @GetMapping("/all")
    public Set<Payment> getAll() {
        return paymentService.getPayments();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        paymentService.delete(id);
    }

    @GetMapping("/generate")
    public Set<Payment> generatePayments() {
        paymentService.generatePayments();
        return paymentService.getPayments();
    }
}