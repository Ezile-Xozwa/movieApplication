package za.ac.cput.factory.user;

import za.ac.cput.domain.user.Login;
import za.ac.cput.domain.user.User;
import za.ac.cput.util.LoginValidationHelper;

public class LoginFactory {

    public static Login createLogin(String loginId, String email, String password, Login.Role role, User user) {

        if (!LoginValidationHelper.isValidLogin(loginId, email, password, role)) {
            return null;
        }

        if (user == null) {
            System.err.println("❌ Cannot create Login: User is null");
            return null;
        }

        return new Login.Builder()
                .setLoginId(loginId)
                .setEmail(email)
                .setPassword(password)
                .setRole(role)
                .setUser(user)
                .build();
    }
}
