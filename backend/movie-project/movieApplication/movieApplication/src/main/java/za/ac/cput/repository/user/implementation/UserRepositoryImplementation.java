//package za.ac.cput.repository.user.implementation;
//
//import za.ac.cput.domain.user.User;
//import za.ac.cput.repository.user.UserRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class UserRepositoryImplementation implements UserRepository {
//    private Set<User> usersDB;
//
//    public UserRepositoryImplementation() {
//        usersDB = new HashSet<User>();
//    }
//
//    @Override
//    public User create(User user) {
//        usersDB.add(user);
//        return user;
//    }
//
//    @Override
//    public User read(String userId) {
//        User user = this.usersDB.stream()
//                .filter(u->u.getUserId().equalsIgnoreCase(userId))
//                .findAny()
//                .orElse(null);
//        return user;
//    }
//
//    @Override
//    public User update(User newuser) {
//        User user = read((newuser.getUserId()));
//        if (user != null) {
//            usersDB.remove(user);
//            usersDB.add(newuser);
//        }
//        return user;
//    }
//
//
//    @Override
//    public void delete(String userId) {
//        User user = read(userId);
//        if (user != null) {
//            usersDB.remove(user);
//        }
//    }
//
//    @Override
//    public Set<User> getAll() {
//        return usersDB;
//    }
//
//}
