package za.ac.cput.util;

import za.ac.cput.domain.user.Login;

public class LoginValidationHelper {
    public static boolean isValidLogin(String loginId, String email, String password, Login.Role role) {
        return !isEmptyOrNull(loginId) &&
                isValidEmail(email) &&
                !isEmptyOrNull(password) &&
                role != null;
    }

//    // In LoginValidationHelper.java
//    public static boolean isValidLogin(String loginId, String email, String password, Login.Role role) {
//        return loginId != null && !loginId.isEmpty() &&
//                email != null && email.contains("@") &&
//                password != null && password.length() >= 6 &&
//                role != null;
//    }

    private static boolean isEmptyOrNull(String value) {
        return value == null || value.trim().isEmpty();
    }

    private static boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
}