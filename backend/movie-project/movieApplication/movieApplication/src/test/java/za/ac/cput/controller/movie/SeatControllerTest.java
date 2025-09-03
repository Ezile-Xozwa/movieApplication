package za.ac.cput.controller.movie;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.movie.Seat;
import za.ac.cput.factory.movie.SeatFactory;
import za.ac.cput.util.GenericHelper;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SeatControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseUrl = "http://localhost:8080/seats";

    private static Seat seat = SeatFactory.createSeat(GenericHelper.generateID(), 'A', 12, Seat.Status.Available);

    @Test
    @Order(1)
    void create() {
        String url = baseUrl + "/create";
        System.out.println("Post data: " + seat);
        ResponseEntity<Seat> postResponse = restTemplate.postForEntity(url, seat, Seat.class);
        System.out.println("Save data: " + seat);
        assertNotNull(postResponse.getBody());
    }

    @Test
    @Order(2)
    void read() {
        String url = baseUrl + "/read" + seat.getSeatId();
        System.out.println("URL: " + url);
        ResponseEntity<Seat> postResponse = restTemplate.getForEntity(url, Seat.class);
        assertNotNull(postResponse.getBody());
    }

    @Test
    @Order(3)
    void update() {
        Seat updated = new Seat.Builder().copy(seat).setSeatNumber(2).build();
        String url = baseUrl + "update";
        System.out.println("Post data: " + updated);
        ResponseEntity<Seat> response = restTemplate.postForEntity(url, updated, Seat.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Order(4)
    void getAll() {
        String url = baseUrl + "All";
        System.out.println("URL: " + url);
    }

    @Test
    @Order(5)
    void delete() {
        String url = baseUrl + "delete/" + seat.getSeatId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }
}