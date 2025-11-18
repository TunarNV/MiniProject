package user.impl.usermenuimpl;

import required.Required;
import user.impl.userserviceimpl.UserServiceImpl;
import user.service.menuservice.IUserMenuService;
import user.service.userservice.IUserService;

public class UserMenuServiceImpl implements IUserMenuService {
    @Override
    public void menuService(int choice, IUserService userService) throws IllegalAccessException {
        Required required = new Required();
        switch (choice) {
            case 1 -> {
                String username = required.inputString("Enter username: ");
                String password = required.inputString("Enter password: ");
                userService.register(username, password);
            }
            case 2 -> {
                String username = required.inputString("Enter username: ");
                String password = required.inputString("Enter password: ");
                userService.login(username, password);
            }
            case 3 -> System.out.println("Exiting...");
            default -> System.out.println("Invalid choice!");
        }
    }
}

