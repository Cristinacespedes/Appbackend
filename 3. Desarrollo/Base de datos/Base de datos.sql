-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.6.4-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para tienda_generica
CREATE DATABASE IF NOT EXISTS `tienda_generica` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `tienda_generica`;

-- Volcando estructura para tabla tienda_generica.clientes
CREATE TABLE IF NOT EXISTS `clientes` (
  `cedula_cliente` bigint(20) NOT NULL DEFAULT 0,
  `direccion_cliente` varchar(255) DEFAULT NULL,
  `email_cliente` varchar(255) DEFAULT NULL,
  `nombre_cliente` varchar(255) DEFAULT NULL,
  `telefono_cliente` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cedula_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla tienda_generica.clientes: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` (`cedula_cliente`, `direccion_cliente`, `email_cliente`, `nombre_cliente`, `telefono_cliente`) VALUES
	(654321, 'Carrera 321 #56-77', 'sergio@mail.com', 'andres Felipe Perez', '5555577'),
	(7654321, 'Carrera 321 #56-77', 'maria@mail.com', 'maria Perez', '5555555');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;

-- Volcando estructura para tabla tienda_generica.detalle_ventas
CREATE TABLE IF NOT EXISTS `detalle_ventas` (
  `codigo_detalle_venta` bigint(20) NOT NULL,
  `cantidad_producto` int(11) NOT NULL DEFAULT 0,
  `codigo_producto` bigint(20) NOT NULL DEFAULT 0,
  `codigo_venta` bigint(20) NOT NULL DEFAULT 0,
  `valor_total` double NOT NULL DEFAULT 0,
  `valor_venta` double NOT NULL DEFAULT 0,
  `valoriva` double NOT NULL DEFAULT 0,
  PRIMARY KEY (`codigo_detalle_venta`),
  KEY `FK_detalle_ventas_ventas` (`codigo_venta`),
  KEY `FK_detalle_ventas_productos` (`codigo_producto`),
  CONSTRAINT `FK_detalle_ventas_productos` FOREIGN KEY (`codigo_producto`) REFERENCES `productos` (`codigo_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_detalle_ventas_ventas` FOREIGN KEY (`codigo_venta`) REFERENCES `ventas` (`codigo_venta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla tienda_generica.detalle_ventas: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `detalle_ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_ventas` ENABLE KEYS */;

-- Volcando estructura para tabla tienda_generica.productos
CREATE TABLE IF NOT EXISTS `productos` (
  `codigo_producto` bigint(20) NOT NULL DEFAULT 0,
  `ivacompra` double NOT NULL,
  `nitproveedor` bigint(20) NOT NULL DEFAULT 0,
  `nombre_producto` varchar(255) NOT NULL DEFAULT '0',
  `precio_compra` double NOT NULL DEFAULT 0,
  `precio_venta` double NOT NULL DEFAULT 0,
  PRIMARY KEY (`codigo_producto`),
  KEY `FK_productos_proveedores` (`nitproveedor`),
  CONSTRAINT `FK_productos_proveedores` FOREIGN KEY (`nitproveedor`) REFERENCES `proveedores` (`nitproveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla tienda_generica.productos: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;

-- Volcando estructura para tabla tienda_generica.proveedores
CREATE TABLE IF NOT EXISTS `proveedores` (
  `nitproveedor` bigint(20) NOT NULL DEFAULT 0,
  `ciudad_proveedor` varchar(255) NOT NULL DEFAULT '0',
  `direccion_proveedor` varchar(255) NOT NULL DEFAULT '0',
  `nombre_proveedor` varchar(255) NOT NULL DEFAULT '0',
  `telefono_proveedor` varchar(255) NOT NULL DEFAULT '0',
  PRIMARY KEY (`nitproveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla tienda_generica.proveedores: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;

-- Volcando estructura para tabla tienda_generica.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `cedula_usuario` bigint(20) NOT NULL COMMENT 'campo del numero de identificacion y es llave primaria',
  `email_usuario` varchar(255) NOT NULL COMMENT 'correo electronico del usuario y debe ser unico',
  `nombre_usuario` varchar(255) NOT NULL COMMENT 'nombres y apellidos del usuario',
  `password` varchar(255) NOT NULL COMMENT 'campo para almacenar la contraseña',
  `usuario` varchar(255) NOT NULL COMMENT 'Campo de identificacion del usuario',
  PRIMARY KEY (`cedula_usuario`),
  UNIQUE KEY `usuario` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla que representa los actores o personas que pueden utilizar y acceder al sistema';

-- Volcando datos para la tabla tienda_generica.usuarios: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`cedula_usuario`, `email_usuario`, `nombre_usuario`, `password`, `usuario`) VALUES
	(0, ' ', ' ', 'admin123456', 'admininicial'),
	(1111, 'clopez@mail.com', 'carlos', '12345', 'clopez'),
	(123456, 'carloslo@mail.com', 'carlos lopez', '1234567', 'calopez'),
	(1234568, 'prueba@mail.com', 'prueba contreras', '123456', 'prueba'),
	(12345678, 'ccontreras@mail.com', 'cesar contreras', '123456', 'ccontreras'),
	(36424555, 'pruebacrear@gmail.com', 'usuario de prueba crear', '32145', 'pruebaUsuario'),
	(64105512, 'prueba2@mail.com', 'ususario de prueba 2', '8545321', 'prueba2'),
	(1014210446, 'cesarxc@gmail.com', 'cesar armando', '12345', 'CESARC');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;

-- Volcando estructura para tabla tienda_generica.ventas
CREATE TABLE IF NOT EXISTS `ventas` (
  `codigo_venta` bigint(20) NOT NULL DEFAULT 0,
  `cedula_cliente` bigint(20) NOT NULL,
  `cedula_usuario` bigint(20) NOT NULL,
  `ivaventa` double NOT NULL DEFAULT 0,
  `total_venta` double NOT NULL DEFAULT 0,
  `valor_venta` double NOT NULL DEFAULT 0,
  PRIMARY KEY (`codigo_venta`),
  KEY `FK_ventas_clientes` (`cedula_cliente`),
  KEY `FK_ventas_usuarios` (`cedula_usuario`),
  CONSTRAINT `FK_ventas_clientes` FOREIGN KEY (`cedula_cliente`) REFERENCES `clientes` (`cedula_cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ventas_usuarios` FOREIGN KEY (`cedula_usuario`) REFERENCES `usuarios` (`cedula_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla tienda_generica.ventas: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
