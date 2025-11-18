package user.service.userservice;

import user.entity.User;

import java.util.List;

public interface IUserService {
    boolean register(String username, String password) throws IllegalAccessException;
    User login(String username, String password);
    List<User> getAllUsers();
}
