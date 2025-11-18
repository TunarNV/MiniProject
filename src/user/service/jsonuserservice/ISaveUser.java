package user.service.jsonuserservice;

import user.entity.User;

import java.util.List;

public interface ISaveUser {
    void saveUsers(List<User> users);
}
