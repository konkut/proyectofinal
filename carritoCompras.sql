-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-06-2022 a las 03:50:33
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_ventas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carritos`
--

CREATE TABLE `carritos` (
  `id` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `fecha` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `nombre` varchar(32) NOT NULL,
  `correo` varchar(128) NOT NULL,
  `celular` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `nombre`, `correo`, `celular`) VALUES
(1, 'Macey Weaver', 'macey@mail.com', '77712345'),
(2, 'Caleb Buckner', 'fames@ornare.org', '70612345'),
(3, 'Ursula Gilliam', 'nec@lacus.ca', '79112345'),
(4, 'Karina Sharp', 'auctor@sed.com', '72012345'),
(7, 'Marco Perez', 'marco@mail.com', '71526789'),
(8, 'Pedro Marquez', 'peter@mail.com', '72054578'),
(9, 'Juan de Arco', 'juanita@mail.com', '77112456'),
(11, 'leo', 'leo@gmai.com', '77548106'),
(17, 'marcos', 'administrador@gmail.com', '2019-02-09'),
(18, 'marcos', 'luiskonkut@gmail.com', '70612341'),
(19, 'pedro', 'luiskonkut@gmail.com', '70612341'),
(20, 'pedro', 'luiskonkut@gmail.com', '70612341'),
(21, 'marcos', 'luiskonkut@gmail.com', '70612341'),
(22, 'pedro', 'luiskonkut@gmail.com', '70612341'),
(23, 'marcos', 'luiskonkut@gmail.com', '70612341'),
(24, 'marcos', 'luiskonkut@gmail.com', '70612341'),
(25, 'marcos', 'luiskonkut@gmail.com', '2019-02-09'),
(26, 'PEDRO LUIS', 'PEDROLUIS@GMAIL.COM', '77548105'),
(27, 'administrador', 'luiskonkut@gmail.com', '70612341'),
(28, 'marcos', 'luiskonkut@gmail.com', '70612341'),
(29, 'marcos', 'luiskonkut@gmail.com', '70612341'),
(30, 'marcos', 'luiskonkut@gmail.com', '70612341'),
(31, 'marcos', 'luiskonkut@gmail.com', '70612341'),
(32, 'marcos', 'luiskonkut@gmail.com', '70612341'),
(33, 'marcos', 'luiskonkut@gmail.com', '70612341'),
(34, 'marcos', 'luiskonkut@gmail.com', '70612341'),
(35, 'marcos', 'luiskonkut@gmail.com', '70612341'),
(36, 'marcos', 'luiskonkut@gmail.com', '70612341'),
(37, 'marcos', 'luiskonkut@gmail.com', '70612341'),
(38, 'marcos', 'luiskonkut@gmail.com', '70612341');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `domicilios`
--

CREATE TABLE `domicilios` (
  `id` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `nroPuerta` varchar(20) NOT NULL,
  `calle` varchar(50) NOT NULL,
  `ciudad` varchar(50) NOT NULL,
  `departamento` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `domicilios`
--

INSERT INTO `domicilios` (`id`, `idCliente`, `nroPuerta`, `calle`, `ciudad`, `departamento`) VALUES
(1, 11, '2413', 'Huancarani ', 'El Alto', 'La Paz'),
(2, 17, '2414', 'Huancarani', 'El Alto', 'La Paz'),
(3, 18, '2414', 'Huancarani', 'El Alto', 'La Paz'),
(4, 19, '2414', 'Huancarani', 'El Alto', 'La Paz'),
(5, 20, '2414', 'Huancarani', 'El Alto', 'Santa Cruz'),
(6, 21, '2414', 'Huancarani', 'El Alto', 'La Paz'),
(7, 22, '2414', 'Huancarani', 'El Alto', 'La Paz'),
(8, 23, '2414', 'Huancarani', 'El Alto', 'La Paz'),
(9, 24, '2414', 'Huancarani', 'El Alto', 'Santa Cruz'),
(10, 25, '2414', 'Huancarani', 'El Alto', 'La Paz'),
(11, 26, '2414', 'Huancarani', 'El Alto', 'La Paz'),
(12, 7, '2414', 'Huancarani', 'El Alto', 'Santa Cruz'),
(13, 27, '2414', 'Huancarani', 'El Alto', 'La Paz'),
(14, 28, '2414', 'Huancarani', 'El Alto', 'La Paz'),
(15, 29, '2414', 'Huancarani', 'El Alto', 'La Paz'),
(16, 30, '2414', 'Huancarani', 'El Alto', 'La Paz'),
(17, 31, '2414', 'Huancarani', 'El Alto', 'La Paz'),
(18, 32, '2414', 'Huancarani', 'El Alto', 'La Paz'),
(19, 33, '2414', 'Huancarani', 'El Alto', 'La Paz'),
(20, 34, '2414', 'Huancarani', 'El Alto', 'La Paz'),
(21, 35, '2414', 'Huancarani', 'El Alto', 'La Paz'),
(22, 36, '2414', 'Huancarani', 'El Alto', 'La Paz'),
(23, 37, '2414', 'Huancarani', 'El Alto', 'La Paz'),
(24, 38, '2414', 'Huancarani', 'El Alto', 'La Paz');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ordenes`
--

