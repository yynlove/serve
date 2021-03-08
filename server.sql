/*
 Navicat Premium Data Transfer

 Source Server         : MySql
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : server

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 08/03/2021 17:44:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `link` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '链接',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标题',
  `pid` bigint(0) NULL DEFAULT NULL COMMENT '父id',
  `order_no` int(0) NULL DEFAULT NULL COMMENT '序号',
  `last_time` timestamp(0) NULL DEFAULT NULL COMMENT '时间戳',
  `is_valid` int(0) NULL DEFAULT 1 COMMENT '是否有效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, NULL, '系统管理', 0, 1, '2021-03-08 13:47:42', 1);
INSERT INTO `menu` VALUES (2, './welcome', '欢迎', 1, 1, '2021-03-08 13:48:23', 1);
INSERT INTO `menu` VALUES (3, './user', '用户管理', 1, 2, '2021-03-08 13:48:52', 1);
INSERT INTO `menu` VALUES (4, './role', '角色管理', 1, 3, '2021-03-08 13:49:38', 1);
INSERT INTO `menu` VALUES (5, './menus', '菜单管理', 1, 4, '2021-03-08 13:50:14', 1);
INSERT INTO `menu` VALUES (6, NULL, '应用管理', 0, 2, '2021-03-08 13:50:47', 1);
INSERT INTO `menu` VALUES (7, './mokuai1', '模块一', 6, 1, '2021-03-08 13:51:22', 1);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色名',
  `role_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '编码',
  `last_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次修改时间',
  `is_valid` int(0) NULL DEFAULT 1 COMMENT '是否有效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '管理员', 'admin', '2021-03-08 13:45:21', 1);
INSERT INTO `role` VALUES (2, '用户', 'user', '2021-03-08 13:45:44', 1);

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(0) NULL DEFAULT NULL COMMENT '角色id',
  `menu_id` bigint(0) NULL DEFAULT NULL COMMENT '菜单id',
  `is_valid` int(0) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (1, 1, 1, 1);
INSERT INTO `role_menu` VALUES (2, 1, 2, 1);
INSERT INTO `role_menu` VALUES (3, 1, 3, 1);
INSERT INTO `role_menu` VALUES (4, 1, 4, 1);
INSERT INTO `role_menu` VALUES (5, 1, 5, 1);
INSERT INTO `role_menu` VALUES (6, 1, 6, 1);
INSERT INTO `role_menu` VALUES (7, 1, 7, 1);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(0) NULL DEFAULT NULL COMMENT '用户id',
  `role_id` bigint(0) NULL DEFAULT NULL COMMENT '角色Id',
  `is_valid` int(0) NULL DEFAULT 1 COMMENT '是否有效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1, 1);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `md5` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int(0) NULL DEFAULT NULL,
  `create_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  `is_valid` int(0) NULL DEFAULT 1,
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '账户名',
  `gender` int(0) NULL DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'admin', '123456', NULL, 'renle', 123, '2021-03-02 03:38:42.764000', 1, 'admin', 2);

SET FOREIGN_KEY_CHECKS = 1;
