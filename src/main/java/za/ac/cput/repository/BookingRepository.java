package za.ac.cput.repository;

import za.ac.cput.domain.Booking;

import java.util.*;

// BookingRepository Class (stores and manages Booking entities)
public class BookingRepository implements IRepository<Booking, Integer> {
    private Map<Integer, Booking> bookings = new HashMap<>();

    @Override
    public Booking create(Booking booking) {
        bookings.put(booking.getBookingId(), booking);
        return booking;
    }

    @Override
    public Booking read(Integer id) {
        return bookings.get(id);
    }

    @Override
    public Booking update(Booking booking) {
        if (bookings.containsKey(booking.getBookingId())) {
            bookings.put(booking.getBookingId(), booking);
            return booking;
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        bookings.remove(id);
    }

    @Override
    public List<Booking> findAll() {
        return new ArrayList<>(bookings.values());
    }
}
