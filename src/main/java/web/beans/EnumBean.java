package web.beans;

import domain.entity.Sector;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class EnumBean {

    public Sector[] getSectors(){
        return Sector.values();
    }
}
