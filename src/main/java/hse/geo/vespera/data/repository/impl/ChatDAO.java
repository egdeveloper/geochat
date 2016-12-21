package hse.geo.vespera.data.repository.impl;

import com.google.common.collect.ImmutableMap;
import hse.geo.vespera.data.domain.Chat;
import hse.geo.vespera.data.domain.Message;
import hse.geo.vespera.data.domain.Note;
import hse.geo.vespera.data.domain.User;
import hse.geo.vespera.data.repository.IChatDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Roman Baygildin egdeveloper@mail.ru - 05.12.16
 *
 */

@Transactional
@Repository
public class ChatDAO implements IChatDAO {

    private final JdbcTemplate template;

    private static final String UPDATE_CHAT = "UPDATE chats SET name = ?, description = ? WHERE chat_id = ?";
    private static final String DELETE_CHAT = "DELETE FROM chats WHERE chat_id = ?";
    private static final String DELETE_USER_FROM_CHAT = "DELETE FROM users_chats WHERE user_id = ? AND chat_id = ?";
    private static final String SAVE_MESSAGE = "INSERT INTO messages (body, time, geom, chat_id, sender_id) VALUES (?, ?, ST_GeomFromText('?'), ?, ?)";
    private static final String FIND_MESSAGES = "SELECT * FROM FIND_MESSAGES(?)";
    private static final String FIND_CHATS = "SELECT c.*, uc.user_role FROM users u, users_chats uc, chats c " +
            "WHERE u.user_id = uc.user_id AND uc.chat_id = c.chat_id AND u.user_id = ?";
    private static final String FIND_MEMBERS = "SELECT u.* FROM users u, users_chats uc, chats c " +
            "WHERE u.user_id = uc.user_id AND uc.chat_id = c.chat_id AND c.chat_id = ?";
    private static final String FIND_NOTES = "SELECT * FROM notes WHERE chat_id = ?";

    @Autowired
    public ChatDAO(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Chat createChat(long adminId, Chat chat) {
        SimpleJdbcInsert insertStatement = new SimpleJdbcInsert(template);
        insertStatement.withTableName("chats")
                .usingGeneratedKeyColumns("chat_id");
        Number chatId = insertStatement.executeAndReturnKey(ImmutableMap.of("name", chat.getName(),
                "description", chat.getDescription(),
                "admin_id", adminId));
        chat.setId(chatId.longValue());
        return chat;
    }

    @Override
    public Chat updateChat(Chat chat) {
        template.update(UPDATE_CHAT, ps -> {
           ps.setString(1, chat.getName());
           ps.setString(2, chat.getDescription());
           ps.setLong(3, chat.getId());
        });
        return chat;
    }

    @Override
    public void deleteChat(long chatId) {
        template.update(DELETE_CHAT, ps -> {
           ps.setLong(1, chatId);
        });
    }

    @Override
    public void addUserToChat(long userId, long chatId) {
        SimpleJdbcInsert insertStatement = new SimpleJdbcInsert(template);
        insertStatement.withTableName("users_chats")
                .usingGeneratedKeyColumns("id");
        insertStatement.execute(ImmutableMap.of("user_id", userId,
                "chat_id", chatId));
    }

    @Override
    public void deleteUserFromChat(long userId, long chatId) {
        template.update(DELETE_USER_FROM_CHAT, ps -> {
           ps.setLong(1, userId);
           ps.setLong(2, chatId);
        });
    }

    @Override
    public Message saveMessage(Message message) {
        template.update(SAVE_MESSAGE, ps -> {
           ps.setString(1, message.getBody());
           ps.setTimestamp(2, Timestamp.valueOf(message.getTime()));
           ps.setString(3, message.getGeom());
           ps.setLong(4, message.getChatId());
           ps.setLong(5, message.getSenderId());
        });
        return message;
    }

    @Override
    public List<Message> findMessages(long chatId) {
        try {
            return template.queryForList(FIND_MESSAGES,
                    new Object[]{chatId},
                    Message.class);
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Chat> findChats(long userId) {
        try {
            return template.queryForList(FIND_CHATS,
                    new Object[]{userId},
                    Chat.class);
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<User> findMembers(long chatId) {
        try {
            return template.queryForList(FIND_MEMBERS,
                    new Object[]{chatId},
                    User.class);
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Note> findNotes(long chatId) {
        try {
            return template.queryForList(FIND_NOTES,
                    new Object[]{chatId},
                    Note.class);
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
