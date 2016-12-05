package hse.geo.vespera.repository;

import hse.geo.vespera.domain.GeoChat;

public interface IGeoChatDAO {
    GeoChat createChat(GeoChat geoChat);
    GeoChat updateChat(GeoChat geoChat);
    void deleteChat(long chatId);
    void addUserToChat(long userId, long chatId);
    void deleteUserFromChat(long userId, long chatId);
}
