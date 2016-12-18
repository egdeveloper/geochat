package hse.geo.vespera.data.repository;

import hse.geo.vespera.data.domain.Chat;
import hse.geo.vespera.data.domain.Message;

public interface IChatDAO {
    Chat createChat(Chat chat);
    Chat updateChat(Chat chat);
    void deleteChat(long chatId);
    void addUserToChat(long userId, long chatId);
    void deleteUserFromChat(long userId, long chatId);
    Message saveMessage(String chatId, Message message);
}
