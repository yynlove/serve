/*
 Navicat Premium Data Transfer

 Source Server         : MySQL数据库
 Source Server Type    : MySQL
 Source Server Version : 50527
 Source Host           : localhost:3306
 Source Schema         : server

 Target Server Type    : MySQL
 Target Server Version : 50527
 File Encoding         : 65001
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `link` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '路由链接',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `pid` bigint(20) NOT NULL COMMENT '父id',
  `order_no` int(11) NULL DEFAULT NULL COMMENT '序号',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `is_valid` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '', '系统管理', 0, 1, '2021-03-06 14:56:13', 1);
INSERT INTO `menu` VALUES (2, './welcome', '欢迎', 1, 1, '2021-03-06 15:14:36', 1);
INSERT INTO `menu` VALUES (3, './user', '用户管理', 1, 2, '2021-03-06 15:14:36', 1);
INSERT INTO `menu` VALUES (4, './menu', '菜单管理', 1, 3, '2021-03-06 15:14:36', 1);
INSERT INTO `menu` VALUES (5, './permission', '权限管理', 1, 4, '2021-03-06 15:14:36', 1);
INSERT INTO `menu` VALUES (6, '', '模块一', 0, 2, '2021-03-06 15:26:17', 1);
INSERT INTO `menu` VALUES (7, './mokuai1', '模块-1', 6, 1, '2021-03-06 15:27:31', 1);
INSERT INTO `menu` VALUES (8, './mokuai2', '模块-2', 6, 2, '2021-03-06 15:27:31', 1);

-- ----------------------------
-- Table structure for user_menu
-- ----------------------------
DROP TABLE IF EXISTS `user_menu`;
CREATE TABLE `user_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户主键',
  `user_menus` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户菜单字符串',
  `last_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `is_valid` int(11) NOT NULL DEFAULT 1 COMMENT '有效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_menu
-- ----------------------------
INSERT INTO `user_menu` VALUES (3, 1, '[{\"children\":[{\"createTime\":1615014876000,\"id\":2,\"isValid\":1,\"link\":\"./welcome\",\"orderNo\":1,\"pid\":1,\"title\":\"欢迎\"},{\"createTime\":1615014876000,\"id\":3,\"isValid\":1,\"link\":\"./user\",\"orderNo\":2,\"pid\":1,\"title\":\"用户管理\"},{\"createTime\":1615014876000,\"id\":4,\"isValid\":1,\"link\":\"./menu\",\"orderNo\":3,\"pid\":1,\"title\":\"菜单管理\"},{\"createTime\":1615014876000,\"id\":5,\"isValid\":1,\"link\":\"./permission\",\"orderNo\":4,\"pid\":1,\"title\":\"权限管理\"}],\"createTime\":1615013773000,\"id\":1,\"isValid\":1,\"link\":\"\",\"orderNo\":1,\"pid\":0,\"title\":\"系统管理\"},{\"children\":[{\"createTime\":1615015651000,\"id\":7,\"isValid\":1,\"link\":\"./mokuai1\",\"orderNo\":1,\"pid\":6,\"title\":\"模块-1\"},{\"createTime\":1615015651000,\"id\":8,\"isValid\":1,\"link\":\"./mokuai2\",\"orderNo\":2,\"pid\":6,\"title\":\"模块-2\"}],\"createTime\":1615015577000,\"id\":6,\"isValid\":1,\"link\":\"\",\"orderNo\":2,\"pid\":0,\"title\":\"模块一\"}]', NULL, 1);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `md5` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `age` int(4) NULL DEFAULT NULL,
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_valid` int(11) NULL DEFAULT 1,
  `gender` int(11) NULL DEFAULT NULL,
  `account` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'admin', '123456', NULL, '2021-02-19 22:02:46', 15, '4444444444444444444444444444444444', 1, 1, 'admin');
INSERT INTO `users` VALUES (2, 'yuanyenan', '123456', NULL, '2021-02-27 21:32:56', 15, '213456', 1, 1, 'yuanyenan');
INSERT INTO `users` VALUES (5, '1', '1', NULL, '2021-02-28 15:22:49', 1, '1', 1, 1, '1');
INSERT INTO `users` VALUES (6, '2', '2', NULL, '2021-02-28 15:23:00', 2, '2', 1, 2, '2');
INSERT INTO `users` VALUES (7, '3', '3', NULL, '2021-02-28 15:25:26', 3, '3', 1, 3, '3');
INSERT INTO `users` VALUES (8, '4', '4', NULL, '2021-02-28 15:25:59', 4, '4', 1, 2, '4');
INSERT INTO `users` VALUES (9, '5', '5', NULL, '2021-02-28 15:26:09', 5, '5', 1, 2, '5');
INSERT INTO `users` VALUES (10, '6', '6', NULL, '2021-02-28 15:26:18', 6, '6', 1, 2, '6');
INSERT INTO `users` VALUES (11, '7', '7', NULL, '2021-02-28 15:26:27', 7, '7', 1, 2, '7');
INSERT INTO `users` VALUES (12, '8', '8', NULL, '2021-02-28 15:26:50', 8, '8', 1, 2, '8');

SET FOREIGN_KEY_CHECKS = 1;
