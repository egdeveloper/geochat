package hse.geo.vespera.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Roman Yarnykh (rvyarnykh@edu.hse.ru) on 21.12.16.
 */

@Controller
public class ChatPageController {

    @RequestMapping("/pages/chat/new")
    public String newChat(){
        return "new_chat";
    }

    @RequestMapping("/pages/chat")
    public String chat(){
        return "chat";
    }

    @RequestMapping("/pages/chats/dashboard")
    public String chatsDashboard(){
        return "chats_dashboard";
    }
}
