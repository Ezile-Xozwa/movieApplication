package za.ac.cput.factory.movie;

import za.ac.cput.domain.movie.Seat;

import za.ac.cput.util.GenericHelper;
import org.junit.jupiter.api.Test;

//import static junit.framework.Assert.assertNotNull;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SeatFactoryTest {

    @Test
    void createSeat(){
        Seat seat = SeatFactory.createSeat(GenericHelper.generateID(), 'A', 10, Seat.Status.Available);

        System.out.println(seat);

        assertNotNull(seat);

//        Seat seat = new Seat.Builder()
//                .setSeatId(GenericHelper.generateID())
//                .setRow('A')
//                .setSeatNumber(10)
//                .setStatus(Seat.Status.Available)
//                .build();

    }
}
