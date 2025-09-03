// File: za.ac.cput.repository.user.UserRepository
package za.ac.cput.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    // Optional: add custom queries later
}