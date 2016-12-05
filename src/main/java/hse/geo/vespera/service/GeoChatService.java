package hse.geo.vespera.service;

import hse.geo.vespera.domain.GeoChat;
import hse.geo.vespera.repository.IGeoChatDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Roman Baygildin egdeveloper@mail.ru - 05.12.16
 */

@Transactional
@Service
public class GeoChatService implements IGeoChatService{

    @Autowired
    private IGeoChatDAO geoChatDAO;

    @Override
    public GeoChat createChat(GeoChat geoChat) {
        return geoChatDAO.createChat(geoChat);
    }

    @Override
    public GeoChat updateChat(GeoChat geoChat) {
        return geoChatDAO.updateChat(geoChat);
    }

    @Override
    public void deleteChat(long chatId) {
        geoChatDAO.deleteChat(chatId);
    }

    @Override
    public void addUserToChat(long userId, long chatId) {
        geoChatDAO.addUserToChat(userId, chatId);
    }

    @Override
    public void deleteUserFromChat(long userId, long chatId) {
        geoChatDAO.deleteUserFromChat(userId, chatId);
    }
}
