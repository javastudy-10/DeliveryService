package com.javastudy.deliveryservice.mvc.entity;

import com.javastudy.deliveryservice.validation.Patterns;
import com.javastudy.deliveryservice.validation.Sizes;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Maxim Sambulat
 */
@Entity
@Table(name = "customers")
@NamedQueries({
        @NamedQuery(name = "Customer.findByLogin",
                query = "select c from Customer c where c.login=:login"),
        @NamedQuery(name = "Customer.findById",
                query = "select c from Customer c where c.id=:id"),
        @NamedQuery(name = "Customer.findByIdWithDetails",
                query = "select c from Customer c inner join fetch c.address where c.id=:id"),
        @NamedQuery(name = "Customer.findAll",
                query = "select c from Customer c"),
        @NamedQuery(name = "Customer.findAllWithDetails",
                query = "select c from Customer c inner join fetch c.address")
})
public class Customer implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "login", length = Sizes.UserInfo.MAX_LOGIN, nullable = false, unique = true)
    @NotNull(message = "{login.notnull}")
    @Size(min = Sizes.UserInfo.MIN_LOGIN, max = Sizes.UserInfo.MAX_LOGIN, message = "{login.size}")
    @Pattern(regexp = Patterns.LOGIN, message = "{login.pattern}")
    private String login;

    @Column(name = "password", length = Sizes.UserInfo.MAX_PASSWORD_HASH, nullable = false)
    @NotNull(message = "{password.hash.notnull}")
    @NotEmpty(message = "{password.hash.notempty}")
    @Size(max = Sizes.UserInfo.MAX_PASSWORD_HASH, message = "{password.hash.size}")
    private String password;

    @Column(name = "enabled", nullable = false)
    private boolean enabled = false;

    @Column(name = "first_name", length = Sizes.UserInfo.MAX_FIRST_NAME, nullable = false)
    @NotNull(message = "{first_name.notnull}")
    @NotEmpty(message = "{first_name.notempty}")
    @Size(max = Sizes.UserInfo.MAX_FIRST_NAME, message = "{first_name.size}")
    @Pattern(regexp = Patterns.NAME, message = "{first_name.pattern}")
    private String firstName;

    @Column(name = "last_name", length = Sizes.UserInfo.MAX_LAST_NAME, nullable = false)
    @NotNull(message = "{last_name.notnull}")
    @NotEmpty(message = "{last_name.notempty}")
    @Size(max = Sizes.UserInfo.MAX_LAST_NAME, message = "{last_name.size}")
    @Pattern(regexp = Patterns.NAME, message = "{last_name.pattern}")
    private String lastName;

    @Column(name = "phone", length = Sizes.UserInfo.MAX_PHONE, nullable = false)
    @NotNull(message = "{phone.notnull}")
    @NotEmpty(message = "{phone.notempty}")
    @Size(max = Sizes.UserInfo.MAX_PHONE, message = "{phone.size}")
    @Pattern(regexp = Patterns.PHONE, message = "{phone.pattern}")
    private String phone;

    @Column(name = "email", length = Sizes.UserInfo.MAX_EMAIL, nullable = false)
    @NotNull(message = "{email.notnull}")
    @NotEmpty(message = "{email.notempty}")
    @Size(max = Sizes.UserInfo.MAX_EMAIL, message = "{email.size}")
    @Email(message = "{email.pattern}")
    private String email;

    @OneToOne(optional = false, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_address")
    @NotNull(message = "{customer.address.notnull}")
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
        this.login = login == null ? null : login.trim();
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
        this.firstName = firstName == null ? null : firstName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
