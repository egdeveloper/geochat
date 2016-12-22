package hse.geo.vespera.data.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class Message extends AbstractModel{
    private String body;
//    @JsonFormat(pattern="yyyy-MM-ddThh:mm:ss")
    private LocalDateTime time;
    private String geom;
    private long chatId;
    private long senderId;
    private String senderName;
}
