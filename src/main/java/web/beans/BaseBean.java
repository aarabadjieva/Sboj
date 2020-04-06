package web.beans;

import javax.faces.context.FacesContext;
import java.io.IOException;

public class BaseBean {

    protected void redirect(String url) throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect(url);
    }

}
