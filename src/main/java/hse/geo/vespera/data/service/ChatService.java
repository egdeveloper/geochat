package hse.geo.vespera.data.service;

import hse.geo.vespera.data.domain.Chat;
import hse.geo.vespera.data.domain.Message;
import hse.geo.vespera.data.repository.IChatDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Roman Baygildin egdeveloper@mail.ru - 05.12.16
 */

@Transactional
@Service
public class ChatService implements IChatService {

    private final IChatDAO rep;

    @Autowired
    public ChatService(IChatDAO rep) {
        this.rep = rep;
    }

    @Override
    public Chat createChat(long adminId, Chat chat) {
        return rep.createChat(adminId, chat);
    }

    @Override
    public Chat updateChat(Chat chat) {
        return rep.updateChat(chat);
    }

    @Override
    public void deleteChat(long chatId) {
        rep.deleteChat(chatId);
    }

    @Override
    public void addUserToChat(long userId, long chatId) {
        rep.addUserToChat(userId, chatId);
    }

    @Override
    public void deleteUserFromChat(long userId, long chatId) {
        rep.deleteUserFromChat(userId, chatId);
    }

    @Override
    public Message saveMessage(Message message) {
        return rep.saveMessage(message);
    }
}
