/*
 Navicat Premium Data Transfer

 Source Server         : newone
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : ssobs

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 12/06/2022 19:30:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for logs
-- ----------------------------
DROP TABLE IF EXISTS `logs`;
CREATE TABLE `logs`  (
  `userId` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci DEFAULT NULL,
  `times` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci DEFAULT NULL,
  `logContext` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of logs
-- ----------------------------
INSERT INTO `logs` VALUES ('000009', '2022-05-15 10:48:51', '用户登录系统');
INSERT INTO `logs` VALUES ('000009', '2022-05-15 12:45:01', '用户登录系统');
INSERT INTO `logs` VALUES ('000009', '2022-05-15 12:45:05', '用户查询余额');
INSERT INTO `logs` VALUES ('000009', '2022-05-15 12:45:12', '用户取款，金额：2.0');
INSERT INTO `logs` VALUES ('000009', '2022-05-15 12:45:48', '转账给用户:uuu成功,转账金额：20.0');
INSERT INTO `logs` VALUES ('000009', '2022-05-15 13:00:15', '用户登录系统');
INSERT INTO `logs` VALUES ('000009', '2022-05-15 13:00:21', '用户查询余额');
INSERT INTO `logs` VALUES ('000009', '2022-05-15 13:00:27', '用户取款，金额：2.0');
INSERT INTO `logs` VALUES ('000009', '2022-05-15 13:00:43', '用户取款失败余额不足');
INSERT INTO `logs` VALUES ('000009', '2022-05-15 13:00:51', '用户存款，金额：1.0');
INSERT INTO `logs` VALUES ('000009', '2022-05-15 13:01:11', '转账失败');
INSERT INTO `logs` VALUES ('000009', '2022-05-15 13:01:25', '退出登录');
INSERT INTO `logs` VALUES ('000009', '2022-05-15 13:01:44', '用户登录系统');
INSERT INTO `logs` VALUES ('000009', '2022-05-16 21:16:48', '用户登录系统');
INSERT INTO `logs` VALUES ('000009', '2022-05-16 21:17:06', '转账给用户:uuu,转账金额：1.0');
INSERT INTO `logs` VALUES ('000009', '2022-05-17 20:53:16', '用户登录系统');
INSERT INTO `logs` VALUES ('000009', '2022-05-17 20:53:32', '转账给用户:uuu,转账金额：2.0');
INSERT INTO `logs` VALUES ('000010', '2022-05-17 20:53:32', '收到用户：aaa的转账，金额：2.0');
INSERT INTO `logs` VALUES ('000009', '2022-05-17 20:53:39', '用户查看帮助手册');
INSERT INTO `logs` VALUES ('000010', '2022-05-17 20:54:35', '用户登录系统');
INSERT INTO `logs` VALUES ('000007', '2022-05-21 23:07:46', '用户登录系统');
INSERT INTO `logs` VALUES ('000007', '2022-05-21 23:07:57', '用户存款，金额：100.0');
INSERT INTO `logs` VALUES ('000007', '2022-05-21 23:08:06', '退出登录');
INSERT INTO `logs` VALUES ('000007', '2022-05-22 20:52:22', '用户登录系统');
INSERT INTO `logs` VALUES ('000007', '2022-05-22 20:52:45', '用户取款，金额：47.9');
INSERT INTO `logs` VALUES ('000014', '2022-05-29 15:01:11', '用户登录系统');
INSERT INTO `logs` VALUES ('000014', '2022-05-29 15:01:24', '用户查询余额');
INSERT INTO `logs` VALUES ('000014', '2022-05-29 15:01:33', '用户取款失败余额不足');
INSERT INTO `logs` VALUES ('000014', '2022-05-29 15:01:43', '用户存款，金额：100.0');
INSERT INTO `logs` VALUES ('000014', '2022-05-29 15:02:16', '转账给用户:ooo,转账金额：30.0');
INSERT INTO `logs` VALUES ('000007', '2022-05-29 15:02:17', '收到用户：abcd的转账，转账金额：30.0');
INSERT INTO `logs` VALUES ('000014', '2022-05-29 15:02:32', '用户查看帮助手册');
INSERT INTO `logs` VALUES ('000007', '2022-05-31 17:24:13', '用户登陆系统');
INSERT INTO `logs` VALUES ('000007', '2022-05-31 17:24:17', '用户查询余额');
INSERT INTO `logs` VALUES ('000007', '2022-05-31 17:24:18', '用户查询余额');
INSERT INTO `logs` VALUES ('000007', '2022-05-31 17:24:18', '用户查询余额');
INSERT INTO `logs` VALUES ('000007', '2022-05-31 17:24:18', '用户查询余额');
INSERT INTO `logs` VALUES ('000007', '2022-05-31 17:24:23', '用户取款，金额：1.0');
INSERT INTO `logs` VALUES ('000007', '2022-05-31 17:24:27', '用户存款，金额：1.0');
INSERT INTO `logs` VALUES ('000007', '2022-05-31 17:24:42', '用户向000007转账，金额：1.0元');
INSERT INTO `logs` VALUES ('000009', '2022-05-31 17:24:42', '用户收到000009转账，金额：1.0元');
INSERT INTO `logs` VALUES ('000007', '2022-05-31 17:25:00', '用户向退出系统');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci DEFAULT NULL,
  `serialnum` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci DEFAULT NULL,
  `balance` double(255, 2) DEFAULT NULL,
  PRIMARY KEY (`serialnum`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('000001', 1, NULL, NULL, NULL);
INSERT INTO `user` VALUES ('000002', 2, NULL, NULL, NULL);
INSERT INTO `user` VALUES ('000003', 3, NULL, NULL, NULL);
INSERT INTO `user` VALUES ('000004', 4, '111', '111', 0.00);
INSERT INTO `user` VALUES ('000005', 5, '123', 'qwer', 0.00);
INSERT INTO `user` VALUES ('000006', 6, 'liu', '12345', 0.00);
INSERT INTO `user` VALUES ('000007', 7, 'ooo', '1234', 47.10);
INSERT INTO `user` VALUES ('000008', 8, 'qwer', '000', 4.00);
INSERT INTO `user` VALUES ('000009', 9, 'aaa', '123456', 92.00);
INSERT INTO `user` VALUES ('000010', 10, 'uuu', '123', 84.00);
INSERT INTO `user` VALUES ('000011', 11, '123', '321654', 0.00);
INSERT INTO `user` VALUES ('000012', 12, 'lwh', '789456', 0.00);
INSERT INTO `user` VALUES ('000013', 13, 'ppp', '999', 0.00);
INSERT INTO `user` VALUES ('000014', 14, 'abcd', '666', 70.00);

SET FOREIGN_KEY_CHECKS = 1;
