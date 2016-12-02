package hse.geo.vespera.service;

import hse.geo.vespera.domain.User;
import hse.geo.vespera.exception.UserNotFoundException;

public interface IUserService {
    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(long userId);
    User findUserByCredentials(String username, String password) throws UserNotFoundException;
}
