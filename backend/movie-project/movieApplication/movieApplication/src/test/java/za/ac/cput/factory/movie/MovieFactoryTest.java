package za.ac.cput.factory.movie;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.movie.Movie;
import za.ac.cput.util.GenericHelper;

import static org.junit.jupiter.api.Assertions.*;

class MovieFactoryTest {

    @Test
    void createMovie() {
        Movie movie = MovieFactory.createMovie("Inception", GenericHelper.generateID(), "Sci-Fi", "2h28min");
        assertNotNull(movie);
        System.out.println(movie);
    }
}
