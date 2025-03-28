package za.ac.cput.domain;

// Payment Entity (used for Processing Payments)
public class Payment {
    private final int paymentId;
    private final Booking booking; // Assuming Booking is already created
    private final double amount;
    private final PaymentStatus status;

    private Payment(Builder builder) {
        this.paymentId = builder.paymentId;
        this.booking = builder.booking;
        this.amount = builder.amount;
        this.status = builder.status;
    }

    // Getters
    public int getPaymentId() {
        return paymentId;
    }

    public Booking getBooking() {
        return booking;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    // Static Builder class for Payment
    public static class Builder {
        private int paymentId;
        private Booking booking;
        private double amount;
        private PaymentStatus status;

        public Builder setPaymentId(int paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder setBooking(Booking booking) {
            this.booking = booking;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setStatus(PaymentStatus status) {
            this.status = status;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}
