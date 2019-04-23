Use Clientes;

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `clientes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Acciones`
--

CREATE TABLE IF NOT EXISTS `Acciones` (
  `Idaccion` INT NOT NULL,
  `Accion` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`Idaccion`),
  KEY `Idaccion` (`Idaccion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Control`
--

CREATE TABLE IF NOT EXISTS `Control` (
  `Consecutivo` INT NULL,
  `CuentaCorreo` VARCHAR(50) NULL,
  `SMTP` VARCHAR(50) NULL,
  `Puerto` INT NULL
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Prospectos`
--


CREATE TABLE IF NOT EXISTS `Prospectos` (
  `Idprospecto` int(5) NOT NULL AUTO_INCREMENT,
  `Prospecto` VARCHAR(50) NULL,
  `Contacto` VARCHAR(50) NULL,
  `Cargo` VARCHAR(30) NULL,
  `Direccion` VARCHAR(100) NULL,
  `Estatus` VARCHAR(1) NULL,
  `Telefono` VARCHAR(30) NULL,
  `CorreoElectronico` VARCHAR(50) NULL,
  `PaginaWeb` VARCHAR(80) NULL,
  `Valoracion` VARCHAR(15) NULL,
  `MedioContacto` VARCHAR(30) NULL,
  `GiroEmpresa` VARCHAR(50) NULL,
  `FechaEstimadaCompra` VARCHAR(20) NULL,
  `Presupuesto` VARCHAR(20) NULL,
  PRIMARY KEY (`Idprospecto`),
  KEY `Idprospecto` (`Idprospecto`)
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `Tareas`
--


CREATE TABLE IF NOT EXISTS `Tareas` (
  `IdTarea` int(2) NOT NULL AUTO_INCREMENT,
  `Tarea` varchar(35) NULL,
  PRIMARY KEY (`Idtarea`),
  KEY `Idtarea` (`Idtarea`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



--
-- Estructura de tabla para la tabla `Tipos`
--


CREATE TABLE IF NOT EXISTS `Tipos` (
  `Idtipo` VARCHAR(3) NULL,
  `Tipo` varchar(10) NULL,
  PRIMARY KEY (`Idtipo`),
  KEY `Idtipo` (`Idtipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



--
-- Estructura de tabla para la tabla `Usuarios`
--



CREATE TABLE IF NOT EXISTS `Usuarios` (
  `Idusuario` INT NOT NULL,
  `Usuario` VARCHAR(25) NULL,
  `Nombre` VARCHAR(50) NULL,
  `Contrasena` VARCHAR(15) NULL,
  `Sucursal` VARCHAR(15) NULL,
  `Email` VARCHAR(50) NULL,
  `Area` VARCHAR(15) NULL,
  PRIMARY KEY (`Idusuario`),
  KEY `Idusuario` (`Idusuario`)
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

  
CREATE TABLE IF NOT EXISTS `Vendedores` (
  `Cve_Vendedor` VARCHAR(3) NULL,
  `Nom_Vendedor` VARCHAR(50) NULL
   ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
   
   
   
CREATE TABLE IF NOT EXISTS `AsignacionProspectos` (
  `IdAsignacion` int(5) NOT NULL AUTO_INCREMENT,
  `Prospecto` varchar(50) NULL,
  `Vendedor` varchar(50) NULL,
  PRIMARY KEY (`IdAsignacion`),
  KEY `IdAsignacion` (`IdAsignacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

   
CREATE TABLE IF NOT EXISTS `TareasEjecutivos` (
  `IdTareas` int(5) NOT NULL AUTO_INCREMENT, 
  `Vendedor` varchar(50) NULL,
  `Tarea` varchar(20) NULL,
  `Prospecto` VARCHAR(50) NULL,  
  `Fecha` varchar(20) NULL,
  `FechaTarea` varchar(30) NULL,
  `Observaciones` varchar(300) NULL,
  PRIMARY KEY (`IdTareas`),
  KEY `IdTareas` (`IdTareas`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `clientes`.`tareas` (`IdTarea`, `Tarea`) VALUES ('1', 'Llamada Telefonica');
INSERT INTO `clientes`.`tareas` (`IdTarea`, `Tarea`) VALUES ('2', 'Visita');
INSERT INTO `clientes`.`tareas` (`IdTarea`, `Tarea`) VALUES ('3', 'Videoconferencia');
INSERT INTO `clientes`.`tareas` (`IdTarea`, `Tarea`) VALUES ('4', 'Presentacion Demo');
INSERT INTO `clientes`.`tareas` (`IdTarea`, `Tarea`) VALUES ('5', 'Cotizacion');
INSERT INTO `clientes`.`tareas` (`IdTarea`, `Tarea`) VALUES ('6', 'Invitacion a Evento');


INSERT INTO `clientes`.`vendedores` (`Cve_Vendedor`, `Nom_Vendedor`) VALUES ('AMG', 'ALAN DAN MARTINEZ GONZALEZ');
INSERT INTO `clientes`.`vendedores` (`Cve_Vendedor`, `Nom_Vendedor`) VALUES ('CPD', 'CLAUDIA MARLENE POSADA DELGADILLO');
INSERT INTO `clientes`.`vendedores` (`Cve_Vendedor`, `Nom_Vendedor`) VALUES ('JMN', 'JOSE LUIS MARTINEZ NUÑEZ');
