package cinema.user.service.menuservice;

import cinema.user.impl.userserviceimpl.UserServiceImpl;
import cinema.user.service.userservice.IUserService;

public interface IUserMenuService {
    void menuService(int choice, IUserService userService) throws IllegalAccessException;
}
