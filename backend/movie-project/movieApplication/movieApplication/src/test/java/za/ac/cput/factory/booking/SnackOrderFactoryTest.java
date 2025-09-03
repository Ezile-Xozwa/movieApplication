package za.ac.cput.factory.booking;

//import org.junit.Test;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.booking.Booking;
import za.ac.cput.domain.booking.SnackOrder;
import za.ac.cput.domain.movie.Movie;
import za.ac.cput.domain.movie.Showtime;
import za.ac.cput.domain.user.User;
import za.ac.cput.util.GenericHelper;


import java.time.LocalDate;
import java.time.LocalDateTime;

//import static junit.framework.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SnackOrderFactoryTest {

    @Test
    public void createSnackOrder() {
        LocalDateTime orderTime = LocalDateTime.of(2025, 5, 18, 12, 15);
        LocalDate date = LocalDate.of(2025, 5, 18);
        LocalDateTime startTime = LocalDateTime.of(2025, 5, 18, 11, 30);
        LocalDate birth = LocalDate.of(2025, 3, 27);

        Movie movie = new Movie.Builder()
                .setMovieId(GenericHelper.generateID())
                .setTitle("Inception")
                .setDuration("2h5m")
                .setGenre("Sci-Fi")
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

        Booking booking = new Booking.Builder()
                .setBookingId(GenericHelper.generateID())
                .setUser(user)
                .setShowtime(showtime)
                .build();

        SnackOrder snackOrder = new SnackOrder.Builder()
                .setSnackOrderId(GenericHelper.generateID())
                .setBookingId(GenericHelper.generateID())
                .setSnackId(GenericHelper.generateID())
                .setQuantity(2)
                .setTotalPrice(80.00)
                .setOrderTime(LocalDateTime.now().minusMinutes(10))
                .setSpecialInstructions("No ice")
                .build();

        System.out.println(snackOrder);

        assertNotNull(snackOrder);

    }
}
