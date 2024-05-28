package br.com.backend.userapi.enums;

public enum EHandlers {
    NOT_FOUND("not found");

    private String value;

    EHandlers(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
