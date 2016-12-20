package hse.geo.vespera.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping({"/", "/pages/index"})
    public String index(){
        return "index";
    }

    @RequestMapping("/pages/registration")
    public String registration(){
        return "registration";
    }

    @RequestMapping("/pages/chat/new")
    public String newChat(){
        return "new_chat";
    }

    @RequestMapping("/pages/chat")
    public String chat(){
        return "chat";
    }

    @RequestMapping("/pages/user/personal_page")
    public String personalPage(){
        return "personal_page";
    }

    @RequestMapping("/pages/analytics")
    public String analytics(){
        return "analytics";
    }
}
