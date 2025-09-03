package za.ac.cput.factory.user;

import za.ac.cput.domain.user.User;
import za.ac.cput.util.UserValidationHelper;

import java.time.LocalDate;

public class UserFactory {

    public static User createUser(String userId, String name, String surname, String phoneNumber, LocalDate dateOfBirth, String gender, String password,String email) {

        System.out.println("🔧 Validating user creation...");
        System.out.println("  userId: '" + userId + "' -> " + (UserValidationHelper.IsEmptyOrNullString(userId) ? "FAIL" : "OK"));
        System.out.println("  name: '" + name + "' -> " + (!UserValidationHelper.isValidName(name) ? "FAIL" : "OK"));
        System.out.println("  surname: '" + surname + "' -> " + (!UserValidationHelper.isValidSurname(surname) ? "FAIL" : "OK"));
        System.out.println("  phone: '" + phoneNumber + "' -> " + (!UserValidationHelper.isValidPhoneNumber(phoneNumber) ? "FAIL" : "OK"));
        System.out.println("  dob: " + dateOfBirth + " -> " + (!UserValidationHelper.isValidDateOfBirth(dateOfBirth) ? "FAIL" : "OK"));
        System.out.println("  gender: '" + gender + "' -> " + (!UserValidationHelper.isValidGender(gender) ? "FAIL" : "OK"));
        System.out.println("  email: '" + email + "' -> " + (!UserValidationHelper.isValidEmail(email) ? "FAIL" : "OK"));
        System.out.println("  password: '" + password + "' -> " + (password == null || password.length() < 6 ? "FAIL" : "OK"));

        if (UserValidationHelper.IsEmptyOrNullString(userId)
                || !UserValidationHelper.isValidName(name)
                || !UserValidationHelper.isValidPhoneNumber(phoneNumber)
                || !UserValidationHelper.isValidSurname(surname)
                || !UserValidationHelper.isValidDateOfBirth(dateOfBirth)
                //|| !UserValidationHelper.isValidDateOfBirth(dateOfBirth)
                || !UserValidationHelper.isValidGender(gender)
                || !UserValidationHelper.isValidEmail(email)
                || password == null || password.length() < 6){
            System.out.println("❌ User validation FAILED");
            return null;
        }

        System.out.println("✅ User validation PASSED");
        return new User.Builder()
                .setUserId(userId)
                .setName(name)
                .setPhoneNumber(phoneNumber)
                .setSurname(surname)
                .setDateOfBirth(dateOfBirth)
                .setGender(gender)
                .setPassword(password)
                .setEmail(email)
                .build();
    }
}
