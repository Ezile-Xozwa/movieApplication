package za.ac.cput.factory;

import za.ac.cput.domain.User;
import za.ac.cput.util.UserValidationHelper;

public class UserFactory {

    public static User createUser(String userId, String name, String password, String email, String phoneNumber, String surname, String dob, String gender) {

        if (UserValidationHelper.IsEmptyOrNullString(userId)
                || UserValidationHelper.IsEmptyOrNullString(name)
                || UserValidationHelper.IsEmptyOrNullString(password)
                || UserValidationHelper.IsEmptyOrNullString(email)
                || UserValidationHelper.IsEmptyOrNullString(phoneNumber)
                || UserValidationHelper.IsEmptyOrNullString(surname)
                || UserValidationHelper.IsEmptyOrNullString(dob)
                || UserValidationHelper.IsEmptyOrNullString(gender)) {
            return null;
        }

        return new User.Builder()
                .setUserId(userId)
                .setName(name)
                .setPassword(password)
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .setSurname(surname)
                .setDob(dob)
                .setGender(gender)
                .build();
    }
}

