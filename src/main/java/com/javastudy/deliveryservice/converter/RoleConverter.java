package com.javastudy.deliveryservice.converter;

import com.javastudy.deliveryservice.domain.UserRole;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by Maxim Sambulat
 */
@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<UserRole, Integer> {

    @Override
    public Integer convertToDatabaseColumn(UserRole roles) {
        return roles.getId();
    }

    @Override
    public UserRole convertToEntityAttribute(Integer id) {
        return UserRole.valueOf(id);
    }
}
