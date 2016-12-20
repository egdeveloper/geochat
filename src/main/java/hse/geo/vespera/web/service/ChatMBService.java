package hse.geo.vespera.web.service;

import hse.geo.vespera.data.domain.Message;
import hse.geo.vespera.data.service.IChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Roman Yarnykh (rvyarnykh@edu.hse.ru) on 18.12.16.
 */

@RestController
public class ChatMBService {

    private final IChatService service;

    @Autowired
    public ChatMBService(IChatService service) {
        this.service = service;
    }

    @MessageMapping("/chat/{chatId}/message/new")
    @SendTo("/chat/{chatId}/message/broadcast")
    public Message sendMessage(@DestinationVariable String chatId, @RequestBody Message message){
        return service.saveMessage(chatId, message);
    }
}
