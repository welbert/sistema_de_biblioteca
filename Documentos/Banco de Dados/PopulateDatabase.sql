USE `mydb` ;

INSERT INTO `mydb`.`tus_tipo_usuario` (
`tus_tp_usuario` ,
`tus_ds_usuario` ,
`tus_nu_nivel_usuario`
)
VALUES (
'1', 'Admin','3'
);

INSERT INTO `mydb`.`tus_tipo_usuario` (
`tus_tp_usuario` ,
`tus_ds_usuario` ,
`tus_nu_nivel_usuario`
)
VALUES (
'2', 'Professor','2'
);

INSERT INTO `mydb`.`tus_tipo_usuario` (
`tus_tp_usuario` ,
`tus_ds_usuario` ,
`tus_nu_nivel_usuario`
)
VALUES (
'3', 'Aluno Graduação' ,'1'
);

INSERT INTO `mydb`.`tus_tipo_usuario` (
`tus_tp_usuario` ,
`tus_ds_usuario` ,
`tus_nu_nivel_usuario`
)
VALUES (
'4', 'Aluno Pós-Graduação', '1'
);


-- Criando Admnistrador
--Senha = admin
INSERT INTO `mydb`.`usr_usuario` (
`usr_id_usuario` ,
`usr_nm_login` ,
`usr_ds_senha` ,
`usr_tp_usuario` ,
`usr_nm_nome` ,
`usr_dt_nascimento` ,
`usr_nu_cpf` ,
`usr_nu_telefone` ,
`usr_ds_endereco` ,
`usr_ch_inativo`
)
VALUES (
'1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '1', 'Admin', '2017-01-01', '55555555555', '55555555555', 'Ali', 'N'
);


--Criando Alunos de Graduação e Pos
-- Senha = senha

INSERT INTO `mydb`.`usr_usuario` (
`usr_id_usuario`,
`usr_nm_login` ,
`usr_ds_senha` ,
`usr_tp_usuario` ,
`usr_nm_nome` ,
`usr_dt_nascimento` ,
`usr_nu_cpf` ,
`usr_nu_telefone` ,
`usr_ds_endereco` ,
`usr_ch_inativo`
)
VALUES 
('5', 'alunog1', 'e8d95a51f3af4a3b134bf6bb680a213a', '3', 'Aluno Graduacao 1', '2017-01-01', '55555555555', '55555555555', 'Ali', 'N'),
('2', 'alunog2', 'e8d95a51f3af4a3b134bf6bb680a213a', '3', 'Aluno Graduacao 2', '2017-01-01', '55555555555', '55555555555', 'Ali', 'N'),
('3', 'alunopg1', 'e8d95a51f3af4a3b134bf6bb680a213a', '4', 'Aluno Pos Graduacao 1', '2017-01-01', '55555555555', '55555555555', 'Ali', 'N'),
('4', 'alunopg2', 'e8d95a51f3af4a3b134bf6bb680a213a', '4', 'Aluno Pos Graduacao 2', '2017-01-01', '55555555555', '55555555555', 'Ali', 'N');


--Criando Professores
-- Senha = senha

INSERT INTO `mydb`.`usr_usuario` (
`usr_id_usuario`,
`usr_nm_login` ,
`usr_ds_senha` ,
`usr_tp_usuario` ,
`usr_nm_nome` ,
`usr_dt_nascimento` ,
`usr_nu_cpf` ,
`usr_nu_telefone` ,
`usr_ds_endereco` ,
`usr_ch_inativo`
)
VALUES 
('6', 'prof1', 'e8d95a51f3af4a3b134bf6bb680a213a', '2', 'Professor 1', '2017-01-01', '55555555555', '55555555555', 'Ali', 'N'),
('7', 'prof2', 'e8d95a51f3af4a3b134bf6bb680a213a', '2', 'Professor 2', '2017-01-01', '55555555555', '55555555555', 'Ali', 'N');


-- Tipo de materiais
INSERT INTO `mydb`.`tma_tipo_material` (
`tipo_id_material` ,
`tma_ds_material`
)
VALUES ('1', 'Livro'),
 ('2', 'Revista'),
 ('3', 'CD'),
 ('4', 'DVD');


-- Materiais
INSERT INTO `mydb`.`mat_material` (
`mat_id_material` ,
`mat_ch_inativo` ,
`mat_cd_localizacao` ,
`mat_ds_titutlo` ,
`mat_nu_ano` ,
`mat_tp_material`
)
VALUES ('1', 'N', 'a123', 'Livro 1', '2000', '1'),
       ('2', 'S', 'a124', 'Livro inativo', '2010', '1'),
       ('3', 'N', 'r34', 'Revista 1', '2008', '2'),
       ('4', 'N', 'z1', 'CD 1', '1998', '3'),
       ('5', 'N', 'z2', 'DVD 1', '2004', '4');

-- Livro
INSERT INTO `mydb`.`liv_livro` (
`liv_id_livro` ,
`liv_id_material` ,
`liv_mn_autor` ,
`liv_nm_editora` ,
`liv_nm_edicacao`
)
VALUES ('1', '1', 'Garoff', 'Intrinseca', '1a'),
       ('2', '2', 'Autor do livro', 'editora', '2a');

-- Revista
INSERT INTO `mydb`.`rev_revista` (
`rev_id_revista` ,
`rev_nu_issn` ,
`rev_nm_local` ,
`rev_nu_fasciculo` ,
`rev_id_material`)
VALUES ('1', '1234567890-7890', 'SP', '3', '3');

--CD
INSERT INTO `mydb`.`dsc_disco_cd` (
`dsc_id_disco_cd` ,
`dsc_nu_faixas` ,
`dsc_nm_gravadora` ,
`dsc_nm_artista` ,
`dsc_id_material`
)
VALUES ('1', '5', 'globo', 'desconhecido', '4');

--DVD
INSERT INTO `mydb`.`dsd_disco_dvd` (
`dsd_id_disco_dvd` ,
`dsd_nm_distribuidora` ,
`dsd_nm_diretor` ,
`dsd_nm_estudio` ,
`dsd_nm_pais` ,
`dsd_id_material`
)
VALUES ('1', 'HQ Filmes', 'FULANO', '1', 'Brasil', '5');
