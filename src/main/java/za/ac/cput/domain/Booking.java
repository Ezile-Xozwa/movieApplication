package za.ac.cput.domain;

// Booking Entity (used for Ticket Reservations)
public class Booking {
    private final int bookingId;
    private final User user; // Assuming you have a User class
    private final Showtime showtime; // Assuming you have a Showtime class
    private final Seat seat; // Assuming you have a Seat class
    private final BookingStatus status;

    private Booking(Builder builder) {
        this.bookingId = builder.bookingId;
        this.user = builder.user;
        this.showtime = builder.showtime;
        this.seat = builder.seat;
        this.status = builder.status;
    }

    // Getters
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

    // Static Builder class for Booking
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

        public Booking build() {
            return new Booking(this);
        }
    }
}
