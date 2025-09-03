package za.ac.cput.service.movie.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.booking.SnackOrder;
import za.ac.cput.domain.movie.Seat;
import za.ac.cput.repository.movie.SeatRepository;
//import za.ac.cput.repository.movie.implementation.SeatRepositoryImplementation;
import za.ac.cput.service.movie.SeatService;
import za.ac.cput.util.GenericHelper;

import java.util.HashSet;
import java.util.List; //coz AI
import java.util.Set;

@Service
public class SeatServiceImplementation implements SeatService {

    //private static SeatService seatService = null;
    @Autowired
    private SeatRepository seatRepository;


//    private SeatServiceImplementation() {
//        this.seatRepository = SeatRepositoryImplementation.getSeatRepository();
//    }

//    public static SeatService getSeatService() {
//        if (seatService == null)
//            seatService = new SeatServiceImplementation();
//        return seatService;
//    }

//    public void generateSeats() {
//        char[] rows = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
//        for (char row : rows) {
//            for (int num = 1; num <= 10; num++) {
//                String id = GenericHelper.generateID();
//                Seat seat = new Seat.Builder()
//                        .setSeatId(id)
//                        .setRow(row)
//                        .setSeatNumber(num)
//                        .setStatus(Seat.Status.Available)
//                        .build();
//                create(seat);
//            }
//        }
//    }


    public void generateSeats() {
        System.out.println("✅ Starting to generate seats...");
        char [] rows = {'A', 'B', 'C', 'D', 'E'};
        for (char seatRow : rows) {
            for (int num = 1; num <= 10; num++) {
                String id = GenericHelper.generateID();
                Seat seat = new Seat.Builder()
                        .setSeatId(id)
                        .setSeatRow(seatRow)
                        .setSeatNumber(num)
                        .setStatus(Seat.Status.Available)
                        .build();
                Seat saved = create(seat); //will save via JPA
                System.out.println("✅ Created seat: " + saved.getSeatId() + " | Row: " + saved.getSeatRow() + " | Num: " + saved.getSeatNumber());
            }
        }
    }


//    @Override
//    public Set<Seat> getSeats() {
//        return this.seatRepository.getAll();
//        //return this.seatRepository.getSeats();
//    }

    @Override
    public Set<Seat> getAll() {
        return getSeats();
    }
    @Override
    public Set<Seat> getSeats() {
        //List<Seat> all = seatRepository.findAll();
        //return new java.util.HashSet<>(all); // Convert to Set
        return new HashSet<>(seatRepository.findAll());
    }



//    @Override
//    public Set<Seat> getSeatsInRowB() { //you can also implement in Repo if function is too big
//        Set<Seat> allSeats = getSeats();
//        for(Seat seat1 : allSeats) {
//            if(seat1.getRow('B')){
//                allSeats.add(seat1);
//            }
//        }
//        return allSeats;
//    }

//    @Override
//    public Seat create(Seat seat) {
//        return this.seatRepository.create(seat);
//    }
    @Override
    public Seat create(Seat seat) {
        return seatRepository.save(seat);
    }

//    @Override
//    public Seat read(String s) {
//        //return this.seatRepository.read(s);
//        return this.seatRepository.read(s);
//    }
    @Override
    public Seat read(String id) {
        return seatRepository.findById(id).orElse(null);
    }

//    @Override
//    public Seat update(Seat seat) {
//        return this.seatRepository.update(seat);
//    }
    @Override
    public Seat update(Seat seat) {
        return seatRepository.save(seat);
    }

//    @Override
//    public void delete(String s) {
//        //this.seatRepository.delete(s);
//        this.seatRepository.delete(s);
//    }
    @Override
    public void delete(String id) {
        seatRepository.deleteById(id);
    }

}
