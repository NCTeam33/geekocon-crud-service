package org.geekocon.exception;

import org.geekocon.dto.ZoneType;

public class UnknownTypeException extends RuntimeException{
    public final ZoneType zoneType;

    public UnknownTypeException(ZoneType zoneType) {
        this.zoneType = zoneType;
    }
}
