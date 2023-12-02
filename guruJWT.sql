CREATE DATABASE db_guruJWT WITH OWNER = postgres
ENCODING = 'UTF8' CONNECTION LIMIT = -1;


DROP TABLE usuario;

CREATE TABLE usuario
(
    id BIGSERIAL,
    email VARCHAR (50) UNIQUE NOT NULL,
    senha VARCHAR (128) NOT NULL,
    tipo VARCHAR (20) NOT NULL,
    criado_em TIMESTAMP NOT NULL,
    PRIMARY KEY(id)
);

------------------
INSERT INTO usuario
(email, senha, tipo, criado_em)
VALUES('admin@email.com', 'adminadmin','ADMINISTRATOR', now());

INSERT INTO usuario
(email, senha, tipo, criado_em)
VALUES('pedro@email.com', 'pedropedro','ADMINISTRATOR', now());

INSERT INTO usuario
(email, senha, tipo, criado_em)
VALUES('marins@email.com', 'marinsmarins','CLIENT', now());

INSERT INTO usuario
(email, senha, tipo, criado_em)
VALUES('gabriel@email.com', 'gabrielgabriel','EMPLOYEE', now());
