// File: za.ac.cput.service.user.implementation.UserServiceImplementation
package za.ac.cput.service.user.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.user.User;
import za.ac.cput.repository.user.UserRepository;
import za.ac.cput.service.user.UserService;
import za.ac.cput.util.GenericHelper;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Set<User> getUsers() {
        return new HashSet<>(userRepository.findAll());
    }

    @Override
    public Set<User> getAll() {
        return getUsers(); // ← Delegation: getAll() reuses getUsers()
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User read(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    public void generateUsers() {
        String[][] userData = {
                {"John", "Doe", "0711234567", "1990-05-15", "Male"},
                {"Jane", "Smith", "0822345678", "1985-12-20", "Female"},
                {"Alex", "Brown", "0633456789", "1998-03-10", "Other"},
                {"Sarah", "Wilson", "0744567890", "1992-08-25", "Female"},
                {"Mike", "Taylor", "0815678901", "1980-11-30", "Male"}
        };

        for (String[] data : userData) {
            String id = GenericHelper.generateID();
            User user = new User.Builder()
                    .setUserId(id)
                    .setName(data[0])
                    .setSurname(data[1])
                    .setPhoneNumber(data[2])
                    .setDateOfBirth(java.time.LocalDate.parse(data[3]))
                    .setGender(data[4])
                    .build();

            if (userRepository.findById(id).isEmpty()) {
                create(user);
            }
        }
    }
}