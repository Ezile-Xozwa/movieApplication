package za.ac.cput.controller.movie;

/* Payment Controller.java

     Author: Herold M Ubisi (222662786)

     Date: 20 August 2025 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
        import za.ac.cput.domain.Payment;
import za.ac.cput.service.impl.PaymentServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentServiceImpl service;

    @PostMapping("/create")
    public Payment create(@RequestBody Payment payment) {
        return service.create(payment);
    }

    @GetMapping("/read/{id}")
    public Payment read(@PathVariable Integer id) {
        return service.read(id);
    }

    @PostMapping("/update")
    public Payment update(@RequestBody Payment payment) {
        return service.update(payment);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id) {
        return service.delete(id);
    }

    @GetMapping("/all")
    public List<Payment> getAll() {
        return service.getAll();
    }
}
