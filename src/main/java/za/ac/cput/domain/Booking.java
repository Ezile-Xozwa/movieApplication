package za.ac.cput.domain;

public class Booking {
    private String bookingId;
    private User user;
    private Showtime showtime;
    private Seat seat;

    private Booking(){

    }

    private Booking(Builder builder) {
        this.bookingId = builder.bookingId;
        this.user = builder.user;
        this.showtime = builder.showtime;
        this.seat = builder.seat;
    }

    public String getBookingId() {
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


    @Override
    public String toString() {
        return "bookingId:" + bookingId + "\n"
                + " user=" + user + "\n"
                + " showtime=" + showtime + "\n"
                + " seat=" + seat + "\n";
    }

    public static class Builder {
        private String bookingId;
        private User user;
        private Showtime showtime;
        private Seat seat;

        public Builder setBookingId(String bookingId) {
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


        private Builder copy(Booking booking) {
            this.bookingId = booking.bookingId;
            this.user = booking.user;
            this.showtime = booking.showtime;
            this.seat = booking.seat;
            return this;
        }

        public Booking build() {
            return new Booking(this);
        }
    }
}