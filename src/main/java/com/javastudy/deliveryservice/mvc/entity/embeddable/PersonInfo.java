package com.javastudy.deliveryservice.mvc.entity.embeddable;

import com.javastudy.deliveryservice.validation.Patterns;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Maxim Sambulat
 */
@Embeddable
@Access(AccessType.FIELD)
public class PersonInfo {
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

    @Column(name = "phone")
    @NotNull(message = "{phone.notnull}")
    @Size(min = 4, max = 20, message = "{phone.size}")
    @Pattern(regexp = Patterns.PHONE, message = "{phone.pattern}")
    private String phone;

    @Column(name = "email")
    @NotNull(message = "{email.notnull}")
    @Size(max = 32, message = "{email.size}")
    @Email(message = "{email.pattern}")
    private String email;

    public PersonInfo() {
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
}
