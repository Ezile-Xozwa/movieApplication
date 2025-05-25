package za.ac.cput.domain;
/* Payment.java

     Payment POJO class

     Author: Herold M Ubisi (222662786)

     Date: 10 May 2025 */

public class Payment {
    public enum PaymentStatus {
        PENDING, SUCCESS, FAILED
    }

    private final String paymentId;
    private final Booking booking;
    private final double amount;
    private final PaymentStatus status;

    private Payment(Builder builder) {
        this.paymentId = builder.paymentId;
        this.booking = builder.booking;
        this.amount = builder.amount;
        this.status = builder.status;
    }

    public String getPaymentId() {
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

    public static class Builder {
        private String paymentId;
        private Booking booking;
        private double amount;
        private PaymentStatus status;

        public Builder setPaymentId(String paymentId) {
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

        public Builder copy(Payment payment) {
            this.paymentId = payment.getPaymentId();
            this.booking = payment.getBooking();
            this.amount = payment.getAmount();
            this.status = payment.getStatus();
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}
