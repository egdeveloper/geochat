package hse.geo.vespera.data.repository;

import hse.geo.vespera.data.domain.Chat;
import hse.geo.vespera.data.domain.Message;
import hse.geo.vespera.data.domain.Note;
import hse.geo.vespera.data.domain.User;

import java.util.List;

public interface IChatDAO {
    Chat createChat(long adminId, Chat chat);
    Chat updateChat(Chat chat);
    void deleteChat(long chatId);
    void addUserToChat(long userId, long chatId);
    void deleteUserFromChat(long userId, long chatId);
    Message saveMessage(Message message);
    List<Message> findMessages(long chatId);
    List<Chat> findChats(long userId);
    List<User> findMembers(long chatId);
    List<Note> findNotes(long chatId);
}
