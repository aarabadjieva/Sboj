package domain.models.binding;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateBinding {
    
    private String username;
    private String password;
}
