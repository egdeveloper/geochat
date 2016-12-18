package hse.geo.vespera.data.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Message extends AbstractModel{
    private User sender;
    private String message;
    private Chat chat;
    private Date date;
    private String pos;
}
