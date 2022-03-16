package org.geekocon.exception;

import org.geekocon.dto.ZoneType;

public class DependencyZoneTypeException extends RuntimeException{
    public final String zoneName;

    public DependencyZoneTypeException(String name) {
        this.zoneName = name;
    }
}
