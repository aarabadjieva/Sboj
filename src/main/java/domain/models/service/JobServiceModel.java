package domain.models.service;

import domain.entity.Sector;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class JobServiceModel {

    private String id;
    private Sector sector;
    private String profession;
    private BigDecimal salary;
    private String description;
}
