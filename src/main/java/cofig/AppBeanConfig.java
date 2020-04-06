package cofig;

import org.modelmapper.ModelMapper;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class AppBeanConfig {

    @Produces
    public EntityManager entityManager(){
        return Persistence.createEntityManagerFactory("SbojUnit")
                .createEntityManager();
    }

    @Produces
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
