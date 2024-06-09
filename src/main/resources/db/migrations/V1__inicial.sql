-- Criar tabela de usuários
CREATE TABLE usuario (
                         id SERIAL PRIMARY KEY,
                         nome VARCHAR(255) NOT NULL,
                         sobrenome VARCHAR(255),
                         email VARCHAR(255) UNIQUE NOT NULL,
                         id_lattes VARCHAR(255),
                         ocupacao VARCHAR(255),
                         senha VARCHAR(255) NOT NULL,
                         nivel INT
);

-- Criar tabela de produções
CREATE TABLE producao (
                          id SERIAL PRIMARY KEY,
                          usuario_id INT,
                          autor VARCHAR(255) NOT NULL,
                          coAutores VARCHAR(255),
                          tipoProducao VARCHAR(255),
                          titulo VARCHAR(255) NOT NULL,
                          localDePublicacao VARCHAR(255),
                          url VARCHAR(255),
                          FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);
