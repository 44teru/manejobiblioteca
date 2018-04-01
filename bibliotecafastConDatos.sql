-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-06-2017 a las 21:48:16
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bibliotecafast`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autor`
--

CREATE TABLE `autor` (
  `cod_autor` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `ape_paterno` varchar(20) NOT NULL,
  `ape_materno` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `autor`
--

INSERT INTO `autor` (`cod_autor`, `nombre`, `ape_paterno`, `ape_materno`) VALUES
(1, 'Camilo Andres', 'Fuentealba', 'Perez'),
(2, 'Francisca Andrea', 'Andrade', 'Alvarez'),
(3, 'Rodrigo Andres', 'Valdivia', 'Teuber'),
(4, 'Jessica Maria', 'Soto', 'Martinez'),
(5, 'Guillermo Marcelo', 'Madrid', 'Madrid'),
(6, 'Sandra Andrea', 'Salgado', 'Rios'),
(7, 'Daniel Javier', 'Barrera', 'Zapata'),
(8, 'Martina Juana', 'Montes', 'Rayz'),
(9, 'Marcelo Camilo', 'Jara', 'Jara'),
(10, 'Marta Magdalena', 'Silva', 'Valdivia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autor_libro`
--

CREATE TABLE `autor_libro` (
  `libro_serie` int(11) NOT NULL,
  `autor_cod_autor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `autor_libro`
--

INSERT INTO `autor_libro` (`libro_serie`, `autor_cod_autor`) VALUES
(1, 1),
(1, 10),
(2, 5),
(2, 7),
(3, 4),
(3, 8),
(4, 1),
(5, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `cod_cate` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`cod_cate`, `nombre`) VALUES
(1, 'Ficcion'),
(2, 'Comedia'),
(3, 'Accion'),
(4, 'Espacial'),
(5, 'Infantil'),
(6, 'Parodia'),
(7, 'Deportes'),
(8, 'Aventuras'),
(9, 'Historico'),
(10, 'Romance'),
(11, 'Terror');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria_libro`
--

CREATE TABLE `categoria_libro` (
  `categoria_cod_cate` int(11) NOT NULL,
  `libro_serie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `categoria_libro`
--

INSERT INTO `categoria_libro` (`categoria_cod_cate`, `libro_serie`) VALUES
(1, 2),
(2, 4),
(3, 1),
(4, 2),
(5, 3),
(6, 5),
(7, 2),
(8, 3),
(9, 2),
(10, 1),
(11, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE `compra` (
  `id` int(11) NOT NULL,
  `precio` int(11) NOT NULL,
  `libro_serie` int(11) NOT NULL,
  `factura_folio_fac` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `compra`
--

INSERT INTO `compra` (`id`, `precio`, `libro_serie`, `factura_folio_fac`) VALUES
(1, 25000, 4, 5),
(2, 15000, 1, 4),
(3, 32000, 2, 3),
(4, 9000, 3, 1),
(5, 45000, 2, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `distribuidor`
--

CREATE TABLE `distribuidor` (
  `rut_dis` varchar(9) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `calle` varchar(30) NOT NULL,
  `numero` int(11) NOT NULL,
  `comuna` varchar(30) NOT NULL,
  `pais` varchar(30) NOT NULL,
  `fono` int(11) NOT NULL,
  `año_contrato` year(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `distribuidor`
--

INSERT INTO `distribuidor` (`rut_dis`, `nombre`, `calle`, `numero`, `comuna`, `pais`, `fono`, `año_contrato`) VALUES
('102365879', 'The WordFiction', 'Port Sunshain', 1540, 'San Francisco', 'Estados Unidos', 2147483647, 2017),
('154789586', 'Robles', 'Rios del Sol', 2, 'Buenos Aires', 'Argentina', 2147483647, 1985),
('701542545', 'Los Hermanos', 'Picarte', 15, 'Santiago', 'Chile', 958745866, 1998),
('77859415k', 'Ziggs', 'Diego de Almagro', 500, 'Valparaiso', 'Chile', 985784595, 2007),
('801547896', 'Icarito', 'Balmaceda', 4000, 'Valdivia', 'Chile', 987458000, 2000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `editorial`
--

CREATE TABLE `editorial` (
  `cod_edi` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `editorial`
--

INSERT INTO `editorial` (`cod_edi`, `nombre`) VALUES
(1, 'Soles'),
(2, 'Zig Zag'),
(3, 'Romanx'),
(4, 'LibrosTom'),
(5, 'SanPaper');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

CREATE TABLE `estado` (
  `cod_estado` int(11) NOT NULL,
  `descripcion` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estado`
--

INSERT INTO `estado` (`cod_estado`, `descripcion`) VALUES
(1, 'Disponible'),
(2, 'Arrendados'),
(3, 'Inventario');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `folio_fac` int(11) NOT NULL,
  `precio_neto` int(11) NOT NULL,
  `costo_iva` int(11) NOT NULL,
  `precio_total` int(11) NOT NULL,
  `fecha_compra` date NOT NULL,
  `hora` time NOT NULL,
  `distribuidor_rut_dis` varchar(9) NOT NULL,
  `metodo_pago_cod_metod` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`folio_fac`, `precio_neto`, `costo_iva`, `precio_total`, `fecha_compra`, `hora`, `distribuidor_rut_dis`, `metodo_pago_cod_metod`) VALUES
(1, 15000, 2850, 17850, '2007-05-01', '15:00:00', '102365879', 7),
(2, 17000, 3230, 20230, '2009-02-20', '14:15:01', '77859415k', 5),
(3, 24000, 4560, 28560, '2003-11-21', '20:30:00', '701542545', 2),
(4, 41000, 7790, 48790, '2010-04-10', '16:12:50', '102365879', 4),
(5, 12000, 2280, 14280, '2016-08-23', '11:45:00', '154789586', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `idioma`
--

CREATE TABLE `idioma` (
  `cod_idioma` int(11) NOT NULL,
  `lengua` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `idioma`
--

INSERT INTO `idioma` (`cod_idioma`, `lengua`) VALUES
(1, 'Español'),
(2, 'Ingles'),
(3, 'Portugues'),
(4, 'Frances'),
(5, 'Aleman'),
(6, 'Japones'),
(7, 'Chino Mandarin'),
(8, 'Griego'),
(9, 'Catalan'),
(10, 'Indu');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `idioma_libro`
--

CREATE TABLE `idioma_libro` (
  `idioma_cod_idioma` int(11) NOT NULL,
  `libro_serie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `idioma_libro`
--

INSERT INTO `idioma_libro` (`idioma_cod_idioma`, `libro_serie`) VALUES
(1, 5),
(2, 4),
(3, 3),
(4, 2),
(5, 1),
(6, 2),
(7, 4),
(8, 4),
(9, 1),
(10, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `serie` int(11) NOT NULL,
  `isbn` int(11) NOT NULL,
  `titulo` varchar(30) NOT NULL,
  `paginas` int(11) NOT NULL,
  `precio` int(11) NOT NULL,
  `año` year(4) NOT NULL,
  `editorial_cod_edi` int(11) NOT NULL,
  `estado_cod_estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`serie`, `isbn`, `titulo`, `paginas`, `precio`, `año`, `editorial_cod_edi`, `estado_cod_estado`) VALUES
(1, 2147483647, 'Programacion C#', 250, 25000, 1975, 2, 1),
(2, 2147483647, 'C++ for Dumpies', 100, 10000, 1952, 4, 3),
(3, 2147483647, 'JAVA By ORACLE', 195, 40000, 2000, 5, 2),
(4, 2147483647, 'MySQL By ORACLE', 210, 47000, 1997, 3, 1),
(5, 2147483647, 'Aprende Pyton en 1 semana', 108, 41000, 2004, 4, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `metodo_pago`
--

CREATE TABLE `metodo_pago` (
  `cod_metod` int(11) NOT NULL,
  `descripcion` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `metodo_pago`
--

INSERT INTO `metodo_pago` (`cod_metod`, `descripcion`) VALUES
(1, 'Tarjeta credito nacional'),
(2, 'Tarjeta credito Internacional'),
(3, 'Tarjeta debito'),
(4, 'Cheque al dia'),
(5, 'Transferencia'),
(6, 'Efectivo'),
(7, 'PayPal');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `autor`
--
ALTER TABLE `autor`
  ADD PRIMARY KEY (`cod_autor`);

--
-- Indices de la tabla `autor_libro`
--
ALTER TABLE `autor_libro`
  ADD PRIMARY KEY (`libro_serie`,`autor_cod_autor`),
  ADD KEY `autor_libro_autor_fk` (`autor_cod_autor`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`cod_cate`);

--
-- Indices de la tabla `categoria_libro`
--
ALTER TABLE `categoria_libro`
  ADD PRIMARY KEY (`categoria_cod_cate`,`libro_serie`),
  ADD KEY `categoria_libro_libro_fk` (`libro_serie`);

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`id`),
  ADD KEY `compra_factura_fk` (`factura_folio_fac`),
  ADD KEY `compra_libro_fk` (`libro_serie`);

--
-- Indices de la tabla `distribuidor`
--
ALTER TABLE `distribuidor`
  ADD PRIMARY KEY (`rut_dis`);

--
-- Indices de la tabla `editorial`
--
ALTER TABLE `editorial`
  ADD PRIMARY KEY (`cod_edi`);

--
-- Indices de la tabla `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`cod_estado`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`folio_fac`),
  ADD KEY `factura_distribuidor_fk` (`distribuidor_rut_dis`),
  ADD KEY `factura_metodo_pago_fk` (`metodo_pago_cod_metod`);

--
-- Indices de la tabla `idioma`
--
ALTER TABLE `idioma`
  ADD PRIMARY KEY (`cod_idioma`);

--
-- Indices de la tabla `idioma_libro`
--
ALTER TABLE `idioma_libro`
  ADD PRIMARY KEY (`idioma_cod_idioma`,`libro_serie`),
  ADD KEY `idioma_libro_libro_fk` (`libro_serie`);

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`serie`),
  ADD KEY `libro_editorial_fk` (`editorial_cod_edi`),
  ADD KEY `libro_estado_fk` (`estado_cod_estado`);

--
-- Indices de la tabla `metodo_pago`
--
ALTER TABLE `metodo_pago`
  ADD PRIMARY KEY (`cod_metod`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `autor_libro`
--
ALTER TABLE `autor_libro`
  ADD CONSTRAINT `autor_libro_autor_fk` FOREIGN KEY (`autor_cod_autor`) REFERENCES `autor` (`cod_autor`),
  ADD CONSTRAINT `autor_libro_libro_fk` FOREIGN KEY (`libro_serie`) REFERENCES `libro` (`serie`);

--
-- Filtros para la tabla `categoria_libro`
--
ALTER TABLE `categoria_libro`
  ADD CONSTRAINT `categoria_libro_categoria_fk` FOREIGN KEY (`categoria_cod_cate`) REFERENCES `categoria` (`cod_cate`),
  ADD CONSTRAINT `categoria_libro_libro_fk` FOREIGN KEY (`libro_serie`) REFERENCES `libro` (`serie`);

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `compra_factura_fk` FOREIGN KEY (`factura_folio_fac`) REFERENCES `factura` (`folio_fac`),
  ADD CONSTRAINT `compra_libro_fk` FOREIGN KEY (`libro_serie`) REFERENCES `libro` (`serie`);

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `factura_distribuidor_fk` FOREIGN KEY (`distribuidor_rut_dis`) REFERENCES `distribuidor` (`rut_dis`),
  ADD CONSTRAINT `factura_metodo_pago_fk` FOREIGN KEY (`metodo_pago_cod_metod`) REFERENCES `metodo_pago` (`cod_metod`);

--
-- Filtros para la tabla `idioma_libro`
--
ALTER TABLE `idioma_libro`
  ADD CONSTRAINT `idioma_libro_idioma_fk` FOREIGN KEY (`idioma_cod_idioma`) REFERENCES `idioma` (`cod_idioma`),
  ADD CONSTRAINT `idioma_libro_libro_fk` FOREIGN KEY (`libro_serie`) REFERENCES `libro` (`serie`);

--
-- Filtros para la tabla `libro`
--
ALTER TABLE `libro`
  ADD CONSTRAINT `libro_editorial_fk` FOREIGN KEY (`editorial_cod_edi`) REFERENCES `editorial` (`cod_edi`),
  ADD CONSTRAINT `libro_estado_fk` FOREIGN KEY (`estado_cod_estado`) REFERENCES `estado` (`cod_estado`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
