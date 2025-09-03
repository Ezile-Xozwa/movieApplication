// File: za.ac.cput.repository.user.LoginRepository
package za.ac.cput.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.user.Login;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {
    Optional<Login> findByEmail(String email);
}