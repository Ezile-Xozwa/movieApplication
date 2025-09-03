
package za.ac.cput.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.user.Login;
import za.ac.cput.factory.user.LoginFactory;
import za.ac.cput.service.user.LoginService;
import za.ac.cput.service.user.implementation.LoginServiceImplementation;

import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/logins")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/create")
    public Login create(@RequestBody Login login) {
        Login newLogin = LoginFactory.createLogin(
                login.getLoginId(),
                login.getEmail(),
                login.getPassword(),
                login.getRole(),
                login.getUser()
        );
        return loginService.create(newLogin);
    }

    @GetMapping("/read/{id}")
    public Login read(@PathVariable String id) {
        return loginService.read(id);
    }

    @PutMapping("/update")
    public Login update(@RequestBody Login login) {
        return loginService.update(login);
    }

    @GetMapping("/all")
    public Set<Login> getAll() {
        return loginService.getLogins();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        loginService.delete(id);
    }

    @GetMapping("/generate")
    public Set<Login> generateLogins() {
        ((LoginServiceImplementation) loginService).generateLogins();
        return loginService.getLogins();
    }

    @GetMapping("/email/{email}")
    public Login findByEmail(@PathVariable String email) {
        return loginService.findByEmail(email);
    }
}