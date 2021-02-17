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

    private String username;
    private String password;
    private String email;

    private Boolean isEnable;

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
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
    @Column(name = "ROLE_NAME",columnDefinition = "role_of_user_in_application",nullable = false)
    private Role role;
}
