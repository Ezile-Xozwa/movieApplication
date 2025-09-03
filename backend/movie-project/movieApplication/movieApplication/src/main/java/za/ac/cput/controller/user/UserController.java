
package za.ac.cput.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.user.User;
import za.ac.cput.factory.user.UserFactory;
import za.ac.cput.service.user.UserService;
import za.ac.cput.service.user.implementation.UserServiceImplementation;

import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        User newUser = UserFactory.createUser(
                user.getUserId(),
                user.getName(),
                user.getSurname(),
                user.getPhoneNumber(),
                user.getDateOfBirth(),
                user.getGender(),
                user.getPassword(),
                user.getEmail()
        );
        return userService.create(newUser);
    }

    @GetMapping("/read/{id}")
    public User read(@PathVariable String id) {
        return userService.read(id);
    }

    @PutMapping("/update")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @GetMapping("/all")
    public Set<User> getAll() {
        return userService.getUsers();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        userService.delete(id);
    }

    @GetMapping("/generate")
    public Set<User> generateUsers() {
        ((UserServiceImplementation) userService).generateUsers();
        return userService.getUsers();
    }
}