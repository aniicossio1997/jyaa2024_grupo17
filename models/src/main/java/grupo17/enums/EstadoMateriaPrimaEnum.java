package grupo17.enums;

import java.util.Objects;

public enum EstadoMateriaPrimaEnum {
    ESTANTE("ESTANTE"),
    FREEZER("FREEZER"),
    CAMARA_FRIO("CAMARA_FRIO");


    private final String value;

    EstadoMateriaPrimaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoMateriaPrimaEnum fromValue(String value) {
        for (EstadoMateriaPrimaEnum estado : EstadoMateriaPrimaEnum.values()) {
            if (Objects.equals(estado.getValue(), value)) {
                return estado;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
