package hse.geo.vespera.data.repository.impl;

import hse.geo.vespera.data.repository.IStatDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Roman Yarnykh (rvyarnykh@edu.hse.ru) on 22.12.16.
 */

@Transactional
@Repository
public class StatDAO implements IStatDAO{

    private final JdbcTemplate template;

    private static final String FIND_REGION_STATISTICS = "SELECT name AS attr_name, m.time::TIMESTAMP::date AS message_date, AVG(ma.value) AS avg_value FROM messages m " +
            "INNER JOIN messages_attrs ma USING(message_id) " +
            "WHERE st_contains(st_geomfromtext(?), m.geom) " +
            "GROUP BY message_date, ma.name";

    private static final String FIND_REGION_MESSAGES_FREQ = "SELECT m.time::TIMESTAMP::date AS message_date, COUNT(*) AS messages_freq " +
            "FROM messages m " +
            "WHERE st_contains(st_geomfromtext(?), m.geom) " +
            "GROUP BY message_date;";

    @Autowired
    public StatDAO(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Map findRegionStatistics(String regionGeom) {
        return template.query(FIND_REGION_STATISTICS, new Object[]{regionGeom},
                (ResultSetExtractor<Map<String, Map<LocalDate, Double>>>) rs -> {
            HashMap<String, Map<LocalDate, Double>> res = new HashMap<>();
            while(rs.next()){
                String attr = rs.getString("attr_name");
                LocalDate date = rs.getDate("message_date").toLocalDate();
                Double value = rs.getDouble("avg_value");
                if(!res.containsKey(attr))
                    res.put(attr, new HashMap<>());
                HashMap<LocalDate, Double> davg = (HashMap<LocalDate, Double>) res.get(attr);
                davg.put(date, value);
            }
            return res;
        });
    }

    @Override
    public Map findRegionMessagesFrequency(String region) {
        return template.query(FIND_REGION_MESSAGES_FREQ, new Object[]{region},
                (ResultSetExtractor<Map<LocalDate, Long>>) rs -> {
                    HashMap<LocalDate, Long> res = new HashMap<>();
                    while(rs.next()){
                        LocalDate date = rs.getDate("message_date").toLocalDate();
                        Long freq = rs.getLong("messages_freq");
                        res.put(date, freq);
                    }
                    return res;
                });
    }
}
