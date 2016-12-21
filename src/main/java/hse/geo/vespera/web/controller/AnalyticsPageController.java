package hse.geo.vespera.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Roman Yarnykh (rvyarnykh@edu.hse.ru) on 21.12.16.
 */

@Controller
public class AnalyticsPageController {
    @RequestMapping("/pages/analytics")
    public String analytics(){
        return "analytics";
    }
}
