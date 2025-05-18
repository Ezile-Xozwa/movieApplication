
package za.ac.cput.repository;

import za.ac.cput.domain.Booking;
import java.util.Set;

public interface BookingRepository extends IRepository<Booking, Integer> {
    Set<Booking> getAll();
}
