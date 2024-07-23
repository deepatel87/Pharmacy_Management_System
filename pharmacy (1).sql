-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 14, 2024 at 08:43 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `medical`
--

-- --------------------------------------------------------

--
-- Table structure for table `pharmacy`
--

CREATE TABLE `pharmacy` (
  `sr_no` int(255) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `category` varchar(20) DEFAULT NULL,
  `exp_date` date DEFAULT NULL,
  `quantity` int(30) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pharmacy`
--

INSERT INTO `pharmacy` (`sr_no`, `name`, `category`, `exp_date`, `quantity`, `price`) VALUES
(1, 'Cefitaxe-200 DT', 'antibiotic', '2025-07-16', 46, 109.00),
(2, 'Evoxil-500', 'antibiotic', '2022-11-28', 10, 78.00),
(3, 'Acekick-SP', 'painkiller', '2024-04-20', 20, 85.00),
(4, 'NODARD PLUS', 'painkiller', '2025-08-08', 30, 57.75),
(5, 'CIPCAL-500', 'CALCIUM', '2025-01-04', 5, 95.00),
(6, 'OKACET', 'antialergic', '2026-02-03', 7, 18.81),
(7, 'COLDREST PLUS', 'COLD COUGH', '2024-10-03', 9, 38.00),
(8, 'OMEHOF', 'GAS', '2025-04-06', 8, 55.00),
(9, 'NORHOF-TZ', 'loos motion', '2024-02-02', 15, 80.00),
(10, 'FOLE-200', 'fungal', '2025-11-03', 10, 13.17),
(11, 'Amlokind-AT', 'blood pressure', '2025-02-06', 40, 49.05),
(12, 'Amlokind-5', 'blood pressure', '2026-01-20', 10, 22.15),
(13, 'Amlosasfe-AT', 'blood pressure', '2026-03-02', 15, 109.50),
(14, 'Glycomet-1GM', 'diabetes', '2024-04-15', 15, 68.04),
(15, 'Glimestar M2', 'diabetes', '2025-02-03', 10, 102.00),
(16, 'AKT-4', 'TB', '2025-01-01', 4, 27.15),
(17, 'stemetil MD', 'dizziness', '2024-10-10', 30, 157.00),
(18, 'SYL plus', 'bleeding', '2025-06-06', 10, 165.00),
(19, 'Panderm++ cream', 'fungal', '2024-11-12', 18, 112.00),
(20, 'Pilex', 'piles', '2025-10-15', 60, 165.00),
(21, 'LIV52', 'liver', '2026-01-02', 100, 150.00),
(22, 'GASEX', 'GAS', '2025-10-05', 100, 160.00),
(23, 'Thyronorm', 'thyroid', '2023-11-21', 25, 132.03),
(24, 'BECADEXAMIN', 'multivitamin', '2024-06-03', 60, 46.06),
(25, 'VITAZYME syrup', 'Fungal diastase', '2024-05-02', 5, 105.00),
(26, 'NEERI syrup', 'stone', '2026-02-09', 9, 285.00),
(27, 'Sinarest-AF', 'COLD', '2025-01-01', 12, 129.00),
(28, 'Citralka liquid', 'urine infection', '2024-10-20', 3, 147.61),
(29, 'BECOSULES syrup', 'vitamin-B and C', '2024-05-05', 6, 40.50),
(30, 'TusQ-x+', 'cough', '2024-11-10', 5, 99.00),
(31, 'TusQ-Dx', 'dry cough', '2024-12-13', 7, 99.00),
(32, 'Ibugesic plus', 'fever', '2025-02-03', 3, 49.91),
(33, 'CYCLOPAM syrup', 'stomach ache', '2025-08-09', 30, 95.00),
(34, 'APP-up plus syrup', 'multivitamin', '2025-03-08', 10, 137.00),
(35, 'HUNGRY syrup', 'multivitamin', '2024-09-02', 2, 188.00),
(36, 'Rabivax-s Vaccine', 'Rabies', '2026-02-12', 10, 397.61),
(37, 'DONO-TT vaccine', 'Tetanus', '2025-04-15', 25, 12.64),
(38, 'duolin 3', 'nebuliser', '2025-07-08', 40, 113.00),
(39, 'ZIFI100 DT', 'antibiotic', '2024-07-23', 10, 86.90),
(40, 'Zoryl-M 1', 'diabetes', '2025-03-02', 20, 224.00),
(41, 'Zerodol-P', 'painkiller', '2025-02-03', 10, 66.40),
(42, 'zocef-CV 500', 'antibiotic', '2024-09-06', 6, 570.00),
(43, 'VITCOFOL', 'FOLIC ACID AND ZINC', '2024-09-08', 30, 108.90),
(44, 'Ulcirest plus', 'folic acid', '2024-09-04', 10, 60.00),
(45, 'UDP-AT', 'blood pressure', '2025-04-03', 14, 26.47),
(46, 'VOGLYSON-M 0.3', 'diabetes', '2025-05-05', 15, 78.00),
(47, 'VIZYLAC', 'LACTIC ACID', '2024-10-11', 15, 69.25),
(48, 'UNWANTED-72', 'CONTRACEPTIVE TABLET', '2024-06-07', 8, 110.00),
(49, 'TELMA 40', 'BLOOD PRESSURE', '2025-10-13', 15, 111.15),
(50, 'Theo-asthalin Forte', 'Asthama', '2024-12-30', 20, 17.40);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pharmacy`
--
ALTER TABLE `pharmacy`
  ADD PRIMARY KEY (`sr_no`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pharmacy`
--
ALTER TABLE `pharmacy`
  MODIFY `sr_no` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
