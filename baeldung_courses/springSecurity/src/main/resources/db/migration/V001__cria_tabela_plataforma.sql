CREATE TABLE plataforma (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome_plataforma VARCHAR(45) NOT NULL UNIQUE,
    sigla_plataforma VARCHAR(45) NOT NULL,
    url VARCHAR(145) NOT NULL,
    status BOOLEAN DEFAULT true NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;