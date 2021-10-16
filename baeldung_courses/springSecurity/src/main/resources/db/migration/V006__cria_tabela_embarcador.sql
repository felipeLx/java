CREATE TABLE embarcador (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome_embarcador VARCHAR(200) NOT NULL UNIQUE,
    cnpj VARCHAR(18) NOT NULL UNIQUE,
    endereco VARCHAR(200) NOT NULL,
    telefone VARCHAR(25) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    uf VARCHAR(10) NOT NULL,
    cep VARCHAR(30) NOT NULL,
    email VARCHAR(200) NOT NULL,
    complemento VARCHAR(100),
    latitude BIGINT(20),
    longitude BIGINT(20),
    status BOOLEAN DEFAULT true NOT NULL,
    usuario  BIGINT(20) NOT NULL,
    FOREIGN KEY (usuario) REFERENCES usuario(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;