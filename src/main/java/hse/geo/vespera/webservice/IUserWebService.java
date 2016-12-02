package hse.geo.vespera.webservice;

import hse.geo.vespera.domain.User;
import hse.geo.vespera.exception.UserNotFoundException;

public interface IUserWebService {
    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(long userId);
    User findUserByCredentials(UserCredentials credentials) throws UserNotFoundException;
}
