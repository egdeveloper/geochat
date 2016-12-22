package hse.geo.vespera.data.mapper;


import hse.geo.vespera.data.domain.Chat;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Roman Yarnykh (rvyarnykh@edu.hse.ru) on 22.12.16.
 */
public class ChatMapper implements RowMapper<Chat> {
    @Override
    public Chat mapRow(ResultSet rs, int i) throws SQLException {
        Chat chat = new Chat();
        chat.setId(rs.getLong("chat_id"));
        chat.setName(rs.getString("name"));
        chat.setDescription(rs.getString("description"));
        return chat;
    }
}
