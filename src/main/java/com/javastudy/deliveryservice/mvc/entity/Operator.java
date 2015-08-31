package com.javastudy.deliveryservice.mvc.entity;

import com.javastudy.deliveryservice.security.Authentication;
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
@Entity
@Table(name = "operators")
@NamedQueries({
        @NamedQuery(name = "Operator.findByLoginOrPhoneOrEmail",
                query = "select o from Operator o where o.login=:login " +
                        "or o.phone=:login or o.email=:login"),
        @NamedQuery(name = "Operator.findAll",
                query = "select o from Operator o")
})
public class Operator implements Authentication, Serializable {
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

    public Operator() {
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
}
