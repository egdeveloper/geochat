package hse.geo.vespera.data.repository;

import com.google.common.collect.ImmutableMap;
import hse.geo.vespera.data.domain.Chat;
import hse.geo.vespera.data.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

/**
 * @author Roman Baygildin egdeveloper@mail.ru - 05.12.16
 *
 */

@Repository
public class ChatDAO implements IChatDAO {

    private final JdbcTemplate template;

    @Autowired
    public ChatDAO(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Chat createChat(Chat chat) {
        SimpleJdbcInsert insertStatement = new SimpleJdbcInsert(template);
        insertStatement.withTableName("chats")
                .usingGeneratedKeyColumns("chat_id");
        Number chatId = insertStatement.executeAndReturnKey(ImmutableMap.of("name", chat.getName()));
        chat.setId(chatId.longValue());
        return chat;
    }

    @Override
    public Chat updateChat(Chat chat) {
        return null;
    }

    @Override
    public void deleteChat(long chatId) {

    }

    @Override
    public void addUserToChat(long userId, long chatId) {

    }

    @Override
    public void deleteUserFromChat(long userId, long chatId) {

    }

    @Override
    public Message saveMessage(String chatId, Message message) {
        return null;
    }
}
