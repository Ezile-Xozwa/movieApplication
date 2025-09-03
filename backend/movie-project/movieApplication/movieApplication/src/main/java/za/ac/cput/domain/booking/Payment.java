package za.ac.cput.domain.booking;

import jakarta.persistence.*;

@Entity
public class Payment {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String paymentId; //changed into to string

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking; // Assuming Booking is already created

    private double amount;
    private PaymentStatus status;
    public enum PaymentStatus{PENDING, SUCCESS, FAILED}

    protected Payment() {

    }

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

    public PaymentStatus getPaymentStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "amount=" + amount +
                ", paymentId='" + paymentId + '\'' +
                ", booking=" + booking +
                ", status=" + status +
                '}';
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

        private Builder copy(Payment payment) {
            this.paymentId = payment.paymentId;
            this.booking = payment.booking;
            this.amount = payment.amount;
            this.status = payment.status;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}
