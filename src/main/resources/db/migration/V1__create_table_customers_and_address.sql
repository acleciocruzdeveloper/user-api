CREATE TABLE IF NOT EXISTS addresses
(
    id         serial primary key,
    logradouro varchar(250) not null,
    numero     integer      not null,
    bairro     varchar(150) not null,
    cidade     varchar(100)  not null,
    uf         varchar(100) not null,
    estado     varchar(100) not null
);

CREATE TABLE IF NOT EXISTS customers
(
    id              bigserial primary key,
    nome            varchar(150) not null,
    cpf       varchar(14)  not null unique,
    id_endereco     integer      not null,
    email           varchar(150) not null unique,
    password        varchar(16)  not null,
    status_customer varchar(20)  DEFAULT 'ativo',
    telefone        varchar(25)  not null,
    data_cadastro   TIMESTAMP    not null,
    CONSTRAINT fk_address FOREIGN KEY (id_endereco) REFERENCES addresses (id)
);