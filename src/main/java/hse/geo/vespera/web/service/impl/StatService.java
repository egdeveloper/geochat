package hse.geo.vespera.web.service.impl;

import hse.geo.vespera.data.repository.IStatDAO;
import hse.geo.vespera.web.service.IStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Roman Yarnykh (rvyarnykh@edu.hse.ru) on 20.12.16.
 */

@RequestMapping("/stat-service/")
@RestController
public class StatService implements IStatService {

    private final IStatDAO statDAO;

    @Autowired
    public StatService(IStatDAO statDAO) {
        this.statDAO = statDAO;
    }

    @RequestMapping("/region/statistics")
    public Map findRegionStatistics(@RequestParam String region){
        return statDAO.findRegionStatistics(region);
    }

    @RequestMapping("/region/messages/freq")
    public Map findRegionMessageFrequency(@RequestParam String region){
        return statDAO.findRegionMessagesFrequency(region);
    }

}
