package com.javastudy.deliveryservice.mvc.entity;

import com.javastudy.deliveryservice.validation.Sizes;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Maxim Sambulat
 */
@Entity
@Table(name = "address",
        uniqueConstraints = @UniqueConstraint(columnNames = {"region", "district", "city", "street", "house", "apartment"}))
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String DEFAULT_DISTRICT = "";
    private static final String DEFAULT_APARTMENT = "";

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "zip")
    private Integer zip;

    @Column(name = "region", length = Sizes.Address.MAX_REGION, nullable = false)
    @NotNull(message = "{address.region.notnull}")
    @NotEmpty(message = "{address.region.notempty}")
    @Size(max = Sizes.Address.MAX_REGION, message = "{address.region.size}")
    private String region;

    @Column(name = "district", length = Sizes.Address.MAX_DISTRICT, nullable = false)
    @Size(max = Sizes.Address.MAX_DISTRICT, message = "{address.district.size}")
    private String district;

    @Column(name = "city", length = Sizes.Address.MAX_CITY, nullable = false)
    @NotNull(message = "{address.city.notnull}")
    @NotEmpty(message = "{address.city.notempty}")
    @Size(max = Sizes.Address.MAX_CITY, message = "{address.city.size}")
    private String city;

    @Column(name = "street", length = Sizes.Address.MAX_STREET, nullable = false)
    @NotNull(message = "{address.street.notnull}")
    @NotEmpty(message = "{address.street.notempty}")
    @Size(max = Sizes.Address.MAX_STREET, message = "{address.street.size}")
    private String street;

    @Column(name = "house", length = Sizes.Address.MAX_HOUSE, nullable = false)
    @NotNull(message = "{address.house.notnull}")
    @NotEmpty(message = "{address.house.notempty}")
    @Size(max = Sizes.Address.MAX_HOUSE, message = "{address.house.size}")
    private String house;

    @Column(name = "apartment", length = Sizes.Address.MAX_APARTMENT, nullable = false)
    @Size(max = Sizes.Address.MAX_APARTMENT, message = "{address.apartment.size}")
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
        this.region = region == null ? null : region.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? DEFAULT_DISTRICT : district.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street == null ? null : street.trim();
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house == null ? null : house.trim();
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment == null ? DEFAULT_APARTMENT : apartment.trim();
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
