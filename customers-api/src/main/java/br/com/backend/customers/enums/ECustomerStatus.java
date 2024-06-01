package br.com.backend.customers.enums;

public enum ECustomerStatus {

    ACTIVE("ativo"),
    INACTIVE("inativo");
    private final String status;

    ECustomerStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
