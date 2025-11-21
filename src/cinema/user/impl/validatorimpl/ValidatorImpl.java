package cinema.user.impl.validatorimpl;

import cinema.user.annotations.Password;
import cinema.user.annotations.Username;
import cinema.user.entity.User;
import cinema.user.service.validatorservice.IValidator;

import java.lang.reflect.Field;

public class ValidatorImpl implements IValidator {
    @Override
    public boolean validate(User user) throws IllegalAccessException {
        for (Field field : user.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(user);

            if (field.isAnnotationPresent(Username.class)) {
                Username u = field.getAnnotation(Username.class);
                String username = (String) value;
                if (username.length() < u.min() || username.length() > u.max()) {
                    System.out.println("Username must be between " + u.min() + " and " + u.max() + " characters.");
                    return false;
                }
            }

            if (field.isAnnotationPresent(Password.class)) {
                Password p = field.getAnnotation(Password.class);
                String password = (String) value;
                if (password.length() < p.min()) {
                    System.out.println("Password must be at least " + p.min() + " characters.");
                    return false;
                }
                if (p.mustContainNumber() && !password.matches(".*\\d.*")) {
                    System.out.println("Password must contain at least one number.");
                    return false;
                }
                if (p.mustContainUppercase() && !password.matches(".*[A-Z].*")) {
                    System.out.println("Password must contain at least one uppercase letter.");
                    return false;
                }
            }
        }
        return true;
    }
}
