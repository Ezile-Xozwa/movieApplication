//package za.ac.cput.service.movie.implementation;
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.domain.movie.Seat;
//import za.ac.cput.factory.movie.SeatFactory;
//import za.ac.cput.service.movie.SeatService;
//import za.ac.cput.util.GenericHelper;
//
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class SeatServiceImplementationTest {
//
//    //private static SeatService seatService = SeatServiceImplementation.getSeatService();
//    private static SeatService seatService;
//    private static Seat seat= SeatFactory.createSeat(GenericHelper.generateID(), 'B', 12, Seat.Status.Available);
//
//    @Test
//    void getSeatService() {
//    }
//
//    @Test
//    @Order(6)
//    void getSeats() {
//        Set<Seat> seats = seatService.getSeats();
//        System.out.println("All Seats: " + seats);
//    }
//
//    @Test
//    @Order(1)
//    void create() {
//        Seat seat1 = seatService.create(seat);
//        assertNotNull(seat1);
//        System.out.println("Created seat: " + seat1);
//    }
//
//    @Test
//    @Order(2)
//    void read() {
//        Seat read = seatService.read(seat.getSeatId());
//        assertNotNull(read);
//        System.out.println("Read seat: " + read);
//    }
//
//    @Test
//    @Order(3)
//    void update() {
//        //Seat update = new Seat.Builder().copy(seat).setStatus(Seat.Status.Not).build();
//        Seat updated = new Seat.Builder().copy(seat).setSeatNumber(15).build();
//        updated = seatService.update(updated);
//        System.out.println("Updated seat: " + updated);
//    }
//
//    @Test
//    @Order(4)
//    void delete() {
//        seatService.delete(seat.getSeatId());
//    }
//}