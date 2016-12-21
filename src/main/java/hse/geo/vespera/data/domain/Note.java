package hse.geo.vespera.data.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Note extends AbstractModel{
    private String geom;
    private Double bufferRadius;
    private long creatorId;
}
