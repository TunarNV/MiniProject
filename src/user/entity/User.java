package user.entity;

import user.annotations.NotNull;
import user.annotations.Password;
import user.annotations.Username;

public class User {
    @NotNull
    @Username(min = 3 , max = 20)
    private String username;

    @Password(min = 6 , mustContainNumber = true, mustContainUppercase = true)
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
