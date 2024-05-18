package grupo17.enums;

public enum EstadoLoteEnum {
    EN_PROCESO(1),
    EN_DEPOSITO(2),
    ENTREGADO_PARCIAL(3),
    ENTREGADO_COMPLETO(4);

    private final int value;

    EstadoLoteEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static EstadoLoteEnum fromValue(int value) {
        for (EstadoLoteEnum estado : EstadoLoteEnum.values()) {
            if (estado.getValue() == value) {
                return estado;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
