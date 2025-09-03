package za.ac.cput.service.booking;

import za.ac.cput.domain.booking.SnackOrder;
import za.ac.cput.domain.movie.Seat;
import za.ac.cput.service.Service;

import java.util.Set;

public interface SnackOrderService extends Service<SnackOrder, String> {
    Set<SnackOrder> getSnackOrder();
    //void generateSnackOrder();
}