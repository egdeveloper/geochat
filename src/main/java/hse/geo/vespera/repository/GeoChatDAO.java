package hse.geo.vespera.repository;

import com.google.common.collect.ImmutableMap;
import hse.geo.vespera.domain.GeoChat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

/**
 * @author Roman Baygildin egdeveloper@mail.ru - 05.12.16
 *
 */

@Repository
public class GeoChatDAO implements IGeoChatDAO{

    @Autowired
    private JdbcTemplate template;

    @Override
    public GeoChat createChat(GeoChat geoChat) {
        SimpleJdbcInsert insertStatement = new SimpleJdbcInsert(template);
        insertStatement.withTableName("chats")
                .usingGeneratedKeyColumns("chat_id");
        Number chatId = insertStatement.executeAndReturnKey(ImmutableMap.of("name", geoChat.getName()));
        geoChat.setId(chatId.longValue());
        return geoChat;
    }

    @Override
    public GeoChat updateChat(GeoChat geoChat) {
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
}
