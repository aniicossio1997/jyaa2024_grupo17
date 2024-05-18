package grupo17.enums;

public enum UnidadMedidaEnum {
    KG(1),
    GR(2),
    CC(3),
    LITRO(4);

    private final int value;

    UnidadMedidaEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static UnidadMedidaEnum fromValue(int value) {
        for (UnidadMedidaEnum unidad : UnidadMedidaEnum.values()) {
            if (unidad.getValue() == value) {
                return unidad;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}

