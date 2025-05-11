package za.ac.cput.domain;

public class Login {
    private String loginId;
    private String email;
    private String password;
    private Role role;

    public enum Role {
        Admin, Customer
    }

    private Login() {
    }

    private Login(Builder builder) {
        this.loginId = builder.loginId;
        this.email = builder.email;
        this.password = builder.password;
        this.role = builder.role;
    }

    public String getLoginId() {
        return loginId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Login{" +
                "loginId='" + loginId + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    public static class Builder {
        private String loginId;
        private String email;
        private String password;
        private Role role;

        public Builder setLoginId(String loginId) {
            this.loginId = loginId;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setRole(Role role) {
            this.role = role;
            return this;
        }

        public Builder copy(Login login) {
            this.loginId = login.loginId;
            this.email = login.email;
            this.password = login.password;
            this.role = login.role;
            return this;
        }

        public Login build() {
            return new Login(this);
        }
    }
}
