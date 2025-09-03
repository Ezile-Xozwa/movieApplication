package za.ac.cput.factory.booking;

//import za.ac.cput.util.PaymentGenericHelper;
import org.junit.jupiter.api.Test;
//import za.ac.cput.util.ShowtimeGenericHelper;
//import za.ac.cput.util.UserGenericHelper;
import za.ac.cput.domain.booking.Booking;
import za.ac.cput.domain.booking.Payment;
import za.ac.cput.domain.movie.Movie;
import za.ac.cput.domain.movie.Showtime;
import za.ac.cput.domain.user.User;
import za.ac.cput.util.GenericHelper;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static junit.framework.Assert.assertNotNull;

class PaymentFactoryTest {

    @Test
    void createPayment() {

        LocalDateTime startTime = LocalDateTime.of(2025, 3, 27, 14, 30);
        LocalDate date = LocalDate.of(2025, 3, 27);
        LocalDate birth = LocalDate.of(2025, 3, 27);


        Movie movie = new Movie.Builder()
                .setMovieId(GenericHelper.generateID())
                .setTitle("Inception")
                .setGenre("Sci-Fi")
                .setDuration("2h5m")
                .build();

        User user = new User.Builder()
                .setUserId(GenericHelper.generateID())
                .setName("Mbali")
                .setSurname("Banda")
                //.setEmail("")
                //.setPassword("")
                .setPhoneNumber("")
                .setDateOfBirth(birth)
                .setGender("Female")
                .build();
        Showtime showtime = new Showtime.Builder()
                .setShowtimeId(GenericHelper.generateID())
                .setMovie(movie)
                .setDate(date)
                .setStartTime(startTime)
                .build();

        Booking booking = new Booking.Builder()
                .setBookingId(GenericHelper.generateID())
                .setUser(user)
                .setShowtime(showtime)
                //.setStatus(Booking.BookingStatus.Confirmed)
                .build();

        Payment payment = PaymentFactory.createPayment(GenericHelper.generateID(), booking, 25.00, Payment.PaymentStatus.SUCCESS);
        assertNotNull(payment);
        System.out.println(payment);
    }
}
