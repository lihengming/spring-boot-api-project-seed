/*
Navicat MySQL Data Transfer

Source Server         : Localhost
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-04-10 15:53:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user_tester
-- ----------------------------
DROP TABLE IF EXISTS `t_user_tester`;
CREATE TABLE `t_user_tester` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `state` char(1) DEFAULT '1' COMMENT '0-关闭，1-正常',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_tester
-- ----------------------------
INSERT INTO `t_user_tester` VALUES ('1', 'jcouyang', '1', '2019-04-09 09:53:21', 'admin', null, null);
INSERT INTO `t_user_tester` VALUES ('2', '123243', '1', '2019-04-09 09:56:15', 'jcouyang', null, null);
INSERT INTO `t_user_tester` VALUES ('3', '123', '1', '2019-04-10 15:20:30', '中文测试', null, null);
