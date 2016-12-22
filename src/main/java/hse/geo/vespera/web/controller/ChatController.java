package hse.geo.vespera.web.controller;

import hse.geo.vespera.data.domain.Message;
import hse.geo.vespera.data.repository.IChatDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Roman Yarnykh (rvyarnykh@edu.hse.ru) on 22.12.16.
 */
@RestController
public class ChatController {

    private final SimpMessagingTemplate template;

    private final IChatDAO chatDAO;

    @Autowired
    public ChatController(SimpMessagingTemplate template, IChatDAO chatDAO) {
        this.template = template;
        this.chatDAO = chatDAO;
    }

    @MessageMapping("/chat/{chatId}/message/send")
//    @SendTo("/chat/{chatId}/message/message/receive")
    public void sendMessage(@RequestBody Message message){
//        message = chatDAO.saveMessage(message);
        template.convertAndSend("/chat/message/receive",
                message);
    }
}
