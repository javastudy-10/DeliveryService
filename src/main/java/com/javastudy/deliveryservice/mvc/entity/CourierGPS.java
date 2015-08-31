package com.javastudy.deliveryservice.mvc.entity;

import com.javastudy.deliveryservice.mvc.entity.embeddable.Coordinates;

import javax.persistence.*;

/**
 * Created by Maxim Sambulat
 */
@Entity
@Table(name = "courier_gps")
public class CourierGPS {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Coordinates coordinates;

    public CourierGPS() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
