package org.geekocon.dto;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@ToString
@Entity
public class Zone extends PanacheEntity {

    @ManyToOne
    @JoinColumn(name = "type_id")
    private ZoneType type;

    @Column(name = "contributor_id")
    private UUID contributorId;

    private String description;

    @Column(name = "total_tickets_amount")
    private int totalTicketAmount;

    @Column(name = "available_tickets_amount")
    private int availableTicketAmount;

    private String name;
}
