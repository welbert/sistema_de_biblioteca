USE `mydb` ;

INSERT INTO `mydb`.`tus_tipo_usuario` (
`tus_tp_usuario` ,
`tus_ds_usuario`
)
VALUES (
'1', 'Professor'
);

INSERT INTO `mydb`.`tus_tipo_usuario` (
`tus_tp_usuario` ,
`tus_ds_usuario`
)
VALUES (
'2', 'Aluno Graduação'
);

INSERT INTO `mydb`.`tus_tipo_usuario` (
`tus_tp_usuario` ,
`tus_ds_usuario`
)
VALUES (
'2', 'Aluno Pós-Graduação'
);

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
'1', 'admin', 'admin', '1', 'Admin', '2017-01-01', '55555555555', '55555555555', 'Ali', 'N'
);