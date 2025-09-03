package za.ac.cput.factory.user;

import za.ac.cput.domain.user.User;
import za.ac.cput.util.GenericHelper;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserFactoryTest {

    LocalDate birth = LocalDate.of(2025, 3, 27);

    @Test
    void createUser() {
        User user = UserFactory.createUser(GenericHelper.generateID(), "Haille",
            "McCall",
            "071-787-7485",
            birth,
            "Male");


        System.out.println(user);
        assertNotNull(user);
    }

//    private void assertNotNull(User user) {
//    }
}
