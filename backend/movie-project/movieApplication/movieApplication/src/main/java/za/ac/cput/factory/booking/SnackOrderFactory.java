package za.ac.cput.factory.booking;

import za.ac.cput.domain.booking.SnackOrder;
import za.ac.cput.util.SnackOrderValidationHelper;

import java.time.LocalDateTime;

public class SnackOrderFactory {

public static SnackOrder createSnackOrder(
        String snackOrderId,
        String bookingId,
        String snackId,
        int quantity,
        double totalPrice,
        LocalDateTime orderTime,
        String specialInstructions) {

    if (SnackOrderValidationHelper.isNullOrEmpty(snackOrderId) ||
            SnackOrderValidationHelper.isNullOrEmpty(bookingId) ||
            SnackOrderValidationHelper.isNullOrEmpty(snackId) ||
            quantity <= 0 ||
            totalPrice <= 0 ||
            orderTime == null) {
        return null;
    }

    return new SnackOrder.Builder()
            .setSnackOrderId(snackOrderId)
            .setBookingId(bookingId)
            .setSnackId(snackId)
            .setQuantity(quantity)
            .setTotalPrice(totalPrice)
            .setOrderTime(orderTime)
            .setSpecialInstructions(specialInstructions)
            .build();
}
}