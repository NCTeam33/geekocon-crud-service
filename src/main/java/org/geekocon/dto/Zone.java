package org.geekocon.dto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Zone {

    private Integer zoneId;

    private String zoneType;

    private String zoneManager;

    private String zoneName;

}
