import cinema.required.Required;
import cinema.appdata.AppData;
import cinema.user.impl.jsonuserimpl.JsonUserImpl;
import cinema.user.impl.usermenuimpl.UserMenuImpl;
import cinema.user.impl.usermenuimpl.UserMenuServiceImpl;
import cinema.user.impl.userserviceimpl.UserServiceImpl;
import cinema.user.service.jsonuserservice.IUserPersistence;
import cinema.user.service.userservice.IUserService;

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
            if (choice == 3) {
                loop = false;
            }
            if(appData.getUsers() == null){
                choice=1;
            }
            userMenuService.menuService(choice,userService);
        }
    }
}