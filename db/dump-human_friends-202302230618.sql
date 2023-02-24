-- MySQL dump 10.13  Distrib 8.0.32, for macos13 (arm64)
--
-- Host: localhost    Database: human_friends
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `animals`
--

DROP TABLE IF EXISTS `animals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animals` (
  `animal_id` int NOT NULL AUTO_INCREMENT,
  `animal_name` varchar(45) NOT NULL,
  `animal_age` varchar(45) NOT NULL,
  `animal_type` int NOT NULL,
  `animal_clan` int NOT NULL,
  PRIMARY KEY (`animal_id`),
  KEY `animal_type_idx` (`animal_type`),
  KEY `animal_clan_idx` (`animal_clan`),
  CONSTRAINT `animal_clan` FOREIGN KEY (`animal_clan`) REFERENCES `clan` (`clan_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `animal_type` FOREIGN KEY (`animal_type`) REFERENCES `type` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animals`
--

LOCK TABLES `animals` WRITE;
/*!40000 ALTER TABLE `animals` DISABLE KEYS */;
INSERT INTO `animals` VALUES (1,'Арсен','12',1,4),(2,'Поляк','2',2,2),(3,'Медуза','2',2,3),(4,'Куст','2',2,1),(5,'Ворон','2',1,6),(6,'Иа','23',1,5),(7,'Горб','12',1,6);
/*!40000 ALTER TABLE `animals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clan`
--

DROP TABLE IF EXISTS `clan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clan` (
  `clan_id` int NOT NULL AUTO_INCREMENT,
  `clan` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`clan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clan`
--

LOCK TABLES `clan` WRITE;
/*!40000 ALTER TABLE `clan` DISABLE KEYS */;
INSERT INTO `clan` VALUES (1,'Собаки'),(2,'Кошки'),(3,'Хомяки'),(4,'Лошади'),(5,'Ослы'),(6,'Верблюды');
/*!40000 ALTER TABLE `clan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comand`
--

DROP TABLE IF EXISTS `comand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comand` (
  `comand_id` int NOT NULL AUTO_INCREMENT,
  `comand_name` varchar(45) NOT NULL,
  PRIMARY KEY (`comand_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comand`
--

LOCK TABLES `comand` WRITE;
/*!40000 ALTER TABLE `comand` DISABLE KEYS */;
INSERT INTO `comand` VALUES (1,'Стоять'),(2,'Лежать'),(3,'Голос'),(4,'Сидеть');
/*!40000 ALTER TABLE `comand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skils`
--

DROP TABLE IF EXISTS `skils`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skils` (
  `animal` int NOT NULL,
  `comand` int NOT NULL,
  KEY `comand_id_idx` (`comand`),
  KEY `animal_id_idx` (`animal`,`comand`),
  CONSTRAINT `animal` FOREIGN KEY (`animal`) REFERENCES `animals` (`animal_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comand` FOREIGN KEY (`comand`) REFERENCES `comand` (`comand_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skils`
--

LOCK TABLES `skils` WRITE;
/*!40000 ALTER TABLE `skils` DISABLE KEYS */;
INSERT INTO `skils` VALUES (1,1),(1,1),(2,1),(2,1),(2,2),(2,3),(2,4),(3,1),(3,2),(3,4),(4,1),(4,2),(4,3),(4,4),(5,1),(5,2),(6,1),(6,2),(6,3),(7,2),(7,3),(7,4);
/*!40000 ALTER TABLE `skils` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type` (
  `type_id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (1,'Вьючные'),(2,'Домашние');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'human_friends'
--

--
-- Dumping routines for database 'human_friends'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-23  6:18:29
