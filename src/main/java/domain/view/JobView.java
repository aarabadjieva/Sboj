package domain.view;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class JobView {

    private String id;
    private String sector;
    private String profession;
    private BigDecimal salary;
    private String description;
}
