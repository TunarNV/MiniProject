package cinema.user.service.jsonuserservice;

import cinema.user.entity.User;

import java.util.List;

public interface ISaveUser {
    void saveUsers(List<User> users);
}
