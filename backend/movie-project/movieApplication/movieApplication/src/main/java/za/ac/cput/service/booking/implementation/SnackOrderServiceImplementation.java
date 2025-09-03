package za.ac.cput.service.booking.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.booking.SnackOrder;
import za.ac.cput.repository.booking.SnackOrderRepository;
import za.ac.cput.service.booking.SnackOrderService;
import za.ac.cput.util.GenericHelper;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class SnackOrderServiceImplementation implements SnackOrderService {

    @Autowired
    private SnackOrderRepository snackOrderRepository;

    @Override
    public Set<SnackOrder> getAll() {
        return getSnackOrder();
    }
    @Override
    public Set<SnackOrder> getSnackOrder() {
        return new HashSet<>(snackOrderRepository.findAll());
    }


    @Override
    public SnackOrder create(SnackOrder snackOrder) {
        return snackOrderRepository.save(snackOrder);
    }

    @Override
    public SnackOrder read(String id) {
        return snackOrderRepository.findById(id).orElse(null);
    }

    @Override
    public SnackOrder update(SnackOrder snackOrder) {
        return snackOrderRepository.save(snackOrder);
    }

    @Override
    public void delete(String id) {
        snackOrderRepository.deleteById(id);
    }

//    @Override
//    public void generateSnackOrder() {
//        // Sample snack IDs
//        List<String> snackIds = Arrays.asList("popcorn", "soda", "nachos", "candy", "hotdog");
//        List<String> bookingIds = Arrays.asList(
//                "book-001", "book-002", "book-003", "book-004", "book-005"
//        );
//
//        Random random = new Random();
//
//        for (int i = 0; i < 10; i++) {
//            String id = GenericHelper.generateID();
//            String bookingId = bookingIds.get(random.nextInt(bookingIds.size()));
//            String snackId = snackIds.get(random.nextInt(snackIds.size()));
//            int quantity = random.nextInt(5) + 1; // 1 to 5
//            double pricePerItem = Map.of(
//                    "popcorn", 12.99,
//                    "soda", 8.99,
//                    "nachos", 15.99,
//                    "candy", 6.99,
//                    "hotdog", 10.99
//            ).get(snackId);
//            double totalPrice = quantity * pricePerItem;
//            LocalDateTime orderTime = LocalDateTime.now().minusHours(new Random().nextInt(48));
//            String specialInstructions = random.nextBoolean() ? "No ice" : "Extra butter";
//
//            SnackOrder snackOrder = new SnackOrder.Builder()
//                    .setSnackOrderId(id)
//                    .setBookingId(bookingId)
//                    .setSnackId(snackId)
//                    .setQuantity(quantity)
//                    .setTotalPrice(totalPrice)
//                    .setOrderTime(orderTime)
//                    .setSpecialInstructions(specialInstructions)
//                    .build();
//
//            create(snackOrder);
//        }
//    }
}