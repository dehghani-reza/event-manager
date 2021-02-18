package ir.team.eventmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Celebration extends BaseEntity {

    @Column(nullable = false)
    private LocalDate occurrenceDate;
    private Integer period;
    private Boolean isRecursive;

    //one way connection so there is no need to map this class in catalogValue
    @ManyToOne
    @JoinColumn(nullable = false,
            name = "CATALOG_VALUE_ID")
    private CatalogValue title;

    @ManyToOne
    @JoinColumn(nullable = false,name = "PERSON_ID")
    private Person person;

}
