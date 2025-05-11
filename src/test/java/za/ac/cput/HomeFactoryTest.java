package za.ac.cput;

import za.ac.cput.domain.Home;
import org.junit.jupiter.api.Test;
import za.ac.cput.factory.HomeFactory;
import za.ac.cput.util.HomeGenericHelper;

import static org.junit.jupiter.api.Assertions.*;

class HomeFactoryTest {

    @Test
    void createHome() {
        Home home = HomeFactory.createHome("Inception", HomeGenericHelper.generateID(), "Sci-Fi", "2h28min");
        assertNotNull(home);
        System.out.println(home);
    }
}
