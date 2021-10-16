CREATE TABLE usuarios (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    id_empresa BIGINT(20) NOT NULL,
    id_embarcador BIGINT(20) NOT NULL,
    id_plataforma BIGINT(20) NOT NULL,
    role_name VARCHAR(200) NOT NULL,
    nome VARCHAR(200) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    email VARCHAR(200) NOT NULL UNIQUE,
    status BOOLEAN DEFAULT true NOT NULL,
    cpf VARCHAR(18) NOT NULL UNIQUE,
    data_expiracao DATE,
    FOREIGN KEY (id_empresa) REFERENCES empresa(id),
    FOREIGN KEY (id_embarcador) REFERENCES embarcador(id),
    FOREIGN KEY (id_plataforma) REFERENCES plataforma(id),
    FOREIGN KEY (role_name) REFERENCES autorizacao(role)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;