package za.ac.cput.repository;

import za.ac.cput.repository.Repository;
import za.ac.cput.domain.User;

import java.util.Set;

public interface UserRepository extends Repository<User,String>{
    Set<User> getAll();
}
