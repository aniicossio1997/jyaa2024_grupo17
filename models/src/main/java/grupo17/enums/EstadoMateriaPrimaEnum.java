package grupo17.enums;

public enum EstadoMateriaPrimaEnum {
    ESTANTE(1),
    FREEZER(2),
    CAMARA_FRIO(3);


    private final int value;

    EstadoMateriaPrimaEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static EstadoMateriaPrimaEnum fromValue(int value) {
        for (EstadoMateriaPrimaEnum estado : EstadoMateriaPrimaEnum.values()) {
            if (estado.getValue() == value) {
                return estado;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
