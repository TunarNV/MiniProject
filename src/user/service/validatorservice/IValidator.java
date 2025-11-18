package user.service.validatorservice;

import user.entity.User;

public interface IValidator {
    boolean validate(User user) throws IllegalAccessException;
}
