package domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "job_applications")
public class JobApplication extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Sector sector;

    @Column(nullable = false)
    private String profession;

    @Column
    private BigDecimal salary;

    @Column(nullable = false)
    private String description;

}
