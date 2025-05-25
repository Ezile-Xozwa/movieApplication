package za.ac.cput.util;

/* PaymentGenericHelper.java


   Author: Herold M Ubisi (222662786)

   Date: May 2025
*/

import java.util.UUID;

public class PaymentGenericHelper {
    public static String generateID() {
        return UUID.randomUUID().toString();
    }
}
