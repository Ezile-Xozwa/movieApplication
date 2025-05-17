package za.ac.cput.util;
/* Booking.java

     Booking POJO class

     Author: Herold M Ubisi (222662786)

     Date:  */
import java.util.UUID;

public class BookingGenericHelper {
    public static String generateID() {
        return UUID.randomUUID().toString();
    }
}
