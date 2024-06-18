package com.app.models.enums;

import java.util.Objects;

public enum RolUsuario {
    ADMIN("ADMIN"),
    ENCARGADO_SALA("ENCARGADO_SALA");

    private final String value;

    RolUsuario(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RolUsuario fromValue(String value) {
        for (RolUsuario rolUsuario : RolUsuario.values()) {
            if (Objects.equals(rolUsuario.getValue(), value)) {
                return rolUsuario;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}