package ir.team.eventmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CatalogValue extends BaseEntity{

    @Column(nullable = false,unique = true)
    private String catalogValueTitle;

    @OneToMany(mappedBy = "father",
            cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    private List<CatalogValue> children;

    @ManyToOne
    @JoinColumn(name = "FATHER_ID")
    private CatalogValue father;

    @ManyToOne
    @JoinColumn(name = "CATALOG_GROUP_ID",nullable = false)
    private CatalogGroup group;

}
