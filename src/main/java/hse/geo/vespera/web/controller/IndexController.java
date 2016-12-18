package hse.geo.vespera.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"/", "/pages/index"})
    public String index(){
        return "index";
    }
}
