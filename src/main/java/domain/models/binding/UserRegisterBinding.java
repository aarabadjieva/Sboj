package domain.models.binding;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterBinding {

    private String username;
    private String password;
    private String confirmPassword;
    private String email;
}
