package user.entity;

import java.util.ArrayList;
import java.util.List;

public class AppData {
    private List<User>users = new ArrayList<>();
    private User loggedUsers;


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getLoggedUsers() {
        return loggedUsers;
    }

    public void setLoggedUsers(User loggedUsers) {
        this.loggedUsers = loggedUsers;
    }
}
