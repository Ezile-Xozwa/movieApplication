package za.ac.cput.factory.movie;

//import org.junit.Test;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.movie.Movie;
import za.ac.cput.domain.movie.Showtime;
import za.ac.cput.util.GenericHelper;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ShowtimeFactoryTest {

    @Test
    public void createShowtime() {
        LocalDateTime startTime = LocalDateTime.of(2025, 7, 27, 14, 30);
        LocalDate date = LocalDate.of(2025, 7, 27);

        Movie movie = new Movie.Builder()
                .setMovieId(GenericHelper.generateID())
                .setTitle("Inception")
                .setGenre("Sci-Fi")
                .setDuration("2h5m")
                .build();

        Showtime showtime = ShowtimeFactory.createShowtime(
                GenericHelper.generateID(),
                movie,
                startTime,
                date
        );

        System.out.println(showtime);

        assertNotNull(showtime);
    }

}
