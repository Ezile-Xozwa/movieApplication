package za.ac.cput.factory;

import za.ac.cput.domain.User;
import za.ac.cput.util.UserValidationHelper;

public class UserFactory {

    public static User createUser(String userId, String name, String phoneNumber, String surname, String dateOfBirth, String gender) {

        if (UserValidationHelper.IsEmptyOrNullString(userId)
                || UserValidationHelper.IsEmptyOrNullString(name)
                || UserValidationHelper.IsEmptyOrNullString(phoneNumber)
                || UserValidationHelper.IsEmptyOrNullString(surname)
                || UserValidationHelper.IsEmptyOrNullString(dateOfBirth)
                || UserValidationHelper.IsEmptyOrNullString(gender)) {
            return null;
        }

        return new User.Builder()
                .setUserId(userId)
                .setName(name)
                .setPhoneNumber(phoneNumber)
                .setSurname(surname)
                .setDob(dateOfBirth)
                .setGender(gender)
                .build();
    }
}
