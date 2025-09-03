//package za.ac.cput.util;
//
//import org.apache.commons.validator.routines.EmailValidator;
//import za.ac.cput.domain.booking.Booking;
//import za.ac.cput.domain.booking.Payment;
//import za.ac.cput.domain.movie.Movie;
//import za.ac.cput.domain.movie.Seat;
//import za.ac.cput.domain.movie.Showtime;
//import za.ac.cput.domain.review.Review;
//import za.ac.cput.domain.user.User;
//
//import java.time.LocalDateTime;
//
//public class ValidationHelper {
//
//    //BOOKING CLASS VALIDATION
//    public static boolean IsEmptyOrNullString(String bookingId) {
//        return bookingId == null || bookingId.isEmpty();
//    }
//
//    public static boolean isValidUser(User user) {
//        return user != null;
//    }
//
//    public static boolean isValidShowtime(Showtime showtime) {
//        return showtime != null;
//    }
//
//    public static boolean isValidSeat(Seat seat) {
//        return seat != null;
//    }
//
////    public static boolean isValidBookingStatus(Booking.BookingStatus status) {
////        return status == Booking.BookingStatus.Confirmed || status == Booking.BookingStatus.Cancelled;
////    }
//
//    //MOVIE CLASS VALIDATION
//    public static boolean IsEmptyOrNullString (String str){
//        return str == null || str.trim().isEmpty();
//    }
//
//    public static boolean isValidDuration(String duration) {
//        return duration != null && duration.matches("^(\\d+h)?(\\s?\\d{1,2}min)?$");
//    }
//
//
//    //PAYMENT CLASS VALIDATION
//    public static boolean IsEmptyOrNullString(String paymentId) {
//        return paymentId == null || paymentId.isEmpty();
//    }
//
//    public static boolean isValidBooking(Booking booking) {
//        return booking != null;
//    }
//
//    public static boolean isValidAmount(double amount) {
//        return amount > 0;
//    }
//
//    public static boolean isValidPaymentStatus(Payment.PaymentStatus status) {
//        return status == Payment.PaymentStatus.SUCCESS || status == Payment.PaymentStatus.FAILED;
//    }
//
//
//    //REVIEW CLASS VALIDATION
//    public static boolean isEmptyOrNull(String reviewId) {
//        return reviewId == null || reviewId.isEmpty();
//    }
//
//    public static boolean isValidUser(User user) { //got it from payment class, don't fully understand why we have it cause showtime doesn't have it
//        return user != null;
//    }
//
//    public static boolean isValidMovie(Movie movie) { //got it from payment class, don't fully understand why we have it cause showtime doesn't have it
//        return movie != null;
//    }
//
//    public static boolean isRatingValid(double rating) {
//        return rating >= 1 && rating <= 5;
//    }
////        {
////            return false;
////        }
////        return true;
////    }
//
////    public static boolean isEmptyOrNull(String comment){
////        return comment == null || comment.isEmpty();
////    }
//
//    public static boolean isValidTimeStamp(java.time.LocalDateTime startTime) {
//        return startTime != null && startTime.isAfter(java.time.LocalDateTime.now());
//    }
//
//    public static boolean isValidSpoilerWarning(Review.isSpoiler spoiler) {
//        return spoiler == Review.isSpoiler.SPOILER || spoiler == Review.isSpoiler.NOT_SPOILER;
//    }
//
//
//
//    //SEAT CLASS VALIDATION
//    public static boolean IsEmptyOrNullString (String seatId){
//        if ( seatId.isEmpty() || seatId == null )
//            return true;
//        return false;
//    }
//
//    public static boolean isValidSeatNumber(int seatNumber) {
//        return seatNumber > 0;
//    }
//
//    public static boolean isValidRow(char row) {
//        return row >= 'A' && row <= 'Z';
//    }
//
//    public static boolean isValidSeatStatus(Seat.Status status) {
//        return status == Seat.Status.Available || status == Seat.Status.Booked;
//    }
//
//
//
//    //SHOWTIME CLASS VALIDATION
//    public static boolean isEmptyOrNullString(String showtimeId) {
//        return showtimeId == null || showtimeId.isEmpty();
//    }
//
//    public static boolean isValidStartTime(java.time.LocalDateTime startTime) {
//        return startTime != null && startTime.isAfter(java.time.LocalDateTime.now());
//    }
//
//    public static boolean isValidDate(java.time.LocalDate date) {
//        return date != null && !date.isBefore(java.time.LocalDate.now());
//    }
//
//    public static boolean isValidMovie(Movie movie) {
//        return movie != null;
//    }
//
//
//    //USER CLASS VALIDATION
//    public static boolean IsEmptyOrNullString(String userId) {
//        if(userId.isEmpty() || userId == null)
//            return true;
//        return false;
//    }
//    public static boolean isValidName(String name){
//        return name == null || name.isEmpty();
//    }
//    public static boolean isValidSurname(String surname){
//        return surname == null || surname.isEmpty();
//    }
//    public static boolean isValidEmail(String email){
//        EmailValidator validator = EmailValidator.getInstance();
//        if(validator.isValid(email))
//            return false;
//        return true;
//    }
//    public static boolean isValidPassword(String password){
//        return password == null || password.isEmpty();
//    }
//    public static boolean isValidPhoneNumber(String phoneNumber){
//        return phoneNumber == null || phoneNumber.isEmpty();
//    }
//
//    public static boolean isValidDateOfBirth(java.time.LocalDate date) {
//        return date != null && !date.isBefore(java.time.LocalDate.now());
//    }
//    public static boolean isValidGender(String gender){
//        return gender == null || gender.isEmpty();
//    }
//
//
//
//    //SNACKORDER CLASS VALIDATION
//
//        public static boolean isNullOrEmpty(String value) {
//            return value == null || value.trim().isEmpty();
//        }
//
//        public static boolean isValidQuantity(int quantity) {
//            return quantity > 0;
//        }
//
//        public static boolean isValidTotalPrice(double totalPrice) {
//            return totalPrice >= 0;
//        }
//
//        public static boolean isValidOrderTime(LocalDateTime orderTime) {
//            return orderTime != null && !orderTime.isAfter(LocalDateTime.now());
//        }
//
//        public static boolean isValidSnackOrder(String snackOrderId, String bookingId, String snackId,
//                                                int quantity, double totalPrice, LocalDateTime orderTime) {
//            return !isNullOrEmpty(snackOrderId)
//                    && !isNullOrEmpty(bookingId)
//                    && !isNullOrEmpty(snackId)
//                    && isValidQuantity(quantity)
//                    && isValidTotalPrice(totalPrice)
//                    && isValidOrderTime(orderTime);
//        }
//
//
//
//}
