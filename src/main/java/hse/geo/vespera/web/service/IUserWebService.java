package hse.geo.vespera.web.service;

import hse.geo.vespera.data.domain.User;
import hse.geo.vespera.data.domain.temp.UserCredentials;
import hse.geo.vespera.exception.UserNotFoundException;

public interface IUserWebService {
    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(long userId);
    User findUserByCredentials(UserCredentials credentials) throws UserNotFoundException;
    User findUserById(long userId) throws UserNotFoundException;
}