CREATE TABLE `ordenes` (
  `id` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idDomicilio` int(11) NOT NULL,
  `metodoPago` varchar(11) NOT NULL,
  `total` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ordenes`
--

INSERT INTO `ordenes` (`id`, `idCliente`, `idDomicilio`, `metodoPago`, `total`) VALUES
(1, 11, 1, 'Efectivo', 102.2),
(3, 26, 11, 'Efectivo', 40);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ordenesDetalle`
--

CREATE TABLE `ordenesDetalle` (
  `id` int(11) NOT NULL,
  `idOrden` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` float NOT NULL,
  `fecha` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ordenesDetalle`
--

INSERT INTO `ordenesDetalle` (`id`, `idOrden`, `idProducto`, `cantidad`, `precio`, `fecha`) VALUES
(1, 1, 11, 50, 100, '2022-05-25 00:00:00'),
(2, 1, 1, 12, 23, '2019-02-09 00:00:00'),
(3, 3, 1, 1, 40, '2022-06-28 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(32) NOT NULL,
  `descripcion` text NOT NULL,
  `precio` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `nombre`, `descripcion`, `precio`) VALUES
(1, 'Teclado Gamer', 'From Apples', 40),
(2, 'mouse', 'iPhone 5 from Apple', 30),
(3, 'pantalla', 'iPhone 5s is too expensive.', 200),
(4, 'pc', 'iPad Air is thin like samurai!', 250),
(5, 'impresora', 'Best of 2013', 250),
(6, 'camara web', 'God is not on sale. Sorry.', 132),
(7, 'Lenovo 2020', 'This sword is so sharp that it can slice itself. Good for slicing jellies.', 2000),
(8, 'Latitude e6420', 'Built by ultimate killing machines. For ultimate killing hobies.', 50),
(9, 'Toshiba xd456', 'This jacket could save you from heart attack. And maybe heartbreaks.', 50000),
(10, 'Dell vostro 456', 'This helps you brighten things in the dark.', 650),
(11, 'teclado', 'teclado gamer marca samsung', 13);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id`, `nombre`) VALUES
(1, 'usuario'),
(2, 'administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `nombres` varchar(50) DEFAULT NULL,
  `apellidos` varchar(80) DEFAULT NULL,
  `idRol` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `correo`, `password`, `nombres`, `apellidos`, `idRol`) VALUES
(7, 'luiskonkut@gmail.com', '8cb2237d0679ca88db6464eac60da96345513964', 'Pedro Luis', 'Condori Cutile', 1),
(8, 'usuario@gmail.com', 'da39a3ee5e6b4b0d3255bfef95601890afd80709', 'Leo', 'condori Cutile', 1),
(12, 'administrador@gmail.com', '8cb2237d0679ca88db6464eac60da96345513964', 'Omar', 'Perez', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `carritos`
--
ALTER TABLE `carritos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idCliente` (`idCliente`),
  ADD KEY `idProducto` (`idProducto`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- Indices de la tabla `domicilios`
--
ALTER TABLE `domicilios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idCliente` (`idCliente`);

--
-- Indices de la tabla `ordenes`
--
ALTER TABLE `ordenes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idCliente` (`idCliente`),
  ADD KEY `idDomicilio` (`idDomicilio`);

--
-- Indices de la tabla `ordenesDetalle`
--
ALTER TABLE `ordenesDetalle`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idOrden` (`idOrden`),
  ADD KEY `idProducto` (`idProducto`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idRol` (`idRol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `carritos`
--
ALTER TABLE `carritos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT de la tabla `domicilios`
--
ALTER TABLE `domicilios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `ordenes`
--
ALTER TABLE `ordenes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `ordenesDetalle`
--
ALTER TABLE `ordenesDetalle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `carritos`
--
ALTER TABLE `carritos`
  ADD CONSTRAINT `carritos_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`id`),
  ADD CONSTRAINT `carritos_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`id`);

--
-- Filtros para la tabla `domicilios`
--
ALTER TABLE `domicilios`
  ADD CONSTRAINT `domicilios_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`id`);

--
-- Filtros para la tabla `ordenes`
--
ALTER TABLE `ordenes`
  ADD CONSTRAINT `ordenes_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`id`),
  ADD CONSTRAINT `ordenes_ibfk_2` FOREIGN KEY (`idDomicilio`) REFERENCES `domicilios` (`id`);

--
-- Filtros para la tabla `ordenesDetalle`
--
ALTER TABLE `ordenesDetalle`
  ADD CONSTRAINT `ordenesdetalle_ibfk_1` FOREIGN KEY (`idOrden`) REFERENCES `ordenes` (`id`),
  ADD CONSTRAINT `ordenesdetalle_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`id`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`idRol`) REFERENCES `roles` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
