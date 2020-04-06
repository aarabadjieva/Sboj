package repository;

import domain.entity.User;

public interface UserRepository {

    void saveUser(User user);

    User findUser(String username, String password);

}
