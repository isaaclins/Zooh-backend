-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: zooh
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `animal`
--

DROP TABLE IF EXISTS `animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animal` (
  `animalID` int NOT NULL AUTO_INCREMENT,
  `specie` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int NOT NULL,
  `locationID` int NOT NULL,
  PRIMARY KEY (`animalID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal`
--

LOCK TABLES `animal` WRITE;
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
INSERT INTO `animal` VALUES (1,'Lion','Simba',5,1),(2,'Elephant','Dumbo',3,2),(3,'Giraffe','Melman',4,3),(4,'Penguin','Skipper',2,4),(5,'Kangaroo','Jack',3,5);
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event` (
  `eventID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `tagIDFS` int NOT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`eventID`),
  KEY `tagIDFS_idx` (`tagIDFS`),
  CONSTRAINT `tagIDFStotagID` FOREIGN KEY (`tagIDFS`) REFERENCES `tag` (`tagID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,'Feeding Time',1,'2024-01-26 10:00:00'),(2,'Bird Show',4,'2024-01-27 14:30:00'),(3,'Elephant Bath',3,'2024-01-28 11:15:00'),(4,'Lion Roaring Session',1,'2024-01-29 15:45:00'),(5,'Goat Feeding',2,'2024-01-30 13:00:00');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favorite_event`
--

DROP TABLE IF EXISTS `favorite_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favorite_event` (
  `user_id` int NOT NULL,
  `event_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`event_id`),
  KEY `user_id_idx` (`user_id`),
  KEY `event_id_idx` (`event_id`),
  CONSTRAINT `event_id_to_event` FOREIGN KEY (`event_id`) REFERENCES `event` (`eventID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_id_to_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorite_event`
--

LOCK TABLES `favorite_event` WRITE;
/*!40000 ALTER TABLE `favorite_event` DISABLE KEYS */;
/*!40000 ALTER TABLE `favorite_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favorite_events`
--

DROP TABLE IF EXISTS `favorite_events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favorite_events` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `event_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj6wvox90giiybjr6sm1m94jfk` (`event_id`),
  KEY `FKpukxnc2maedwdq9c6s33ecymh` (`user_id`),
  CONSTRAINT `FKio9a3i49sga2m69tf862xpn7o` FOREIGN KEY (`user_id`) REFERENCES `user` (`userid`),
  CONSTRAINT `FKj6wvox90giiybjr6sm1m94jfk` FOREIGN KEY (`event_id`) REFERENCES `event` (`eventID`),
  CONSTRAINT `FKpukxnc2maedwdq9c6s33ecymh` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorite_events`
--

LOCK TABLES `favorite_events` WRITE;
/*!40000 ALTER TABLE `favorite_events` DISABLE KEYS */;
/*!40000 ALTER TABLE `favorite_events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag` (
  `tagID` int NOT NULL AUTO_INCREMENT,
  `tagname` varchar(255) NOT NULL,
  PRIMARY KEY (`tagID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (1,'Family event'),(2,'Children'),(3,'Visual'),(4,'Relaxing');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `ticketid` int NOT NULL AUTO_INCREMENT,
  `used` bit(1) DEFAULT NULL,
  `cost` double NOT NULL,
  `userid` int NOT NULL,
  `expirationdate` date DEFAULT NULL,
  `UUID` varchar(24) NOT NULL DEFAULT '',
  PRIMARY KEY (`ticketid`),
  UNIQUE KEY `ID_UNIQUE` (`ticketid`),
  KEY `ticketidtouserid_idx` (`userid`),
  CONSTRAINT `FKj1tebj3d8f4mii697wl9pog2v` FOREIGN KEY (`userid`) REFERENCES `users` (`user_id`),
  CONSTRAINT `ticketidtouserid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1,_binary '\0',11,1,'2024-02-01','K32P8ICSIXW3PSSL2AH4MJAI'),(2,_binary '',9,2,'2024-02-05','K32P8ICSIXW3SHSL2AH1MJAI'),(3,_binary '\0',12,3,'2024-02-10','K32P8ICSIXJ3THSL2AH4MJAI'),(4,_binary '\0',15,1,'2024-03-05','b3d91e79e1d14423b7240da0'),(5,_binary '\0',15,1,'2024-03-05','4f66f4c9cc3446a48c65be8d'),(6,_binary '\0',15,1,'2024-03-05','39e4f602eb474c0183bad5cf'),(7,_binary '\0',15,2,'2024-03-05','aa6acbc864004232ab11bfe1'),(8,_binary '\0',20,2,'2024-03-05','f9d5fe3e798e4215b09e80ca'),(9,_binary '\0',235,2,'2024-03-05','27a00f1458f04ff6bc0df894'),(10,_binary '\0',345,3,'2024-03-05','e1bd6491928f4ce5957f14a4'),(11,_binary '\0',10,3,'2024-03-05','f8edd3e8f0a147e4bb2b1284'),(12,_binary '\0',10,3,'2024-03-05','88157dca2b8544f7868f3513'),(13,_binary '\0',10,3,'2024-03-05','40e1307342074eafa46031d4'),(14,_binary '\0',10,3,'2024-03-05','7d79af8efa0e4fe3a024dfb8'),(15,_binary '\0',10,3,'2024-03-05','c16f6038694e47a38c3df0eb'),(16,_binary '\0',10,3,'2024-03-05','7f3c624e998747fcabd6db8b'),(17,_binary '\0',10,3,'2024-03-05','88b8bda9de2246389454424a'),(18,_binary '\0',10,3,'2024-03-05','f3a95988114d4bfb99076987'),(19,_binary '\0',20,3,'2024-03-05','b997885b2d0d4d0ea84794f8'),(20,_binary '\0',20,3,'2024-03-05','05d61143728b45a29162faa5'),(21,_binary '\0',20,3,'2024-03-05','fc65d0a7f4b34f0a912b74a4'),(22,_binary '\0',20,3,'2024-03-05','5c5cb4f73d0e47608c35c68f'),(23,_binary '\0',20,3,'2024-03-05','7b34ed40a30b41709c639e46'),(24,_binary '\0',20,3,'2024-03-05','fb79beacc6d34ae7a1072a97'),(25,_binary '\0',20,3,'2024-03-05','016b45a05b68484e87150329'),(26,_binary '\0',20,3,'2024-03-05','7d1e490c48f94e89aaca0a97'),(27,_binary '\0',20,3,'2024-03-05','e16b23e49a5845349b4a1662'),(28,_binary '\0',20,3,'2024-03-05','e50cc26f32ec4d91a9406b34'),(29,_binary '\0',20,3,'2024-03-05','380d0560b4844507980edd86'),(30,_binary '\0',15,3,'2024-03-05','586d811206d9480088268b8a'),(31,_binary '\0',15,3,'2024-03-05','a74ac60f85024f14829331cd'),(32,_binary '\0',15,3,'2024-03-05','f8e98da9fef941e7a7c2fa08'),(33,_binary '\0',15,3,'2024-03-05','addc0fde58b6483497f7483a'),(34,_binary '\0',15,3,'2024-03-05','56825feb22cb4e93953cefa1'),(35,_binary '\0',15,3,'2024-03-05','b7a026f476564c26885dbdf5'),(36,_binary '\0',15,3,'2024-03-05','70cb87d3470649f692cb5f5d');
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `userid_UNIQUE` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'john_doe','password123'),(2,'jane_smith','securepass'),(3,'bob_jones','letmein'),(8,'patrick','gooooo');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_favorite_events`
--

DROP TABLE IF EXISTS `user_favorite_events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_favorite_events` (
  `user_id` int NOT NULL,
  `event_id` int DEFAULT NULL,
  KEY `FKswjisu2tkl8p2bkc3gh17mutt` (`user_id`),
  CONSTRAINT `FKswjisu2tkl8p2bkc3gh17mutt` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_favorite_events`
--

LOCK TABLES `user_favorite_events` WRITE;
/*!40000 ALTER TABLE `user_favorite_events` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_favorite_events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'password123','john_doe'),(2,'securepass','jane_smith'),(3,'letmein','bob_jones'),(4,'password123','john_doe'),(5,'securepass','jane_smith'),(6,'letmein','bob_jones'),(7,'cacca',' test'),(8,'test','test'),(9,'test','testwwww'),(10,'1234','patrick'),(11,'',''),(12,'test','testsss'),(13,'sss','ss'),(14,'ss','ssssss'),(15,'222','testaa'),(16,'test','cacca');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-04 20:48:56
