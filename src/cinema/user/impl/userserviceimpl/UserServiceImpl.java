package cinema.user.impl.userserviceimpl;

import cinema.appdata.AppData;
import cinema.user.entity.User;
import cinema.user.enums.Role;
import cinema.user.impl.validatorimpl.ValidatorImpl;
import cinema.user.service.jsonuserservice.IUserPersistence;
import cinema.user.service.userservice.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {
    private final AppData appData;
    private final IUserPersistence userPersistence;
    public UserServiceImpl(AppData appData, IUserPersistence userPersistence) {
        this.appData = appData;
        this.userPersistence = userPersistence;
        List<User> loadedUsers = userPersistence.loadUsers();

        if (loadedUsers != null) {
                appData.getUsers().addAll(loadedUsers);
        }
    }

    @Override
    public boolean register(String username, String password) throws IllegalAccessException {
        ValidatorImpl validator = new ValidatorImpl();
      if (appData.getLoggedUsers()!= null){
          System.out.println("A cinema.user is already logged in: " + appData.getLoggedUsers().getUsername());
          return false;
      }
      boolean exist = appData.getUsers().stream().anyMatch(u->u.getUsername().equals(username));
      if (exist){
          System.out.println("Username already exists!");
          return false;
      }
      User newUser = new User(username,password, Role.USER);
        if (!validator.validate(newUser)) return false;
        appData.getUsers().add(newUser);
        userPersistence.saveUsers(appData.getUsers());
        System.out.println("Registration successful!");
        return true;
    }

    @Override
    public User login(String username, String password) {
        User found = appData.getUsers().stream().filter(u->u.getUsername().equals(username)
                && u.getPassword().equals(password)).findFirst().orElse(null);
        if (found != null){
            appData.setLoggedUsers(found);
            System.out.println("Login successful! Welcome " + found.getUsername());
        }
        else {
            System.out.println("Invalid credentials!");
        }
        return found;
    }

    @Override
    public List<User> getAllUsers()
    {
        return appData.getUsers();
    }
}
