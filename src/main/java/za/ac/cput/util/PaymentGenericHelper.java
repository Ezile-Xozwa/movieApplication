package za.ac.cput.util;

import java.util.UUID;

public class PaymentGenericHelper {

    public static String generateID() {
        return UUID.randomUUID().toString();
    }
}
