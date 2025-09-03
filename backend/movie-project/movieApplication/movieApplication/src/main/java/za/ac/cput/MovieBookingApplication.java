package za.ac.cput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin; //added coz AI
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.service.booking.SnackOrderService;
import za.ac.cput.service.booking.implementation.SnackOrderServiceImplementation;
import za.ac.cput.service.movie.MovieService;
import za.ac.cput.service.movie.SeatService;
import za.ac.cput.service.movie.ShowtimeService;
import za.ac.cput.service.movie.implementation.MovieServiceImplementation;
import za.ac.cput.service.movie.implementation.SeatServiceImplementation;
import za.ac.cput.service.movie.implementation.ShowtimeServiceImplementation;

//@CrossOrigin(origins = "http://localhost:5173") //coz AI //AI said remove
@RestController
@SpringBootApplication
//@ComponentScan(basePackages = "za.ac.cput") // Optional: ensure full scan
public class MovieBookingApplication implements CommandLineRunner {
    @RequestMapping("/")
    String home (){
        return "Welcome to MovieBookingApplication!";
    }

    public static void main(String[] args) {
        SpringApplication.run(MovieBookingApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("🎬 Movie Booking System Started — Generating test data...");

        try {
            // 1. Generate Movies
            System.out.println("📽️  Generating movies...");
            movieService.generateMovies();
            System.out.println("✅ Movies generated successfully");

            // 2. Generate Showtimes (depends on movies)
            System.out.println("⏰ Generating showtimes...");
            showtimeService.generateShowtimes();
            System.out.println("✅ Showtimes generated successfully");

            // 3. Generate Seats
            System.out.println("🪑 Generating seats...");
            seatService.generateSeats();
            System.out.println("✅ Seats generated successfully");

            // 4. Generate Snack Orders
//            System.out.println("🍿 Generating snack orders...");
//            snackOrderService.generateSnackOrder();
//            System.out.println("✅ Snack orders generated successfully");

            System.out.println("🎉 All test data has been generated and saved to the database!");
        } catch (Exception e) {
            System.err.println("❌ Error during data generation: " + e.getMessage());
            e.printStackTrace();
        }

    }

    @Autowired
    private MovieService movieService;

    @Autowired
    private ShowtimeService showtimeService;

    @Autowired
    private SeatService seatService;

    @Autowired
    private SnackOrderService snackOrderService;

}
