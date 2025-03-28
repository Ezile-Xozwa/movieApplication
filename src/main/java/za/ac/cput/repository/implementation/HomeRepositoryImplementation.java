package za.ac.cput.repository.implementation;

import za.ac.cput.domain.Home;
import za.ac.cput.repository.HomeRepository;

import java.util.HashSet;
import java.util.Set;

public class HomeRepositoryImplementation implements HomeRepository {
   // private static HomeRepositoryImplementation repository = null;
    private Set<Home> homeDB;

    public HomeRepositoryImplementation() {
        this.homeDB = new HashSet<>();
    }

    @Override
    public Home create(Home home) {
        this.homeDB.add(home);
        return home;
    }

    @Override
    public Home read(String movieId) {
       Home home = this.homeDB.stream()
                .filter(h-> h.getMovieId().equalsIgnoreCase(movieId))
                .findAny()
                .orElse(null);
       return home;
    }

    @Override
    public Home update(Home home) {
        Home oldHome = read(home.getMovieId());
        if (oldHome != null) {
            this.homeDB.remove(oldHome);
            this.homeDB.add(home);
            return home;
        }
        return null;
    }

    @Override
    public void delete(String movieId) {
        Home home = read(movieId);
        if (home != null) {
            this.homeDB.remove(home);
        }
    }

    @Override
    public Set<Home> getAll() {
        return new HashSet<>(this.homeDB); // Returns a copy to avoid direct modification
    }
}
