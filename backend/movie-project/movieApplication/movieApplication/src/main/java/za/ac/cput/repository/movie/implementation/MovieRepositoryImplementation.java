//package za.ac.cput.repository.movie.implementation;
//
//import za.ac.cput.domain.movie.Movie;
//import za.ac.cput.repository.movie.MovieRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class MovieRepositoryImplementation implements MovieRepository {
//   // private static HomeRepositoryImplementation repository = null;
//    private Set<Movie> moviesDB;
//
//    public MovieRepositoryImplementation() {
//        this.moviesDB = new HashSet<>();
//    }
//
//    @Override
//    public Movie create(Movie movie) {
//        this.moviesDB.add(movie);
//        return movie;
//    }
//
//    @Override
//    public Movie read(String movieId) {
//       Movie movie = this.moviesDB.stream()
//                .filter(m-> m.getMovieId().equalsIgnoreCase(movieId))
//                .findAny()
//                .orElse(null);
//       return movie;
//    }
//
//    @Override
//    public Movie update(Movie movie) {
//        Movie oldMovie = read(movie.getMovieId());
//        if (oldMovie != null) {
//            this.moviesDB.remove(oldMovie);
//            this.moviesDB.add(movie);
//            return movie;
//        }
//        return null;
//    }
//
//    @Override
//    public void delete(String movieId) {
//        Movie movie = read(movieId);
//        if (movie != null) {
//            this.moviesDB.remove(movie);
//        }
//    }
//
//    @Override
//    public Set<Movie> getAll() {
//        return new HashSet<>(this.moviesDB); // Returns a copy to avoid direct modification
//    }
//}
