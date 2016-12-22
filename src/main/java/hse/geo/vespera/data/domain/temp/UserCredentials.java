package hse.geo.vespera.data.domain.temp;

import hse.geo.vespera.data.domain.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCredentials {
    public UserCredentials(){
        userName = "";
        password = "";
    }
    private String userName;
    private String password;
}
