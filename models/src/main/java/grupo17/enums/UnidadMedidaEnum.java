package grupo17.enums;

import java.util.Objects;

public enum UnidadMedidaEnum {
    KG("KG"),
    GR("GR"),
    CC("CC"),
    LITRO("LITRO"),
    UNIDAD("UNIDAD");

    private final String value;

    UnidadMedidaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static UnidadMedidaEnum fromValue(String value) {
        for (UnidadMedidaEnum unidad : UnidadMedidaEnum.values()) {
            if (Objects.equals(unidad.getValue(), value)) {
                return unidad;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}

