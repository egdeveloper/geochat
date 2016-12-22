package hse.geo.vespera.web.controller;

import hse.geo.vespera.data.domain.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Roman Yarnykh (rvyarnykh@edu.hse.ru) on 22.12.16.
 */
@RestController
public class ChatController {

    @MessageMapping("/chat/{chatId}/message/send")
    @SendTo("/chat/{chatId}/message/message/receive")
    public Message sendMessage(@RequestBody Message message){
//        return chatDAO.saveMessage(message);
        return message;
    }
}
