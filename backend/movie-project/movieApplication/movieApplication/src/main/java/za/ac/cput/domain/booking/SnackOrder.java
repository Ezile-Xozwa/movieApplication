package za.ac.cput.domain.booking;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SnackOrder {

    @Id
    private String snackOrderId;

    private String bookingId;
    private String snackId;
    private int quantity;
    private double totalPrice;
    private LocalDateTime orderTime;
    private String specialInstructions;

    protected SnackOrder() {}

    private SnackOrder(Builder builder){
        this.snackOrderId = builder.snackOrderId;
        this.bookingId = builder.bookingId;
        this.snackId = builder.snackId;
        this.quantity = builder.quantity;
        this.totalPrice = builder.totalPrice;
        this.orderTime = builder.orderTime;
        this.specialInstructions = builder.specialInstructions;
    }

    public String getSnackOrderId() {
        return snackOrderId;
    }
    public String getBookingId() {
        return bookingId;
    }
    public  String getSnackId() {
        return snackId;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public LocalDateTime getOrderTime() {
        return orderTime;
    }
    public String getSpecialInstructions() {
        return specialInstructions;
    }

    @Override
    public String toString(){
        return "SnackOrder{" +
                "snackOrderId='" + snackOrderId + '\'' +
                ", bookingId='" + bookingId + '\'' +
                ", snackId='" + snackId + '\'' +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", orderTime=" + orderTime +
                ", specialInstructions='" + specialInstructions + '\'' +
                '}';
    }

    public static class Builder {
        private String snackOrderId;
        private String bookingId;
        private String snackId;
        private int quantity;
        private double totalPrice;
        private LocalDateTime orderTime;
        private String specialInstructions;

        public Builder setSnackOrderId(String snackOrderId) {
            this.snackOrderId = snackOrderId;
            return this;
        }

        public Builder setBookingId(String bookingId) {
            this.bookingId = bookingId;
            return this;
        }

        public Builder setSnackId(String snackId) {
            this.snackId = snackId;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Builder setOrderTime(LocalDateTime orderTime) {
            this.orderTime = orderTime;
            return this;
        }

        public Builder setSpecialInstructions(String specialInstructions) {
            this.specialInstructions = specialInstructions;
            return this;
        }

        public Builder copy(SnackOrder snackOrder) {
            this.snackOrderId = snackOrder.snackOrderId;
            this.bookingId = snackOrder.bookingId;
            this.snackId = snackOrder.snackId;
            this.quantity = snackOrder.quantity;
            this.totalPrice = snackOrder.totalPrice;
            this.orderTime = snackOrder.orderTime;
            this.specialInstructions = snackOrder.specialInstructions;
            return this;
        }

        public SnackOrder build() {
            return new SnackOrder(this);
        }
    }



}
