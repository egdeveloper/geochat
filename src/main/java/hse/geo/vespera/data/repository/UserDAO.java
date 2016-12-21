package hse.geo.vespera.data.repository;

import com.google.common.collect.ImmutableMap;
import hse.geo.vespera.data.domain.User;
import hse.geo.vespera.exception.UserNotFoundException;
import hse.geo.vespera.data.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO implements IUserDAO{

    private static final String FIND_USER_BY_CREDS = "SELECT * FROM users WHERE user_name = ? AND password = ?";
    private static final String UPDATE_USER = "UPDATE users " +
            "SET first_name = ?, last_name = ?, user_name = ?, password = ? WHERE user_id = ?";
    private static final String DELETE_USER = "DELETE FROM users WHERE user_id = ?";

    private final JdbcTemplate template;

    @Autowired
    public UserDAO(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public User saveUser(User user) {
        SimpleJdbcInsert insertStatement = new SimpleJdbcInsert(template);
        insertStatement.withTableName("users")
                .usingGeneratedKeyColumns("user_id");
        Number key = insertStatement.executeAndReturnKey(ImmutableMap.of("first_name", user.getFirstName(),
                "last_name", user.getLastName(),
                "user_name", user.getUserName(),
                "password", user.getPassword()));
        user.setId(key.longValue());
        return user;
    }

    @Override
    public User updateUser(User user) {
        template.update(UPDATE_USER, ps -> {
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getUserName());
            ps.setString(4, user.getPassword());
            ps.setLong(5, user.getId());
        });
        return user;
    }

    @Override
    public void deleteUser(long userId) {
        template.update(DELETE_USER, ps -> {
            ps.setLong(1, userId);
        });
    }

    @Override
    public User findUserByCredentials(String username, String password) throws UserNotFoundException {
        try {
            return template.queryForObject(FIND_USER_BY_CREDS,
                    new Object[]{username, password},
                    new UserMapper()
            );
        }
        catch (EmptyResultDataAccessException e){
            throw new UserNotFoundException();
        }
    }
}
