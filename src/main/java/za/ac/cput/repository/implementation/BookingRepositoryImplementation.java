/*
package za.ac.cput.repository.implementation;

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
    }
}

*/
