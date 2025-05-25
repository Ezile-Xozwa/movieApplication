package za.ac.cput.util;
/*LoginValidationHelper.java

     LoginValidationHelper class

     Author: Katie Khezani Tolo (222831960)

     Date: 18 May 2025 */
import za.ac.cput.domain.Login;

public class LoginValidationHelper {

    public static boolean isEmptyOrNull(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static boolean isValidLogin(String loginId, String email, String password, Login.Role role) {
        return !isEmptyOrNull(loginId)
                && !isEmptyOrNull(email)
                && !isEmptyOrNull(password)
                && role != null;
    }
}
