// File: za.ac.cput.service.user.UserService
package za.ac.cput.service.user;

import za.ac.cput.domain.user.User;
import za.ac.cput.service.Service;

import java.util.Set;

public interface UserService extends Service<User, String> {
    Set<User> getUsers();
}