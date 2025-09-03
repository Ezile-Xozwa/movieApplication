package za.ac.cput.controller.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.booking.Booking;
import za.ac.cput.factory.booking.BookingFactory;
import za.ac.cput.service.booking.BookingService;

import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/create")
    public Booking create(@RequestBody Booking booking) {
        Booking newBooking = BookingFactory.createBooking(
                booking.getBookingId(),
                booking.getUser(),
                booking.getShowtime(),
                booking.getSeat()
        );
        return bookingService.create(newBooking);
    }

    @GetMapping("/read/{id}")
    public Booking read(@PathVariable String id) {
        return bookingService.read(id);
    }

    @PutMapping("/update")
    public Booking update(@RequestBody Booking booking) {
        return bookingService.update(booking);
    }

    @GetMapping("/all")
    public Set<Booking> getAll() {
        return bookingService.getBookings();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        bookingService.delete(id);
    }
}