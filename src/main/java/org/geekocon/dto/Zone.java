package org.geekocon.dto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Setter
@Getter
@ToString
@Entity
public class Zone {

    @Id
    @GeneratedValue
    private UUID id;

    private UUID typeId;

    private String manager;

    private String name;

}
