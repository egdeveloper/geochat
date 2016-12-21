package hse.geo.vespera.data.mapper;

import hse.geo.vespera.data.domain.Message;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * Created by Roman Yarnykh (rvyarnykh@edu.hse.ru) on 21.12.16.
 */
public class MessageMapper implements RowMapper<Message> {

    @Override
    public Message mapRow(ResultSet rs, int i) throws SQLException {
        Message message = new Message();
        message.setId(rs.getLong("message_id"));
        message.setBody(rs.getString("body"));
        message.setTime(rs.getTimestamp("message_time").toLocalDateTime());
        message.setGeom(rs.getString("geom"));
        message.setChatId(rs.getLong("chat_id"));
        message.setSenderId(rs.getLong("sender_id"));
        return message;
    }
}
