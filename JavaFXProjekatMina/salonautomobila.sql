-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 30, 2020 at 10:55 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.3.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `salonautomobila`
--

-- --------------------------------------------------------

--
-- Table structure for table `brendauta`
--

CREATE TABLE `brendauta` (
  `IDbrendAuta` int(11) NOT NULL,
  `NazivBrenda` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `brendauta`
--

INSERT INTO `brendauta` (`IDbrendAuta`, `NazivBrenda`) VALUES
(1, 'Mercedes'),
(2, 'BMW'),
(3, 'Fiat'),
(4, 'Audi');

-- --------------------------------------------------------

--
-- Table structure for table `dodatnaoprema`
--

CREATE TABLE `dodatnaoprema` (
  `IDdodatnaOprema` int(11) NOT NULL,
  `IDbrendAuta` int(11) NOT NULL,
  `LetnjeGume` double DEFAULT NULL,
  `ZimskeGume` double DEFAULT NULL,
  `KrovniKofer` double DEFAULT NULL,
  `NosacZaBicikle` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dodatnaoprema`
--

INSERT INTO `dodatnaoprema` (`IDdodatnaOprema`, `IDbrendAuta`, `LetnjeGume`, `ZimskeGume`, `KrovniKofer`, `NosacZaBicikle`) VALUES
(1, 3, 80, 80, NULL, NULL),
(3, 2, 100, 110, 70, NULL),
(6, 1, 110, 120, 85, 80),
(8, 4, 90, 100, NULL, 50),
(9, 1, 200, 300, NULL, NULL),
(10, 1, 500, 800, NULL, NULL),
(11, 3, 1000000, NULL, NULL, 1000000),
(12, 4, 100, 100, 50, NULL),
(13, 3, 500, 500, NULL, NULL),
(14, 2, 500, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `korisnici`
--

CREATE TABLE `korisnici` (
  `IDkorisnika` int(11) NOT NULL,
  `ImePrezime` varchar(50) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Mail` varchar(50) NOT NULL,
  `Telefon` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `korisnici`
--

INSERT INTO `korisnici` (`IDkorisnika`, `ImePrezime`, `Username`, `Password`, `Mail`, `Telefon`) VALUES
(1, 'Tadija T', 'tadija', 'tadija', 'tadija@gmail.com', 12345),
(2, 'Aleksa S', 'aleksa', 'aleksa', 'aleksa@gmail.com', 13579),
(3, 'Tadija T', 'tadija', 'tadija', 'tadija@gmail.com', 12345),
(4, 'Aleksa S', 'aleksa', 'aleksa', 'aleksa@gmail.com', 13579);

-- --------------------------------------------------------

--
-- Table structure for table `modeliauta`
--

CREATE TABLE `modeliauta` (
  `IDmodelAuta` int(11) NOT NULL,
  `IDbrendAuta` int(11) NOT NULL,
  `ModelAuta` varchar(50) NOT NULL,
  `BojaAuta` varchar(11) DEFAULT NULL,
  `Cena` varchar(110) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `modeliauta`
--

INSERT INTO `modeliauta` (`IDmodelAuta`, `IDbrendAuta`, `ModelAuta`, `BojaAuta`, `Cena`) VALUES
(16, 2, 'X1', 'Plava', '10000'),
(17, 4, 'A6', 'Bela', '7000'),
(18, 2, 'X1', 'Plava', '10000'),
(19, 2, 'X1', 'Plava', '10000'),
(20, 2, 'X1', 'Plava', '10000'),
(21, 2, 'X1', 'Plava', '10000'),
(22, 2, 'X1', 'Plava', '10000'),
(29, 2, 'X1', 'Plava', '10000'),
(30, 3, '500', 'Crvena', '12000');

-- --------------------------------------------------------

--
-- Table structure for table `tipmotora`
--

CREATE TABLE `tipmotora` (
  `IDtipMotora` int(11) NOT NULL,
  `IDmodelAuta` int(11) NOT NULL,
  `Benzin` varchar(500) NOT NULL,
  `Dizel` varchar(500) NOT NULL,
  `Hibrid` varchar(500) DEFAULT NULL,
  `Elektricni` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tipmotora`
--

INSERT INTO `tipmotora` (`IDtipMotora`, `IDmodelAuta`, `Benzin`, `Dizel`, `Hibrid`, `Elektricni`) VALUES
(1, 1, '1.6', '2.0', NULL, NULL),
(2, 2, '3.0', '3.0', NULL, NULL),
(3, 3, '2.0', '2.0', NULL, NULL),
(4, 4, '3.0', '2.0', NULL, NULL),
(5, 5, '1.2', '1.6', NULL, NULL),
(6, 6, '2.0', '2.0', NULL, NULL),
(7, 7, '2.0', '3.0', NULL, NULL),
(8, 8, '3.0', '3.0', '1.4', NULL),
(9, 1, '1.6', '2.0', NULL, NULL),
(10, 2, '3.0', '3.0', NULL, NULL),
(11, 3, '2.0', '2.0', NULL, NULL),
(12, 4, '3.0', '2.0', NULL, NULL),
(13, 5, '1.2', '1.6', NULL, NULL),
(14, 6, '2.0', '2.0', NULL, NULL),
(15, 7, '2.0', '3.0', NULL, NULL),
(16, 8, '3.0', '3.0', '1.4', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `brendauta`
--
ALTER TABLE `brendauta`
  ADD PRIMARY KEY (`IDbrendAuta`);

--
-- Indexes for table `dodatnaoprema`
--
ALTER TABLE `dodatnaoprema`
  ADD PRIMARY KEY (`IDdodatnaOprema`);

--
-- Indexes for table `korisnici`
--
ALTER TABLE `korisnici`
  ADD PRIMARY KEY (`IDkorisnika`);

--
-- Indexes for table `modeliauta`
--
ALTER TABLE `modeliauta`
  ADD PRIMARY KEY (`IDmodelAuta`);

--
-- Indexes for table `tipmotora`
--
ALTER TABLE `tipmotora`
  ADD PRIMARY KEY (`IDtipMotora`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `brendauta`
--
ALTER TABLE `brendauta`
  MODIFY `IDbrendAuta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `dodatnaoprema`
--
ALTER TABLE `dodatnaoprema`
  MODIFY `IDdodatnaOprema` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `korisnici`
--
ALTER TABLE `korisnici`
  MODIFY `IDkorisnika` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `modeliauta`
--
ALTER TABLE `modeliauta`
  MODIFY `IDmodelAuta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `tipmotora`
--
ALTER TABLE `tipmotora`
  MODIFY `IDtipMotora` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
