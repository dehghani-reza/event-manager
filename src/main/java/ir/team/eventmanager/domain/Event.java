package ir.team.eventmanager.domain;

import ir.team.eventmanager.util.StaticValue;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;


@NoArgsConstructor
@Data
@Entity
public class Event extends BaseEntity{

    private BigDecimal cost;
    private LocalDateTime occurrenceDate;
    @Column(columnDefinition = "when_bill_checkout_this_column_change_to_true")
    private Boolean isCleared;

    //one way connection so there is no need to map this class in catalogValue
    @ManyToOne
    @JoinColumn(nullable = false,name = "EVENT_REASON",columnDefinition = "reason_of_event_payment")
    private CatalogValue reason;

    @ManyToOne
    @JoinColumn(name = "BILL_ID",nullable = false)
    private Bill bill;


    public Event(Double cost, LocalDateTime occurrenceDate, Boolean isCleared) {
        this.cost = new BigDecimal(Double.toString(cost))
                .setScale(StaticValue.EVENT_COST_SCALE_VALUE, RoundingMode.HALF_EVEN);
        this.occurrenceDate = occurrenceDate;
        this.isCleared = isCleared;
    }

    public Double getCost() {
        return cost.doubleValue();
    }

    public void setCost(Double cost) {
        this.cost = BigDecimal.valueOf(cost);
    }
}
