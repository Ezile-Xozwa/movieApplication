package za.ac.cput.controller.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.booking.SnackOrder;
import za.ac.cput.factory.booking.SnackOrderFactory;
import za.ac.cput.service.booking.SnackOrderService;

import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/snackorders")
public class SnackOrderController {

    @Autowired
    private SnackOrderService snackOrderService;

    @PostMapping("/create")
    public SnackOrder create(@RequestBody SnackOrder snackOrder) {
        return snackOrderService.create(snackOrder);
    }

    @GetMapping("/read/{id}")
    public SnackOrder read(@PathVariable String id) {
        return snackOrderService.read(id);
    }

    @PutMapping("/update")
    public SnackOrder update(@RequestBody SnackOrder snackOrder) {
        return snackOrderService.update(snackOrder);
    }

    @GetMapping("/all")
    public Set<SnackOrder> getAll() {
        return snackOrderService.getSnackOrder();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        snackOrderService.delete(id);
    }

//    @GetMapping("/generate")
//    public Set<SnackOrder> generateSnackOrders() {
//        snackOrderService.generateSnackOrder();
//        return snackOrderService.getSnackOrder();
//    }
}