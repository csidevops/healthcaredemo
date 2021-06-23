USE `carapp`;
LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES (1,'Deepak','dk@test.com','test');
UNLOCK TABLES;
