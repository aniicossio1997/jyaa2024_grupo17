package com.app.models.enums;

import java.util.Objects;

public enum EstadoLoteEnum {
    EN_PROCESO("EN_PROCESO"),
    EN_DEPOSITO("EN_DEPOSITO"),
    ENTREGADO_PARCIAL("ENTREGADO_PARCIAL"),
    ENTREGADO_COMPLETO("ENTREGADO_COMPLETO");

    private final String value;

    EstadoLoteEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoLoteEnum fromValue(String value) {
        for (EstadoLoteEnum estado : EstadoLoteEnum.values()) {
            if (Objects.equals(estado.getValue(), value)) {
                return estado;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
