package hse.geo.vespera.web.service;

import hse.geo.vespera.data.domain.Chat;
import hse.geo.vespera.data.service.IChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Roman Baygildin (egdeveloper@mail.ru) [03.12.16]
 */

@RestController
public class ChatWebService implements IChatWebService {

    @Autowired
    private IChatService service;

    @Override
    @RequestMapping(value = "/chat", method = RequestMethod.POST)
    public Chat createChat(Chat chat) {
        return service.createChat(chat);
    }

    @Override
    @RequestMapping(value = "/chat", method = RequestMethod.PUT)
    public Chat updateChat(Chat chat) {
        return service.updateChat(chat);
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
