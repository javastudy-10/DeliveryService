package com.javastudy.deliveryservice.mvc.entity;

import com.javastudy.deliveryservice.validation.Patterns;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Maxim Sambulat
 */

/**
 * Data of the contact person of the sender or recipient
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "senders_and_destinations")
@NamedQueries({
        @NamedQuery(name = "ContactPerson.findById", query = "select cp from ContactPerson cp where cp.id=:id"),
        @NamedQuery(name = "ContactPerson.findByIdWithAddress", query = "select cp from ContactPerson cp inner join fetch cp.address where cp.id=:id"),
        @NamedQuery(name = "ContactPerson.findAll", query = "select cp from ContactPerson cp"),
        @NamedQuery(name = "ContactPerson.findAllWithAddress", query = "select cp from ContactPerson cp inner join fetch cp.address"),
})
public class ContactPerson implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    @NotNull(message = "{name.notnull}")
    @Size(max = 32, message = "{name.size}")
    @Pattern(regexp = Patterns.NAME, message = "{name.pattern}")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "{name.notnull}")
    @Size(max = 32, message = "{name.size}")
    @Pattern(regexp = Patterns.NAME, message = "{name.pattern}")
    private String lastName;

    @NotNull(message = "{phone.notnull}")
    @Size(min = 4, max = 20, message = "{phone.size}")
    @Pattern(regexp = Patterns.PHONE, message = "{phone.pattern}")
    private String phone;

    @Size(max = 32, message = "{email.size}")
    @Email(message = "{email.pattern}")
    private String email;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_address")
    private Address address;

    public ContactPerson() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
