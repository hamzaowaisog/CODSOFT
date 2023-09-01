-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: atmdb
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
-- Table structure for table `accountdetail`
--

DROP TABLE IF EXISTS `accountdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accountdetail` (
  `atmno` int NOT NULL COMMENT 'atm card no',
  `accno` int NOT NULL COMMENT 'accont no of atm card holder',
  `pinno` int NOT NULL COMMENT 'pin no of atm card holder',
  `acctype` varchar(50) NOT NULL COMMENT 'account type',
  `name` varchar(100) NOT NULL COMMENT 'name of the atm card holder',
  `balance` float NOT NULL COMMENT 'available balance of atm card holder',
  `atmexpirydate` date DEFAULT NULL COMMENT 'atm expiry date',
  PRIMARY KEY (`atmno`),
  UNIQUE KEY `accno` (`accno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accountdetail`
--

LOCK TABLES `accountdetail` WRITE;
/*!40000 ALTER TABLE `accountdetail` DISABLE KEYS */;
INSERT INTO `accountdetail` VALUES (1000,10001,1234,'saving','Huzaifa Awan',49550,'2028-03-31'),(1111,100011,1000,'current','MS Dhoni',100000,'2022-03-17'),(2000,20002,2222,'saving','Zayn Khan',21000,'2025-04-03'),(4000,40001,4444,'saving','John Cena',29000,'2024-03-02'),(5000,50001,5555,'current','Rana Hannan',5000,'2028-03-31'),(6000,42301,7777,'current','Mir Hamza',301909,'2028-06-29'),(9999,54876,3232,'saving','Triple H',20000,'2023-12-15');
/*!40000 ALTER TABLE `accountdetail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-16  0:53:03
