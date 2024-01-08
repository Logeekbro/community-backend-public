/*
 Navicat Premium Data Transfer

 Source Server         : 本地mysql3306
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : db_community

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 08/01/2024 08:44:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mtb_article_tag
-- ----------------------------
DROP TABLE IF EXISTS `mtb_article_tag`;
CREATE TABLE `mtb_article_tag`  (
  `tag_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标签id',
  `article_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文章id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `visible` bit(1) NOT NULL DEFAULT b'1' COMMENT '可见性， 0-不可见  1-可见',
  PRIMARY KEY (`tag_id`, `article_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for mtb_follow
-- ----------------------------
DROP TABLE IF EXISTS `mtb_follow`;
CREATE TABLE `mtb_follow`  (
  `parent_id` int NOT NULL COMMENT '联合主键，被关注者id',
  `follower_id` int NOT NULL COMMENT '联合主键，关注者id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `visible` bit(1) NOT NULL DEFAULT b'1' COMMENT '可见性，0-不可见  1-可见',
  PRIMARY KEY (`parent_id`, `follower_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for mtb_like
-- ----------------------------
DROP TABLE IF EXISTS `mtb_like`;
CREATE TABLE `mtb_like`  (
  `user_id` int NOT NULL COMMENT '点赞者的id',
  `aoc_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '被点赞的文章或评论id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `visible` bit(1) NOT NULL DEFAULT b'1' COMMENT '可见性 0-不可见  1-可见',
  PRIMARY KEY (`user_id`, `aoc_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for mtb_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `mtb_role_permission`;
CREATE TABLE `mtb_role_permission`  (
  `role_id` int NOT NULL COMMENT '角色id',
  `perm_id` int NOT NULL COMMENT '权限id',
  PRIMARY KEY (`role_id`, `perm_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for mtb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `mtb_user_role`;
CREATE TABLE `mtb_user_role`  (
  `user_id` int NOT NULL COMMENT '用户id',
  `role_id` int NOT NULL COMMENT '角色id',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_article
-- ----------------------------
DROP TABLE IF EXISTS `tb_article`;
CREATE TABLE `tb_article`  (
  `article_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键，文章id',
  `author_id` int NOT NULL COMMENT '作者id',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文章标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文章内容',
  `summary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文章摘要',
  `main_pic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '文章封面图',
  `section_id` int NOT NULL DEFAULT 1 COMMENT '文章所属分区的id',
  `top` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否置顶，0-不置顶 1-置顶 默认0',
  `status` int NOT NULL DEFAULT 0 COMMENT '文章状态 0-正常 1-审核中 2-审核不通过 3-新发布且还未被管理员查看的文章',
  `view_count` int NOT NULL DEFAULT 0 COMMENT '浏览量',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除， 0-未删除  1-已删除',
  PRIMARY KEY (`article_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment`  (
  `comment_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键，评论id',
  `user_id` int NOT NULL COMMENT '评论者id',
  `article_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '被评论的文章id',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '评论内容',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime NOT NULL COMMENT '修改时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除， 0-未删除  1-已删除',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_like_count
-- ----------------------------
DROP TABLE IF EXISTS `tb_like_count`;
CREATE TABLE `tb_like_count`  (
  `aoc_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键，文章或评论id',
  `count` int NOT NULL COMMENT '点赞数',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除， 0-未删除  1-已删除',
  PRIMARY KEY (`aoc_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_message
-- ----------------------------
DROP TABLE IF EXISTS `tb_message`;
CREATE TABLE `tb_message`  (
  `message_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键，消息id',
  `sender_id` int NOT NULL COMMENT '消息发送者的id',
  `target_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '消息发送的目标id',
  `is_read` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否被读取，0-未读取 1-已读取 默认0',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '消息内容',
  `type` enum('USER','SYSTEM') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'USER' COMMENT '消息类型',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime NOT NULL COMMENT '修改时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除， 0-未删除  1-已删除',
  PRIMARY KEY (`message_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_notification
-- ----------------------------
DROP TABLE IF EXISTS `tb_notification`;
CREATE TABLE `tb_notification`  (
  `notification_id` int NOT NULL AUTO_INCREMENT COMMENT '主键，通知id',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '通知内容',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `display` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否显示， 0-不显示  1-显示',
  PRIMARY KEY (`notification_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_permission`;
CREATE TABLE `tb_permission`  (
  `perm_id` int NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `perm_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限名称',
  `perm_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限值',
  PRIMARY KEY (`perm_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_reply
-- ----------------------------
DROP TABLE IF EXISTS `tb_reply`;
CREATE TABLE `tb_reply`  (
  `reply_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键，回复id',
  `user_id` int NOT NULL COMMENT '回复者id',
  `target` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '回复的目标用户id，如果为空则回复评论',
  `comment_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '回复的评论id',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '回复内容',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime NOT NULL COMMENT '修改时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除， 0-未删除  1-已删除',
  PRIMARY KEY (`reply_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role`  (
  `role_id` int NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  `role_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色标识',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_section
-- ----------------------------
DROP TABLE IF EXISTS `tb_section`;
CREATE TABLE `tb_section`  (
  `section_id` int NOT NULL AUTO_INCREMENT COMMENT '分区的主键',
  `section_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分区名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除 0-未删除 1-已删除',
  PRIMARY KEY (`section_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_tag
-- ----------------------------
DROP TABLE IF EXISTS `tb_tag`;
CREATE TABLE `tb_tag`  (
  `tag_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键，标签id',
  `tag_name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标签名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`tag_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '用户id，主键',
  `account` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
  `password` char(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `nick_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '昵称',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '邮箱',
  `qq` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'QQ号',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  `introduce` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '简介',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '用户状态，1-正常  0-封禁',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime NOT NULL COMMENT '修改时间',
  `role_id` int NULL DEFAULT NULL COMMENT '角色id，用于权限管理',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除， 0-未删除  1-已删除',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_verifyword
-- ----------------------------
DROP TABLE IF EXISTS `tb_verifyword`;
CREATE TABLE `tb_verifyword`  (
  `word_id` int NOT NULL AUTO_INCREMENT COMMENT '汉字id',
  `word` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '汉字值',
  PRIMARY KEY (`word_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_view
-- ----------------------------
DROP TABLE IF EXISTS `tb_view`;
CREATE TABLE `tb_view`  (
  `view_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键，浏览记录id',
  `reader_id` int NOT NULL COMMENT '阅读者id',
  `article_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '阅读的文章id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime NOT NULL COMMENT '修改时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除， 0-未删除  1-已删除',
  PRIMARY KEY (`view_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
