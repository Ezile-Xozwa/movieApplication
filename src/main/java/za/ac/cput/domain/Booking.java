package za.ac.cput.domain;

public class Booking {
    private final int bookingId;
    private final User user;
    private final Showtime showtime;
    private final Seat seat;
    private BookingStatus status;
    public enum BookingStatus {Pending, Confirmed, Cancelled};

    private Booking(Builder builder) {
        this.bookingId = builder.bookingId;
        this.user = builder.user;
        this.showtime = builder.showtime;
        this.seat = builder.seat;
        this.status = builder.status;
    }

    public int getBookingId() {
        return bookingId;
    }

    public User getUser() {
        return user;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public Seat getSeat() {
        return seat;
    }

    public BookingStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", user=" + user +
                ", showtime=" + showtime +
                ", seat=" + seat +
                ", status=" + status +
                '}';
    }

    public static class Builder {
        private int bookingId;
        private User user;
        private Showtime showtime;
        private Seat seat;
        private BookingStatus status;

        public Builder setBookingId(int bookingId) {
            this.bookingId = bookingId;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setShowtime(Showtime showtime) {
            this.showtime = showtime;
            return this;
        }

        public Builder setSeat(Seat seat) {
            this.seat = seat;
            return this;
        }

        public Builder setStatus(BookingStatus status) {
            this.status = status;
            return this;
        }


        private copy (Booking booking)
        private copy(Booking booking) {
            this.bookingId = booking.bookingId;
            this.user = booking.user;
            this.showtime = booking.showtime;
            this.seat = booking.seat;
            this.status = booking.status;
        }

        public Booking build() {
            return new Booking(this);
        }
    }
}
