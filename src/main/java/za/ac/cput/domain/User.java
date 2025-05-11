package za.ac.cput.domain;

/*User.java

     User POJO class

     Author: Ayanda Nongxa (204513723)

     Date: 11 May 2025 */

import java.time.LocalDate;

public class User {

    private String userId;
    private String name;
    private String surname;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String gender;

    private User(){

    }

    private User(Builder builder){
        this.userId = builder.userId;
        this.name = builder.name;
        this.surname = builder.surname;
        this.phoneNumber = builder.phoneNumber;
        this.dateOfBirth = builder.dateOfBirth;
        this.gender = builder.gender;
    }

    public String getUserId(){
        return userId;
    }
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }
    public String getGender(){
        return gender;
    }

    @Override
    public String toString() {
        return    "User Id: " + userId + "\n"
                + "Name: " + name + "\n"
                + "Surname: " + surname + "\n"
                + "Gender: " + gender + "\n"
                + "Date Of Birth: " + dateOfBirth + "\n"
                + "Phone Number: " + phoneNumber + "\n";
    }

    public static class Builder {
        private String userId;
        private String name;
        private String surname;
        private String phoneNumber;
        private LocalDate dateOfBirth;
        private String gender;

        public Builder setUserId(String userId){
            this.userId = userId;
            return this;
        }
        public Builder setName(String name){
            this.name = name;
            return this;
        }
        public Builder setSurname(String surname){
            this.surname = surname;
            return this;
        }
        public Builder setPhoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }
        public Builder setDateOfBirth(LocalDate dateOfBirth){
            this.dateOfBirth = dateOfBirth;
            return this;
        }
        public Builder setGender(String gender){
            this.gender = gender;
            return this;
        }

        private Builder copy(User user){
            this.userId = user.userId;
            this.name = user.name;
            this.surname = user.surname;
            this.phoneNumber = user.phoneNumber;
            this.dateOfBirth = user.dateOfBirth;
            this.gender = user.gender;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}

