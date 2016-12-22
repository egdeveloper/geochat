package hse.geo.vespera.data.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chat extends AbstractModel{
    public Chat(){
        name = "";
        description = "";
    }
    private String name;
    private String description;
}
