// File: za.ac.cput.service.user.LoginService
package za.ac.cput.service.user;

import za.ac.cput.domain.user.Login;
import za.ac.cput.service.Service;

import java.util.Set;

public interface LoginService extends Service<Login, String> {
    Set<Login> getLogins();
    Login findByEmail(String email);
}