package cinema.user.entity;

import cinema.user.annotations.NotNull;
import cinema.user.annotations.Password;
import cinema.user.annotations.Username;
import cinema.user.enums.Role;

public class User {
    private int id;
    @NotNull
    @Username(min = 3 , max = 20)
    private String username;

    @Password(min = 6 , mustContainNumber = true, mustContainUppercase = true)
    private String password;

    private Role role;

    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
