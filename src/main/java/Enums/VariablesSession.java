package Enums;

public enum VariablesSession {
    SESION_RESULTADO("resultadoOperacion");

    private final String valor;

    VariablesSession(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
