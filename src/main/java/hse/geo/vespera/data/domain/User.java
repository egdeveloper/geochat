package hse.geo.vespera.data.domain;

import lombok.Getter;
import lombok.Setter;

public class User extends AbstractModel{

    public User(){
        firstName = "";
        lastName = "";
        userName = "";
        password = "";
    }

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
