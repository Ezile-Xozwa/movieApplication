package za.ac.cput;
/*LoginFactoryTest.java

     LoginFactoryTest class

     Author: Katie Khezani Tolo (222831960)

     Date: 17 May 2025 */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Login;
import za.ac.cput.factory.LoginFactory;

import static org.junit.jupiter.api.Assertions.*;

class LoginFactoryTest {

    @Test
      void testCreateLoginSuccess() {
        Login login = LoginFactory.createLogin(
                "L001",
                "admin@example.com",
                "password123",
                Login.Role.Admin
        );

        assertNotNull(login);
        assertEquals("L001", login.getLoginId());
        assertEquals("admin@example.com", login.getEmail());
        assertEquals("password123", login.getPassword());
        assertEquals(Login.Role.Admin, login.getRole());
    }

    @Test
     void testCreateLoginWithInvalidData() {
        Login login = LoginFactory.createLogin(
                "", // invalid loginId
                "user@example.com",
                "pass",
                Login.Role.Customer
        );

        assertNull(login); // Should return null due to invalid loginId
    }
}

        assertNull(login); // Should return null due to invalid loginId
    }
}

