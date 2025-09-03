package za.ac.cput.factory.booking;

//import org.junit.Test;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.booking.Booking;
import za.ac.cput.domain.movie.Movie;
import za.ac.cput.domain.movie.Seat;
import za.ac.cput.domain.movie.Showtime;
import za.ac.cput.domain.user.User;
import za.ac.cput.util.GenericHelper;

import java.time.LocalDate;
import java.time.LocalDateTime;

//import static junit.framework.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BookingFactoryTest {

    @Test
    public void createBooking() {

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
        Seat seat = new Seat.Builder()
                .setSeatId(GenericHelper.generateID())
                .setRow('A')
                .setSeatNumber(10)
                .setStatus(Seat.Status.Available)
                .build();

        Booking booking = BookingFactory.createBooking(GenericHelper.generateID(), user, showtime, seat);
        System.out.println(booking);
        assertNotNull(booking);
    }

}
