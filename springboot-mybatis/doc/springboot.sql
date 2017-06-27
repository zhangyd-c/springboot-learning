/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50624
Source Host           : 127.0.0.1:3306
Source Database       : springboot

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-03-10 15:33:13
*/

SET FOREIGN_KEY_CHECKS=0;

CREATE DATABASE springboot;
USE springboot;
-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `ID` int(50) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `NICK_NAME` varchar(50) DEFAULT NULL COMMENT '昵称',
  `IP` varchar(50) DEFAULT NULL COMMENT 'IP',
  `INSERT_TIME` datetime DEFAULT NULL COMMENT '提交时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Procedure structure for autoInsert
-- ----------------------------
DROP PROCEDURE IF EXISTS `autoInsert`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `autoInsert`()
BEGIN
	DECLARE
		i INT DEFAULT 0 ; -- 开始 
	SET autocommit = 0 ; -- 结束 
	WHILE (i < 1000) DO
		REPLACE INTO message (
			`ID`,
			`NICK_NAME`,
			`IP`,
			`INSERT_TIME`
		)
	VALUE
		(
			i,
			'flyat.cc',
			'127.0.0.1',
			NOW()
		) ;
	SET i = i + 1 ;
	END
	WHILE ;
	SET autocommit = 1 ; COMMIT ;
	END
;;
DELIMITER ;
