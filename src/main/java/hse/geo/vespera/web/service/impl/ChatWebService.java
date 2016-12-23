package hse.geo.vespera.web.service.impl;

import hse.geo.vespera.data.domain.Chat;
import hse.geo.vespera.data.domain.Message;
import hse.geo.vespera.data.repository.IChatDAO;
import hse.geo.vespera.web.service.IChatWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Roman Baygildin (egdeveloper@mail.ru) [03.12.16]
 */

@RestController
public class ChatWebService implements IChatWebService {

    private final IChatDAO service;

    @Autowired
    public ChatWebService(IChatDAO service) {
        this.service = service;
    }

    @Override
    @RequestMapping(value = "/user/{userId}/chat", method = RequestMethod.POST)
    public Chat createChat(@PathVariable long userId, Chat chat) {
        return service.createChat(userId, chat);
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

    @Override
    @RequestMapping(value = "/chat/{chatId}/messages")
    public List<Message> chatMessages(@PathVariable long chatId) {
        return service.findMessages(chatId);
    }
}
