insert into erro (ambiente, arquivado, coletor, data_hora, descricao, eventos, level, origem, titulo, id, detalhes) values (0, false, 'RAFAEL', now(), 'teste1', 100, 0, '10.01.2', 'erro 1', 1,'ocorreu de madrugada')
insert into erro (ambiente, arquivado, coletor, data_hora, descricao, eventos, level, origem, titulo, id, detalhes) values (2, false, 'OSEIAS', now(), 'teste2', 100, 1, '10.01.4', 'erro 2', 2,'ocorreu pela manhã')
insert into erro (ambiente, arquivado, coletor, data_hora, descricao, eventos, level, origem, titulo, id, detalhes) values (1, false, 'WESLEY', now(), 'teste3', 100, 2, '10.01.8', 'erro 3', 3,'ocorreu por 20 min')
insert into erro (ambiente, arquivado, coletor, data_hora, descricao, eventos, level, origem, titulo, id, detalhes) values (0, false, 'RENATA', now(), 'teste4', 100, 1, '10.01.9', 'erro 4', 4,'ocorreu ao inserir novo usuário')
insert into erro (ambiente, arquivado, coletor, data_hora, descricao, eventos, level, origem, titulo, id, detalhes) values (0, false, 'RAFAEL', now(), 'teste5', 100, 0, '10.01.1', 'erro 5', 5,'ocorreu após diversas requisições')

insert into usuario(nome, email, senha, token) values ('teste', 'teste@test.com', '$2a$10$RCY3VHJbXq12w4evcO9TEuYfBsC.aAyaYTJ1M2LEKSghp.oGlBsnu', 'bXq12w4evcO9TEuYfBsC');
