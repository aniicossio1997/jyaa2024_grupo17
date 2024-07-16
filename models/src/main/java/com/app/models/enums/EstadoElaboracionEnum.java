package com.app.models.enums;

import java.util.Objects;

public enum EstadoElaboracionEnum {
    EN_PROCESO("EN_PROCESO"),
    EN_DEPOSITO("EN_DEPOSITO"),
    ENTREGADO_PARCIAL("ENTREGADO_PARCIAL"),
    ENTREGADO_COMPLETO("ENTREGADO_COMPLETO");

    private final String value;

    EstadoElaboracionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoElaboracionEnum fromValue(String value) {
        for (EstadoElaboracionEnum estado : EstadoElaboracionEnum.values()) {
            if (Objects.equals(estado.getValue(), value)) {
                return estado;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
