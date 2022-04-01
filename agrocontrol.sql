-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-04-2022 a las 15:38:39
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `agrocontrol`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `area`
--

CREATE TABLE `area` (
  `ID_Area` int(11) NOT NULL,
  `Nombre_Area` varchar(25) DEFAULT NULL,
  `Ancho_Area` int(11) DEFAULT NULL,
  `Largo_Area` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `area`
--

INSERT INTO `area` (`ID_Area`, `Nombre_Area`, `Ancho_Area`, `Largo_Area`) VALUES
(1, 'Area 1', 30, 30);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compras`
--

CREATE TABLE `compras` (
  `IdCompra` int(11) NOT NULL,
  `Fecha_compra` date DEFAULT NULL,
  `N_Factura` int(11) DEFAULT NULL,
  `Nombre_Proveedor` varchar(40) DEFAULT NULL,
  `Nombre_producto` varchar(40) DEFAULT NULL,
  `Cantidad_Producto` int(11) DEFAULT NULL,
  `Valor_Unitario` int(11) DEFAULT NULL,
  `Subtotal` int(11) DEFAULT NULL,
  `Total_Compra` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consumos`
--

CREATE TABLE `consumos` (
  `IdAplicacion` int(11) NOT NULL,
  `Fecha_Aplicacion` date DEFAULT NULL,
  `Tipo_Cultivo` varchar(40) DEFAULT NULL,
  `Nombre_Cosecha` varchar(40) DEFAULT NULL,
  `Area` varchar(40) DEFAULT NULL,
  `Tipo_Cosecha` varchar(40) DEFAULT NULL,
  `Nombre_Producto` varchar(40) DEFAULT NULL,
  `Cantidad_Producto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cosecha`
--

CREATE TABLE `cosecha` (
  `IdCosecha` int(11) NOT NULL,
  `Nombre_Cosecha` varchar(40) DEFAULT NULL,
  `Tipo_Cultivo` varchar(40) DEFAULT NULL,
  `Tipo_Cosecha` varchar(40) DEFAULT NULL,
  `Fecha_Siembra` text DEFAULT NULL,
  `Fecha_Recoleccion` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cosecha`
--

INSERT INTO `cosecha` (`IdCosecha`, `Nombre_Cosecha`, `Tipo_Cultivo`, `Tipo_Cosecha`, `Fecha_Siembra`, `Fecha_Recoleccion`) VALUES
(2432, 'Tomate', 'Transitorio', 'Tomate', '1/02/2022', '30/03/2022'),
(876587, 'Mango', 'Permanente', 'Mango', '12/01/2022', '22/03/2022');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

CREATE TABLE `inventario` (
  `invCodigo` int(11) NOT NULL,
  `invEntradas` int(11) NOT NULL,
  `invSalidas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `Codigo` int(11) NOT NULL,
  `Nombre` varchar(30) DEFAULT NULL,
  `Descripcion` varchar(40) DEFAULT NULL,
  `IngredienteActivo` varchar(40) DEFAULT NULL,
  `FechadeVencimiento` text DEFAULT NULL,
  `UnidaddeMedida` varchar(40) DEFAULT NULL,
  `TipodeProducto` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`Codigo`, `Nombre`, `Descripcion`, `IngredienteActivo`, `FechadeVencimiento`, `UnidaddeMedida`, `TipodeProducto`) VALUES
(54435, 'producto', 'un producto', 'no', '02/03/2023', 'Volumen', 'Insectisidas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `Nit` varchar(15) NOT NULL,
  `Nombre` varchar(40) DEFAULT NULL,
  `Direccion` varchar(50) DEFAULT NULL,
  `Correo` varchar(30) DEFAULT NULL,
  `Telefono` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`Nit`, `Nombre`, `Direccion`, `Correo`, `Telefono`) VALUES
('18877544-45', 'jose ', 'calle 3 #5-48', 'jose@gmial.com', '3135374962'),
('811013990-5', 'Linea Comunicaciones SAS', 'medellin', '365gfdggdf', '421345');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodeproducto`
--

CREATE TABLE `tipodeproducto` (
  `TipodeProductoo` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_cosecha`
--

CREATE TABLE `tipo_cosecha` (
  `IDTipoCosecha` int(11) NOT NULL,
  `Nombre_TipoCosecha` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_cosecha`
--

INSERT INTO `tipo_cosecha` (`IDTipoCosecha`, `Nombre_TipoCosecha`) VALUES
(1, 'Tomate'),
(2, 'Mango');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `unimedidatproducto`
--

CREATE TABLE `unimedidatproducto` (
  `UnidaddeMedidaDato` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `Id` int(11) NOT NULL,
  `TipoUsuario` varchar(25) DEFAULT NULL,
  `Usuario` varchar(25) DEFAULT NULL,
  `Contrasena` varchar(25) DEFAULT NULL,
  `Nombres` varchar(25) DEFAULT NULL,
  `Apellidos` varchar(25) DEFAULT NULL,
  `Direccion` varchar(50) DEFAULT NULL,
  `Telefono` float DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`Id`, `TipoUsuario`, `Usuario`, `Contrasena`, `Nombres`, `Apellidos`, `Direccion`, `Telefono`, `Email`) VALUES
(1, 'Super administrador', 'Admin', '123', NULL, NULL, NULL, NULL, NULL),
(2, 'Administrador', 'usuario', '123', NULL, NULL, NULL, NULL, NULL),
(3, 'Administrador', 'prueba', '123', 'prueba', 'prueba', 'agfgf', 2343, 'gfgasfg');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `area`
--
ALTER TABLE `area`
  ADD PRIMARY KEY (`ID_Area`);

--
-- Indices de la tabla `compras`
--
ALTER TABLE `compras`
  ADD PRIMARY KEY (`IdCompra`);

--
-- Indices de la tabla `consumos`
--
ALTER TABLE `consumos`
  ADD PRIMARY KEY (`IdAplicacion`);

--
-- Indices de la tabla `cosecha`
--
ALTER TABLE `cosecha`
  ADD PRIMARY KEY (`IdCosecha`);

--
-- Indices de la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD PRIMARY KEY (`invCodigo`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`Codigo`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`Nit`);

--
-- Indices de la tabla `tipo_cosecha`
--
ALTER TABLE `tipo_cosecha`
  ADD PRIMARY KEY (`IDTipoCosecha`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `area`
--
ALTER TABLE `area`
  MODIFY `ID_Area` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `compras`
--
ALTER TABLE `compras`
  MODIFY `IdCompra` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `consumos`
--
ALTER TABLE `consumos`
  MODIFY `IdAplicacion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cosecha`
--
ALTER TABLE `cosecha`
  MODIFY `IdCosecha` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=876588;

--
-- AUTO_INCREMENT de la tabla `inventario`
--
ALTER TABLE `inventario`
  MODIFY `invCodigo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_cosecha`
--
ALTER TABLE `tipo_cosecha`
  MODIFY `IDTipoCosecha` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
