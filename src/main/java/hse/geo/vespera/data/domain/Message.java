package hse.geo.vespera.data.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class Message extends AbstractModel{
    private String body;
    private LocalDateTime time;
    private String geom;
    private long chatId;
    private long senderId;
}
