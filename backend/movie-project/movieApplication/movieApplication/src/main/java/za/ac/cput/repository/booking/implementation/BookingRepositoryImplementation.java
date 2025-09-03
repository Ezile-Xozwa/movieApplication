//package za.ac.cput.repository.booking.implementation;
//
//import za.ac.cput.domain.booking.Booking;
//import za.ac.cput.repository.booking.BookingRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class BookingRepositoryImplementation implements BookingRepository {
//    private Set<Booking> bookingsDB;
//
//    public BookingRepositoryImplementation() {
//        this.bookingsDB = new HashSet<Booking>();
//    }
//
//    public Booking create(Booking booking) {
//        bookingsDB.add(booking);
//        return booking;
//    }
//
//    @Override //there was error before this
//    public Booking read(Integer integer) {
//        return null;
//    }
//
//
//    public Booking read(String bookingId) {
//        Booking booking = this.bookingsDB.stream()
//                        .filter(b -> b.getBookingId().equalsIgnoreCase(bookingId))
//                        .findAny()
//                        .orElse(null);
//                return booking;
//    }
//
//    public Booking update(Booking updatebooking) {
//        Booking booking = read(updatebooking.getBookingId());
//        if (booking != null) {
//            this.bookingsDB.remove(booking);
//            this.bookingsDB.add(booking);
//        }
//        return booking;
//    }
//
//    @Override //there was error before this
//    public void delete(Integer integer) {
//
//    }
//
//    public void delete(String bookingId) {
//        Booking booking = read(bookingId);
//        if (booking != null) {
//            this.bookingsDB.remove(booking);
//        }
//    }
//
//    public Set<Booking> getAll() {
//        return this.bookingsDB;
//    }
//}
