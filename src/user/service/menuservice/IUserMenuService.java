package user.service.menuservice;

import user.impl.userserviceimpl.UserServiceImpl;
import user.service.userservice.IUserService;

public interface IUserMenuService {
    void menuService(int choice, IUserService userService) throws IllegalAccessException;
}
