package za.ac.cput.repository;
/*LoginRepository.java

     LoginRepository

     Author: Katie Khezani Tolo (222831960)

     Date: 25 May 2025 */
import za.ac.cput.domain.Login;
import java.util.List;
import java.util.Optional;

public interface LoginRepository {
    Login save(Login login);
    Optional<Login> findById(String id);
    void deleteById(String id);
    List<Login> findAll();
}
