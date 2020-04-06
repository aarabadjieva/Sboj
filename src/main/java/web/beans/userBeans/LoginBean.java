package web.beans.userBeans;

import domain.models.binding.UserCreateBinding;
import domain.models.service.UserServiceModel;
import lombok.NoArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import service.UserService;
import web.beans.BaseBean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.util.Map;

@NoArgsConstructor
@Named
@RequestScoped
public class LoginBean extends BaseBean {

    private UserService userService;
    private UserCreateBinding user;

    @Inject
    public LoginBean(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        user = new UserCreateBinding();
    }

    public UserCreateBinding getUser() {
        return user;
    }

    public void setUser(UserCreateBinding user) {
        this.user = user;
    }

    public void loginUser() throws IOException {
        UserServiceModel userServiceModel = userService.findUser(user.getUsername(), DigestUtils.sha256Hex(user.getPassword()));
        if (userServiceModel==null){
            redirect("/login");
        }else {
            Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            sessionMap.put("username", userServiceModel.getUsername());
            redirect("/home");
        }
    }
}
