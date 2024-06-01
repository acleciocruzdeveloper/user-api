package br.com.backend.customers.enums;

public enum EHandlers {
    NOT_FOUND("not found");

    private final String value;

    EHandlers(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
