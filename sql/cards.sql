/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : cards

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2020-09-29 16:53:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bank_card
-- ----------------------------
DROP TABLE IF EXISTS `bank_card`;
CREATE TABLE `bank_card` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `bank_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `flag` int DEFAULT NULL,
  `credit_line` varchar(20) DEFAULT NULL,
  `deposit` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of bank_card
-- ----------------------------
INSERT INTO `bank_card` VALUES ('9', '1', '信用卡', '2', '50000', '');
INSERT INTO `bank_card` VALUES ('10', '1', '借记卡', '1', '', '5000');
INSERT INTO `bank_card` VALUES ('11', '2', '信用卡', '2', '10000', '');
INSERT INTO `bank_card` VALUES ('12', '2', 'wx', '1', '', '20000');
INSERT INTO `bank_card` VALUES ('13', '2', 'wx', '1', '', '60000');

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of card
-- ----------------------------
INSERT INTO `card` VALUES ('9', '1', '身份证', '郑州');
INSERT INTO `card` VALUES ('10', '2', '军官证', '上海');
INSERT INTO `card` VALUES ('11', '4', '学生证', '北京');
INSERT INTO `card` VALUES ('12', '7', 'wx', '444');
INSERT INTO `card` VALUES ('13', '8', 'wx', '123');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '小李', 'admin');
INSERT INTO `user` VALUES ('2', '张三', '123');
INSERT INTO `user` VALUES ('4', '小王', '123');
INSERT INTO `user` VALUES ('7', '闻名', '123');
INSERT INTO `user` VALUES ('8', '沃力', '123');
