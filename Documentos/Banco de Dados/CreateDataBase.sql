-- MySQL Script generated by MySQL Workbench
-- Sun Mar 26 21:57:08 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`tus_tipo_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tus_tipo_usuario` (
  `tus_tp_usuario` INT NOT NULL AUTO_INCREMENT,
  `tus_ds_usuario` VARCHAR(45) NOT NULL,
  `tus_nu_nivel_usuario` INT NOT NULL,
  PRIMARY KEY (`tus_tp_usuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`usr_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`usr_usuario` (
  `usr_id_usuario` INT NOT NULL AUTO_INCREMENT,
  `usr_nm_login` VARCHAR(20) NOT NULL,
  `usr_ds_senha` VARCHAR(40) NOT NULL,
  `usr_tp_usuario` INT NOT NULL,
  `usr_nm_nome` VARCHAR(60) NOT NULL,
  `usr_dt_nascimento` DATE NULL,
  `usr_nu_cpf` VARCHAR(11) NOT NULL,
  `usr_nu_telefone` VARCHAR(45) NULL,
  `usr_ds_endereco` VARCHAR(45) NULL,
  `usr_ch_inativo` VARCHAR(1) NULL,
  PRIMARY KEY (`usr_id_usuario`),
  INDEX `fk_usr_usuario_tus_tipo_usuario_idx` (`usr_tp_usuario` ASC),
  CONSTRAINT `fk_usr_usuario_tus_tipo_usuario`
    FOREIGN KEY (`usr_tp_usuario`)
    REFERENCES `mydb`.`tus_tipo_usuario` (`tus_tp_usuario`)
    ON DELETE RESTRICT
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tma_tipo_material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tma_tipo_material` (
  `tipo_id_material` INT NOT NULL AUTO_INCREMENT,
  `tma_ds_material` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`tipo_id_material`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`mat_material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`mat_material` (
  `mat_id_material` INT NOT NULL AUTO_INCREMENT,
  `mat_ch_inativo` VARCHAR(1) NULL,
  `mat_cd_localizacao` VARCHAR(8) NOT NULL,
  `mat_ds_titulo` VARCHAR(45) NOT NULL,
  `mat_nu_ano` INT NULL,
  `mat_tp_material` INT NOT NULL,
  PRIMARY KEY (`mat_id_material`),
  INDEX `fk_mat_material_tma_tipo_material1_idx` (`mat_tp_material` ASC),
  CONSTRAINT `fk_mat_material_tma_tipo_material1`
    FOREIGN KEY (`mat_tp_material`)
    REFERENCES `mydb`.`tma_tipo_material` (`tipo_id_material`)
    ON DELETE RESTRICT
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`reg_registro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`reg_registro` (
  `reg_id_registro` INT NOT NULL AUTO_INCREMENT,
  `reg_ds_descricao` VARCHAR(45) NOT NULL,
  `reg_dt_operacao` DATETIME NOT NULL,
  `reg_id_usuario` INT NOT NULL,
  `reg_id_usuario_logado` INT NOT NULL,
  `reg_id_material` INT NOT NULL,
  PRIMARY KEY (`reg_id_registro`),
  INDEX `fk_reg_registro_usr_usuario1_idx` (`reg_id_usuario` ASC),
  INDEX `fk_reg_registro_usr_usuario2_idx` (`reg_id_usuario_logado` ASC),
  INDEX `fk_reg_registro_mat_material1_idx` (`reg_id_material` ASC),
  CONSTRAINT `fk_reg_registro_usr_usuario1`
    FOREIGN KEY (`reg_id_usuario`)
    REFERENCES `mydb`.`usr_usuario` (`usr_id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reg_registro_usr_usuario2`
    FOREIGN KEY (`reg_id_usuario_logado`)
    REFERENCES `mydb`.`usr_usuario` (`usr_id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reg_registro_mat_material1`
    FOREIGN KEY (`reg_id_material`)
    REFERENCES `mydb`.`mat_material` (`mat_id_material`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`alu_aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`alu_aluno` (
  `alu_id_aluno` INT NOT NULL AUTO_INCREMENT,
  `alu_nu_matricula` VARCHAR(45) NOT NULL,
  `alu_ch_graduacao` VARCHAR(1) NOT NULL,
  `alu_ch_inadimplente` VARCHAR(1) NULL,
  `alu_id_usuario` INT NOT NULL,
  PRIMARY KEY (`alu_id_aluno`),
  INDEX `fk_alu_aluno_usr_usuario1_idx` (`alu_id_usuario` ASC),
  CONSTRAINT `fk_alu_aluno_usr_usuario1`
    FOREIGN KEY (`alu_id_usuario`)
    REFERENCES `mydb`.`usr_usuario` (`usr_id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`pro_professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`pro_professor` (
  `pro_id_professor` INT NOT NULL AUTO_INCREMENT,
  `pro_nu_siape` VARCHAR(15) NOT NULL,
  `pro_ch_afastado` VARCHAR(1) NULL,
  `pro_id_usuario` INT NOT NULL,
  PRIMARY KEY (`pro_id_professor`),
  INDEX `fk_pro_professor_usr_usuario1_idx` (`pro_id_usuario` ASC),
  CONSTRAINT `fk_pro_professor_usr_usuario1`
    FOREIGN KEY (`pro_id_usuario`)
    REFERENCES `mydb`.`usr_usuario` (`usr_id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`liv_livro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`liv_livro` (
  `liv_id_livro` INT NOT NULL AUTO_INCREMENT,
  `liv_id_material` INT NOT NULL,
  `liv_mn_autor` VARCHAR(20) NULL,
  `liv_nm_editora` VARCHAR(45) NULL,
  `liv_nm_edicacao` VARCHAR(45) NULL,
  PRIMARY KEY (`liv_id_livro`),
  INDEX `fk_liv_livro_mat_material1_idx` (`liv_id_material` ASC),
  CONSTRAINT `fk_liv_livro_mat_material1`
    FOREIGN KEY (`liv_id_material`)
    REFERENCES `mydb`.`mat_material` (`mat_id_material`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`rev_revista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`rev_revista` (
  `rev_id_revista` INT NOT NULL AUTO_INCREMENT,
  `rev_nu_issn` VARCHAR(45) NOT NULL,
  `rev_nm_local` VARCHAR(45) NULL,
  `rev_nu_fasciculo` VARCHAR(45) NULL,
  `rev_id_material` INT NOT NULL,
  PRIMARY KEY (`rev_id_revista`),
  INDEX `fk_rev_revista_mat_material1_idx` (`rev_id_material` ASC),
  CONSTRAINT `fk_rev_revista_mat_material1`
    FOREIGN KEY (`rev_id_material`)
    REFERENCES `mydb`.`mat_material` (`mat_id_material`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`dsc_disco_cd`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`dsc_disco_cd` (
  `dsc_id_disco_cd` INT NOT NULL AUTO_INCREMENT,
  `dsc_nu_faixas` INT NULL,
  `dsc_nm_gravadora` VARCHAR(30) NULL,
  `dsc_nm_artista` VARCHAR(45) NULL,
  `dsc_id_material` INT NOT NULL,
  PRIMARY KEY (`dsc_id_disco_cd`, `dsc_id_material`),
  INDEX `fk_dsc_disco_cd_mat_material1_idx` (`dsc_id_material` ASC),
  CONSTRAINT `fk_dsc_disco_cd_mat_material1`
    FOREIGN KEY (`dsc_id_material`)
    REFERENCES `mydb`.`mat_material` (`mat_id_material`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`dsd_disco_dvd`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`dsd_disco_dvd` (
  `dsd_id_disco_dvd` INT NOT NULL AUTO_INCREMENT,
  `dsd_nm_distribuidora` VARCHAR(45) NULL,
  `dsd_nm_diretor` VARCHAR(45) NULL,
  `dsd_nm_estudio` VARCHAR(45) NULL,
  `dsd_nm_pais` VARCHAR(45) NULL,
  `dsd_id_material` INT NOT NULL,
  PRIMARY KEY (`dsd_id_disco_dvd`, `dsd_id_material`),
  INDEX `fk_dsd_disco_dvd_mat_material1_idx` (`dsd_id_material` ASC),
  CONSTRAINT `fk_dsd_disco_dvd_mat_material1`
    FOREIGN KEY (`dsd_id_material`)
    REFERENCES `mydb`.`mat_material` (`mat_id_material`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`emp_emprestimo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`emp_emprestimo` (
  `emp_id_emprestimo` INT NOT NULL AUTO_INCREMENT,
  `emp_dt_emprestimo` DATE NOT NULL,
  `emp_dt_devolucao` DATE NULL,
  `emp_dt_prevista` DATE NULL,
  `emp_id_usuario` INT NOT NULL,
  `emp_id_material` INT NOT NULL,
  PRIMARY KEY (`emp_id_emprestimo`, `emp_id_usuario`, `emp_id_material`),
  INDEX `fk_emp_emprestimo_usr_usuario1_idx` (`emp_id_usuario` ASC),
  INDEX `fk_emp_emprestimo_mat_material1_idx` (`emp_id_material` ASC),
  CONSTRAINT `fk_emp_emprestimo_usr_usuario1`
    FOREIGN KEY (`emp_id_usuario`)
    REFERENCES `mydb`.`usr_usuario` (`usr_id_usuario`)
    ON DELETE RESTRICT
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_emp_emprestimo_mat_material1`
    FOREIGN KEY (`emp_id_material`)
    REFERENCES `mydb`.`mat_material` (`mat_id_material`)
    ON DELETE RESTRICT
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`res_reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`res_reserva` (
  `res_id_reserva` INT NOT NULL AUTO_INCREMENT,
  `res_id_material` INT NOT NULL,
  `res_id_usuario` INT NOT NULL,
  `res_dt_reserva` DATE NULL,
  PRIMARY KEY (`res_id_reserva`),
  INDEX `fk_res_reserva_mat_material1_idx` (`res_id_material` ASC),
  INDEX `fk_res_reserva_usr_usuario1_idx` (`res_id_usuario` ASC),
  CONSTRAINT `fk_res_reserva_mat_material1`
    FOREIGN KEY (`res_id_material`)
    REFERENCES `mydb`.`mat_material` (`mat_id_material`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_res_reserva_usr_usuario1`
    FOREIGN KEY (`res_id_usuario`)
    REFERENCES `mydb`.`usr_usuario` (`usr_id_usuario`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`alx_aluno_excluido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`alx_aluno_excluido` (
  `alx_id_aluno` INT NOT NULL AUTO_INCREMENT,
  `alx_nu_matricula` VARCHAR(45) NOT NULL,
  `alx_ch_graduacao` VARCHAR(1) NOT NULL,
  `alx_ch_inadimplente` VARCHAR(1) NULL,
  `alu_id_usuario` INT NOT NULL,
  PRIMARY KEY (`alx_id_aluno`),
  INDEX `fk_alx_aluno_usr_usuario1_idx` (`alu_id_usuario` ASC),
  CONSTRAINT `fk_alx_aluno_usr_usuario`
    FOREIGN KEY (`alu_id_usuario`)
    REFERENCES `mydb`.`usr_usuario` (`usr_id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`alx_aluno_excluido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`alx_aluno_excluido` (
  `alx_id_aluno` INT NOT NULL AUTO_INCREMENT,
  `alx_nu_matricula` VARCHAR(45) NOT NULL,
  `alx_ch_graduacao` VARCHAR(1) NOT NULL,
  `alx_ch_inadimplente` VARCHAR(1) NULL,
  `alu_id_usuario` INT NOT NULL,
  PRIMARY KEY (`alx_id_aluno`),
  INDEX `fk_alx_aluno_usr_usuario1_idx` (`alu_id_usuario` ASC),
  CONSTRAINT `fk_alx_aluno_usr_usuario`
    FOREIGN KEY (`alu_id_usuario`)
    REFERENCES `mydb`.`usr_usuario` (`usr_id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`prx_professor_excluido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`prx_professor_excluido` (
  `prx_id_professor` INT NOT NULL AUTO_INCREMENT,
  `prx_nu_siape` VARCHAR(15) NOT NULL,
  `prx_ch_afastado` VARCHAR(1) NULL,
  `prx_id_usuario` INT NOT NULL,
  PRIMARY KEY (`prx_id_professor`),
  INDEX `fk_prx_professor_usr_usuario1_idx` (`prx_id_usuario` ASC),
  CONSTRAINT `fk_prx_professor_usr_usuario10`
    FOREIGN KEY (`prx_id_usuario`)
    REFERENCES `mydb`.`usr_usuario` (`usr_id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `mydb` ;

-- -----------------------------------------------------
-- Placeholder table for view `mydb`.`usuario_devedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`usuario_devedores` (`usr_nm_nome` INT, `usr_nu_cpf` INT, `usr_nu_telefone` INT, `usr_ds_endereco` INT, `usr_id_usuario` INT, `emp_dt_emprestimo` INT, `emp_dt_prevista` INT, `mat_ds_titulo` INT, `mat_id_material` INT);

-- -----------------------------------------------------
-- Placeholder table for view `mydb`.`usuario_reservas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`usuario_reservas` (`usr_nm_nome` INT, `usr_nu_cpf` INT, `usr_nu_telefone` INT, `usr_ds_endereco` INT, `usr_id_usuario` INT, `mat_ds_titulo` INT, `mat_id_material` INT, `res_dt_reserva` INT);

-- -----------------------------------------------------
-- View `mydb`.`usuario_devedores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`usuario_devedores`;
USE `mydb`;
CREATE OR REPLACE VIEW usuario_devedores AS 
SELECT usr_usuario.usr_nm_nome,
usr_usuario.usr_nu_cpf,
usr_usuario.usr_nu_telefone,
usr_usuario.usr_ds_endereco,
usr_usuario.usr_id_usuario,
emp_emprestimo.emp_dt_emprestimo,
emp_emprestimo.emp_dt_prevista,
mat_material.mat_ds_titulo,
mat_material.mat_id_material
FROM usr_usuario, 
emp_emprestimo,
mat_material
where usr_usuario.usr_id_usuario = emp_emprestimo.emp_id_usuario 
AND emp_emprestimo.emp_dt_prevista < NOW()
AND emp_emprestimo.emp_id_material = mat_material.mat_id_material
ORDER BY emp_emprestimo.emp_dt_prevista;

-- -----------------------------------------------------
-- View `mydb`.`usuario_reservas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`usuario_reservas`;
USE `mydb`;
CREATE OR REPLACE VIEW usuario_reservas AS 
SELECT usr_usuario.usr_nm_nome,
usr_usuario.usr_nu_cpf,
usr_usuario.usr_nu_telefone,
usr_usuario.usr_ds_endereco,
usr_usuario.usr_id_usuario,
mat_material.mat_ds_titulo,
mat_material.mat_id_material,
res_reserva.res_dt_reserva
FROM usr_usuario,
res_reserva,
mat_material
where usr_usuario.usr_id_usuario = res_reserva.res_id_usuario 
ORDER BY res_reserva.res_dt_reserva;
USE `mydb`;

DELIMITER $$
USE `mydb`$$
CREATE DEFINER = CURRENT_USER TRIGGER `mydb`.`alu_aluno_BEFORE_DELETE` BEFORE DELETE ON `alu_aluno` FOR EACH ROW
BEGIN
INSERT INTO alx_aluno_excluido
SELECT * FROM alu_aluno alu WHERE alu.alu_id_usuario = alu_id_usuario;

update usr_usuario
set usr_ch_inativo = 'S'
where usr_id_usuario = alu_id_usuario;
END$$

USE `mydb`$$
CREATE DEFINER = CURRENT_USER TRIGGER `mydb`.`alu_aluno_AFTER_INSERT` AFTER INSERT ON `alu_aluno` FOR EACH ROW
BEGIN
update usr_usuario
set usr_ch_inativo = 'N'
where usr_id_usuario = alu_id_usuario;
END$$

USE `mydb`$$
CREATE DEFINER = CURRENT_USER TRIGGER `mydb`.`pro_professor_BEFORE_DELETE` BEFORE DELETE ON `pro_professor` FOR EACH ROW
BEGIN
INSERT INTO prx_professor_excluido
SELECT * FROM pro_professor prof WHERE prof.pro_id_usuario = pro_id_usuario;

update usr_usuario
set usr_ch_inativo = 'S'
where usr_id_usuario = pro_id_usuario;
END$$

USE `mydb`$$
CREATE DEFINER = CURRENT_USER TRIGGER `mydb`.`pro_professor_AFTER_INSERT` AFTER INSERT ON `pro_professor` FOR EACH ROW
BEGIN
update usr_usuario
set usr_ch_inativo = 'N'
where usr_id_usuario = pro_id_usuario;
END$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
