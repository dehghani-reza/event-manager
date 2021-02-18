package ir.team.eventmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends BaseEntity {

    @Column(unique = true,nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    private String email;

    private Boolean isEnable;

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @OneToMany(cascade = {CascadeType.REFRESH,CascadeType.MERGE},
    fetch = FetchType.LAZY,
    mappedBy = "user")
    List<Bill> bills;

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "DEVICE_ID")
    private Device device;


    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE_NAME",nullable = false)
    private Role role;
}
