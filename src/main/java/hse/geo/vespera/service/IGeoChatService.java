package hse.geo.vespera.service;

import hse.geo.vespera.domain.GeoChat;

/**
 * @author Roman Baygildin egdeveloper@mail.ru - 05.12.16
 */
public interface IGeoChatService {
    GeoChat createChat(GeoChat geoChat);

    GeoChat updateChat(GeoChat geoChat);

    void deleteChat(long chatId);

    void addUserToChat(long userId, long chatId);

    void deleteUserFromChat(long userId, long chatId);
}
