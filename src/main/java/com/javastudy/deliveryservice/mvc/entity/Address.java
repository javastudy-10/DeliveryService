package com.javastudy.deliveryservice.mvc.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Maxim Sambulat
 */
@Entity
@Table(name = "address")
public class Address implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "zip")
    private Integer zip;

    @Column(name = "region", length = 32, nullable = false)
    @NotNull(message = "{address.region.notnull}")
    @Size(max = 32, message = "{address.region.size}")
    private String region;

    @Column(name = "district", length = 32)
    @Size(max = 32, message = "{address.district.size}")
    private String district;

    @Column(name = "city", length = 32, nullable = false)
    @NotNull(message = "{address.city.notnull}")
    @Size(max = 32, message = "{address.city.size}")
    private String city;

    @Column(name = "street", length = 32, nullable = false)
    @NotNull(message = "{address.street.notnull}")
    @Size(max = 32, message = "{address.street.size}")
    private String street;

    @Column(name = "house", length = 8, nullable = false)
    @NotNull(message = "{address.house.notnull}")
    @Size(max = 8, message = "{address.house.size}")
    private String house;

    @Column(name = "apartment", length = 8)
    @Size(max = 8, message = "{address.apartment.size}")
    private String apartment;

    @Column(name = "longitude", precision = 9, scale = 6)
    private Double longitude;

    @Column(name = "latitude", precision = 8, scale = 6)
    private Double latitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
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

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", zip=" + zip +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", apartment='" + apartment + '\'' +
                ", coordinates (longitude=" + longitude +
                ", latitude=" + latitude + ")" +
                '}';
    }
}
