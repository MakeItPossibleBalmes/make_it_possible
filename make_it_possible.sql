-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema make_it_possible
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `make_it_possible` ;

-- -----------------------------------------------------
-- Schema make_it_possible
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `make_it_possible` DEFAULT CHARACTER SET utf8 ;
USE `make_it_possible` ;

-- -----------------------------------------------------
-- Table `make_it_possible`.`categorias`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `make_it_possible`.`categorias` ;

CREATE TABLE IF NOT EXISTS `make_it_possible`.`categorias` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nombre` (`nombre` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `make_it_possible`.`usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `make_it_possible`.`usuarios` ;

CREATE TABLE IF NOT EXISTS `make_it_possible`.`usuarios` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `dni` VARCHAR(9) NULL DEFAULT NULL,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(64) NOT NULL,
  `nombre` VARCHAR(75) NOT NULL,
  `primer_apellido` VARCHAR(75) NOT NULL,
  `segundo_apellido` VARCHAR(75) NULL DEFAULT NULL,
  `codigo_postal` INT(5) NULL DEFAULT NULL,
  `ciudad` VARCHAR(65) NOT NULL,
  `pais` VARCHAR(65) NOT NULL,
  `is_admin` TINYINT(1) NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email` (`email` ASC),
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `make_it_possible`.`temas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `make_it_possible`.`temas` ;

CREATE TABLE IF NOT EXISTS `make_it_possible`.`temas` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(255) NOT NULL,
  `cuerpo` TEXT NOT NULL,
  `fecha_creacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `usuario_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `usuario_id`),
  INDEX `fk_tema_usuario1_idx` (`usuario_id` ASC),
  CONSTRAINT `fk_tema_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `make_it_possible`.`usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `make_it_possible`.`tema_categoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `make_it_possible`.`tema_categoria` ;

CREATE TABLE IF NOT EXISTS `make_it_possible`.`tema_categoria` (
  `tema_id` INT(11) NOT NULL,
  `categoria_id` INT(11) NOT NULL,
  PRIMARY KEY (`tema_id`, `categoria_id`),
  INDEX `fk_tema_has_categoria_categoria1_idx` (`categoria_id` ASC),
  INDEX `fk_tema_has_categoria_tema_idx` (`tema_id` ASC),
  CONSTRAINT `fk_tema_has_categoria_categoria1`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `make_it_possible`.`categorias` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tema_has_categoria_tema`
    FOREIGN KEY (`tema_id`)
    REFERENCES `make_it_possible`.`temas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `make_it_possible`.`voto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `make_it_possible`.`voto` ;

CREATE TABLE IF NOT EXISTS `make_it_possible`.`voto` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `usuario_id` INT(11) NOT NULL,
  `tema_id` INT(11) NOT NULL,
  `fecha_creacion` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`, `usuario_id`, `tema_id`),
  INDEX `fk_usuarios_has_temas_temas1_idx` (`tema_id` ASC),
  INDEX `fk_usuarios_has_temas_usuarios1_idx` (`usuario_id` ASC),
  CONSTRAINT `fk_usuarios_has_temas_temas1`
    FOREIGN KEY (`tema_id`)
    REFERENCES `make_it_possible`.`temas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarios_has_temas_usuarios1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `make_it_possible`.`usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
