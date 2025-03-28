package za.ac.cput.repository.implemenataion;

import za.ac.cput.domain.Booking;


import za.ac.cput.repository.BookingRepository;
import za.ac.cput.repository.Repository;

import java.util.*;

import java.util.HashSet;
import java.util.Set;

public class BookingRepository implements BookingRepository {
    private Set<Booking> bookingsDB;

    public BookingRepositoryImplementation() {

        this.bookingsDB = new HashSet<>();
    }

    @Override
    public Booking create(Booking booking) {
        bookingsDB.add(booking);
=======
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

    public Booking read(Integer bookingId) {
        return bookingsDB.stream()
                .filter(b -> b.getBookingId() == bookingId)
                .findAny()
                .orElse(null);
    }

    @Override
    public void delete(Integer bookingId) {
        Booking booking = read(bookingId);
        if (booking != null) {
            bookingsDB.remove(booking);
        }
    }

    @Override
    public Set<Booking> getAll() {
        return bookingsDB;
=======
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

