
package za.ac.cput.util;

import java.time.LocalDateTime;

public class SnackOrderValidationHelper {

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static boolean isValidQuantity(int quantity) {
        return quantity > 0;
    }

    public static boolean isValidTotalPrice(double totalPrice) {
        return totalPrice >= 0;
    }

    public static boolean isValidOrderTime(LocalDateTime orderTime) {
        return orderTime != null && !orderTime.isAfter(LocalDateTime.now());
    }

    public static boolean isValidSnackOrder(String snackOrderId, String bookingId, String snackId,
                                            int quantity, double totalPrice, LocalDateTime orderTime) {
        return !isNullOrEmpty(snackOrderId)
                && !isNullOrEmpty(bookingId)
                && !isNullOrEmpty(snackId)
                && isValidQuantity(quantity)
                && isValidTotalPrice(totalPrice)
                && isValidOrderTime(orderTime);
    }
}
