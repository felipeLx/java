CREATE TABLE transportadora (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nomeTransportadora VARCHAR(200) NOT NULL,
    plataforma BIGINT(20),
    FOREIGN KEY (plataforma) REFERENCES plataforma(id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;