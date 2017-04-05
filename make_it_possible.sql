-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 05, 2017 at 05:49 PM
-- Server version: 5.7.17-0ubuntu0.16.04.1
-- PHP Version: 7.0.17-2+deb.sury.org~xenial+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `make_it_possible`
--
CREATE DATABASE IF NOT EXISTS `make_it_possible` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `make_it_possible`;

-- --------------------------------------------------------

--
-- Table structure for table `categorias`
--
-- Creation: Apr 05, 2017 at 03:46 PM
-- Last update: Apr 05, 2017 at 03:46 PM
--

CREATE TABLE `categorias` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- RELATIONS FOR TABLE `categorias`:
--

-- --------------------------------------------------------

--
-- Table structure for table `temas`
--
-- Creation: Apr 05, 2017 at 03:44 PM
--

CREATE TABLE `temas` (
  `id` int(11) NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `cuerpo` text NOT NULL,
  `fecha_creacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- RELATIONS FOR TABLE `temas`:
--   `id_usuario`
--       `usuarios` -> `id`
--

-- --------------------------------------------------------

--
-- Table structure for table `temas_categorias`
--
-- Creation: Apr 05, 2017 at 03:44 PM
--

CREATE TABLE `temas_categorias` (
  `id` int(11) NOT NULL,
  `id_tema` int(11) NOT NULL,
  `id_categoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- RELATIONS FOR TABLE `temas_categorias`:
--   `id_categoria`
--       `categorias` -> `id`
--   `id_tema`
--       `temas` -> `id`
--

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--
-- Creation: Apr 05, 2017 at 03:48 PM
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `password` varchar(64) NOT NULL,
  `nombre` varchar(75) NOT NULL,
  `primer_apellido` varchar(75) NOT NULL,
  `segundo_apellido` varchar(75) DEFAULT NULL,
  `codigo_postal` int(5) NOT NULL,
  `ciudad` varchar(65) NOT NULL,
  `pais` varchar(65) NOT NULL,
  `is_admin` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- RELATIONS FOR TABLE `usuarios`:
--

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indexes for table `temas`
--
ALTER TABLE `temas`
  ADD PRIMARY KEY (`id`,`id_usuario`),
  ADD KEY `fk_tema_usuario1_idx` (`id_usuario`);

--
-- Indexes for table `temas_categorias`
--
ALTER TABLE `temas_categorias`
  ADD PRIMARY KEY (`id`,`id_tema`,`id_categoria`),
  ADD KEY `fk_tema_has_categoria_categoria1_idx` (`id_categoria`),
  ADD KEY `fk_tema_has_categoria_tema_idx` (`id_tema`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `dni_UNIQUE` (`dni`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categorias`
--
ALTER TABLE `categorias`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `temas`
--
ALTER TABLE `temas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `temas_categorias`
--
ALTER TABLE `temas_categorias`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `temas`
--
ALTER TABLE `temas`
  ADD CONSTRAINT `fk_tema_usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `temas_categorias`
--
ALTER TABLE `temas_categorias`
  ADD CONSTRAINT `fk_tema_has_categoria_categoria1` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tema_has_categoria_tema` FOREIGN KEY (`id_tema`) REFERENCES `temas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
