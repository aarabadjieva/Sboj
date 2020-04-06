package domain.models.binding;

import domain.entity.Sector;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class JobAddBinding {

    private Sector sector;
    private String profession;
    private BigDecimal salary;
    private String description;

}
