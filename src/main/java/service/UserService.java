package service;

import domain.models.service.UserServiceModel;

public interface UserService {

    void saveUser(UserServiceModel user);

    UserServiceModel findUser(String username, String password);
}
