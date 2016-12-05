package hse.geo.vespera.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeoChat extends AbstractModel{
    private String name;
    private User owner;
}
