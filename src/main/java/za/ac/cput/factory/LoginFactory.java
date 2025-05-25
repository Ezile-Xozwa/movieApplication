package za.ac.cput.factory;
/*Login.java

     LoginFactory  class

     Author: Katie Khezani Tolo (222831960)

     Date: 17 May 2025 */
import za.ac.cput.domain.Login;
import za.ac.cput.util.LoginValidationHelper;

public class LoginFactory {

    public static Login createLogin(String loginId, String email, String password, Login.Role role) {
        if (!LoginValidationHelper.isValidLogin(loginId, email, password, role)) {
            return null;
        }

        return new Login.Builder()
                .setLoginId(loginId)
                .setEmail(email)
                .setPassword(password)
                .setRole(role)
                .build();
    }
}
