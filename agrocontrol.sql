-- MariaDB dump 10.19  Distrib 10.4.24-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: agrocontrol
-- ------------------------------------------------------
-- Server version	10.4.24-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `area` (
  `ID_Area` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre_Area` varchar(25) DEFAULT NULL,
  `Ancho_Area` int(11) DEFAULT NULL,
  `Largo_Area` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_Area`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras`
--

DROP TABLE IF EXISTS `compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compras` (
  `IdCompra` int(11) NOT NULL AUTO_INCREMENT,
  `Fecha_compra` date DEFAULT NULL,
  `N_Factura` varchar(40) DEFAULT NULL,
  `Nombre_Proveedor` varchar(15) DEFAULT NULL,
  `Total_Compra` int(25) NOT NULL,
  PRIMARY KEY (`IdCompra`),
  KEY `Nombre_Proveedor` (`Nombre_Proveedor`),
  CONSTRAINT `compras_ibfk_1` FOREIGN KEY (`Nombre_Proveedor`) REFERENCES `proveedores` (`Nit`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras`
--

LOCK TABLES `compras` WRITE;
/*!40000 ALTER TABLE `compras` DISABLE KEYS */;
INSERT INTO `compras` VALUES (1,'2022-04-07','0001','1090415521-6',8500);
/*!40000 ALTER TABLE `compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consumos`
--

DROP TABLE IF EXISTS `consumos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consumos` (
  `IdAplicacion` int(11) NOT NULL AUTO_INCREMENT,
  `Fecha_Aplicacion` date DEFAULT NULL,
  `Tipo_Cultivo` varchar(40) DEFAULT NULL,
  `Nombre_Cosecha` int(11) DEFAULT NULL,
  `Area` int(11) DEFAULT NULL,
  `Tipo_Cosecha` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdAplicacion`),
  KEY `Tipo_Cosecha` (`Tipo_Cosecha`),
  KEY `Area` (`Area`),
  KEY `Nombre_Cosecha` (`Nombre_Cosecha`),
  CONSTRAINT `consumos_ibfk_1` FOREIGN KEY (`Tipo_Cosecha`) REFERENCES `tipo_cosecha` (`IDTipoCosecha`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `consumos_ibfk_2` FOREIGN KEY (`Area`) REFERENCES `area` (`ID_Area`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `consumos_ibfk_3` FOREIGN KEY (`Nombre_Cosecha`) REFERENCES `cosecha` (`IdCosecha`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consumos`
--

LOCK TABLES `consumos` WRITE;
/*!40000 ALTER TABLE `consumos` DISABLE KEYS */;
/*!40000 ALTER TABLE `consumos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cosecha`
--

DROP TABLE IF EXISTS `cosecha`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cosecha` (
  `IdCosecha` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre_Cosecha` varchar(40) DEFAULT NULL,
  `Tipo_Cultivo` varchar(40) DEFAULT NULL,
  `Tipo_Cosecha` int(11) DEFAULT NULL,
  `Fecha_Siembra` text DEFAULT NULL,
  `Fecha_Recoleccion` text DEFAULT NULL,
  PRIMARY KEY (`IdCosecha`),
  KEY `Tipo_Cosecha` (`Tipo_Cosecha`),
  CONSTRAINT `cosecha_ibfk_1` FOREIGN KEY (`Tipo_Cosecha`) REFERENCES `tipo_cosecha` (`IDTipoCosecha`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cosecha`
--

LOCK TABLES `cosecha` WRITE;
/*!40000 ALTER TABLE `cosecha` DISABLE KEYS */;
/*!40000 ALTER TABLE `cosecha` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallecompra`
--

DROP TABLE IF EXISTS `detallecompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallecompra` (
  `id` int(11) NOT NULL,
  `Nombre_producto` int(11) NOT NULL,
  `Cantidad_Producto` int(15) NOT NULL,
  `Valor_Unitario` int(20) NOT NULL,
  `Subtotal` int(25) NOT NULL,
  KEY `id` (`id`),
  KEY `Nombre_producto` (`Nombre_producto`),
  CONSTRAINT `detallecompra_ibfk_1` FOREIGN KEY (`id`) REFERENCES `compras` (`IdCompra`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `detallecompra_ibfk_2` FOREIGN KEY (`Nombre_producto`) REFERENCES `productos` (`Codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallecompra`
--

LOCK TABLES `detallecompra` WRITE;
/*!40000 ALTER TABLE `detallecompra` DISABLE KEYS */;
INSERT INTO `detallecompra` VALUES (1,34,1,2500,2500),(1,34,6,1000,6000);
/*!40000 ALTER TABLE `detallecompra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleconsumos`
--

DROP TABLE IF EXISTS `detalleconsumos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalleconsumos` (
  `IDConsumos` int(11) NOT NULL,
  `NombreProducto` int(11) NOT NULL,
  `Cantidad` int(15) NOT NULL,
  KEY `IDConsumos` (`IDConsumos`),
  KEY `NombreProducto` (`NombreProducto`),
  CONSTRAINT `detalleconsumos_ibfk_1` FOREIGN KEY (`IDConsumos`) REFERENCES `consumos` (`IdAplicacion`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `detalleconsumos_ibfk_2` FOREIGN KEY (`NombreProducto`) REFERENCES `productos` (`Codigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleconsumos`
--

LOCK TABLES `detalleconsumos` WRITE;
/*!40000 ALTER TABLE `detalleconsumos` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalleconsumos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventario`
--

DROP TABLE IF EXISTS `inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventario` (
  `invCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `invEntradas` int(11) NOT NULL,
  `invSalidas` int(11) NOT NULL,
  PRIMARY KEY (`invCodigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventario`
--

LOCK TABLES `inventario` WRITE;
/*!40000 ALTER TABLE `inventario` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productos` (
  `Codigo` int(11) NOT NULL,
  `Nombre` varchar(40) DEFAULT NULL,
  `Descripcion` varchar(40) DEFAULT NULL,
  `IngredienteActivo` varchar(40) DEFAULT NULL,
  `FechadeVencimiento` text DEFAULT NULL,
  `UnidaddeMedida` int(11) DEFAULT NULL,
  `TipodeProducto` int(11) DEFAULT NULL,
  PRIMARY KEY (`Codigo`),
  KEY `TipodeProducto` (`TipodeProducto`),
  KEY `UnidaddeMedida` (`UnidaddeMedida`),
  CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`TipodeProducto`) REFERENCES `tipodeproducto` (`idtipoproducto`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `productos_ibfk_2` FOREIGN KEY (`UnidaddeMedida`) REFERENCES `unimedidatproducto` (`IDuniMedida`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (34,'Producto','descripcion','Ingrediente','07/04/2023 ',1,1);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedores` (
  `Nit` varchar(15) NOT NULL,
  `Nombre` varchar(40) DEFAULT NULL,
  `Direccion` varchar(50) DEFAULT NULL,
  `Correo` varchar(30) DEFAULT NULL,
  `Telefono` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Nit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES ('1090415521-6','Javier Pacheco','MZ 30 LOTE 431-D','javier.709@hotmail.com','3156372069');
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_cosecha`
--

DROP TABLE IF EXISTS `tipo_cosecha`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_cosecha` (
  `IDTipoCosecha` int(11) NOT NULL AUTO_INCREMENT,
  `TipoCosecha` varchar(40) NOT NULL,
  PRIMARY KEY (`IDTipoCosecha`),
  KEY `TipoCosecha` (`TipoCosecha`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_cosecha`
--

LOCK TABLES `tipo_cosecha` WRITE;
/*!40000 ALTER TABLE `tipo_cosecha` DISABLE KEYS */;
INSERT INTO `tipo_cosecha` VALUES (1,'Tomate');
/*!40000 ALTER TABLE `tipo_cosecha` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipodeproducto`
--

DROP TABLE IF EXISTS `tipodeproducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipodeproducto` (
  `idtipoproducto` int(11) NOT NULL AUTO_INCREMENT,
  `TipodeProducto` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`idtipoproducto`),
  KEY `TipodeProductoo` (`TipodeProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipodeproducto`
--

LOCK TABLES `tipodeproducto` WRITE;
/*!40000 ALTER TABLE `tipodeproducto` DISABLE KEYS */;
INSERT INTO `tipodeproducto` VALUES (1,'Tomate');
/*!40000 ALTER TABLE `tipodeproducto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unimedidatproducto`
--

DROP TABLE IF EXISTS `unimedidatproducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unimedidatproducto` (
  `IDuniMedida` int(11) NOT NULL AUTO_INCREMENT,
  `UnidaddeMedidaDato` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`IDuniMedida`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unimedidatproducto`
--

LOCK TABLES `unimedidatproducto` WRITE;
/*!40000 ALTER TABLE `unimedidatproducto` DISABLE KEYS */;
INSERT INTO `unimedidatproducto` VALUES (1,'Gramos');
/*!40000 ALTER TABLE `unimedidatproducto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `TipoUsuario` varchar(25) DEFAULT NULL,
  `Usuario` varchar(25) DEFAULT NULL,
  `Contrasena` varchar(25) DEFAULT NULL,
  `Nombres` varchar(25) DEFAULT NULL,
  `Apellidos` varchar(25) DEFAULT NULL,
  `Direccion` varchar(50) DEFAULT NULL,
  `Telefono` float DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Super administrador','Admin','123',NULL,NULL,NULL,NULL,NULL),(2,'Administrador','usuario','123',NULL,NULL,NULL,NULL,NULL),(3,'Administrador','prueba','123','prueba','prueba','agfgf',2343,'gfgasfg');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-08 22:37:19
