//package za.ac.cput.repository.booking.implementation;
//
//import za.ac.cput.repository.booking.PaymentRepository;
//import za.ac.cput.domain.booking.Payment;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class PaymentRepositoryImplementation implements PaymentRepository {
//    private Set<Payment> paymentsDB;
//
//    public PaymentRepositoryImplementation() {
//        paymentsDB = new HashSet<Payment>();
//    }
//
//    @Override
//    public Payment create(Payment payment) {
//        paymentsDB.add(payment);
//        return payment;
//    }
//
//    @Override //there was an error before this
//    public Payment read(Integer integer) {
//        return null;
//    }
//
//    //@Override
//    public Payment read(String paymentId){
//        Payment payment = this.paymentsDB.stream()
//                .filter(p -> p.getPaymentId().equals(paymentId))
//                .findAny()
//                .orElse(null);
//        return payment;
//    }
//
//    @Override
//    public Payment update(Payment newpayment) {
//        Payment payment = read(newpayment.getPaymentId());
//        if(payment != null) {
//            paymentsDB.remove(payment);
//            paymentsDB.add(newpayment);
//        }
//        return payment;
//    }
//
//    @Override //there was an error before this
//    public void delete(Integer integer) {
//
//    }
//
//    //@Override
//    public void delete(String paymentId){
//        Payment payment = read(paymentId);
//        if(payment != null) {
//            paymentsDB.remove(payment);
//        }
//    }
//
//    @Override
//    public Set<Payment> getAll() {
//        return this.paymentsDB;
//    }
//}
