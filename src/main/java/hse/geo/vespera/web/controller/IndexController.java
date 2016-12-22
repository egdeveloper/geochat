package hse.geo.vespera.web.controller;

import hse.geo.vespera.data.domain.User;
import hse.geo.vespera.data.domain.temp.UserCredentials;
import hse.geo.vespera.data.repository.IUserDAO;
import hse.geo.vespera.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Roman Yarnykh (rvyarnykh@edu.hse.ru) on 21.12.16.
 */

@Controller
public class IndexController {

    private final IUserDAO userDAO;

    @Autowired
    public IndexController(IUserDAO userDAO)
    {
        this.userDAO = userDAO;
    }

    // Retrieve index page
    @RequestMapping({"/", "/pages/index"})
    public String indexPage(Model model)
    {
        model.addAttribute("newUser", new User());
        model.addAttribute("credentials", new UserCredentials());
        return "index";
    }

    // Authenticate user
    @RequestMapping(value = "/pages/index/action/user/auth", method = RequestMethod.POST)
    public String authUser(@ModelAttribute UserCredentials credentials,
                           RedirectAttributes ra)
    {
        try
        {
            User user = userDAO.findUserByCredentials(credentials.getUserName(), credentials.getPassword());
            ra.addFlashAttribute("user", user);
            return "redirect:/pages/chats";
        }
        catch (UserNotFoundException e){
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/pages/index/action/user/new", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute User newUser){
        userDAO.saveUser(newUser);
        return "redirect:/";
    }
}
