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

    private UUID contributorId;

    private String name;

}
