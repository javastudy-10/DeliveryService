package com.javastudy.deliveryservice.mvc.entity;

import com.javastudy.deliveryservice.domain.UserRole;
import com.javastudy.deliveryservice.mvc.entity.embeddable.UserInfo;
import com.javastudy.deliveryservice.security.Authentication;
import com.javastudy.deliveryservice.validation.Patterns;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.EnumSet;
import java.util.Set;

/**
 * Created by Maxim Sambulat
 */
@Entity
@Table(name = "customers")
@NamedQueries({
        @NamedQuery(name = "Customer.findByLoginOrPhoneOrEmail",
                query = "select c from Customer c where c.login=:login " +
                        "or c.phone=:login or c.email=:login"),
        @NamedQuery(name = "Customer.findById",
                query = "select c from Customer c where c.id=:id"),
        @NamedQuery(name = "Customer.findByIdWithDetails",
                query = "select c from Customer c inner join fetch c.address where c.id=:id"),
        @NamedQuery(name = "Customer.findAll",
                query = "select c from Customer c"),
        @NamedQuery(name = "Customer.findAllWithDetails",
                query = "select c from Customer c inner join fetch c.address")
})
public class Customer implements Authentication, Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "login", length = 16, nullable = false, unique = true)
    @NotNull(message = "{login.notnull}")
    @Size(max = 16, message = "{login.size}")
    @Pattern(regexp = Patterns.LOGIN, message = "{login.pattern}")
    private String login;

    @Column(name = "password", length = 64, nullable = false)
    @NotNull(message = "{password.notnull}")
    private String password;

    @Column(name = "enabled", nullable = false)
    private boolean enabled = false;

    @Column(name = "first_name", length = 32, nullable = false)
    @NotNull(message = "{name.notnull}")
    @Size(max = 32, message = "{name.size}")
    @Pattern(regexp = Patterns.NAME, message = "{name.pattern}")
    private String firstName;

    @Column(name = "last_name", length = 32, nullable = false)
    @NotNull(message = "{name.notnull}")
    @Size(max = 32, message = "{name.size}")
    @Pattern(regexp = Patterns.NAME, message = "{name.pattern}")
    private String lastName;

    @Column(name = "phone", length = 20, nullable = false)
    @NotNull(message = "{phone.notnull}")
    @Size(min = 4, max = 20, message = "{phone.size}")
    @Pattern(regexp = Patterns.PHONE, message = "{phone.pattern}")
    private String phone;

    @Column(name = "email", length = 64, nullable = false)
    @NotNull(message = "{email.notnull}")
    @Size(max = 64, message = "{email.size}")
    @Email(message = "{email.pattern}")
    private String email;

    @OneToOne(optional = false, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_address")
    private Address address;

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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
