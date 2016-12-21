package hse.geo.vespera.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Roman Yarnykh (rvyarnykh@edu.hse.ru) on 21.12.16.
 */

@Controller
public class UserPageController {
    @RequestMapping("/pages/user/personal_page")
    public String personalPage(){
        return "personal_page";
    }
}
