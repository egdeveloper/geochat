package hse.geo.vespera.data.service;

import hse.geo.vespera.data.domain.Chat;
import hse.geo.vespera.data.domain.Message;

/**
 * @author Roman Baygildin egdeveloper@mail.ru - 05.12.16
 */
public interface IChatService {
    Chat createChat(long adminId, Chat chat);

    Chat updateChat(Chat chat);

    void deleteChat(long chatId);

    void addUserToChat(long userId, long chatId);

    void deleteUserFromChat(long userId, long chatId);

    Message saveMessage(Message message);
}
