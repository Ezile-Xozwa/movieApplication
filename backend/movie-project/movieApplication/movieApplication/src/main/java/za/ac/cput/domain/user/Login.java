package za.ac.cput.domain.user;

import jakarta.persistence.*;

@Entity
public class Login {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String loginId;

    private String email;
    private String password;
    private Role role;

    public enum Role {
        Admin, Customer
    }

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    protected Login(){

    }

    private Login(Builder builder){
        this.loginId = builder.loginId;
        this.email = builder.email;
        this.password = builder.password;
        this.role = builder.role;
        this.user = builder.user;
    }

    public String getLoginId(){
        return loginId;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public Role getRole() {
        return role;
    }
    public User getUser() {
        return user;
    }


    @Override
    public String toString() {
        return "Login{" +
                "email='" + email + '\'' +
                ", loginId='" + loginId + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", user=" + (user != null ? user.getName() + " " + user.getSurname() : "null") +
                '}';
    }

    public static class Builder{
        private String loginId;
        private String email;
        private String password;
        private Role role;
        private User user;

        public Builder setLoginId(String loginId){
            this.loginId = loginId;
            return this;
        }

        public Builder setEmail(String email){
            this.email = email;
            return this;
        }

        public Builder setPassword(String password){
            this.password = password;
            return this;
        }

        public Builder setRole(Role role) {
            this.role = role;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }


        public Builder copy(Login login){
            this.loginId = login.loginId;
            this.email = login.email;
            this.password = login.password;
            this.role = login.role;
            this.user = login.user;
            return this;
        }

        public Login build(){
            return new Login(this);
        }

    }
}
