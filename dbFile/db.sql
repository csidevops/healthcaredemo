USE `carapp`;
LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES (3,'Deepak','dk@test.com','test');
UNLOCK TABLES;
