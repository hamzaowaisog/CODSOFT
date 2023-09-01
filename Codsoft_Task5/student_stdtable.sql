-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: student
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `stdtable`
--

DROP TABLE IF EXISTS `stdtable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stdtable` (
  `roll_no` int NOT NULL,
  `name` varchar(100) COLLATE latin1_bin NOT NULL,
  `grade` int NOT NULL,
  `dob` date NOT NULL,
  `fathername` varchar(100) COLLATE latin1_bin NOT NULL,
  `mobile` varchar(12) COLLATE latin1_bin NOT NULL,
  `gender` varchar(45) COLLATE latin1_bin NOT NULL,
  PRIMARY KEY (`roll_no`),
  UNIQUE KEY `roll_no_UNIQUE` (`roll_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stdtable`
--

LOCK TABLES `stdtable` WRITE;
/*!40000 ALTER TABLE `stdtable` DISABLE KEYS */;
INSERT INTO `stdtable` VALUES (1000,'Mir Hamza',12,'2001-07-07','Muhammad Owais','923322944494','Male'),(1001,'Huzaifa Awan',9,'2002-08-08','Awan ul Haq','923654896643','Male'),(1002,'Zayn Khan',11,'2001-08-26','Khan Baba','923654896356','Male'),(1003,'Abdullah Siddique',12,'2000-04-28','Siddiqui Sahab','925789336654','Male'),(1004,'Huzaifa Zeeshan',11,'2001-09-29','Zeeshan Gul','923654789632','Male'),(1005,'Haris',9,'2007-04-28','Muhammad Owais','923654789635','Male'),(1006,'Aiman Khanum',11,'2002-08-26','Aminullah wahab','926358796332','Female'),(1007,'Samiha Sultan',12,'2000-07-29','Sultan Nawab','923254789636','Female'),(1008,'Rana Hannan',12,'2000-09-09','Abdul Hannan','923336544889','Male'),(1009,'Abdul Raffay',8,'2004-05-18','Rafiq Ustad','936547863654','Male'),(1010,'Maham Rizwan',11,'2002-06-30','Rizwan Ustaad','923365489396','Female'),(1011,'Uzair',11,'2002-01-24','Zikar','923654899633','Male'),(1012,'Talha Asif',11,'2004-11-02','Asif Kandoi','933622256789','Male'),(1013,'Hamza Sharif',22,'2004-11-02','Iqbal Sharif','923456674586','Male'),(1014,'Haroon Sharif',15,'2004-11-02','Iqbal Sharif','922373478534','Male');
/*!40000 ALTER TABLE `stdtable` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-20 21:30:46
