package web.beans.userBeans;

import domain.models.binding.UserRegisterBinding;
import domain.models.service.UserServiceModel;
import lombok.NoArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import service.UserService;
import web.beans.BaseBean;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@NoArgsConstructor
@Named
public class RegisterBean extends BaseBean {

    private UserService userService;
    private UserRegisterBinding user;
    private ModelMapper modelMapper;

    @Inject
    public RegisterBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    private void init(){
        user = new UserRegisterBinding();
    }

    public UserRegisterBinding getUser() {
        return user;
    }

    public void setUser(UserRegisterBinding user) {
        this.user = user;
    }

    public void registerUser() throws IOException {
        if (!user.getPassword().equals(user.getConfirmPassword())){
            return;
        }
        user.setPassword(DigestUtils.sha256Hex(user.getPassword()));
        try {
            userService.saveUser(modelMapper.map(user, UserServiceModel.class));
        }catch (Exception e){
            return;
        }
        redirect("/login");
    }
}
