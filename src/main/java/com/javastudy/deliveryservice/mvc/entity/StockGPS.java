package com.javastudy.deliveryservice.mvc.entity;

import com.javastudy.deliveryservice.mvc.entity.embeddable.Coordinates;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Created by Maxim Sambulat
 */
@Entity
@Table(name = "stock_gps")
public class StockGPS {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "date")
    @NotNull
    private LocalDate date;

    @Embedded
    private Coordinates coordinates;

    public StockGPS() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
