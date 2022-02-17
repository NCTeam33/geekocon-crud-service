package org.geekocon;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Zone {
    @JsonProperty("zone_id")
    private Integer zoneId;

    @JsonProperty("zone_type")
    private String zoneType;

    @JsonProperty("zone_manager")
    private String zoneManager;

    @JsonProperty("zone_name")
    private String zoneName;

    public Integer getZoneId() {
        return zoneId;
    }
    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }
    public String getZoneType() {
        return zoneType;
    }
    public void setZoneType(String zoneType) {
        this.zoneType = zoneType;
    }
    public String getZoneManager() {
        return zoneManager;
    }
    public void setZoneManager(String zoneManager) {
        this.zoneManager = zoneManager;
    }
    public String getZoneName() {
        return zoneName;
    }
    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    }
