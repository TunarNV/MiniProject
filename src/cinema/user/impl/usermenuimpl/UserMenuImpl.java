package cinema.user.impl.usermenuimpl;

import cinema.user.service.menuservice.IUserMenu;

public class UserMenuImpl implements IUserMenu {
    @Override
    public void displayMenu() {
        System.out.println("<<<< WELCOME LOGIN/REGISTER MENU >>>>");
        System.out.println("\n1. Register\n2. Login\n3. Exit");
    }
}
