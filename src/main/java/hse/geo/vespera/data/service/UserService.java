package hse.geo.vespera.data.service;

import hse.geo.vespera.data.domain.User;
import hse.geo.vespera.exception.UserNotFoundException;
import hse.geo.vespera.data.repository.IUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserService implements IUserService{

    private final IUserDAO userDAO;

    @Autowired
    public UserService(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User saveUser(User user) {
        return userDAO.saveUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userDAO.updateUser(user);
    }

    @Override
    public void deleteUser(long userId) {
        userDAO.deleteUser(userId);
    }

    @Override
    public User findUserByCredentials(String username, String password) throws UserNotFoundException {
        return userDAO.findUserByCredentials(username, password);
    }
}
