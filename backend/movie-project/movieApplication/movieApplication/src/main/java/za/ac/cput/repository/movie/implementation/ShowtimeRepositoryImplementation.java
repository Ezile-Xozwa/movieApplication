//package za.ac.cput.repository.movie.implementation;
//
//import za.ac.cput.domain.movie.Showtime;
//import za.ac.cput.repository.movie.ShowtimeRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class ShowtimeRepositoryImplementation implements ShowtimeRepository {
//    private Set<Showtime> showtimeDB;
//
//    public ShowtimeRepositoryImplementation() {
//        this.showtimeDB = new HashSet<>();
//    }
//
//    public Showtime create(Showtime showtime) {
//        this.showtimeDB.add(showtime);
//        return showtime;
//    }
//
//    public Showtime read(String showtimeId) {
//        Showtime showtime = this.showtimeDB.stream()
//                .filter(sh -> sh.getShowtimeId() == showtimeId)
//                .findAny()
//                .orElse(null);
//        return showtime;
//    }
//
//    public Showtime update(Showtime updateshowtime) {
//        Showtime showtime = read(updateshowtime.getShowtimeId());
//        if (showtime != null) {
//            this.showtimeDB.remove(showtime);
//            this.showtimeDB.add(showtime);
//        }
//        return showtime;
//    }
//
//    public void delete(String showtimeId) {
//        Showtime showtime = read(showtimeId);
//     if(showtime !=null)
//
//    {
//        this.showtimeDB.remove(showtime);
//    }
//}
//
//    public Set<Showtime> getAll() {    return this.showtimeDB;}
//}
