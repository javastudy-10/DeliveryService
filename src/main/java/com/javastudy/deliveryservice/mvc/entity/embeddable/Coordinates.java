package com.javastudy.deliveryservice.mvc.entity.embeddable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Maxim Sambulat
 */
@Embeddable
@Access(AccessType.FIELD)
public class Coordinates {
    @Column(name = "longitude", precision = 9, scale = 6)
    private Double longitude;

    @Column(name = "latitude", precision = 8, scale = 6)
    private Double latitude;

    public Coordinates() {
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
