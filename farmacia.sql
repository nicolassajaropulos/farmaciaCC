-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-07-2018 a las 23:37:18
-- Versión del servidor: 10.1.31-MariaDB
-- Versión de PHP: 7.1.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `farmacia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

CREATE TABLE `inventario` (
  `id_inventario` bigint(20) NOT NULL,
  `id_producto` bigint(20) NOT NULL,
  `cantidad` int(10) NOT NULL,
  `estatus` tinyint(1) NOT NULL,
  `fecha_creacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ultima_actualizacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `inventario`
--

INSERT INTO `inventario` (`id_inventario`, `id_producto`, `cantidad`, `estatus`, `fecha_creacion`, `ultima_actualizacion`) VALUES
(1, 1, 4, 1, '2018-07-09 17:30:57', '2018-07-09 21:32:27'),
(2, 2, 10, 1, '2018-07-09 20:21:19', '2018-07-09 21:32:42');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id_producto` bigint(20) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `precio` decimal(5,2) NOT NULL,
  `estatus` tinyint(1) NOT NULL,
  `fecha_creacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ultima_actualizacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id_producto`, `nombre`, `precio`, `estatus`, `fecha_creacion`, `ultima_actualizacion`) VALUES
(1, 'Paracetamol', '10.50', 1, '2018-07-09 17:30:57', '2018-07-09 17:30:57'),
(2, 'Ibuprofeno', '20.50', 1, '2018-07-09 20:21:19', '2018-07-09 20:21:19');

--
-- Disparadores `producto`
--
DELIMITER $$
CREATE TRIGGER `create_invetario` AFTER INSERT ON `producto` FOR EACH ROW BEGIN
		INSERT INTO inventario(id_producto, cantidad, estatus) VALUES(NEW.id_producto, 0, 1);
	END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `drop_invetario` AFTER DELETE ON `producto` FOR EACH ROW BEGIN
		DELETE FROM inventario WHERE id_producto = OLD.id_producto;
	END
$$
DELIMITER ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD PRIMARY KEY (`id_inventario`),
  ADD KEY `id_producto` (`id_producto`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id_producto`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `inventario`
--
ALTER TABLE `inventario`
  MODIFY `id_inventario` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id_producto` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD CONSTRAINT `fk_inventario_producto` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
