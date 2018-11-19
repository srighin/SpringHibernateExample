CREATE TABLE `Person` (
  `excInst` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `excCategory` varchar(20) NOT NULL DEFAULT '',
  `excDesc` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`excInst`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
commit;