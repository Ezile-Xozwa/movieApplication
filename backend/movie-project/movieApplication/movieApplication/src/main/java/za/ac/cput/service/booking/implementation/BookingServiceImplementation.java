// File: za.ac.cput.service.booking.implementation.BookingServiceImplementation
package za.ac.cput.service.booking.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.booking.Booking;
import za.ac.cput.repository.booking.BookingRepository;
import za.ac.cput.service.booking.BookingService;

import java.util.Set;
import java.util.HashSet;

@Service
public class BookingServiceImplementation implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Set<Booking> getBookings() {
        return new HashSet<>(bookingRepository.findAll());
    }
    @Override
    public Set<Booking> getAll() {
        return getBookings(); // ← Delegation: getAll() reuses getBookings()
    }

    @Override
    public Booking create(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking read(String id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public Booking update(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public void delete(String id) {
        bookingRepository.deleteById(id);
    }

}