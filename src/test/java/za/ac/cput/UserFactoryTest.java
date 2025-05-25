package za.ac.cput;

import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.util.UserGenericHelper;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserFactoryTest {
   
    @Test
    void createUser() {
        User user = UserFactory.createUser(UserGenericHelper.generateID(),"Ayanda", "0734658890", "Nelo","27-03-2019","female");

        System.out.println(user);
        assertNotNull(user);
    }
}
