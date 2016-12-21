package hse.geo.vespera.web.controller;

import hse.geo.vespera.data.domain.User;
import hse.geo.vespera.data.domain.temp.UserCredentials;
import hse.geo.vespera.data.repository.IUserDAO;
import hse.geo.vespera.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Roman Yarnykh (rvyarnykh@edu.hse.ru) on 21.12.16.
 */

@Controller
public class IndexPageController {

    private final IUserDAO userDAO;

    @Autowired
    public IndexPageController(IUserDAO userDAO)
    {
        this.userDAO = userDAO;
    }

    // Retrieve index page
    @RequestMapping({"/", "/pages/index"})
    public String indexPage()
    {
        return "index";
    }

    // Retrieve registration page
    @RequestMapping("/pages/registration")
    public String registrationPage()
    {
        return "registration";
    }

    @RequestMapping(value = "/user/auth", method = RequestMethod.POST)
    public String authUser(@RequestBody UserCredentials credentials,
                           ModelMap modelMap,
                           HttpServletResponse response)
    {
        try
        {
            User user = userDAO.findUserByCredentials(credentials.getUserName(), credentials.getPassword());
            response.addCookie(new Cookie("userId", Long.toString(user.getId())));
            modelMap.put("user", user);
            return "redirect:/pages/chat";
        }
        catch (UserNotFoundException e){
            return "redirect:/";
        }
    }
}
