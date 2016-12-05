package hse.geo.vespera.webservice;

import hse.geo.vespera.domain.GeoChat;
import hse.geo.vespera.service.IGeoChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Roman Baygildin (egdeveloper@mail.ru) [03.12.16]
 */

@RestController
public class GeoChatWebService implements IGeoChatWebService{

    @Autowired
    private IGeoChatService service;

    @Override
    @RequestMapping(value = "/chat", method = RequestMethod.POST)
    public GeoChat createChat(GeoChat geoChat) {
        return service.createChat(geoChat);
    }

    @Override
    @RequestMapping(value = "/chat", method = RequestMethod.PUT)
    public GeoChat updateChat(GeoChat geoChat) {
        return service.updateChat(geoChat);
    }

    @Override
    @RequestMapping(value = "/chat/{chatId}", method = RequestMethod.DELETE)
    public void deleteChat(@PathVariable long chatId) {
        service.deleteChat(chatId);
    }

    @Override
    @RequestMapping(value = "/chat/{chatId}/user/{userId}", method = RequestMethod.POST)
    public void addUserToChat(@PathVariable long userId, @PathVariable long chatId) {
        service.addUserToChat(userId, chatId);
    }

    @Override
    @RequestMapping(value = "/chat/{chatId}/user/{userId}", method = RequestMethod.DELETE)
    public void deleteUserFromChat(@PathVariable long userId, @PathVariable long chatId) {
        service.deleteUserFromChat(userId, chatId);
    }
}
