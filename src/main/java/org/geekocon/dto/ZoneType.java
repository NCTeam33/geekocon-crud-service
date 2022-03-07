package org.geekocon.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@ToString
@Entity
public class ZoneType {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;


}
