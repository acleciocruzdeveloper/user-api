package br.com.backend.customers.enums;

public enum EUnidadesFederativas {
    AC("Região Norte", "Acre"),
    AL("Região Nordeste", "Alagoas"),
    AP("Região Norte", "Amapá"),
    AM("Região Norte", "Amazonas"),
    BA("Região Nordeste", "Bahia"),
    CE("Ceará", "Região Nordeste"),
    DF("Centro-Oeste", "Distrito FederaL"),
    ES("Região Sudeste", "Espírito Santo"),
    GO("Região Centro-Oeste", "Goiás"),
    MA("Região Nordeste", "Maranhão"),
    MT("Região Centro-Oeste", "Mato Grosso"),
    MS("Região Centro-Oeste", "Mato Grosso do Sul"),
    MG("Região Sudeste", "Minas Gerais"),
    PA("Região Norte", "Pará"),
    PB("Região Nordeste", "Paraíba"),
    PR("Região Sul", "Paraná"),
    PE("Região Nordeste", "Pernambuco"),
    PI("Região Nordeste", "Piauí"),
    RJ("Região Sudeste", "Rio de Janeiro"),
    RN("Região Nordeste", "Rio Grande do Norte"),
    RS("Região Sul", "Rio Grande do Sul"),
    RO("Região Norte", "Rondônia"),
    RR("Região Norte", "Roraima"),
    SC("Região Sul", "Santa Catarina"),
    SP("Região Sudeste", "São Paulo"),
    SE("Região Nordeste", "Sergipe"),
    TO("Região Norte", "Tocantins");

    private final String regiao;
    private final String unidadeFederativa;

    EUnidadesFederativas(String regiao, String unidadeFederativa) {
        this.regiao = regiao;
        this.unidadeFederativa = unidadeFederativa;
    }

    public String getRegiao() {
        return regiao;
    }

    public String getUnidadeFederativa() {
        return unidadeFederativa;
    }
    }
