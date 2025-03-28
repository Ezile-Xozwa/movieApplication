package za.ac.cput;

import za.ac.cput.domain.Seat;
import za.ac.cput.factory.SeatFactory;

import za.ac.cput.util.SeatGenericHelper;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertNotNull;

public class SeatFactoryTest {

    @Test
    void createSeat(){
        Seat seat = SeatFactory.createSeat(SeatGenericHelper.generateID(), 'A', 10, Seat.Status.Available);

        System.out.println(seat);

        assertNotNull(seat);

    }
}
