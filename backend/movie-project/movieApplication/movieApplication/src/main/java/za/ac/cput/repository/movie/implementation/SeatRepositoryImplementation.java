//package za.ac.cput.repository.movie.implementation;
//
//import za.ac.cput.domain.movie.Seat;
//import za.ac.cput.repository.movie.SeatRepository;
//import java.util.HashSet;
//import java.util.Set;
//
//
//public class SeatRepositoryImplementation implements SeatRepository {
//    private Set<Seat> seatsDB;
//
//    private static SeatRepository seatRepository = null;
//
//    public SeatRepositoryImplementation() {
//        this.seatsDB = new HashSet<>();
//    }
//
//    public static SeatRepository getSeatRepository(){
//        if(seatRepository == null){
//            seatRepository = new SeatRepositoryImplementation();
//        }
//        return seatRepository;
//    }
//
//    @Override
//    public Seat create (Seat seat) {
//        this.seatsDB.add(seat);
//        return seat;
//    }
//
////    @Override
////    public Seat read(Integer seatNumber) {
////        Seat seat = this.seatsDB.stream()
////                .filter(s -> s.getSeatNumber() == seatNumber)
////                .findAny()
////                .orElse(null);
////        return seat;
////    }
//
//    @Override
//    public Seat read(String seatId) {
//        return this.seatsDB.stream()
//                .filter(s -> s.getSeatId().equals(seatId))
//                .findFirst()
//                .orElse(null);
//    }
//
////    @Override
////    public Seat update(Seat updateseat) {
////        Seat seat = read(updateseat.getSeatNumber());
////        if(seat!=null) {
////            this.seatsDB.remove(seat);
////            this.seatsDB.add(seat);
////        }
////        return seat;
////    }
//
//    @Override
//    public Seat update(Seat updatedSeat) {
//        Seat existing = read(updatedSeat.getSeatId());  // Use ID, not seatNumber!
//        if (existing != null) {
//            this.seatsDB.remove(existing);
//        }
//        this.seatsDB.add(updatedSeat);
//        return updatedSeat;
//    }
//
////    @Override
////    public void delete(Integer seatNumber) {
////        Seat seat = read(seatNumber);
////        if (seat != null) {
////            this.seatsDB.remove(seat);
////        }
////    }
//
//    @Override
//    public void delete(String seatId) {
//        Seat seat = read(seatId);
//        if (seat != null) {
//            this.seatsDB.remove(seat);
//        }
//    }
//
//    @Override
//    public Set<Seat> getAll() {
//        return this.seatsDB;
//    }
//
//}
