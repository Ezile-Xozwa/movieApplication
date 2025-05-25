package za.ac.cput.repository.implementation;
/*LoginRepositoryImplement.java

     LoginRepositoryImplement

     Author: Katie Khezani Tolo (222831960)

     Date: 25 May 2025 */
import za.ac.cput.domain.Login;
import za.ac.cput.repository.LoginRepository;

import java.util.*;

public class LoginRepositoryImplementation implements LoginRepository {
    private final Map<String, Login> loginMap = new HashMap<>();

    @Override
    public Login save(Login login) {
        loginMap.put(login.getLoginId(), login);
        return login;
    }

    @Override
    public Optional<Login> findById(String id) {
        return Optional.ofNullable(loginMap.get(id));
    }

    @Override
    public void deleteById(String id) {
        loginMap.remove(id);
    }

    @Override
    public List<Login> findAll() {
        return new ArrayList<>(loginMap.values());
    }
}
