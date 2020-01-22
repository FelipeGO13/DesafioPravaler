INSERT INTO INSTITUICAO (id,  nome, cnpj, status, version) VALUES (999997, 'Universidade SaberMais', '51.839.818/0001-33', 'ativo', 1);
INSERT INTO INSTITUICAO (id,  nome, cnpj, status, version) VALUES (999998, 'Escola Tecnica Aprendizado', '71.746.232/0001-31', 'ativo', 1);

INSERT INTO CURSO(id, nome, duracao, status, instituicao_id, version) VALUES (99999997, 'Computação', '4', 'ativo', 999997, 1);
INSERT INTO CURSO(id, nome, duracao, status, instituicao_id, version) VALUES (99999998, 'Mecatrônica', '2', 'ativo', 999998, 1);
INSERT INTO CURSO(id, nome, duracao, status, instituicao_id, version) VALUES (99999999, 'Nutrição', '2', 'inativo', 999997, 1);

INSERT INTO ALUNO(id, nome, cpf, dataNascimento, email, celular, endereco, numero, bairro, cidade, uf, status, curso_id, version) VALUES (999999998, 'João Silva','637.980.980-50', '10/10/1998', 'joaosouza@gmail.com', '(11) 99999-9999', 'Rua Brasil', '123', 'Jardim América', 'São Paulo', 'SP', 'ativo', 99999997, 1);
INSERT INTO ALUNO(id, nome, cpf, dataNascimento, email, celular, endereco, numero, bairro, cidade, uf, status, curso_id, version) VALUES (999999999, 'Maria Souza','440.497.700-08', '24/02/1994', 'mariasilva@gmail.com', '(11) 88888-8888', 'Rua Japão', '123', 'Jardim Asia', 'São Paulo', 'SP', 'ativo', 99999999, 1);
