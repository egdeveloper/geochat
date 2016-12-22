package hse.geo.vespera.data.repository;

import java.util.Map;

/**
 * Created by Roman Yarnykh (rvyarnykh@edu.hse.ru) on 22.12.16.
 */
public interface IStatDAO {
    Map findRegionStatistics(String regionGeom);
    Map findRegionMessagesFrequency(String region);
}
