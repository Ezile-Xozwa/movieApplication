package za.ac.cput.service.user.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.user.Login;
import za.ac.cput.repository.user.LoginRepository;
import za.ac.cput.service.user.LoginService;
import za.ac.cput.util.GenericHelper;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class LoginServiceImplementation implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public Set<Login> getLogins() {
        return new HashSet<>(loginRepository.findAll());
    }
    @Override
    public Set<Login> getAll() {
        return getLogins();
    }

    @Override
    public Login create(Login login) {
        return loginRepository.save(login);
    }

    @Override
    public Login read(String id) {
        return loginRepository.findById(id).orElse(null);
    }

    @Override
    public Login update(Login login) {
        return loginRepository.save(login);
    }

    @Override
    public void delete(String id) {
        loginRepository.deleteById(id);
    }

    @Override
    public Login findByEmail(String email) {
        return loginRepository.findByEmail(email).orElse(null);
    }

    public void generateLogins() {
        // Sample admin and customer
        Login admin = new Login.Builder()
                .setLoginId(GenericHelper.generateID())
                .setEmail("admin@movie.com")
                .setPassword("admin123")
                .setRole(Login.Role.Admin)
                .build();

        Login customer = new Login.Builder()
                .setLoginId(GenericHelper.generateID())
                .setEmail("customer@movie.com")
                .setPassword("user123")
                .setRole(Login.Role.Customer)
                .build();

        create(admin);
        create(customer);
    }
}