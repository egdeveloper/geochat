package hse.geo.vespera.web.controller;

import hse.geo.vespera.data.domain.Message;
import hse.geo.vespera.data.repository.IChatDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Roman Yarnykh (rvyarnykh@edu.hse.ru) on 18.12.16.
 */

@RestController
public class ChatController {

    private final IChatDAO service;

    @Autowired
    public ChatController(IChatDAO service) {
        this.service = service;
    }

    @MessageMapping("/chat/{chatId}/message/new")
    @SendTo("/chat/{chatId}/message/broadcast")
    public Message sendMessage(@RequestBody Message message){
        return service.saveMessage(message);
    }
}
