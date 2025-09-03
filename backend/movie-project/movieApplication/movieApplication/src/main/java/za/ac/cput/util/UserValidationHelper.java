package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;

public class UserValidationHelper {

    public static boolean IsEmptyOrNullString(String userId) {
        return userId == null || userId.trim().isEmpty();
    }

    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static boolean isValidSurname(String surname) {
        return surname != null && !surname.trim().isEmpty();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("\\d{10,15}"); // e.g., 0712345678
    }

    public static boolean isValidDateOfBirth(java.time.LocalDate date) {
        return date != null && date.isBefore(java.time.LocalDate.now());
    }

    public static boolean isValidGender(String gender) {
        return gender != null && (gender.equalsIgnoreCase("Male") ||
                gender.equalsIgnoreCase("Female") ||
                gender.equalsIgnoreCase("Other"));
    }
    public static boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
}