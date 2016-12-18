package hse.geo.vespera.data.service;

import hse.geo.vespera.data.domain.User;
import hse.geo.vespera.exception.UserNotFoundException;

public interface IUserService {
    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(long userId);
    User findUserByCredentials(String username, String password) throws UserNotFoundException;
}