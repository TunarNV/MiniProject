import required.Required;
import user.entity.AppData;
import user.impl.jsonuserimpl.JsonUserImpl;
import user.impl.usermenuimpl.UserMenuImpl;
import user.impl.usermenuimpl.UserMenuServiceImpl;
import user.impl.userserviceimpl.UserServiceImpl;
import user.service.jsonuserservice.IUserPersistence;
import user.service.userservice.IUserService;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        UserMenuImpl userMenu = new UserMenuImpl();
        UserMenuServiceImpl userMenuService = new UserMenuServiceImpl();
        Required required = new Required();
        AppData appData = new AppData();
        IUserPersistence userPersistence = new JsonUserImpl();
        IUserService userService = new UserServiceImpl(appData, userPersistence);
        boolean loop = true;
        while (loop) {
            userMenu.displayMenu();
            int choice = required.inputInteger("Please input your Choice: ");
            if (choice == 6) {
                loop = false;
            }
            if(appData.getUsers() == null){
                choice=1;
            }
            userMenuService.menuService(choice,userService);
        }
    }
}