package za.ac.cput;
/*ShowtimeFactoryTest.java

     ShowtimeFactoryTest class

     Author: Katie Khezani Tolo (222831960)

     Date: 17 May 2025 */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Showtime;
import za.ac.cput.util.ShowtimeGenericHelper;
import java.time.LocalDate;
import java.time.LocalDateTime;
import za.ac.cput.factory.ShowtimeFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ShowtimeFactoryTest {

    @Test
     void createShowtime() {
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
