package com.javastudy.deliveryservice.security;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Maxim Sambulat
 */
public enum UserRole {
    ADMIN(0, "ROLE_ADMIN"),
    CLIENT(1, "ROLE_CLIENT"),
    OPERATOR(2, "ROLE_OPERATOR"),
    COURIER(3, "ROLE_COURIER");

    private Integer id;
    private String name;

    UserRole(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    private static Map<Integer, UserRole> roleMap;

    static {
        UserRole[] userRoles = UserRole.values();
        roleMap = new HashMap<Integer, UserRole>(userRoles.length);

        for (UserRole userRole : userRoles) {
            roleMap.put(userRole.id, userRole);
        }
    }

    public static UserRole valueOf(Integer id) {
        if (!roleMap.containsKey(id)) {
            throw new IllegalArgumentException("Wrong userRole ID: " + id);
        }

        return roleMap.get(id);
    }
}
