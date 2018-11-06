/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50640
 Source Host           : localhost:3306
 Source Schema         : springboot_learning

 Target Server Type    : MySQL
 Target Server Version : 50640
 File Encoding         : 65001

 Date: 05/11/2018 18:08:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP',
  `insert_time` datetime(0) NULL DEFAULT NULL COMMENT '提交时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Procedure structure for autoInsert
-- ----------------------------
DROP PROCEDURE IF EXISTS `autoInsert`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `autoInsert`()
BEGIN
	DECLARE
		i INT DEFAULT 0 ; -- 开始 
	SET autocommit = 0 ; -- 结束
	WHILE (i <= 100) DO
		REPLACE INTO message (
			`id`,
			`nick_name`,
			`ip`,
			`insert_time`
		)
	VALUE
		(
			i,
			'码一码',
			'127.0.0.1',
			NOW()
		) ;
	SET i = i + 1 ;
	END
	WHILE ;
	SET autocommit = 1 ; COMMIT ;
	END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
