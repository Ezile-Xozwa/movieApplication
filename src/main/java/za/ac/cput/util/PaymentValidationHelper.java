package za.ac.cput.util;

import za.ac.cput.domain.Payment;

public class PaymentValidationHelper {

    public static boolean isValidPaymentId(int paymentId) {
        return paymentId > 0;
    }

    public static boolean isValidAmount(double amount) {
        return amount > 0;
    }

    public static boolean isValidPaymentStatus(PaymentStatus payment) {
        return status != null;
    }
}
