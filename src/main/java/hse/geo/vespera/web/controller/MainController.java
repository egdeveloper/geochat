package hse.geo.vespera.web.controller;

import hse.geo.vespera.data.domain.Chat;
import hse.geo.vespera.data.domain.Message;
import hse.geo.vespera.data.domain.User;
import hse.geo.vespera.data.repository.IChatDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Roman Yarnykh (rvyarnykh@edu.hse.ru) on 22.12.16.
 */

@SessionAttributes("user")
@Controller
public class MainController {

    private final IChatDAO chatDAO;

    @Autowired
    public MainController(IChatDAO chatDAO) {
        this.chatDAO = chatDAO;
    }

    @RequestMapping("/pages/user/personal_page")
    public String personalPage(){
        return "personal_page";
    }

    @RequestMapping("/pages/chat/new")
    public String newChat(){
        return "new_chat";
    }

    @RequestMapping("/pages/chat/{chatId}")
    public String chat(@PathVariable long chatId, Model model){
        Chat chat = chatDAO.findChat(chatId);
        model.addAttribute(chat);
        return "chat";
    }

    @RequestMapping("/pages/chats")
    public String chatsDashboard(@ModelAttribute User user, Model model){
        List<Chat> chats = chatDAO.findChats(user.getId());
        model.addAttribute("chats", chats);
        return "chats_dashboard";
    }

    /*
    Chat message broker
     */

    /*
    Analytics
     */

    @RequestMapping("/pages/analytics")
    public String analytics(){
        return "analytics";
    }

    @RequestMapping("/pages/main/action/logout")
    public String logOut(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/";
    }
}
