CREATE TABLE cargo (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    role VARCHAR(200) NOT NULL,
    usuario_id BIGINT(20),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;