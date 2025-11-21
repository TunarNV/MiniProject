package cinema.user.service.validatorservice;

import cinema.user.entity.User;

public interface IValidator {
    boolean validate(User user) throws IllegalAccessException;
}
