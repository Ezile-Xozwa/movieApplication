package za.ac.cput.util;

import java.util.UUID;

public class UserGenericHelper {
    public static String generateID() {
        return UUID.randomUUID().toString();
}
}
