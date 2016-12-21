package hse.geo.vespera.web.service;

import hse.geo.vespera.data.domain.Chat;

public interface IChatWebService {
    Chat createChat(long userId, Chat chat);

    Chat updateChat(Chat chat);

    void deleteChat(long chatId);

    void addUserToChat(long userId, long chatId);

    void deleteUserFromChat(long userId, long chatId);
}
