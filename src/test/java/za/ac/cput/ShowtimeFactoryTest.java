package za.ac.cput;

import org.junit.Test;
import za.ac.cput.domain.Showtime;
import za.ac.cput.util.ShowtimeGenericHelper;
import java.time.LocalDate;
import java.time.LocalDateTime;
import za.ac.cput.factory.ShowtimeFactory;

import static org.junit.jupiter.api.Assertions.*;

public class ShowtimeFactoryTest {

    @Test
    public void createShowtime() {
        LocalDateTime startTime = LocalDateTime.of(2025, 3, 27, 14, 30);
        LocalDate date = LocalDate.of(2025, 3, 27);
        Showtime showtime = ShowtimeFactory.createShowtime(
                ShowtimeGenericHelper.generateID(),
                "Inception",
                startTime,
                date
        );

        System.out.println(showtime);

        assertNotNull(showtime);
    }

}
