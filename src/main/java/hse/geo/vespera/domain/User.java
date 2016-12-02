package hse.geo.vespera.domain;

import lombok.Getter;
import lombok.Setter;

public class User extends AbstractModel{

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private String userName;

    @Getter
    @Setter
    private String password;
}
