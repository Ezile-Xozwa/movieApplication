package za.ac.cput.repository;

import za.ac.cput.domain.Home;
import java.util.Set;

public interface HomeRepository extends Repository<Home, String> {
    Set<Home> getAll();
}
