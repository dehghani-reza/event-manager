package ir.team.eventmanager.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Where(clause = "IS_DELETED=false")
public class Bill extends BaseEntity{

    @Transient
    private Double balance;

    private Boolean isTimeForCheckOut;
    @Column(nullable = false)
    private LocalDateTime createdTime;

    @ManyToOne
    @JoinColumn(name = "USER_ID",nullable = false)
    private User user;

    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.EAGER,
            mappedBy = "bill")
    private List<Event> eventList;

    public Double getBalance() {
        return eventList.
                stream()
                .map(event -> event.getCost())
                .reduce(0D, (aDouble, aDouble2) -> aDouble + aDouble2).doubleValue();
    }

    //can't set balance its calculated automatically
    public void setBalance(Double balance) {
    }
}
