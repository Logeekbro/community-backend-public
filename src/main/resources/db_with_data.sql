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

 Date: 08/01/2024 08:43:42
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
-- Records of mtb_article_tag
-- ----------------------------
INSERT INTO `mtb_article_tag` VALUES ('1537689937818959873', '1537689937793794049', '2022-06-17 14:53:44', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1537689937818959873', '1537996133623394306', '2022-06-18 11:10:27', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1537689937818959873', '1538832627030269953', '2022-06-20 18:34:23', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1537689937818959873', '1539044789367541762', '2022-06-21 08:37:26', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1537689937818959873', '1539045595319832577', '2022-06-21 08:40:38', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1537689937818959873', '1541610397336207361', '2022-06-28 10:32:15', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1537689937818959873', '1545031777205411842', '2022-07-07 21:07:35', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1537689937818959873', '1547503658345025538', '2022-07-14 16:49:58', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1537689937818959873', '1547504364812619777', '2022-07-14 16:52:46', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1537689937818959873', '1547514317384282114', '2022-07-14 17:32:19', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1537689937818959873', '1547545083371667458', '2022-07-14 19:34:34', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1537689937818959873', '1549932725095059458', '2022-07-21 09:42:12', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1537689937818959873', '1552581671044001794', '2022-07-28 17:08:10', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1537689937818959873', '1554437029450559489', '2022-08-02 20:00:42', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1537689937818959873', '1554806968044810242', '2022-08-03 20:30:42', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1537689937818959873', '1555023170033750017', '2022-08-04 10:49:49', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1537689937818959873', '1555096151044993026', '2022-08-04 15:39:49', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1537689937818959873', '1558020849255157762', '2022-08-12 17:21:31', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1539129937438146561', '1539129937350066178', '2022-06-21 14:15:47', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1539129937438146561', '1579091181562884098', '2022-10-09 20:47:30', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1539129937438146562', '1539129937350066178', '2022-06-21 14:15:47', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1544505476774526977', '1544505476711612418', '2022-07-06 10:16:15', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1547018567613161473', '1547018567550246913', '2022-07-13 08:42:23', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1547018567613161473', '1550302535834386433', '2022-07-22 10:11:44', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1547018567613161473', '1550365379057553410', '2022-07-22 14:21:25', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1549923841802444802', '1549923841471094785', '2022-07-21 09:06:54', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1549923841802444802', '1557643991160500225', '2022-08-11 16:24:01', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1549923841802444802', '1579651243008192513', '2022-10-11 09:52:59', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1549961615192555521', '1549961615096086529', '2022-07-21 11:37:00', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1552867151652335617', '1552867151534895106', '2022-07-29 12:02:34', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1554806968183222273', '1554806968044810242', '2022-08-03 20:30:42', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1557642820295372803', '1557642820295372802', '2022-08-11 16:19:22', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1558003573789298690', '1558003573789298689', '2022-08-12 16:12:52', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1582311646011863042', '1582311645919588354', '2022-10-18 18:04:28', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1585293233162825729', '1585293233150242818', '2022-10-26 23:32:14', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1587265424263753729', '1587265424255365122', '2022-11-01 10:09:01', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1587265424263753729', '1587443674290073601', '2022-11-01 21:57:19', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1587265424263753729', '1587628033315975169', '2022-11-02 10:09:54', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1587265424263753729', '1587712897608331266', '2022-11-02 15:47:07', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1587265424263753729', '1588090704523964417', '2022-11-03 16:48:23', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1587265424263753729', '1589521369916256257', '2022-11-07 15:33:21', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1587443674323628034', '1587443674290073601', '2022-11-01 21:57:19', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1587443674323628035', '1587443674290073601', '2022-11-01 21:57:19', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1587628033315975170', '1587628033315975169', '2022-11-02 10:09:54', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1587628033315975171', '1587628033315975169', '2022-11-02 10:09:54', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1587712897692217346', '1587712897608331266', '2022-11-02 15:47:07', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1589521369928839169', '1589521369916256257', '2022-11-07 15:33:21', b'1');
INSERT INTO `mtb_article_tag` VALUES ('1589521369933033473', '1589521369916256257', '2022-11-07 15:33:21', b'1');

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
-- Records of mtb_follow
-- ----------------------------
INSERT INTO `mtb_follow` VALUES (1, 2, '2022-06-21 17:11:12', b'1');
INSERT INTO `mtb_follow` VALUES (1, 3, '2022-07-22 15:19:27', b'1');
INSERT INTO `mtb_follow` VALUES (1, 4, '2022-07-12 15:51:50', b'1');
INSERT INTO `mtb_follow` VALUES (1, 5, '2022-08-19 17:05:35', b'1');
INSERT INTO `mtb_follow` VALUES (1, 9, '2022-07-21 10:42:17', b'1');
INSERT INTO `mtb_follow` VALUES (2, 1, '2022-07-21 10:10:40', b'1');
INSERT INTO `mtb_follow` VALUES (3, 1, '2022-08-22 15:08:13', b'1');
INSERT INTO `mtb_follow` VALUES (4, 1, '2022-07-12 15:48:34', b'1');
INSERT INTO `mtb_follow` VALUES (5, 1, '2022-07-12 16:00:19', b'1');
INSERT INTO `mtb_follow` VALUES (5, 6, '2022-08-12 16:19:32', b'1');
INSERT INTO `mtb_follow` VALUES (6, 1, '2022-07-12 19:20:10', b'1');
INSERT INTO `mtb_follow` VALUES (7, 1, '2022-07-12 16:56:41', b'1');
INSERT INTO `mtb_follow` VALUES (8, 1, '2022-07-12 20:28:01', b'1');
INSERT INTO `mtb_follow` VALUES (9, 1, '2022-07-14 17:14:38', b'1');

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
-- Records of mtb_like
-- ----------------------------
INSERT INTO `mtb_like` VALUES (1, '1538832627030269953', '2022-08-05 10:19:01', b'1');
INSERT INTO `mtb_like` VALUES (1, '1549923841471094785', '2023-01-09 18:18:14', b'1');
INSERT INTO `mtb_like` VALUES (1, '1550365379057553410', '2022-09-05 16:58:41', b'1');
INSERT INTO `mtb_like` VALUES (1, '1552581671044001794', '2023-01-09 18:18:14', b'1');
INSERT INTO `mtb_like` VALUES (1, '1554806968044810242', '2022-08-05 15:44:56', b'1');
INSERT INTO `mtb_like` VALUES (1, '1555023170033750017', '2022-08-05 15:27:57', b'1');
INSERT INTO `mtb_like` VALUES (1, '1555096151044993026', '2022-08-05 15:24:17', b'1');
INSERT INTO `mtb_like` VALUES (1, '1557643991160500225', '2023-01-09 18:18:14', b'1');
INSERT INTO `mtb_like` VALUES (1, '1558003573789298689', '2022-08-12 18:36:09', b'1');
INSERT INTO `mtb_like` VALUES (1, '1559008535265423361', '2023-01-09 18:18:14', b'1');
INSERT INTO `mtb_like` VALUES (1, '1562603651048939521', '2023-01-09 18:18:14', b'1');
INSERT INTO `mtb_like` VALUES (1, '1562613543373643778', '2023-01-09 18:18:14', b'1');
INSERT INTO `mtb_like` VALUES (1, '1577208140900880385', '2023-01-09 18:18:14', b'1');
INSERT INTO `mtb_like` VALUES (1, '1579091181562884098', '2022-10-11 15:05:42', b'1');
INSERT INTO `mtb_like` VALUES (1, '1587443674290073601', '2022-11-01 21:57:43', b'1');
INSERT INTO `mtb_like` VALUES (2, '1545031777205411842', '2023-01-09 18:18:14', b'1');
INSERT INTO `mtb_like` VALUES (2, '1549932725095059458', '2023-01-09 18:18:14', b'1');
INSERT INTO `mtb_like` VALUES (2, '1557643991160500225', '2022-10-09 20:34:22', b'1');
INSERT INTO `mtb_like` VALUES (2, '1558003573789298689', '2022-10-09 20:33:42', b'1');
INSERT INTO `mtb_like` VALUES (2, '1577208140900880385', '2023-01-09 18:18:14', b'1');
INSERT INTO `mtb_like` VALUES (3, '1557643991160500225', '2023-01-09 18:18:14', b'1');
INSERT INTO `mtb_like` VALUES (4, '1549961615096086529', '2022-08-05 16:46:10', b'1');
INSERT INTO `mtb_like` VALUES (4, '1554806968044810242', '2022-08-05 16:25:58', b'1');
INSERT INTO `mtb_like` VALUES (4, '1555023170033750017', '2022-08-05 16:24:45', b'1');
INSERT INTO `mtb_like` VALUES (4, '1581197916087795714', '2023-01-09 18:18:14', b'1');
INSERT INTO `mtb_like` VALUES (5, '1538832627030269953', '2023-01-09 18:18:14', b'1');
INSERT INTO `mtb_like` VALUES (5, '1557643991160500225', '2022-08-19 17:05:37', b'1');
INSERT INTO `mtb_like` VALUES (6, '1558020849255157762', '2022-08-12 18:21:21', b'1');
INSERT INTO `mtb_like` VALUES (9, '1558003573789298689', '2022-08-19 16:55:17', b'1');

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
-- Records of mtb_role_permission
-- ----------------------------
INSERT INTO `mtb_role_permission` VALUES (1, 1);
INSERT INTO `mtb_role_permission` VALUES (1, 2);
INSERT INTO `mtb_role_permission` VALUES (1, 3);
INSERT INTO `mtb_role_permission` VALUES (1, 4);

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
-- Records of mtb_user_role
-- ----------------------------
INSERT INTO `mtb_user_role` VALUES (1, 1);

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
-- Records of tb_article
-- ----------------------------
INSERT INTO `tb_article` VALUES ('1537689937793794049', 1, 'test2-1', '#### 电脑成功重装\n', '', '', 1, b'0', 0, 5, '2022-06-17 14:53:45', '2022-07-25 19:26:43', b'1');
INSERT INTO `tb_article` VALUES ('1537996133623394306', 1, 'test2', '1111111112334\n', '', '', 1, b'0', 0, 2, '2022-06-18 11:10:27', '2022-06-18 11:10:41', b'1');
INSERT INTO `tb_article` VALUES ('1538832627030269953', 1, 'test2-1', '# aaa\r\n\r\n![.png](http://db-community.oss-cn-guangzhou.aliyuncs.com/article/f63857c8e9c84f6ba06fa8adb4b98502.png)\r\n', '。。。', '', 1, b'0', 0, 19, '2022-06-20 18:34:23', '2022-08-12 16:10:17', b'0');
INSERT INTO `tb_article` VALUES ('1539044789367541762', 1, 'test2-2', '![Epic.png](http://db-community.oss-cn-guangzhou.aliyuncs.com/article/73b369bad10642dbb3a831cfcf0190dc.png)\n![IDEA.png](http://db-community.oss-cn-guangzhou.aliyuncs.com/article/176f950e4007464593ffed0bcb9131cf.png)\n![ghub.png](http://db-community.oss-cn-guangzhou.aliyuncs.com/article/cb57e9b788b64d368b6028f565ba3a39.png)\n![QQ.png](http://db-community.oss-cn-guangzhou.aliyuncs.com/article/7563bf8270b444cc94818ff7e25ffbd4.png)\n123\n', '', '', 1, b'0', 0, 10, '2022-06-21 08:37:27', '2022-06-22 11:44:17', b'1');
INSERT INTO `tb_article` VALUES ('1539045595319832577', 1, 'test2-3', '1111\n', '', '', 1, b'0', 0, 6, '2022-06-21 08:40:39', '2022-06-21 10:10:11', b'1');
INSERT INTO `tb_article` VALUES ('1539129937350066178', 1, '重要调整：关于将中间表mtb_view调整为普通表view的说明', '#### 虽然作为中间表的 `mtb_view`能完成用户浏览历史记录的相关操作，但仅通过简单的中间表通用操作已无法满足需求，如果直接将功能加在中间表操作模块，复用性不强，整体项目结构也会更加复杂和混乱，所以最终决定将记录用户浏览记录的职责从中间表 `mtb_view`转到普通表 `tb_view`\n', '', '', 1, b'0', 0, 9, '2022-06-21 14:15:47', '2022-08-09 19:30:51', b'0');
INSERT INTO `tb_article` VALUES ('1541610397336207361', 2, '$#@%#%@%#', '# h1\n', '', '', 1, b'0', 0, 4, '2022-06-28 10:32:15', '2022-08-12 16:18:54', b'0');
INSERT INTO `tb_article` VALUES ('1544505476711612418', 1, 'js笔记', '## 滚动页面到指定位置\n\n`document.getElementById(\'top\').scrollIntoViewIfNeeded();`\n', '', '', 1, b'0', 0, 3, '2022-07-06 10:16:16', '2022-07-07 19:59:39', b'0');
INSERT INTO `tb_article` VALUES ('1545031777205411842', 1, 'test2-3', '## h2\n\n![Epic.png](http://db-community.oss-cn-guangzhou.aliyuncs.com/article/7f56fc232c574e608e6b3b9dd677a412.png)\n', '', '', 1, b'0', 0, 4, '2022-07-07 21:07:36', '2022-07-12 16:01:20', b'0');
INSERT INTO `tb_article` VALUES ('1547018567550246913', 1, '聊天系统', '## 基本开发完成\n', '', '', 1, b'0', 0, 3, '2022-07-13 08:42:23', '2022-07-13 08:42:24', b'0');
INSERT INTO `tb_article` VALUES ('1547503658345025538', 3, '测试删除文章', 'qdasd\n', '', '', 1, b'0', 0, 1, '2022-07-14 16:49:58', '2022-07-14 16:49:58', b'1');
INSERT INTO `tb_article` VALUES ('1547504364812619777', 3, '被删的文章', '123\n', '', '', 1, b'0', 0, 2, '2022-07-14 16:52:46', '2022-07-25 19:21:58', b'1');
INSERT INTO `tb_article` VALUES ('1547514317384282114', 3, '测试', '123\n', '', '', 1, b'0', 0, 3, '2022-07-14 17:32:19', '2022-07-14 17:32:19', b'1');
INSERT INTO `tb_article` VALUES ('1547545083371667458', 1, '测试新版更新文章', '测试完成-\n', '', '', 1, b'0', 0, 3, '2022-07-14 19:34:35', '2022-07-14 19:34:35', b'0');
INSERT INTO `tb_article` VALUES ('1549923841471094785', 1, '开始重新优化认证授权系统', '待解决的问题：\n\n* Spring Security拦截器从token中解析出的userId应该能被控制器方法获取；\n\n进展：\n\n* MessageController重写完成\n* ArticleController重写完成\n* CommentController重写完成\n* FollowController重写完成\n* ReplyController重写完成\n* ViewController重写完成\n* UploadController重写完成\n* UserController重写完成\n\n已全部重写完成\n', '', '', 1, b'0', 0, 3, '2022-07-21 09:06:55', '2022-08-12 16:09:56', b'0');
INSERT INTO `tb_article` VALUES ('1549932725095059458', 1, 'test2-3', 'asdadwd\n', '', '', 1, b'0', 0, 1, '2022-07-21 09:42:13', '2022-07-21 09:42:13', b'0');
INSERT INTO `tb_article` VALUES ('1549961615096086529', 1, 'GROUP BY 用法实例', '同时获取标签信息和标签对应的文章数量\n\n```sql\nSELECT COUNT(at.article_id) articleCount, t.tag_id, t.tag_name, t.create_time FROM tb_tag t\n        INNER JOIN mtb_article_tag at\n        ON t.tag_id=at.tag_id\n        WHERE t.tag_name like CONCAT(\"%\", \"tagName\", \"%\")\n        AND at.article_id IN (SELECT a.article_id FROM tb_article a WHERE a.article_id=at.article_id AND a.deleted=0)\n        GROUP BY t.tag_id\n        LIMIT offset, size\n```\n', '', '', 1, b'0', 0, 2, '2022-07-21 11:37:01', '2022-08-05 16:46:08', b'0');
INSERT INTO `tb_article` VALUES ('1550302535834386433', 1, 'web容器变动', '### 将容器从tomcat改为undertow\r\n', '', '', 4, b'0', 0, 2, '2022-07-22 10:11:42', '2022-08-02 19:19:31', b'0');
INSERT INTO `tb_article` VALUES ('1550365379057553410', 3, '尝试更换jdk', '当前使用jdk17，接口响应速度全面提升\n', '', '', 1, b'0', 0, 3, '2022-07-22 14:21:25', '2022-10-09 20:48:00', b'0');
INSERT INTO `tb_article` VALUES ('1552581671044001794', 1, 'test3-1', 'asdadad\r\n\r\n![IDEA2022.png](http://db-community.oss-cn-guangzhou.aliyuncs.com/article/0746df5cb1ce4e4cbc137d3ce1c21400.png)\r\n\r\n![ghub.png](http://db-community.oss-cn-guangzhou.aliyuncs.com/article/93d71653301f463dabc73039c9b3f06f.png)\r\n', '', 'http://db-community.oss-cn-guangzhou.aliyuncs.com/article/mainPic/50119c60bb1c4572a525efc46f71a9ba.png', 1, b'0', 0, 1, '2022-07-28 17:08:11', '2022-08-01 09:00:53', b'0');
INSERT INTO `tb_article` VALUES ('1552865320280911873', 1, '1=2=3', 'emmmm...\r\n', '', 'http://db-community.oss-cn-guangzhou.aliyuncs.com/article/mainPic/03668d5203c84defa2e80536da84f919.png', 1, b'0', 0, 1, '2022-07-29 11:55:18', '2022-07-29 12:05:08', b'1');
INSERT INTO `tb_article` VALUES ('1552865876424650754', 1, '1=2=3', 'emmmm...\r\n', '', 'http://db-community.oss-cn-guangzhou.aliyuncs.com/article/mainPic/0a5d0054ab0541a29139c013209da0da.png', 1, b'0', 0, 1, '2022-07-29 11:57:30', '2022-07-29 12:05:16', b'1');
INSERT INTO `tb_article` VALUES ('1552867151534895106', 1, '==1=2=3==', '![20220721225415.png](http://db-community.oss-cn-guangzhou.aliyuncs.com/article/feb60632fa9d4c20991d8b4469f1ff34.png)\r\n', '', 'http://db-community.oss-cn-guangzhou.aliyuncs.com/article/mainPic/da0e7bdd18684fd986b2f006f831dccf.png', 6, b'0', 0, 1, '2022-07-29 12:02:34', '2022-08-02 19:17:59', b'0');
INSERT INTO `tb_article` VALUES ('1554432432153583617', 1, '删库跑路', 'sudo rm -rf /*\r\n', '', 'http://db-community.oss-cn-guangzhou.aliyuncs.com/article/mainPic/669862ecedc740d88f7ebdd3a2483e1f.png', 4, b'0', 0, 1, '2022-08-02 19:42:26', '2022-08-02 19:59:36', b'1');
INSERT INTO `tb_article` VALUES ('1554437029450559489', 1, '删库跑路', 'rm -rf /*\r\n', '', 'http://db-community.oss-cn-guangzhou.aliyuncs.com/article/mainPic/28f1e340591048c6b29ac187f9dede68.png', 4, b'0', 0, 1, '2022-08-02 20:00:43', '2022-08-02 20:00:42', b'0');
INSERT INTO `tb_article` VALUES ('1554806968044810242', 1, 'test 8/3-1', '测试新版创建标签\r\n\r\n## 测试\r\n\r\n![20220721225415.png](http://db-community.oss-cn-guangzhou.aliyuncs.com/article/f49c12d8b91f4b42ba35f1348f8ead05.png)\r\n', '测试新版创建标签', 'http://db-community.oss-cn-guangzhou.aliyuncs.com/article/mainPic/166b2690fc3d4530a5f8d23663ccd9ec.png', 4, b'0', 0, 3, '2022-08-03 20:30:43', '2022-08-22 15:08:59', b'0');
INSERT INTO `tb_article` VALUES ('1554807598859743233', 1, '马上删除', '大大萨达萨达\r\n', '', 'http://db-community.oss-cn-guangzhou.aliyuncs.com/article/mainPic/87dda9217ae24b7fbead0c95b3f21ff5.png', 1, b'0', 0, 0, '2022-08-03 20:33:13', '2022-08-03 20:35:03', b'1');
INSERT INTO `tb_article` VALUES ('1555023170033750017', 1, 'test summary', '测试文章摘要\r\n', '这是摘要', 'http://db-community.oss-cn-guangzhou.aliyuncs.com/article/mainPic/41881496976c4516ba8e580ab824eab3.png', 1, b'0', 0, 5, '2022-08-04 10:49:49', '2022-08-11 16:15:05', b'0');
INSERT INTO `tb_article` VALUES ('1555096151044993026', 3, 'test 8/4-2', '测试后端验证\r\n', '1111111\r\n123123123\r\n3\r\n123\r\n123\r\n123\r\n213\r\n123\r\n123\r\n12\r\n3\r\n213', 'http://db-community.oss-cn-guangzhou.aliyuncs.com/article/mainPic/6bc777b86e26470b8b05b0d3b2db3f45.png', 1, b'0', 0, 4, '2022-08-04 15:39:49', '2022-08-09 19:24:42', b'0');
INSERT INTO `tb_article` VALUES ('1557642820295372802', 1, 'Redis', '部分与数量有关的数据使用Redis做缓存，减小数据库压力\r\n', '部分与数量有关的数据使用Redis做缓存，减小数据库压力', 'http://db-community.oss-cn-guangzhou.aliyuncs.com/article/mainPic/8a01f41c0f65449aa7ddff23aed3be81.png', 4, b'0', 0, 1, '2022-08-11 16:19:23', '2022-08-11 16:21:55', b'1');
INSERT INTO `tb_article` VALUES ('1557643991160500225', 1, 'Redis 缓存', '将点赞数、评论数、浏览量等高频数据用Redis缓存，减轻数据库压力\r\n', '将点赞数、评论数、浏览量等高频数据用Redis缓存，减轻数据库压力', 'http://db-community.oss-cn-guangzhou.aliyuncs.com/article/mainPic/c6560acf1512438894a942dbe900b686.png', 4, b'0', 0, 2, '2022-08-11 16:24:02', '2022-10-09 20:34:22', b'0');
INSERT INTO `tb_article` VALUES ('1558003573789298689', 5, 'Redis incr 的坑', '使用 Redis incr 对存入的值进行自增时只能使用Integer(int) 类型，使用Long类型不会自增\r\n', '使用 Redis incr 对存入的值进行自增时只能使用Integer(int) 类型，使用Long类型不会自增', 'http://db-community.oss-cn-guangzhou.aliyuncs.com/article/mainPic/8504defa74a64917acace3fbe5f6c581.png', 4, b'0', 0, 4, '2022-08-12 16:12:53', '2022-10-09 20:33:42', b'0');
INSERT INTO `tb_article` VALUES ('1558020849255157762', 6, 'asfdqwd', 'dwefewfewf\r\n', 'wefwdqwd', 'http://db-community.oss-cn-guangzhou.aliyuncs.com/article/mainPic/20b9f73f789b45969e79a298c44315ce.png', 1, b'0', 0, 2, '2022-08-12 17:21:32', '2022-08-12 17:29:40', b'1');
INSERT INTO `tb_article` VALUES ('1579091181562884098', 1, '项目介绍', '本项目以文章内容为核心，致力于打造一个自由、开放的社区。即使你是一名游客，也可以使用社区的大部分功能，让每一位朋友都能更加轻松快捷地获取到社区内同学分享的知识。同时本项目还支持匿名点赞功能，让游客朋友们也能表达对作者的肯定。作为一个社区，内容审核是必不可少的，但遵循自由开放的原则，您可以选择不进行审核直接发布文章。但请注意，管理员仍会查看这些未经审核的文章，如果其中存在违规内容，文章将会被删除，同时会对发布者进行惩罚！使用此功能前请确保您的文章合规！推出此功能也是为了让优质作者能更快地发布文章。\r\n\r\n本项目还使用了前后台融合的设计理念，没有使用独立的后台管理系统，而是通过内容差异化显示和服务器端的权限控制，使管理员能在现有功能的基础上对社区进行管理，减少了开发时间，提高开发效率。\r\n', '本项目以文章内容为核心，致力于打造一个自由、开放的社区。', 'http://db-community.oss-cn-guangzhou.aliyuncs.com/article/mainPic/3769c48fa4854092a4978f9a9be52f3a.png', 1, b'1', 0, 1, '2022-10-09 20:47:30', '2022-10-18 09:16:35', b'0');
INSERT INTO `tb_article` VALUES ('1579651243008192513', 1, '记消息系统的重构过程', '## 起因\r\n\r\n由于消息的类型多种多样，MySQL的固定字段特性无法很好的满足存储需求，于是了解到了一种非常适合存储消息的数据库：MongoDB，便开始着手将消息系统进行重构。\r\n\r\n## 类的设计\r\n\r\n经过初步思考，凡消息必有消息的（唯一ID、消息是否已读、创建时间、修改时间、删除标识）字段，这应该作为消息的公共父类属性，而消息应分为两大类：1、用户消息 2、系统消息，具体的消息类型应该以它们为基础，例如：用户私信消息、系统点赞通知等。\r\n\r\n根据上述思路，设计出了如下类结构图：\r\n\r\n![.png](http://db-community.oss-cn-guangzhou.aliyuncs.com/article/2f3b5642318e4987ac5afd2b0b269051.png)\r\n\r\n## 过程\r\n\r\n1、**添加SpringBoot操作mongoDB的依赖**\r\n\r\n```xml\r\n<dependency>\r\n        <groupId>org.springframework.boot</groupId>\r\n        <artifactId>spring-boot-starter-data-mongodb</artifactId>\r\n</dependency>\r\n```\r\n\r\n2、**使用MongoTemplate提供的API重写原来的Serivce层代码，以下为部分代码示例**\r\n\r\n```java\r\n\r\npublic void updateReadStatus(Integer senderId, Integer userId) {\r\n        Query query;\r\n        Class<? extends Message> target;\r\n        if(Objects.equals(senderId, SYSTEM_ID)) {\r\n            query = new Query(MongoUtil.notDeletedCriteria().\r\n                    and(\"isRead\").is(false).\r\n                    and(\"targetId\").is(userId));\r\n            target = LikeNotion.class;\r\n        }\r\n        else {\r\n            query = new Query(MongoUtil.notDeletedCriteria().\r\n                    and(\"isRead\").is(false).\r\n                    and(\"senderId\").is(senderId).\r\n                    and(\"targetId\").is(userId));\r\n            target = UserPrivateMessage.class;\r\n        }\r\n        Update update = new Update();\r\n        update.set(\"isRead\", true);\r\n        mongoTemplate.updateMulti(query, update, target);\r\n}\r\n```\r\n\r\n3、**前端对消息的展示进行适配**\r\n\r\n主要是适配系统通知的显示，因为系统消息的原始数据是用户无法直接阅读的，所以需要通过组件化的方式与后端接口协同将系统消息中的各种id转化为用户可读的信息。\r\n', '由于消息的类型多种多样，MySQL的固定字段特性无法很好的满足存储需求，于是了解到了一种非常适合存储消息的数据库：MongoDB，便开始着手将消息系统进行重构。', 'http://db-community.oss-cn-guangzhou.aliyuncs.com/article/mainPic/16e0a7dca8cb474b81fdbc86a3fa3b81.png', 4, b'0', 0, 1, '2022-10-11 09:52:59', '2022-10-11 09:53:02', b'0');
INSERT INTO `tb_article` VALUES ('1582311645919588354', 1, '寻找一个offer😭😭😭', '多干点活没事，能学到东西就行😭😭😭\r\n', '如题....', '', 3, b'0', 0, 1, '2022-10-18 18:04:29', '2022-10-18 18:05:03', b'0');
INSERT INTO `tb_article` VALUES ('1585293233150242818', 1, 'Go1.18 切片扩容机制', '以下为官方示例代码\r\n\r\n```go\r\nimport \"fmt\"\r\n\r\nfunc main() {\r\n	var s []int\r\n	printSlice(s)\r\n\r\n	// 添加一个空切片\r\n	s = append(s, 0)\r\n	printSlice(s)\r\n\r\n	// 这个切片会按需增长\r\n	s = append(s, 1)\r\n	printSlice(s)\r\n\r\n	// 可以一次性添加多个元素\r\n	s = append(s, 2, 3, 4)\r\n	printSlice(s)\r\n}\r\n\r\nfunc printSlice(s []int) {\r\n	fmt.Printf(\"len=%d cap=%d %v\\n\", len(s), cap(s), s)\r\n}\r\n```\r\n\r\n运行结果：\r\n\r\n`len=0 cap=0 [] `\r\n\r\n`len=1 cap=1 [0]`\r\n\r\n`len=2 cap=2 [0 1] `\r\n\r\n`len=5 cap=6 [0 1 2 3 4]`\r\n\r\n观察最后一次扩容结果，切片中只有5个元素，扩容后容量为6，不是2X2X2=8\r\n\r\n经过测试，扩容后的容量计算机制为：\r\n\r\n```go\r\nfunc getNewCap(s []T, data ...T) int {\r\n	newLen := len(s) + len(data)\r\n	oldCap = cap(s)\r\n	// 先翻倍\r\n	newCap := oldCap * 2 \r\n	// 如果翻倍后再翻倍的容量仍小于新数组长度，则循环翻倍，直至下次翻倍大于数组长度时\r\n	// 此时容量仍小于新数组长度\r\n	for newCap * 2 < newLen { newCap *= 2 }\r\n	// 然后循环+2，直至容量大于等于新数组长度\r\n	// 只是测试几个比较小的数时是+2，如果数比较大，最坏的情况下需要 oldCap/2 次+2\r\n	// oldCap越大效率越低，所以猜测到达某个临界值后可能不是+2，而是+更多\r\n	for newCap < newLen { new Cap += 2 }\r\n	return newCap\r\n\r\n}\r\n```\r\n', '以下为官方示例代码', '', 4, b'0', 3, 1, '2022-10-26 23:32:15', '2022-10-27 09:43:58', b'0');
INSERT INTO `tb_article` VALUES ('1587265424255365122', 1, 'import javax.validation报错', 'SpringBoot自2.3.0版本以后就不在自带validation相关功能了，需要手动引入\r\n\r\n```xml\r\n<dependency>\r\n	<groupId>org.springframework.boot</groupId>\r\n	<artifactId>spring-boot-starter-validation</artifactId>\r\n 	<version>2.7.2</version>\r\n</dependency>\r\n```\r\n', '在springboot版本大于2.3.0时会发生这个问题', '', 4, b'0', 3, 1, '2022-11-01 10:09:02', '2022-11-01 10:09:03', b'0');
INSERT INTO `tb_article` VALUES ('1587443674290073601', 1, 'SpringBoot整合Nacos服务发现&注册中心', '1、前往 [官方github仓库](https://github.com/alibaba/nacos/releases \"点击前往\") 下载nacos客户端压缩包(推荐zip版本)\r\n\r\n2、启动nacos服务器\r\n\r\n* Linux\r\n\r\n  ```bash\r\n  unzip nacosxxx.zip\r\n  cd nacos/bin\r\n  sh startup.sh -m standalone # 单节点启动\r\n  ```\r\n* Windows\r\n\r\n  1) 解压\r\n  2) 进入bin目录\r\n  3) 打开命令行\r\n  4) 输入 startup.cmd -m standalone\r\n\r\n3、SpringBoot中引入依赖\r\n\r\n```xml\r\n<!--nacos-->\r\n<dependency>\r\n	<groupId>com.alibaba.cloud</groupId>\r\n	<artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>\r\n</dependency>\r\n\r\n    <dependencyManagement>\r\n        <dependencies>\r\n            <dependency>\r\n                <groupId>com.alibaba.cloud</groupId>\r\n                <artifactId>spring-cloud-alibaba-dependencies</artifactId>\r\n                <version>2021.0.4.0</version> <!--此处版本和SpringCloud版本有关-->\r\n                <type>pom</type>\r\n                <scope>import</scope>\r\n            </dependency>\r\n        </dependencies>\r\n    </dependencyManagement>\r\n```\r\n\r\n4、修改配置文件\r\n\r\n```yaml\r\nspring:\r\n  cloud:\r\n    nacos:\r\n      discovery:\r\n        server-addr: localhost:8848 # nacos服务器地址\r\n  application:\r\n    name: dbmall-order # 微服务名称\r\n```\r\n\r\n5、在主程序入口处开启注解@EnableDiscoveryClient\r\n\r\n```java\r\n@EnableDiscoveryClient\r\n@SpringBootApplication\r\npublic class DbmallOrderApplication {\r\n\r\n    public static void main(String[] args) {\r\n        SpringApplication.run(DbmallOrderApplication.class, args);\r\n    }\r\n\r\n}\r\n```\r\n\r\n6、验证是否注册成功\r\n\r\n1)浏览器访问[localhost:8848/nacos](http://localhost:8848/nacos) 账号密码都为：nacos\r\n\r\n2)点击 服务管理->服务列表，如果能看到自己的微服务名称则注册成功\r\n\r\n![nacos.png](http://db-community.oss-cn-guangzhou.aliyuncs.com/article/9449e7b5ac7a42949d4cbe139cbb15e4.png)\r\n', '精简版整合教程', 'http://db-community.oss-cn-guangzhou.aliyuncs.com/article/mainPic/4344286143524762aba61c4f4f8b2849.png', 4, b'0', 3, 1, '2022-11-01 21:57:20', '2022-11-01 22:00:56', b'0');
INSERT INTO `tb_article` VALUES ('1587628033315975169', 1, 'SpringBoot整合OpenFeign', '1、引入依赖\r\n\r\n```xml\r\n<dependency>\r\n    <groupId>org.springframework.cloud</groupId>\r\n    <artifactId>spring-cloud-starter-openfeign</artifactId>\r\n</dependency>\r\n```\r\n\r\n2、在需要进行远程调用的服务中创建一个接口（此处以会员服务调用优惠券服务为例），并加上对应的注解，注解中要声明远程调用服务的名称\r\n\r\n![image.png](http://db-community.oss-cn-guangzhou.aliyuncs.com/article/28b6009e41ea4a4091ad6d34b7e1b864.png)\r\n\r\n3、在接口中声明需要调用的方法，具体操作如下：\r\n\r\n这是要调用的方法：\r\n\r\n![image.png](http://db-community.oss-cn-guangzhou.aliyuncs.com/article/9c4027be23f9473593fda6084a60c498.png)\r\n\r\n接口中应声明的方法：\r\n\r\n![image.png](http://db-community.oss-cn-guangzhou.aliyuncs.com/article/aedf4168630d4f18917df85fa5534f26.png)\r\n\r\n4、在启动类上加对应的注解，并指定包名\r\n\r\n![image.png](http://db-community.oss-cn-guangzhou.aliyuncs.com/article/7ee8d82188ea47dd9259417058d2f12c.png)\r\n\r\n6、编写测试接口\r\n\r\n![image.png](http://db-community.oss-cn-guangzhou.aliyuncs.com/article/33dca38ac58d4af4b0efabbf6e48b75a.png)\r\n\r\n7、启动Nocos和2个对应的服务，访问测试接口\r\n\r\n![image.png](http://db-community.oss-cn-guangzhou.aliyuncs.com/article/c600668e58ac46a58f7dff7526f0e341.png)\r\n\r\n如果返回数据正确则说明整合成功\r\n\r\nTips：使用高版本的SpringCloud可能会导致调用方(会员服务)启动失败，请尝试给调用方添加以下依赖\r\n\r\n```xml\r\n<dependency>\r\n        <groupId>org.springframework.cloud</groupId>\r\n        <artifactId>spring-cloud-starter-loadbalancer</artifactId>\r\n</dependency>\r\n```\r\n', '精简版整合教程', '', 4, b'0', 0, 1, '2022-11-02 10:09:55', '2023-01-27 16:16:42', b'0');
INSERT INTO `tb_article` VALUES ('1587712897608331266', 1, 'SpringBoot整合Nacos配置中心', '1、引入依赖\r\n\r\n```xml\r\n<dependency>\r\n    <groupId>com.alibaba.cloud</groupId>\r\n    <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>\r\n</dependency>\r\n```\r\n\r\n2、在需要使用配置中心的服务中的resources目录下创建bootstrap.properties(正确创建后文件有特殊标志),并在其中加入以下内容：\r\n\r\n```properties\r\n# 服务名称\r\nspring.application.name=dbmall-coupon\r\n# 配置中心地址\r\nspring.cloud.nacos.config.server-addr=localhost:8848\r\n# 默认文件格式为yaml\r\nspring.cloud.nacos.config.file-extension=yaml\r\n```\r\n\r\n3、在nacos的配置列表->配置管理中创建一个DataId为 [服务名称].yml 的配置, 并写入一些内容，然后发布配置\r\n\r\n![image.png](http://db-community.oss-cn-guangzhou.aliyuncs.com/article/642fafff0df74edc80f3418e2b9178a5.png)\r\n\r\n4、在Controller中编写测试代码\r\n\r\n![image.png](http://db-community.oss-cn-guangzhou.aliyuncs.com/article/a9db3bb6633a40e3b3a8b85378232837.png)\r\n\r\n注解说明：\r\n\r\n@Value：从配置文件中获取对应的值\r\n\r\n@RefreshScope：动态获取配置文件中的值\r\n\r\n5、访问接口，如果能获取到值，再到配置中对值进行修改，再次获取，如果可以获取到最新的值则表示测试成功。\r\n\r\n踩坑说明：\r\n\r\n如果你使用的是较新版本的SpringCloud，服务很有可能无法启动，因为新版取消了默认对bootstrap的支持，所以需要手动引入依赖\r\n\r\n```xml\r\n<dependency>\r\n        <groupId>org.springframework.cloud</groupId>\r\n        <artifactId>spring-cloud-starter-bootstrap</artifactId>\r\n        <version>3.1.4</version>\r\n</dependency>\r\n```\r\n', '精简版整合教程', 'http://db-community.oss-cn-guangzhou.aliyuncs.com/article/mainPic/06a0f39159494cadba40ee16bbd85ea2.png', 4, b'0', 3, 1, '2022-11-02 15:47:08', '2022-11-02 15:48:56', b'0');
INSERT INTO `tb_article` VALUES ('1588090704523964417', 1, 'SpringBoot微服务项目数据源相关问题', '如果操作数据库的框架在common模块中引入，但某些模块不需要连接数据库(如网关)，可在服务的启动类中加上如下参数来忽略数据库相关配置：\r\n\r\n```java\r\n@EnableDiscoveryClient\r\n// 在此处加上 exclude = {DataSourceAutoConfiguration.class}\r\n@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})\r\npublic class DbmallGatewayApplication {\r\n\r\n    public static void main(String[] args) {\r\n        SpringApplication.run(DbmallGatewayApplication.class, args);\r\n    }\r\n\r\n}\r\n```\r\n', '解决某些服务不需要使用数据源但common模块已经引入的问题', '', 4, b'0', 3, 1, '2022-11-03 16:48:24', '2022-11-03 16:48:43', b'0');
INSERT INTO `tb_article` VALUES ('1589521369916256257', 1, '解决SpringBoot引入依赖时有多个同名Bean的问题', '首先定义一个配置类，在返回自己需要的那个Bean时加上@Primary注解即可\r\n\r\n```java\r\n@Configuration\r\npublic class IpUtilConfig {\r\n\r\n    @Bean\r\n    @Primary\r\n    public InetUtilsProperties getInetUtilsProperties() {\r\n        return new InetUtilsProperties();\r\n    }\r\n}\r\n```\r\n', '核心是@Primary注解', '', 4, b'0', 3, 1, '2022-11-07 15:33:21', '2022-11-07 15:33:56', b'0');

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
-- Records of tb_comment
-- ----------------------------
INSERT INTO `tb_comment` VALUES ('1537693627850199041', 1, '1537689937793794049', '111', '2022-06-17 15:08:25', '2022-06-17 15:08:25', b'0');
INSERT INTO `tb_comment` VALUES ('1537693794632503297', 1, '1537689937793794049', '222', '2022-06-17 15:09:04', '2022-06-17 15:09:04', b'0');
INSERT INTO `tb_comment` VALUES ('1537694233490919425', 1, '1537689937793794049', '333', '2022-06-17 15:10:49', '2022-06-17 15:10:49', b'0');
INSERT INTO `tb_comment` VALUES ('1537996166485766146', 1, '1537996133623394306', '1', '2022-06-18 11:10:35', '2022-06-18 11:10:35', b'0');
INSERT INTO `tb_comment` VALUES ('1539043282509303809', 1, '1538832627030269953', '111', '2022-06-21 08:31:27', '2022-06-21 08:31:27', b'0');
INSERT INTO `tb_comment` VALUES ('1539044868597944322', 1, '1539044789367541762', '111', '2022-06-21 08:37:45', '2022-06-21 08:37:45', b'0');
INSERT INTO `tb_comment` VALUES ('1539047067667337217', 1, '1539045595319832577', '111', '2022-06-21 08:46:30', '2022-06-21 08:46:30', b'0');
INSERT INTO `tb_comment` VALUES ('1539047134004449282', 1, '1539045595319832577', '222', '2022-06-21 08:46:46', '2022-06-21 08:46:46', b'0');
INSERT INTO `tb_comment` VALUES ('1539047142665687042', 1, '1539045595319832577', '333', '2022-06-21 08:46:48', '2022-06-21 08:46:48', b'0');
INSERT INTO `tb_comment` VALUES ('1539047153394716674', 1, '1539045595319832577', '444', '2022-06-21 08:46:50', '2022-06-21 08:46:50', b'0');
INSERT INTO `tb_comment` VALUES ('1539047163653984258', 1, '1539045595319832577', '555', '2022-06-21 08:46:53', '2022-06-21 08:46:53', b'0');
INSERT INTO `tb_comment` VALUES ('1539047175356092418', 1, '1539045595319832577', '666', '2022-06-21 08:46:55', '2022-06-21 08:46:55', b'0');
INSERT INTO `tb_comment` VALUES ('1539050872874143746', 1, '1539045595319832577', '777', '2022-06-21 09:01:37', '2022-06-21 09:01:37', b'0');
INSERT INTO `tb_comment` VALUES ('1539170192086196225', 2, '1539129937350066178', '收到', '2022-06-21 16:55:45', '2022-06-21 16:55:45', b'0');
INSERT INTO `tb_comment` VALUES ('1539170578377400322', 2, '1539129937350066178', '111', '2022-06-21 16:57:17', '2022-06-21 16:57:17', b'0');
INSERT INTO `tb_comment` VALUES ('1539502180039004161', 1, '1538832627030269953', '222', '2022-06-22 14:54:57', '2022-06-22 14:54:57', b'0');
INSERT INTO `tb_comment` VALUES ('1539502204093337602', 1, '1538832627030269953', '333', '2022-06-22 14:55:03', '2022-06-22 14:55:03', b'0');
INSERT INTO `tb_comment` VALUES ('1539502219633233922', 1, '1538832627030269953', '444', '2022-06-22 14:55:06', '2022-06-22 14:55:06', b'0');
INSERT INTO `tb_comment` VALUES ('1539502232237117442', 1, '1538832627030269953', '555', '2022-06-22 14:55:09', '2022-06-22 14:55:09', b'0');
INSERT INTO `tb_comment` VALUES ('1539502254970245122', 1, '1538832627030269953', '666', '2022-06-22 14:55:15', '2022-06-22 14:55:15', b'0');
INSERT INTO `tb_comment` VALUES ('1539502286029066242', 1, '1538832627030269953', '777', '2022-06-22 14:55:22', '2022-06-22 14:55:22', b'0');
INSERT INTO `tb_comment` VALUES ('1539502298079301634', 1, '1538832627030269953', '888', '2022-06-22 14:55:25', '2022-06-22 14:55:25', b'0');
INSERT INTO `tb_comment` VALUES ('1539502310263754754', 1, '1538832627030269953', '999', '2022-06-22 14:55:28', '2022-06-22 14:55:28', b'0');
INSERT INTO `tb_comment` VALUES ('1539502358296924162', 1, '1538832627030269953', '000', '2022-06-22 14:55:39', '2022-06-22 14:55:39', b'0');
INSERT INTO `tb_comment` VALUES ('1539860954356621314', 1, '1539129937350066178', '111', '2022-06-23 14:40:35', '2022-06-23 14:40:35', b'0');
INSERT INTO `tb_comment` VALUES ('1541623559271874561', 2, '1541610397336207361', '1', '2022-06-28 11:24:33', '2022-06-28 11:24:33', b'0');
INSERT INTO `tb_comment` VALUES ('1544503479925112834', 1, '1538832627030269953', '0\n1445145145\n2', '2022-07-06 10:08:20', '2022-07-06 10:08:20', b'0');
INSERT INTO `tb_comment` VALUES ('1546766690917052418', 5, '1545031777205411842', '新账号', '2022-07-12 16:01:31', '2022-07-12 16:01:31', b'0');
INSERT INTO `tb_comment` VALUES ('1548855056655900673', 1, '1547545083371667458', '123', '2022-07-18 10:19:57', '2022-07-18 10:19:57', b'0');
INSERT INTO `tb_comment` VALUES ('1549938548290580481', 1, '1549923841471094785', '123', '2022-07-21 10:05:21', '2022-07-21 10:05:21', b'0');
INSERT INTO `tb_comment` VALUES ('1550365749204881410', 3, '1550365379057553410', '评论测试', '2022-07-22 14:22:54', '2022-07-22 14:22:54', b'0');
INSERT INTO `tb_comment` VALUES ('1553920123081670658', 1, '1552867151534895106', '6', '2022-08-01 09:46:42', '2022-08-01 09:46:42', b'0');
INSERT INTO `tb_comment` VALUES ('1558005389478432769', 6, '1558003573789298689', '1', '2022-08-12 16:20:06', '2022-08-12 16:20:06', b'0');
INSERT INTO `tb_comment` VALUES ('1561611195339882497', 1, '1555096151044993026', '111', '2022-08-22 15:08:17', '2022-08-22 15:08:17', b'0');
INSERT INTO `tb_comment` VALUES ('1589209986293051393', 15, '1588090704523964417', '465', '2022-11-06 18:56:01', '2022-11-06 18:56:01', b'0');

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
-- Records of tb_like_count
-- ----------------------------
INSERT INTO `tb_like_count` VALUES ('1538832627030269953', 3, '2022-08-12 10:29:19', '2023-01-09 18:18:14', b'0');
INSERT INTO `tb_like_count` VALUES ('1539129937350066178', 2, '2022-08-12 11:03:26', '2022-08-12 11:07:26', b'0');
INSERT INTO `tb_like_count` VALUES ('1544505476711612418', 1, '2022-08-12 10:29:19', '2022-08-12 10:29:19', b'0');
INSERT INTO `tb_like_count` VALUES ('1545031777205411842', 1, '2023-01-09 18:18:14', '2023-01-09 18:18:14', b'0');
INSERT INTO `tb_like_count` VALUES ('1549923841471094785', 1, '2023-01-09 18:18:14', '2023-01-09 18:18:14', b'0');
INSERT INTO `tb_like_count` VALUES ('1549932725095059458', 1, '2023-01-09 18:18:14', '2023-01-09 18:18:14', b'0');
INSERT INTO `tb_like_count` VALUES ('1550365379057553410', 1, '2022-09-05 16:58:42', '2022-09-05 16:58:42', b'0');
INSERT INTO `tb_like_count` VALUES ('1552581671044001794', 1, '2023-01-09 18:18:14', '2023-01-09 18:18:14', b'0');
INSERT INTO `tb_like_count` VALUES ('1554806968044810242', 0, '2022-08-21 15:14:38', '2022-08-21 15:14:38', b'0');
INSERT INTO `tb_like_count` VALUES ('1555023170033750017', 1, '2022-08-12 10:29:19', '2022-08-12 10:29:19', b'0');
INSERT INTO `tb_like_count` VALUES ('1555096151044993026', 2, '2022-08-12 10:29:19', '2022-08-12 11:07:06', b'0');
INSERT INTO `tb_like_count` VALUES ('1557643991160500225', 6, '2022-08-12 10:29:19', '2023-01-09 18:18:14', b'0');
INSERT INTO `tb_like_count` VALUES ('1558003573789298689', 3, '2022-08-12 16:14:54', '2023-01-09 18:18:14', b'0');
INSERT INTO `tb_like_count` VALUES ('1558020849255157762', 1, '2022-08-12 17:21:54', '2022-08-12 17:29:14', b'0');
INSERT INTO `tb_like_count` VALUES ('1559008535265423361', 1, '2023-01-09 18:18:14', '2023-01-09 18:18:14', b'0');
INSERT INTO `tb_like_count` VALUES ('1562603651048939521', 1, '2023-01-09 18:18:14', '2023-01-09 18:18:14', b'0');
INSERT INTO `tb_like_count` VALUES ('1562613543373643778', 1, '2023-01-09 18:18:14', '2023-01-09 18:18:14', b'0');
INSERT INTO `tb_like_count` VALUES ('1577208140900880385', 2, '2023-01-09 18:18:14', '2023-01-09 18:18:14', b'0');
INSERT INTO `tb_like_count` VALUES ('1579091181562884098', 1, '2022-10-11 15:05:42', '2022-10-11 15:05:42', b'0');
INSERT INTO `tb_like_count` VALUES ('1581197916087795714', 1, '2023-01-09 18:18:14', '2023-01-09 18:18:14', b'0');
INSERT INTO `tb_like_count` VALUES ('1587443674290073601', 1, '2022-11-01 21:57:43', '2022-11-01 21:57:43', b'0');

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
-- Records of tb_message
-- ----------------------------
INSERT INTO `tb_message` VALUES ('1544660395330555906', 1, '3', b'1', 'hello', 'USER', '2022-07-06 20:31:51', '2022-07-06 20:31:51', b'0');
INSERT INTO `tb_message` VALUES ('1544660526922649601', 3, '1', b'1', 'world', 'USER', '2022-07-06 20:32:23', '2022-07-06 20:32:23', b'0');
INSERT INTO `tb_message` VALUES ('1544886396010123265', 1, '3', b'1', '😀', 'USER', '2022-07-07 11:29:54', '2022-07-07 11:29:54', b'0');
INSERT INTO `tb_message` VALUES ('1544886762579709954', 3, '1', b'1', '😁', 'USER', '2022-07-07 11:31:21', '2022-07-07 11:31:21', b'0');
INSERT INTO `tb_message` VALUES ('1544976063950872578', 1, '3', b'1', 'hello2', 'USER', '2022-07-07 17:26:13', '2022-07-07 17:26:13', b'0');
INSERT INTO `tb_message` VALUES ('1544979325705904129', 1, '3', b'1', 'hello3', 'USER', '2022-07-07 17:39:10', '2022-07-07 17:39:10', b'0');
INSERT INTO `tb_message` VALUES ('1545002511151501313', 1, '2', b'1', 'test', 'USER', '2022-07-07 19:11:18', '2022-07-07 19:11:18', b'0');
INSERT INTO `tb_message` VALUES ('1545003266126221313', 1, '2', b'1', 'test2', 'USER', '2022-07-07 19:14:18', '2022-07-07 19:14:18', b'0');
INSERT INTO `tb_message` VALUES ('1545009851087032322', 1, '3', b'1', 'hello4', 'USER', '2022-07-07 19:40:28', '2022-07-07 19:40:28', b'0');
INSERT INTO `tb_message` VALUES ('1545010720830492674', 1, '3', b'1', 'hello5', 'USER', '2022-07-07 19:43:55', '2022-07-07 19:43:55', b'0');
INSERT INTO `tb_message` VALUES ('1545010822898880513', 1, '2', b'1', 'test3', 'USER', '2022-07-07 19:44:20', '2022-07-07 19:44:20', b'0');
INSERT INTO `tb_message` VALUES ('1545012195107377153', 1, '2', b'1', 'test4', 'USER', '2022-07-07 19:49:47', '2022-07-07 19:49:47', b'0');
INSERT INTO `tb_message` VALUES ('1545012433842966530', 1, '2', b'1', 'test5', 'USER', '2022-07-07 19:50:44', '2022-07-07 19:50:44', b'0');
INSERT INTO `tb_message` VALUES ('1545012892410351617', 1, '3', b'1', 'hello6', 'USER', '2022-07-07 19:52:33', '2022-07-07 19:52:33', b'0');
INSERT INTO `tb_message` VALUES ('1545013010907828225', 1, '2', b'1', 'test6', 'USER', '2022-07-07 19:53:01', '2022-07-07 19:53:01', b'0');
INSERT INTO `tb_message` VALUES ('1545013437716008962', 1, '3', b'1', 'hello7', 'USER', '2022-07-07 19:54:43', '2022-07-07 19:54:43', b'0');
INSERT INTO `tb_message` VALUES ('1545013679140225025', 3, '1', b'1', 'sb', 'USER', '2022-07-07 19:55:41', '2022-07-07 19:55:41', b'0');
INSERT INTO `tb_message` VALUES ('1545014771890634754', 1, '3', b'1', 'hh', 'USER', '2022-07-07 20:00:01', '2022-07-07 20:00:01', b'0');
INSERT INTO `tb_message` VALUES ('1545015571811516418', 1, '3', b'1', '？', 'USER', '2022-07-07 20:03:12', '2022-07-07 20:03:12', b'0');
INSERT INTO `tb_message` VALUES ('1545015770285981697', 1, '3', b'1', '😅', 'USER', '2022-07-07 20:03:59', '2022-07-07 20:03:59', b'0');
INSERT INTO `tb_message` VALUES ('1545016731972780034', 1, '3', b'1', '。', 'USER', '2022-07-07 20:07:49', '2022-07-07 20:07:49', b'0');
INSERT INTO `tb_message` VALUES ('1545017499358445570', 1, '3', b'1', '。。。', 'USER', '2022-07-07 20:10:52', '2022-07-07 20:10:52', b'0');
INSERT INTO `tb_message` VALUES ('1545024059153432577', 1, '3', b'1', 'hh', 'USER', '2022-07-07 20:36:56', '2022-07-07 20:36:56', b'0');
INSERT INTO `tb_message` VALUES ('1545024095614517250', 1, '3', b'1', '?', 'USER', '2022-07-07 20:37:04', '2022-07-07 20:37:04', b'0');
INSERT INTO `tb_message` VALUES ('1545024269564887041', 1, '3', b'1', '1', 'USER', '2022-07-07 20:37:46', '2022-07-07 20:37:46', b'0');
INSERT INTO `tb_message` VALUES ('1545030320863371265', 1, '3', b'1', 'qwe', 'USER', '2022-07-07 21:01:48', '2022-07-07 21:01:48', b'0');
INSERT INTO `tb_message` VALUES ('1545030627613794306', 1, '2', b'1', 'qq', 'USER', '2022-07-07 21:03:02', '2022-07-07 21:03:02', b'0');
INSERT INTO `tb_message` VALUES ('1545031101129744386', 3, '1', b'1', 'www', 'USER', '2022-07-07 21:04:54', '2022-07-07 21:04:54', b'0');
INSERT INTO `tb_message` VALUES ('1545241101215285250', 3, '1', b'1', '最新测试', 'USER', '2022-07-08 10:59:22', '2022-07-08 10:59:22', b'0');
INSERT INTO `tb_message` VALUES ('1545241243540602882', 3, '1', b'1', '最新测试 2', 'USER', '2022-07-08 10:59:56', '2022-07-08 10:59:56', b'0');
INSERT INTO `tb_message` VALUES ('1545241349807489025', 3, '1', b'1', 'emmm', 'USER', '2022-07-08 11:00:22', '2022-07-08 11:00:22', b'0');
INSERT INTO `tb_message` VALUES ('1545241400424349697', 1, '3', b'1', '启动', 'USER', '2022-07-08 11:00:34', '2022-07-08 11:00:34', b'0');
INSERT INTO `tb_message` VALUES ('1545242332985901058', 3, '1', b'1', '失败', 'USER', '2022-07-08 11:04:16', '2022-07-08 11:04:16', b'0');
INSERT INTO `tb_message` VALUES ('1545242816161345537', 3, '1', b'1', '离谱', 'USER', '2022-07-08 11:06:11', '2022-07-08 11:06:11', b'0');
INSERT INTO `tb_message` VALUES ('1545242901913890818', 1, '3', b'1', '再试一次', 'USER', '2022-07-08 11:06:32', '2022-07-08 11:06:32', b'0');
INSERT INTO `tb_message` VALUES ('1545243613787942914', 1, '3', b'1', '111', 'USER', '2022-07-08 11:09:21', '2022-07-08 11:09:21', b'0');
INSERT INTO `tb_message` VALUES ('1545244093234638850', 3, '1', b'1', '发送', 'USER', '2022-07-08 11:11:16', '2022-07-08 11:11:16', b'0');
INSERT INTO `tb_message` VALUES ('1545244130039656450', 1, '3', b'1', '222', 'USER', '2022-07-08 11:11:25', '2022-07-08 11:11:25', b'0');
INSERT INTO `tb_message` VALUES ('1545252865499820034', 3, '1', b'1', '发', 'USER', '2022-07-08 11:46:07', '2022-07-08 11:46:07', b'0');
INSERT INTO `tb_message` VALUES ('1545253526136254465', 3, '1', b'1', '发', 'USER', '2022-07-08 11:48:45', '2022-07-08 11:48:45', b'0');
INSERT INTO `tb_message` VALUES ('1545296075047677953', 3, '1', b'1', '再发', 'USER', '2022-07-08 14:37:49', '2022-07-08 14:37:49', b'0');
INSERT INTO `tb_message` VALUES ('1545296281038282753', 3, '1', b'1', '还发', 'USER', '2022-07-08 14:38:38', '2022-07-08 14:38:38', b'0');
INSERT INTO `tb_message` VALUES ('1545296438714753026', 1, '3', b'1', '再测试', 'USER', '2022-07-08 14:39:16', '2022-07-08 14:39:16', b'0');
INSERT INTO `tb_message` VALUES ('1545296633661808641', 1, '3', b'1', '测', 'USER', '2022-07-08 14:40:02', '2022-07-08 14:40:02', b'0');
INSERT INTO `tb_message` VALUES ('1545296688896598017', 1, '3', b'1', '芜湖', 'USER', '2022-07-08 14:40:16', '2022-07-08 14:40:16', b'0');
INSERT INTO `tb_message` VALUES ('1545296716197322753', 3, '1', b'1', '？', 'USER', '2022-07-08 14:40:22', '2022-07-08 14:40:22', b'0');
INSERT INTO `tb_message` VALUES ('1545312926863515650', 1, '3', b'1', '。。。', 'USER', '2022-07-08 15:44:47', '2022-07-08 15:44:47', b'0');
INSERT INTO `tb_message` VALUES ('1545312970492665858', 1, '3', b'1', '。。。', 'USER', '2022-07-08 15:44:57', '2022-07-08 15:44:57', b'0');
INSERT INTO `tb_message` VALUES ('1545326308085784578', 3, '1', b'1', 'emm\n', 'USER', '2022-07-08 16:37:57', '2022-07-08 16:37:57', b'0');
INSERT INTO `tb_message` VALUES ('1545327170468241410', 1, '3', b'1', '\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n', 'USER', '2022-07-08 16:41:23', '2022-07-08 16:41:23', b'0');
INSERT INTO `tb_message` VALUES ('1545341391222349825', 3, '1', b'1', 'hhh', 'USER', '2022-07-08 17:37:53', '2022-07-08 17:37:53', b'0');
INSERT INTO `tb_message` VALUES ('1546427184552730626', 1, '3', b'1', '666', 'USER', '2022-07-11 17:32:27', '2022-07-11 17:32:27', b'0');
INSERT INTO `tb_message` VALUES ('1546427331340787713', 3, '1', b'1', 'hhh', 'USER', '2022-07-11 17:33:02', '2022-07-11 17:33:02', b'0');
INSERT INTO `tb_message` VALUES ('1546427615022538754', 3, '1', b'1', 'fasong', 'USER', '2022-07-11 17:34:09', '2022-07-11 17:34:09', b'0');
INSERT INTO `tb_message` VALUES ('1546427889636204545', 3, '1', b'1', '111', 'USER', '2022-07-11 17:35:15', '2022-07-11 17:35:15', b'0');
INSERT INTO `tb_message` VALUES ('1546428651305033730', 2, '1', b'1', 'hh', 'USER', '2022-07-11 17:38:16', '2022-07-11 17:38:16', b'0');
INSERT INTO `tb_message` VALUES ('1546428683324350466', 3, '1', b'1', '222', 'USER', '2022-07-11 17:38:24', '2022-07-11 17:38:24', b'0');
INSERT INTO `tb_message` VALUES ('1546453208149618689', 3, '1', b'1', 'fa', 'USER', '2022-07-11 19:15:51', '2022-07-11 19:15:51', b'0');
INSERT INTO `tb_message` VALUES ('1546453429181050882', 3, '1', b'1', 'fa2', 'USER', '2022-07-11 19:16:44', '2022-07-11 19:16:44', b'0');
INSERT INTO `tb_message` VALUES ('1546453598874202114', 3, '1', b'1', 'fa3', 'USER', '2022-07-11 19:17:24', '2022-07-11 19:17:24', b'0');
INSERT INTO `tb_message` VALUES ('1546454134168055809', 3, '1', b'1', 'fa4', 'USER', '2022-07-11 19:19:32', '2022-07-11 19:19:32', b'0');
INSERT INTO `tb_message` VALUES ('1546455315741241345', 3, '1', b'1', 'fa5', 'USER', '2022-07-11 19:24:14', '2022-07-11 19:24:14', b'0');
INSERT INTO `tb_message` VALUES ('1546455650186653697', 3, '1', b'1', 'fa6', 'USER', '2022-07-11 19:25:33', '2022-07-11 19:25:33', b'0');
INSERT INTO `tb_message` VALUES ('1546456233190715393', 3, '1', b'1', 'fa7', 'USER', '2022-07-11 19:27:52', '2022-07-11 19:27:52', b'0');
INSERT INTO `tb_message` VALUES ('1546457157393018882', 3, '1', b'1', 'fa8', 'USER', '2022-07-11 19:31:33', '2022-07-11 19:31:33', b'0');
INSERT INTO `tb_message` VALUES ('1546457299508621313', 3, '1', b'1', 'fa9', 'USER', '2022-07-11 19:32:07', '2022-07-11 19:32:07', b'0');
INSERT INTO `tb_message` VALUES ('1546457680884101121', 3, '1', b'1', 'fa10', 'USER', '2022-07-11 19:33:38', '2022-07-11 19:33:38', b'0');
INSERT INTO `tb_message` VALUES ('1546457852011704321', 3, '1', b'1', 'fa11', 'USER', '2022-07-11 19:34:18', '2022-07-11 19:34:18', b'0');
INSERT INTO `tb_message` VALUES ('1546458694001455106', 3, '1', b'1', 'fa12', 'USER', '2022-07-11 19:37:39', '2022-07-11 19:37:39', b'0');
INSERT INTO `tb_message` VALUES ('1546459110642642946', 3, '1', b'1', 'fa13', 'USER', '2022-07-11 19:39:18', '2022-07-11 19:39:18', b'0');
INSERT INTO `tb_message` VALUES ('1546459701204840450', 3, '1', b'1', 'fa14', 'USER', '2022-07-11 19:41:39', '2022-07-11 19:41:39', b'0');
INSERT INTO `tb_message` VALUES ('1546460031204290561', 3, '1', b'1', 'fa15', 'USER', '2022-07-11 19:42:58', '2022-07-11 19:42:58', b'0');
INSERT INTO `tb_message` VALUES ('1546460223722844162', 3, '1', b'1', 'fa16', 'USER', '2022-07-11 19:43:44', '2022-07-11 19:43:44', b'0');
INSERT INTO `tb_message` VALUES ('1546461746884341761', 3, '1', b'1', 'fa17', 'USER', '2022-07-11 19:49:47', '2022-07-11 19:49:47', b'0');
INSERT INTO `tb_message` VALUES ('1546463209941463041', 3, '1', b'1', '测试轮询', 'USER', '2022-07-11 19:55:36', '2022-07-11 19:55:36', b'0');
INSERT INTO `tb_message` VALUES ('1546463434487721986', 3, '1', b'1', '测试成功', 'USER', '2022-07-11 19:56:29', '2022-07-11 19:56:29', b'0');
INSERT INTO `tb_message` VALUES ('1546684756589338626', 3, '1', b'1', '发送1', 'USER', '2022-07-12 10:35:57', '2022-07-12 10:35:57', b'0');
INSERT INTO `tb_message` VALUES ('1546688502421577729', 3, '1', b'1', '发送2', 'USER', '2022-07-12 10:50:50', '2022-07-12 10:50:50', b'0');
INSERT INTO `tb_message` VALUES ('1546689241910996994', 3, '1', b'1', '发送3', 'USER', '2022-07-12 10:53:46', '2022-07-12 10:53:46', b'0');
INSERT INTO `tb_message` VALUES ('1546689290778832897', 3, '1', b'1', '发送4', 'USER', '2022-07-12 10:53:58', '2022-07-12 10:53:58', b'0');
INSERT INTO `tb_message` VALUES ('1546693160393371649', 3, '1', b'1', '发送5', 'USER', '2022-07-12 11:09:20', '2022-07-12 11:09:20', b'0');
INSERT INTO `tb_message` VALUES ('1546693429915152386', 1, '3', b'1', '收到1', 'USER', '2022-07-12 11:10:25', '2022-07-12 11:10:25', b'0');
INSERT INTO `tb_message` VALUES ('1546693597007835138', 3, '1', b'1', '发送6', 'USER', '2022-07-12 11:11:04', '2022-07-12 11:11:04', b'0');
INSERT INTO `tb_message` VALUES ('1546694732812775425', 3, '1', b'1', '发送7', 'USER', '2022-07-12 11:15:35', '2022-07-12 11:15:35', b'0');
INSERT INTO `tb_message` VALUES ('1546696424295886850', 3, '1', b'1', '发送8', 'USER', '2022-07-12 11:22:18', '2022-07-12 11:22:18', b'0');
INSERT INTO `tb_message` VALUES ('1546696800017444866', 3, '1', b'1', '发送9', 'USER', '2022-07-12 11:23:48', '2022-07-12 11:23:48', b'0');
INSERT INTO `tb_message` VALUES ('1546697104490360833', 3, '1', b'1', '发送10', 'USER', '2022-07-12 11:25:01', '2022-07-12 11:25:01', b'0');
INSERT INTO `tb_message` VALUES ('1546697199310991362', 3, '1', b'1', '发送11', 'USER', '2022-07-12 11:25:23', '2022-07-12 11:25:23', b'0');
INSERT INTO `tb_message` VALUES ('1546697275928342529', 3, '1', b'1', '发送12', 'USER', '2022-07-12 11:25:41', '2022-07-12 11:25:41', b'0');
INSERT INTO `tb_message` VALUES ('1546697551661887490', 3, '1', b'1', '发送13', 'USER', '2022-07-12 11:26:47', '2022-07-12 11:26:47', b'0');
INSERT INTO `tb_message` VALUES ('1546700409182482433', 2, '1', b'1', 'qq', 'USER', '2022-07-12 11:38:09', '2022-07-12 11:38:09', b'0');
INSERT INTO `tb_message` VALUES ('1546700436525150209', 3, '1', b'1', '发送14', 'USER', '2022-07-12 11:38:15', '2022-07-12 11:38:15', b'0');
INSERT INTO `tb_message` VALUES ('1546700761587904514', 3, '1', b'1', '发送15', 'USER', '2022-07-12 11:39:33', '2022-07-12 11:39:33', b'0');
INSERT INTO `tb_message` VALUES ('1546702982681587713', 2, '1', b'1', '发', 'USER', '2022-07-12 11:48:22', '2022-07-12 11:48:22', b'0');
INSERT INTO `tb_message` VALUES ('1546703033122287618', 3, '1', b'1', '发送16', 'USER', '2022-07-12 11:48:34', '2022-07-12 11:48:34', b'0');
INSERT INTO `tb_message` VALUES ('1546703057159843841', 3, '1', b'1', '发送17', 'USER', '2022-07-12 11:48:40', '2022-07-12 11:48:40', b'0');
INSERT INTO `tb_message` VALUES ('1546704294651490306', 3, '1', b'1', '发送18', 'USER', '2022-07-12 11:53:35', '2022-07-12 11:53:35', b'0');
INSERT INTO `tb_message` VALUES ('1546704308958261249', 3, '1', b'1', '发送19', 'USER', '2022-07-12 11:53:38', '2022-07-12 11:53:38', b'0');
INSERT INTO `tb_message` VALUES ('1546704502621859842', 2, '1', b'1', '发2', 'USER', '2022-07-12 11:54:24', '2022-07-12 11:54:24', b'0');
INSERT INTO `tb_message` VALUES ('1546710876500127745', 3, '1', b'1', '发送20', 'USER', '2022-07-12 12:19:44', '2022-07-12 12:19:44', b'0');
INSERT INTO `tb_message` VALUES ('1546713776974589953', 3, '1', b'1', '发送21', 'USER', '2022-07-12 12:31:16', '2022-07-12 12:31:16', b'0');
INSERT INTO `tb_message` VALUES ('1546713872747327489', 3, '1', b'1', '发送22', 'USER', '2022-07-12 12:31:38', '2022-07-12 12:31:38', b'0');
INSERT INTO `tb_message` VALUES ('1546714048664825857', 3, '1', b'1', '发送23', 'USER', '2022-07-12 12:32:20', '2022-07-12 12:32:20', b'0');
INSERT INTO `tb_message` VALUES ('1546714481240174594', 3, '1', b'1', '发送24', 'USER', '2022-07-12 12:34:04', '2022-07-12 12:34:04', b'0');
INSERT INTO `tb_message` VALUES ('1546714630205075458', 3, '1', b'1', '发送25', 'USER', '2022-07-12 12:34:39', '2022-07-12 12:34:39', b'0');
INSERT INTO `tb_message` VALUES ('1546714693664894977', 3, '1', b'1', '发送26', 'USER', '2022-07-12 12:34:54', '2022-07-12 12:34:54', b'0');
INSERT INTO `tb_message` VALUES ('1546714930374635522', 3, '1', b'1', '1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n\n1\n1\n1', 'USER', '2022-07-12 12:35:51', '2022-07-12 12:35:51', b'0');
INSERT INTO `tb_message` VALUES ('1546715264102821890', 2, '1', b'1', '发3', 'USER', '2022-07-12 12:37:10', '2022-07-12 12:37:10', b'0');
INSERT INTO `tb_message` VALUES ('1546715371632193537', 3, '1', b'1', '123', 'USER', '2022-07-12 12:37:36', '2022-07-12 12:37:36', b'0');
INSERT INTO `tb_message` VALUES ('1546744296852713474', 3, '1', b'1', '345', 'USER', '2022-07-12 14:32:32', '2022-07-12 14:32:32', b'0');
INSERT INTO `tb_message` VALUES ('1546744423302590466', 3, '1', b'1', '123', 'USER', '2022-07-12 14:33:02', '2022-07-12 14:33:02', b'0');
INSERT INTO `tb_message` VALUES ('1546744548104105986', 3, '1', b'1', '345', 'USER', '2022-07-12 14:33:32', '2022-07-12 14:33:32', b'0');
INSERT INTO `tb_message` VALUES ('1546745009787924481', 3, '1', b'1', 'asd', 'USER', '2022-07-12 14:35:22', '2022-07-12 14:35:22', b'0');
INSERT INTO `tb_message` VALUES ('1546755967671365634', 1, '4', b'1', '第一次发送', 'USER', '2022-07-12 15:18:55', '2022-07-12 15:18:55', b'0');
INSERT INTO `tb_message` VALUES ('1546756183799656450', 1, '4', b'1', '第二次发送', 'USER', '2022-07-12 15:19:46', '2022-07-12 15:19:46', b'0');
INSERT INTO `tb_message` VALUES ('1546763281119866881', 4, '1', b'1', '发', 'USER', '2022-07-12 15:47:58', '2022-07-12 15:47:58', b'0');
INSERT INTO `tb_message` VALUES ('1546763345393381378', 1, '4', b'1', '嗯', 'USER', '2022-07-12 15:48:14', '2022-07-12 15:48:14', b'0');
INSERT INTO `tb_message` VALUES ('1546772396328161282', 1, '5', b'1', '再次测试', 'USER', '2022-07-12 16:24:12', '2022-07-12 16:24:12', b'0');
INSERT INTO `tb_message` VALUES ('1546812059533185025', 1, '7', b'1', 'asd', 'USER', '2022-07-12 19:01:48', '2022-07-12 19:01:48', b'0');
INSERT INTO `tb_message` VALUES ('1546812187853721601', 1, '7', b'1', '芜湖', 'USER', '2022-07-12 19:02:19', '2022-07-12 19:02:19', b'0');
INSERT INTO `tb_message` VALUES ('1546812231243796481', 7, '1', b'1', '?', 'USER', '2022-07-12 19:02:29', '2022-07-12 19:02:29', b'0');
INSERT INTO `tb_message` VALUES ('1546812957730803714', 7, '1', b'1', '../', 'USER', '2022-07-12 19:05:22', '2022-07-12 19:05:22', b'0');
INSERT INTO `tb_message` VALUES ('1546813496463986689', 7, '1', b'1', '123', 'USER', '2022-07-12 19:07:31', '2022-07-12 19:07:31', b'0');
INSERT INTO `tb_message` VALUES ('1546815815243010050', 7, '1', b'1', '22', 'USER', '2022-07-12 19:16:43', '2022-07-12 19:16:43', b'0');
INSERT INTO `tb_message` VALUES ('1546816064900567041', 1, '7', b'1', '🆗', 'USER', '2022-07-12 19:17:43', '2022-07-12 19:17:43', b'0');
INSERT INTO `tb_message` VALUES ('1546816247298265089', 1, '7', b'1', 'qwe', 'USER', '2022-07-12 19:18:26', '2022-07-12 19:18:26', b'0');
INSERT INTO `tb_message` VALUES ('1546816275995693057', 1, '7', b'1', 'emm', 'USER', '2022-07-12 19:18:33', '2022-07-12 19:18:33', b'0');
INSERT INTO `tb_message` VALUES ('1546816301559975937', 7, '1', b'1', 'sd', 'USER', '2022-07-12 19:18:39', '2022-07-12 19:18:39', b'0');
INSERT INTO `tb_message` VALUES ('1546816720134737921', 1, '6', b'1', '最终测试', 'USER', '2022-07-12 19:20:19', '2022-07-12 19:20:19', b'0');
INSERT INTO `tb_message` VALUES ('1546816763772276737', 6, '1', b'1', '测试成功', 'USER', '2022-07-12 19:20:30', '2022-07-12 19:20:30', b'0');
INSERT INTO `tb_message` VALUES ('1546816888154361858', 1, '7', b'1', '行', 'USER', '2022-07-12 19:20:59', '2022-07-12 19:20:59', b'0');
INSERT INTO `tb_message` VALUES ('1546817130710962178', 6, '1', b'1', '111', 'USER', '2022-07-12 19:21:57', '2022-07-12 19:21:57', b'0');
INSERT INTO `tb_message` VALUES ('1546817235040079874', 7, '1', b'1', '222', 'USER', '2022-07-12 19:22:22', '2022-07-12 19:22:22', b'0');
INSERT INTO `tb_message` VALUES ('1546817363524194305', 7, '1', b'1', '333', 'USER', '2022-07-12 19:22:53', '2022-07-12 19:22:53', b'0');
INSERT INTO `tb_message` VALUES ('1546819341549572097', 7, '1', b'1', '444', 'USER', '2022-07-12 19:30:44', '2022-07-12 19:30:44', b'0');
INSERT INTO `tb_message` VALUES ('1546819702473625602', 7, '1', b'1', '555', 'USER', '2022-07-12 19:32:10', '2022-07-12 19:32:10', b'0');
INSERT INTO `tb_message` VALUES ('1546826426970542082', 7, '1', b'1', '111', 'USER', '2022-07-12 19:58:54', '2022-07-12 19:58:54', b'0');
INSERT INTO `tb_message` VALUES ('1546826504166707201', 7, '1', b'1', '2234', 'USER', '2022-07-12 19:59:12', '2022-07-12 19:59:12', b'0');
INSERT INTO `tb_message` VALUES ('1546830226380820481', 7, '1', b'1', '12345', 'USER', '2022-07-12 20:13:59', '2022-07-12 20:13:59', b'0');
INSERT INTO `tb_message` VALUES ('1546830401484623874', 6, '1', b'1', '3456789', 'USER', '2022-07-12 20:14:41', '2022-07-12 20:14:41', b'0');
INSERT INTO `tb_message` VALUES ('1546830643504353281', 6, '1', b'1', 'asdawd', 'USER', '2022-07-12 20:15:39', '2022-07-12 20:15:39', b'0');
INSERT INTO `tb_message` VALUES ('1546833796136177666', 1, '8', b'1', '再次测试', 'USER', '2022-07-12 20:28:10', '2022-07-12 20:28:10', b'0');
INSERT INTO `tb_message` VALUES ('1546834209560334338', 8, '1', b'1', '测试成功', 'USER', '2022-07-12 20:29:49', '2022-07-12 20:29:49', b'0');
INSERT INTO `tb_message` VALUES ('1546834279311609857', 8, '1', b'1', '+1', 'USER', '2022-07-12 20:30:06', '2022-07-12 20:30:06', b'0');
INSERT INTO `tb_message` VALUES ('1546834549613531138', 7, '1', b'1', '__2', 'USER', '2022-07-12 20:31:10', '2022-07-12 20:31:10', b'0');
INSERT INTO `tb_message` VALUES ('1546834617494147074', 7, '1', b'1', 'eee', 'USER', '2022-07-12 20:31:26', '2022-07-12 20:31:26', b'0');
INSERT INTO `tb_message` VALUES ('1546834719138910210', 7, '1', b'1', 'hxcgl', 'USER', '2022-07-12 20:31:51', '2022-07-12 20:31:51', b'0');
INSERT INTO `tb_message` VALUES ('1546836353998917633', 7, '1', b'1', 'fa', 'USER', '2022-07-12 20:38:20', '2022-07-12 20:38:20', b'0');
INSERT INTO `tb_message` VALUES ('1546836427680256002', 7, '1', b'1', '1', 'USER', '2022-07-12 20:38:38', '2022-07-12 20:38:38', b'0');
INSERT INTO `tb_message` VALUES ('1546836433044770818', 7, '1', b'1', '2', 'USER', '2022-07-12 20:38:39', '2022-07-12 20:38:39', b'0');
INSERT INTO `tb_message` VALUES ('1546836437046136833', 7, '1', b'1', '3', 'USER', '2022-07-12 20:38:40', '2022-07-12 20:38:40', b'0');
INSERT INTO `tb_message` VALUES ('1546836501537755138', 1, '7', b'1', 'ok', 'USER', '2022-07-12 20:38:55', '2022-07-12 20:38:55', b'0');
INSERT INTO `tb_message` VALUES ('1546836866693861377', 1, '7', b'1', '请问', 'USER', '2022-07-12 20:40:23', '2022-07-12 20:40:23', b'0');
INSERT INTO `tb_message` VALUES ('1546857614254817282', 1, '7', b'1', '再测', 'USER', '2022-07-12 22:02:49', '2022-07-12 22:02:49', b'0');
INSERT INTO `tb_message` VALUES ('1546858677997420545', 1, '7', b'1', '1234', 'USER', '2022-07-12 22:07:03', '2022-07-12 22:07:03', b'0');
INSERT INTO `tb_message` VALUES ('1546858905953648641', 1, '7', b'1', '阿萨德', 'USER', '2022-07-12 22:07:57', '2022-07-12 22:07:57', b'0');
INSERT INTO `tb_message` VALUES ('1546859023763259393', 7, '1', b'1', '123', 'USER', '2022-07-12 22:08:25', '2022-07-12 22:08:25', b'0');
INSERT INTO `tb_message` VALUES ('1546859104042237954', 8, '1', b'1', 'ewdasd', 'USER', '2022-07-12 22:08:44', '2022-07-12 22:08:44', b'0');
INSERT INTO `tb_message` VALUES ('1546859113215180801', 8, '1', b'1', 'dasd', 'USER', '2022-07-12 22:08:47', '2022-07-12 22:08:47', b'0');
INSERT INTO `tb_message` VALUES ('1546859381508030466', 1, '9', b'1', '天热', 'USER', '2022-07-12 22:09:50', '2022-07-12 22:09:50', b'0');
INSERT INTO `tb_message` VALUES ('1546859489414889474', 9, '1', b'1', 'gtg', 'USER', '2022-07-12 22:10:16', '2022-07-12 22:10:16', b'0');
INSERT INTO `tb_message` VALUES ('1546860466352177153', 1, '10', b'1', 'asdc', 'USER', '2022-07-12 22:14:09', '2022-07-12 22:14:09', b'0');
INSERT INTO `tb_message` VALUES ('1546872791503224834', 7, '1', b'1', 'asd', 'USER', '2022-07-12 23:03:08', '2022-07-12 23:03:08', b'0');
INSERT INTO `tb_message` VALUES ('1547019315780526082', 7, '1', b'1', 'qwer', 'USER', '2022-07-13 08:45:22', '2022-07-13 08:45:22', b'0');
INSERT INTO `tb_message` VALUES ('1547380894258700290', 3, '1', b'1', 'qwe', 'USER', '2022-07-14 08:42:09', '2022-07-14 08:42:09', b'0');
INSERT INTO `tb_message` VALUES ('1547381032796561409', 1, '3', b'1', '🆗', 'USER', '2022-07-14 08:42:42', '2022-07-14 08:42:42', b'0');
INSERT INTO `tb_message` VALUES ('1547479636336979969', 1, '10', b'0', '111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111', 'USER', '2022-07-14 15:14:31', '2022-07-14 15:14:31', b'0');
INSERT INTO `tb_message` VALUES ('1547495889713770498', 1, '10', b'0', '111111111111111111111111111111111111111111111111111111111111111111111111qwwwwwwwwwwwwwwwe', 'USER', '2022-07-14 16:19:06', '2022-07-14 16:19:06', b'0');
INSERT INTO `tb_message` VALUES ('1547553481106493441', 3, '1', b'1', '111', 'USER', '2022-07-14 20:07:57', '2022-07-14 20:07:57', b'0');
INSERT INTO `tb_message` VALUES ('1547553563914637314', 1, '3', b'1', '234', 'USER', '2022-07-14 20:08:16', '2022-07-14 20:08:16', b'0');
INSERT INTO `tb_message` VALUES ('1547767471237947394', 3, '1', b'1', '345', 'USER', '2022-07-15 10:18:16', '2022-07-15 10:18:16', b'0');
INSERT INTO `tb_message` VALUES ('1547767777984176129', 3, '1', b'1', '3444', 'USER', '2022-07-15 10:19:29', '2022-07-15 10:19:29', b'0');
INSERT INTO `tb_message` VALUES ('1547767784888000513', 3, '1', b'1', '56', 'USER', '2022-07-15 10:19:31', '2022-07-15 10:19:31', b'0');
INSERT INTO `tb_message` VALUES ('1547767793473740802', 3, '1', b'1', '12', 'USER', '2022-07-15 10:19:33', '2022-07-15 10:19:33', b'0');
INSERT INTO `tb_message` VALUES ('1549226049249460226', 3, '1', b'1', '1235', 'USER', '2022-07-19 10:54:08', '2022-07-19 10:54:08', b'0');
INSERT INTO `tb_message` VALUES ('1549226371682385921', 1, '3', b'1', 'ok', 'USER', '2022-07-19 10:55:25', '2022-07-19 10:55:25', b'0');
INSERT INTO `tb_message` VALUES ('1549227326880595970', 3, '5', b'1', '#{qwe}', 'USER', '2022-07-19 10:59:13', '2022-07-19 10:59:13', b'0');
INSERT INTO `tb_message` VALUES ('1549723218213474305', 3, '1', b'1', 'qwe', 'USER', '2022-07-20 19:49:42', '2022-07-20 19:49:42', b'0');
INSERT INTO `tb_message` VALUES ('1549924091669749761', 1, '10', b'0', '123', 'USER', '2022-07-21 09:07:54', '2022-07-21 09:07:54', b'0');
INSERT INTO `tb_message` VALUES ('1549924223752577026', 1, '3', b'1', '345', 'USER', '2022-07-21 09:08:26', '2022-07-21 09:08:26', b'0');
INSERT INTO `tb_message` VALUES ('1549926342740123649', 3, '1', b'1', 'qwe', 'USER', '2022-07-21 09:16:51', '2022-07-21 09:16:51', b'0');
INSERT INTO `tb_message` VALUES ('1549930449764855810', 1, '3', b'1', 'asd', 'USER', '2022-07-21 09:33:10', '2022-07-21 09:33:10', b'0');
INSERT INTO `tb_message` VALUES ('1549930577959563266', 3, '1', b'1', 'ok', 'USER', '2022-07-21 09:33:41', '2022-07-21 09:33:41', b'0');
INSERT INTO `tb_message` VALUES ('1549952287349891073', 11, '1', b'1', 'user11', 'USER', '2022-07-21 10:59:57', '2022-07-21 10:59:57', b'0');
INSERT INTO `tb_message` VALUES ('1554354070580162561', 1, '3', b'1', 'test\n', 'USER', '2022-08-02 14:31:04', '2022-08-02 14:31:04', b'0');
INSERT INTO `tb_message` VALUES ('1555442176239767553', 1, '11', b'0', '123', 'USER', '2022-08-05 14:34:48', '2022-08-05 14:34:48', b'0');
INSERT INTO `tb_message` VALUES ('1555459846955769857', 12, '1', b'1', 'id为：1的用户给你的文章(id:1554806968044810242) 点了个赞', 'USER', '2022-08-05 15:45:01', '2022-08-05 15:45:01', b'0');
INSERT INTO `tb_message` VALUES ('1555469845723590657', 12, '1', b'1', '用户 用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-05 16:24:45', '2022-08-05 16:24:45', b'0');
INSERT INTO `tb_message` VALUES ('1555470154386616322', 12, '1', b'1', '用户 用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-05 16:25:59', '2022-08-05 16:25:59', b'0');
INSERT INTO `tb_message` VALUES ('1555475237056774146', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-05 16:46:11', '2022-08-05 16:46:11', b'0');
INSERT INTO `tb_message` VALUES ('1558035906710831105', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:21:22', '2022-08-12 18:21:22', b'0');
INSERT INTO `tb_message` VALUES ('1558035906870214658', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:21:22', '2022-08-12 18:21:22', b'0');
INSERT INTO `tb_message` VALUES ('1558035906933129218', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:21:22', '2022-08-12 18:21:22', b'0');
INSERT INTO `tb_message` VALUES ('1558035906933129219', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:21:22', '2022-08-12 18:21:22', b'0');
INSERT INTO `tb_message` VALUES ('1558037088552431618', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:26:03', '2022-08-12 18:26:03', b'0');
INSERT INTO `tb_message` VALUES ('1558037088602763265', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:26:04', '2022-08-12 18:26:04', b'0');
INSERT INTO `tb_message` VALUES ('1558037088736980993', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:26:04', '2022-08-12 18:26:04', b'0');
INSERT INTO `tb_message` VALUES ('1558037088736980994', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:26:04', '2022-08-12 18:26:04', b'0');
INSERT INTO `tb_message` VALUES ('1558037374641737730', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:27:12', '2022-08-12 18:27:12', b'0');
INSERT INTO `tb_message` VALUES ('1558037374822092802', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:27:12', '2022-08-12 18:27:12', b'0');
INSERT INTO `tb_message` VALUES ('1558037374885007361', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:27:12', '2022-08-12 18:27:12', b'0');
INSERT INTO `tb_message` VALUES ('1558037374952116226', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:27:12', '2022-08-12 18:27:12', b'0');
INSERT INTO `tb_message` VALUES ('1558037448524402690', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:27:29', '2022-08-12 18:27:29', b'0');
INSERT INTO `tb_message` VALUES ('1558037448591511554', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:27:29', '2022-08-12 18:27:29', b'0');
INSERT INTO `tb_message` VALUES ('1558037448650231809', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:27:29', '2022-08-12 18:27:29', b'0');
INSERT INTO `tb_message` VALUES ('1558037448650231810', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:27:29', '2022-08-12 18:27:29', b'0');
INSERT INTO `tb_message` VALUES ('1558037532322402306', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:27:49', '2022-08-12 18:27:49', b'0');
INSERT INTO `tb_message` VALUES ('1558037532385316866', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:27:49', '2022-08-12 18:27:49', b'0');
INSERT INTO `tb_message` VALUES ('1558037532452425729', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:27:49', '2022-08-12 18:27:49', b'0');
INSERT INTO `tb_message` VALUES ('1558037532452425730', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:27:49', '2022-08-12 18:27:49', b'0');
INSERT INTO `tb_message` VALUES ('1558037616263008257', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:28:09', '2022-08-12 18:28:09', b'0');
INSERT INTO `tb_message` VALUES ('1558037616325922818', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:28:09', '2022-08-12 18:28:09', b'0');
INSERT INTO `tb_message` VALUES ('1558037616388837378', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:28:09', '2022-08-12 18:28:09', b'0');
INSERT INTO `tb_message` VALUES ('1558037616455946242', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:28:09', '2022-08-12 18:28:09', b'0');
INSERT INTO `tb_message` VALUES ('1558037700115533825', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:28:29', '2022-08-12 18:28:29', b'0');
INSERT INTO `tb_message` VALUES ('1558037700115533826', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:28:29', '2022-08-12 18:28:29', b'0');
INSERT INTO `tb_message` VALUES ('1558037700178448386', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:28:29', '2022-08-12 18:28:29', b'0');
INSERT INTO `tb_message` VALUES ('1558037700178448387', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:28:29', '2022-08-12 18:28:29', b'0');
INSERT INTO `tb_message` VALUES ('1558037783905144833', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:28:49', '2022-08-12 18:28:49', b'0');
INSERT INTO `tb_message` VALUES ('1558037783972253697', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:28:49', '2022-08-12 18:28:49', b'0');
INSERT INTO `tb_message` VALUES ('1558037783972253698', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:28:49', '2022-08-12 18:28:49', b'0');
INSERT INTO `tb_message` VALUES ('1558037784035168257', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:28:49', '2022-08-12 18:28:49', b'0');
INSERT INTO `tb_message` VALUES ('1558037867837362178', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:29:09', '2022-08-12 18:29:09', b'0');
INSERT INTO `tb_message` VALUES ('1558037867904471042', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:29:09', '2022-08-12 18:29:09', b'0');
INSERT INTO `tb_message` VALUES ('1558037867904471043', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:29:09', '2022-08-12 18:29:09', b'0');
INSERT INTO `tb_message` VALUES ('1558037867967385601', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:29:09', '2022-08-12 18:29:09', b'0');
INSERT INTO `tb_message` VALUES ('1558037951811522561', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:29:29', '2022-08-12 18:29:29', b'0');
INSERT INTO `tb_message` VALUES ('1558037951945740289', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:29:29', '2022-08-12 18:29:29', b'0');
INSERT INTO `tb_message` VALUES ('1558037952004460545', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:29:29', '2022-08-12 18:29:29', b'0');
INSERT INTO `tb_message` VALUES ('1558037952004460546', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:29:29', '2022-08-12 18:29:29', b'0');
INSERT INTO `tb_message` VALUES ('1558038035575967745', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:29:49', '2022-08-12 18:29:49', b'0');
INSERT INTO `tb_message` VALUES ('1558038035575967746', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:29:49', '2022-08-12 18:29:49', b'0');
INSERT INTO `tb_message` VALUES ('1558038035575967747', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:29:49', '2022-08-12 18:29:49', b'0');
INSERT INTO `tb_message` VALUES ('1558038035638882306', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:29:49', '2022-08-12 18:29:49', b'0');
INSERT INTO `tb_message` VALUES ('1558038119436881921', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:30:09', '2022-08-12 18:30:09', b'0');
INSERT INTO `tb_message` VALUES ('1558038119499796481', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:30:09', '2022-08-12 18:30:09', b'0');
INSERT INTO `tb_message` VALUES ('1558038119499796482', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:30:09', '2022-08-12 18:30:09', b'0');
INSERT INTO `tb_message` VALUES ('1558038119566905346', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:30:09', '2022-08-12 18:30:09', b'0');
INSERT INTO `tb_message` VALUES ('1558038203310379009', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:30:29', '2022-08-12 18:30:29', b'0');
INSERT INTO `tb_message` VALUES ('1558038203377487873', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:30:29', '2022-08-12 18:30:29', b'0');
INSERT INTO `tb_message` VALUES ('1558038203377487874', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:30:29', '2022-08-12 18:30:29', b'0');
INSERT INTO `tb_message` VALUES ('1558038203440402434', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:30:29', '2022-08-12 18:30:29', b'0');
INSERT INTO `tb_message` VALUES ('1558038287213236225', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:30:49', '2022-08-12 18:30:49', b'0');
INSERT INTO `tb_message` VALUES ('1558038287213236226', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:30:49', '2022-08-12 18:30:49', b'0');
INSERT INTO `tb_message` VALUES ('1558038287276150785', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:30:49', '2022-08-12 18:30:49', b'0');
INSERT INTO `tb_message` VALUES ('1558038287343259649', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:30:49', '2022-08-12 18:30:49', b'0');
INSERT INTO `tb_message` VALUES ('1558038371044790273', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:31:09', '2022-08-12 18:31:09', b'0');
INSERT INTO `tb_message` VALUES ('1558038371044790274', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:31:09', '2022-08-12 18:31:09', b'0');
INSERT INTO `tb_message` VALUES ('1558038371107704834', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:31:09', '2022-08-12 18:31:09', b'0');
INSERT INTO `tb_message` VALUES ('1558038371107704835', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:31:09', '2022-08-12 18:31:09', b'0');
INSERT INTO `tb_message` VALUES ('1558038454964424705', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:31:29', '2022-08-12 18:31:29', b'0');
INSERT INTO `tb_message` VALUES ('1558038455027339265', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:31:29', '2022-08-12 18:31:29', b'0');
INSERT INTO `tb_message` VALUES ('1558038455027339266', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:31:29', '2022-08-12 18:31:29', b'0');
INSERT INTO `tb_message` VALUES ('1558038455090253826', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:31:29', '2022-08-12 18:31:29', b'0');
INSERT INTO `tb_message` VALUES ('1558038538816950274', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:31:49', '2022-08-12 18:31:49', b'0');
INSERT INTO `tb_message` VALUES ('1558038538816950275', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:31:49', '2022-08-12 18:31:49', b'0');
INSERT INTO `tb_message` VALUES ('1558038538879864834', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:31:49', '2022-08-12 18:31:49', b'0');
INSERT INTO `tb_message` VALUES ('1558038538879864835', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:31:49', '2022-08-12 18:31:49', b'0');
INSERT INTO `tb_message` VALUES ('1558038622757556225', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:32:09', '2022-08-12 18:32:09', b'0');
INSERT INTO `tb_message` VALUES ('1558038622757556226', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:32:09', '2022-08-12 18:32:09', b'0');
INSERT INTO `tb_message` VALUES ('1558038622820470786', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:32:09', '2022-08-12 18:32:09', b'0');
INSERT INTO `tb_message` VALUES ('1558038622820470787', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:32:09', '2022-08-12 18:32:09', b'0');
INSERT INTO `tb_message` VALUES ('1558038706631053314', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:32:29', '2022-08-12 18:32:29', b'0');
INSERT INTO `tb_message` VALUES ('1558038706631053315', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:32:29', '2022-08-12 18:32:29', b'0');
INSERT INTO `tb_message` VALUES ('1558038706693967873', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:32:29', '2022-08-12 18:32:29', b'0');
INSERT INTO `tb_message` VALUES ('1558038706693967874', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:32:29', '2022-08-12 18:32:29', b'0');
INSERT INTO `tb_message` VALUES ('1558038790412275713', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:32:49', '2022-08-12 18:32:49', b'0');
INSERT INTO `tb_message` VALUES ('1558038790475190273', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:32:49', '2022-08-12 18:32:49', b'0');
INSERT INTO `tb_message` VALUES ('1558038790538104833', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:32:49', '2022-08-12 18:32:49', b'0');
INSERT INTO `tb_message` VALUES ('1558038790538104834', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:32:49', '2022-08-12 18:32:49', b'0');
INSERT INTO `tb_message` VALUES ('1558038874415796225', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:33:09', '2022-08-12 18:33:09', b'0');
INSERT INTO `tb_message` VALUES ('1558038874478710786', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:33:09', '2022-08-12 18:33:09', b'0');
INSERT INTO `tb_message` VALUES ('1558038874478710787', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:33:09', '2022-08-12 18:33:09', b'0');
INSERT INTO `tb_message` VALUES ('1558038874478710788', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:33:09', '2022-08-12 18:33:09', b'0');
INSERT INTO `tb_message` VALUES ('1558038958297681922', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:33:29', '2022-08-12 18:33:29', b'0');
INSERT INTO `tb_message` VALUES ('1558038958297681923', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:33:29', '2022-08-12 18:33:29', b'0');
INSERT INTO `tb_message` VALUES ('1558038958364790785', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:33:29', '2022-08-12 18:33:29', b'0');
INSERT INTO `tb_message` VALUES ('1558038958364790786', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:33:29', '2022-08-12 18:33:29', b'0');
INSERT INTO `tb_message` VALUES ('1558039042150207490', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:33:49', '2022-08-12 18:33:49', b'0');
INSERT INTO `tb_message` VALUES ('1558039042213122049', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:33:49', '2022-08-12 18:33:49', b'0');
INSERT INTO `tb_message` VALUES ('1558039042213122050', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:33:49', '2022-08-12 18:33:49', b'0');
INSERT INTO `tb_message` VALUES ('1558039042280230914', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:33:49', '2022-08-12 18:33:49', b'0');
INSERT INTO `tb_message` VALUES ('1558039126053064705', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:34:09', '2022-08-12 18:34:09', b'0');
INSERT INTO `tb_message` VALUES ('1558039126053064706', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:34:09', '2022-08-12 18:34:09', b'0');
INSERT INTO `tb_message` VALUES ('1558039126120173569', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:34:09', '2022-08-12 18:34:09', b'0');
INSERT INTO `tb_message` VALUES ('1558039126120173570', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:34:09', '2022-08-12 18:34:09', b'0');
INSERT INTO `tb_message` VALUES ('1558039209943339010', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:34:29', '2022-08-12 18:34:29', b'0');
INSERT INTO `tb_message` VALUES ('1558039209943339011', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:34:29', '2022-08-12 18:34:29', b'0');
INSERT INTO `tb_message` VALUES ('1558039210010447873', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:34:29', '2022-08-12 18:34:29', b'0');
INSERT INTO `tb_message` VALUES ('1558039210010447874', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:34:29', '2022-08-12 18:34:29', b'0');
INSERT INTO `tb_message` VALUES ('1558039293716172802', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:34:49', '2022-08-12 18:34:49', b'0');
INSERT INTO `tb_message` VALUES ('1558039293779087362', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:34:49', '2022-08-12 18:34:49', b'0');
INSERT INTO `tb_message` VALUES ('1558039293846196225', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:34:49', '2022-08-12 18:34:49', b'0');
INSERT INTO `tb_message` VALUES ('1558039293846196226', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:34:49', '2022-08-12 18:34:49', b'0');
INSERT INTO `tb_message` VALUES ('1558039377623224322', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:35:09', '2022-08-12 18:35:09', b'0');
INSERT INTO `tb_message` VALUES ('1558039377686138882', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:35:09', '2022-08-12 18:35:09', b'0');
INSERT INTO `tb_message` VALUES ('1558039377753247746', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:35:09', '2022-08-12 18:35:09', b'0');
INSERT INTO `tb_message` VALUES ('1558039377753247747', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:35:09', '2022-08-12 18:35:09', b'0');
INSERT INTO `tb_message` VALUES ('1558039461500915714', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:35:29', '2022-08-12 18:35:29', b'0');
INSERT INTO `tb_message` VALUES ('1558039461563830273', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:35:29', '2022-08-12 18:35:29', b'0');
INSERT INTO `tb_message` VALUES ('1558039461630939137', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:35:29', '2022-08-12 18:35:29', b'0');
INSERT INTO `tb_message` VALUES ('1558039461630939138', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:35:29', '2022-08-12 18:35:29', b'0');
INSERT INTO `tb_message` VALUES ('1558039545441521666', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:35:49', '2022-08-12 18:35:49', b'0');
INSERT INTO `tb_message` VALUES ('1558039545508630530', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:35:49', '2022-08-12 18:35:49', b'0');
INSERT INTO `tb_message` VALUES ('1558039545508630531', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:35:49', '2022-08-12 18:35:49', b'0');
INSERT INTO `tb_message` VALUES ('1558039545571545089', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:35:49', '2022-08-12 18:35:49', b'0');
INSERT INTO `tb_message` VALUES ('1558039629365350402', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:36:09', '2022-08-12 18:36:09', b'0');
INSERT INTO `tb_message` VALUES ('1558039629365350403', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:36:09', '2022-08-12 18:36:09', b'0');
INSERT INTO `tb_message` VALUES ('1558039629432459266', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:36:09', '2022-08-12 18:36:09', b'0');
INSERT INTO `tb_message` VALUES ('1558039629432459267', 12, '5', b'1', 'db(id:1)点赞了你的文章：《Redis incr 的坑》(id:1558003573789298689)', 'USER', '2022-08-12 18:36:09', '2022-08-12 18:36:09', b'0');
INSERT INTO `tb_message` VALUES ('1558039629495373826', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:36:09', '2022-08-12 18:36:09', b'0');
INSERT INTO `tb_message` VALUES ('1558039713230458881', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:36:29', '2022-08-12 18:36:29', b'0');
INSERT INTO `tb_message` VALUES ('1558039713293373441', 12, '5', b'1', 'db(id:1)点赞了你的文章：《Redis incr 的坑》(id:1558003573789298689)', 'USER', '2022-08-12 18:36:29', '2022-08-12 18:36:29', b'0');
INSERT INTO `tb_message` VALUES ('1558039713293373442', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:36:29', '2022-08-12 18:36:29', b'0');
INSERT INTO `tb_message` VALUES ('1558039713360482305', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:36:29', '2022-08-12 18:36:29', b'0');
INSERT INTO `tb_message` VALUES ('1558039713423396866', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:36:29', '2022-08-12 18:36:29', b'0');
INSERT INTO `tb_message` VALUES ('1558039797112344578', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:36:49', '2022-08-12 18:36:49', b'0');
INSERT INTO `tb_message` VALUES ('1558039797112344579', 12, '5', b'1', 'db(id:1)点赞了你的文章：《Redis incr 的坑》(id:1558003573789298689)', 'USER', '2022-08-12 18:36:49', '2022-08-12 18:36:49', b'0');
INSERT INTO `tb_message` VALUES ('1558039797175259138', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:36:49', '2022-08-12 18:36:49', b'0');
INSERT INTO `tb_message` VALUES ('1558039797175259139', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:36:49', '2022-08-12 18:36:49', b'0');
INSERT INTO `tb_message` VALUES ('1558039797175259140', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:36:49', '2022-08-12 18:36:49', b'0');
INSERT INTO `tb_message` VALUES ('1558039880998424578', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:37:09', '2022-08-12 18:37:09', b'0');
INSERT INTO `tb_message` VALUES ('1558039880998424579', 12, '5', b'1', 'db(id:1)点赞了你的文章：《Redis incr 的坑》(id:1558003573789298689)', 'USER', '2022-08-12 18:37:09', '2022-08-12 18:37:09', b'0');
INSERT INTO `tb_message` VALUES ('1558039881061339137', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:37:09', '2022-08-12 18:37:09', b'0');
INSERT INTO `tb_message` VALUES ('1558039881061339138', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:37:09', '2022-08-12 18:37:09', b'0');
INSERT INTO `tb_message` VALUES ('1558039881061339139', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:37:09', '2022-08-12 18:37:09', b'0');
INSERT INTO `tb_message` VALUES ('1558039964888698882', 12, '5', b'1', 'db(id:1)点赞了你的文章：《Redis incr 的坑》(id:1558003573789298689)', 'USER', '2022-08-12 18:37:29', '2022-08-12 18:37:29', b'0');
INSERT INTO `tb_message` VALUES ('1558039964888698883', 12, '3', b'0', 'db(id:1)点赞了你的文章：《test 8/4-2》(id:1555096151044993026)', 'USER', '2022-08-12 18:37:29', '2022-08-12 18:37:29', b'0');
INSERT INTO `tb_message` VALUES ('1558039964951613441', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test summary》(id:1555023170033750017)', 'USER', '2022-08-12 18:37:29', '2022-08-12 18:37:29', b'0');
INSERT INTO `tb_message` VALUES ('1558039964951613442', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《test 8/3-1》(id:1554806968044810242)', 'USER', '2022-08-12 18:37:29', '2022-08-12 18:37:29', b'0');
INSERT INTO `tb_message` VALUES ('1558039965018722305', 12, '1', b'1', '用户test4(id:4)点赞了你的文章：《GROUP BY 用法实例》(id:1549961615096086529)', 'USER', '2022-08-12 18:37:29', '2022-08-12 18:37:29', b'0');
INSERT INTO `tb_message` VALUES ('1560550963423592449', 12, '5', b'1', '用户9(id:9)点赞了你的文章：《Redis incr 的坑》(id:1558003573789298689)', 'USER', '2022-08-19 16:55:18', '2022-08-19 16:55:18', b'0');
INSERT INTO `tb_message` VALUES ('1560553563921432577', 12, '1', b'1', 'test5(id:5)点赞了你的文章：《Redis 缓存》(id:1557643991160500225)', 'USER', '2022-08-19 17:05:38', '2022-08-19 17:05:38', b'0');
INSERT INTO `tb_message` VALUES ('1561611565692731394', 1, '11', b'0', '11', 'USER', '2022-08-22 15:09:45', '2022-08-22 15:09:45', b'0');
INSERT INTO `tb_message` VALUES ('1566712411652726785', 12, '3', b'0', 'db(id:1)点赞了你的文章：《尝试更换jdk》(id:1550365379057553410)', 'USER', '2022-09-05 16:58:42', '2022-09-05 16:58:42', b'0');

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
-- Records of tb_notification
-- ----------------------------
INSERT INTO `tb_notification` VALUES (1, '开发中...', '2022-06-17 11:15:45', b'0');
INSERT INTO `tb_notification` VALUES (2, '致力于打造一个自由、开放的社区', '2022-10-09 21:10:06', b'1');

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
-- Records of tb_permission
-- ----------------------------
INSERT INTO `tb_permission` VALUES (1, '删除文章', 'article.delete');
INSERT INTO `tb_permission` VALUES (2, '置顶文章', 'article.setTop');
INSERT INTO `tb_permission` VALUES (3, '审核文章', 'article.review');
INSERT INTO `tb_permission` VALUES (4, '置顶文章', 'article.setTop');

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
-- Records of tb_reply
-- ----------------------------
INSERT INTO `tb_reply` VALUES ('1537693860348858370', 1, NULL, '1537693794632503297', '1', '2022-06-17 15:09:20', '2022-06-17 15:09:20', b'0');
INSERT INTO `tb_reply` VALUES ('1537693874894704641', 1, '1', '1537693794632503297', '2', '2022-06-17 15:09:23', '2022-06-17 15:09:23', b'0');
INSERT INTO `tb_reply` VALUES ('1539047210068152322', 1, NULL, '1539047067667337217', '1', '2022-06-21 08:47:04', '2022-06-21 08:47:04', b'0');
INSERT INTO `tb_reply` VALUES ('1539047230213394433', 1, '1', '1539047067667337217', '2', '2022-06-21 08:47:08', '2022-06-21 08:47:08', b'0');
INSERT INTO `tb_reply` VALUES ('1539047247015776257', 1, NULL, '1539047067667337217', '3', '2022-06-21 08:47:12', '2022-06-21 08:47:12', b'0');
INSERT INTO `tb_reply` VALUES ('1539047275042115586', 1, '1', '1539047067667337217', '4', '2022-06-21 08:47:19', '2022-06-21 08:47:19', b'0');
INSERT INTO `tb_reply` VALUES ('1539047292817575937', 1, '1', '1539047067667337217', '5', '2022-06-21 08:47:23', '2022-06-21 08:47:23', b'0');
INSERT INTO `tb_reply` VALUES ('1539047311855521793', 1, '1', '1539047067667337217', '6', '2022-06-21 08:47:28', '2022-06-21 08:47:28', b'0');
INSERT INTO `tb_reply` VALUES ('1539047331229011970', 1, '1', '1539047067667337217', '7', '2022-06-21 08:47:33', '2022-06-21 08:47:33', b'0');
INSERT INTO `tb_reply` VALUES ('1539047353622401026', 1, '1', '1539047067667337217', '8', '2022-06-21 08:47:38', '2022-06-21 08:47:38', b'0');
INSERT INTO `tb_reply` VALUES ('1539047379023106049', 1, '1', '1539047067667337217', '9', '2022-06-21 08:47:44', '2022-06-21 08:47:44', b'0');
INSERT INTO `tb_reply` VALUES ('1539047402104360962', 1, '1', '1539047067667337217', '10', '2022-06-21 08:47:49', '2022-06-21 08:47:49', b'0');
INSERT INTO `tb_reply` VALUES ('1539047461936107521', 1, '1', '1539047067667337217', '11', '2022-06-21 08:48:04', '2022-06-21 08:48:04', b'0');
INSERT INTO `tb_reply` VALUES ('1539047478251950082', 1, '1', '1539047067667337217', '12', '2022-06-21 08:48:08', '2022-06-21 08:48:08', b'0');
INSERT INTO `tb_reply` VALUES ('1539047493942841346', 1, '1', '1539047067667337217', '13', '2022-06-21 08:48:11', '2022-06-21 08:48:11', b'0');
INSERT INTO `tb_reply` VALUES ('1539047513706401793', 1, '1', '1539047067667337217', '14', '2022-06-21 08:48:16', '2022-06-21 08:48:16', b'0');
INSERT INTO `tb_reply` VALUES ('1539047730837131265', 1, NULL, '1539047175356092418', '1', '2022-06-21 08:49:08', '2022-06-21 08:49:08', b'0');
INSERT INTO `tb_reply` VALUES ('1539502557627027458', 1, NULL, '1539502358296924162', '1', '2022-06-22 14:56:27', '2022-06-22 14:56:27', b'0');
INSERT INTO `tb_reply` VALUES ('1539502613147029506', 1, NULL, '1539502358296924162', '2', '2022-06-22 14:56:40', '2022-06-22 14:56:40', b'0');
INSERT INTO `tb_reply` VALUES ('1539502642855284737', 1, '1', '1539502358296924162', '3', '2022-06-22 14:56:47', '2022-06-22 14:56:47', b'0');
INSERT INTO `tb_reply` VALUES ('1539502677156302850', 1, '1', '1539502358296924162', '4', '2022-06-22 14:56:55', '2022-06-22 14:56:55', b'0');
INSERT INTO `tb_reply` VALUES ('1539502697188298753', 1, '1', '1539502358296924162', '5', '2022-06-22 14:57:00', '2022-06-22 14:57:00', b'0');
INSERT INTO `tb_reply` VALUES ('1539502903308980225', 1, '1', '1539502358296924162', '6', '2022-06-22 14:57:49', '2022-06-22 14:57:49', b'0');
INSERT INTO `tb_reply` VALUES ('1544503505929797634', 1, NULL, '1544503479925112834', '641465', '2022-07-06 10:08:26', '2022-07-06 10:08:26', b'0');
INSERT INTO `tb_reply` VALUES ('1546766763725975554', 5, NULL, '1546766690917052418', 'test success', '2022-07-12 16:01:49', '2022-07-12 16:01:49', b'0');
INSERT INTO `tb_reply` VALUES ('1549588740908486658', 1, NULL, '1539502310263754754', '123', '2022-07-20 10:55:20', '2022-07-20 10:55:20', b'0');
INSERT INTO `tb_reply` VALUES ('1549943887157252098', 1, NULL, '1549938548290580481', '1', '2022-07-21 10:26:34', '2022-07-21 10:26:34', b'0');
INSERT INTO `tb_reply` VALUES ('1550365790392946690', 3, NULL, '1550365749204881410', '回复测试', '2022-07-22 14:23:04', '2022-07-22 14:23:04', b'0');
INSERT INTO `tb_reply` VALUES ('1551383769503182850', 1, NULL, '1539502180039004161', '145', '2022-07-25 09:48:09', '2022-07-25 09:48:09', b'0');

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
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES (1, '管理员', 'admin');

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
-- Records of tb_section
-- ----------------------------
INSERT INTO `tb_section` VALUES (1, '杂谈', '2022-07-28 14:26:03', '2022-08-02 15:38:09', b'0');
INSERT INTO `tb_section` VALUES (2, '交友', '2022-08-02 15:38:14', '2022-08-02 15:38:17', b'0');
INSERT INTO `tb_section` VALUES (3, '寻物', '2022-08-02 15:38:28', '2022-08-02 15:38:31', b'0');
INSERT INTO `tb_section` VALUES (4, '学习', '2022-08-02 15:38:39', '2022-08-02 19:44:08', b'0');
INSERT INTO `tb_section` VALUES (5, '求助', '2022-08-02 15:38:51', '2022-08-02 15:38:53', b'0');
INSERT INTO `tb_section` VALUES (6, '游戏', '2022-08-02 15:39:20', '2022-08-02 15:39:23', b'0');
INSERT INTO `tb_section` VALUES (7, '日常', '2022-08-02 15:39:40', '2022-08-02 15:39:42', b'0');

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
-- Records of tb_tag
-- ----------------------------
INSERT INTO `tb_tag` VALUES ('1537689937818959873', '测试', '2022-06-17 14:53:45');
INSERT INTO `tb_tag` VALUES ('1539129937438146561', '项目', '2022-06-21 14:15:47');
INSERT INTO `tb_tag` VALUES ('1539129937438146562', '结构调整', '2022-06-21 14:15:47');
INSERT INTO `tb_tag` VALUES ('1544505476774526977', '前端', '2022-07-06 10:16:16');
INSERT INTO `tb_tag` VALUES ('1547018567613161473', '项目进度', '2022-07-13 08:42:23');
INSERT INTO `tb_tag` VALUES ('1549923841802444802', '项目优化', '2022-07-21 09:06:55');
INSERT INTO `tb_tag` VALUES ('1549961615192555521', '笔记', '2022-07-21 11:37:01');
INSERT INTO `tb_tag` VALUES ('1552867151652335617', 'APEX', '2022-07-29 12:02:34');
INSERT INTO `tb_tag` VALUES ('1554806968183222273', '新版标签', '2022-08-03 20:30:43');
INSERT INTO `tb_tag` VALUES ('1557642820295372803', '学习', '2022-08-11 16:19:23');
INSERT INTO `tb_tag` VALUES ('1558003573789298690', 'redis', '2022-08-12 16:12:53');
INSERT INTO `tb_tag` VALUES ('1582311646011863042', '求职', '2022-10-18 18:04:29');
INSERT INTO `tb_tag` VALUES ('1585293233162825729', 'go', '2022-10-26 23:32:15');
INSERT INTO `tb_tag` VALUES ('1587265424263753729', 'springboot', '2022-11-01 10:09:02');
INSERT INTO `tb_tag` VALUES ('1587443674323628034', 'nacos', '2022-11-01 21:57:20');
INSERT INTO `tb_tag` VALUES ('1587443674323628035', 'springcloud', '2022-11-01 21:57:20');
INSERT INTO `tb_tag` VALUES ('1587628033315975170', 'feign', '2022-11-02 10:09:55');
INSERT INTO `tb_tag` VALUES ('1587628033315975171', 'loadbalancer', '2022-11-02 10:09:55');
INSERT INTO `tb_tag` VALUES ('1587712897692217346', 'config', '2022-11-02 15:47:08');
INSERT INTO `tb_tag` VALUES ('1589521369928839169', 'configuration', '2022-11-07 15:33:21');
INSERT INTO `tb_tag` VALUES ('1589521369933033473', 'bean', '2022-11-07 15:33:21');

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
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'db', '$2a$10$.Kjw4NSm4hVXhBcwKL4oT.UzdAW6NnKXUUtDl2xdh39DvJCosYQhm', 'db', 'qq@qq.qq', '12', 'http://db-community.oss-cn-guangzhou.aliyuncs.com/avatar/1.jpg', '666', b'1', '2022-06-17 14:34:54', '2022-08-02 19:20:44', NULL, b'0');
INSERT INTO `tb_user` VALUES (2, 'test1', '$2a$10$3s4iZnbef822UHxhxeh0pePi35WRaeKs6TtPoQHp0E/evpVYV0KHC', '用户test1', 'qq@qq.qq', '34', 'http://db-community.oss-cn-guangzhou.aliyuncs.com/avatar/2.png', 'hhh', b'1', '2022-06-21 16:53:43', '2022-06-22 15:59:53', NULL, b'0');
INSERT INTO `tb_user` VALUES (3, 'test2', '$2a$10$60OyEemwmzlhLBMpbND98eLhQ2Muz0HGNjrk/j2DUx6HGCQtBHw4a', '用户test2', '2031500185@qq.com', NULL, 'http://db-community.oss-cn-guangzhou.aliyuncs.com/avatar/3.jpg', ' ', b'1', '2022-07-04 19:09:27', '2022-07-04 19:10:06', NULL, b'0');
INSERT INTO `tb_user` VALUES (4, 'test4', '$2a$10$fRjFn6jo.KukYK6o/JEWQuGlMC2xRe0xlRHd6Fz7/hW2Ps2dcZAZ6', '用户test4', 'qq@qq.qq', NULL, 'http://db-community.oss-cn-guangzhou.aliyuncs.com/avatar/4.jpg', ' ', b'1', '2022-07-12 15:16:57', '2022-07-22 14:47:30', NULL, b'0');
INSERT INTO `tb_user` VALUES (5, 'test5', '$2a$10$L516JiE0eJg0wM3uydKZiehkNwTImuh0wyca53syzP9fMjPRBnbcm', 'test5', 'qw@11.qwe', NULL, 'http://db-community.oss-cn-guangzhou.aliyuncs.com/avatar/5.jpg', '', b'1', '2022-07-12 15:58:55', '2022-07-19 14:44:20', NULL, b'0');
INSERT INTO `tb_user` VALUES (6, 'test6', '$2a$10$Wqj47kXjt/BAnfWiIRqz8.uk4JUz4jzOWYmEKlRTdXqCNlOdyrG52', '用户test6', 'qwe@qed.das', NULL, 'http://db-community.oss-cn-guangzhou.aliyuncs.com/avatar/6.jpg', '...', b'1', '2022-07-12 16:30:57', '2022-08-12 16:19:57', NULL, b'0');
INSERT INTO `tb_user` VALUES (7, 'test7', '$2a$10$d43CaoFjQmar7dpNz7jYP.DnYiHjWX8sns/ofgI1E8qPJFmHYlWuq', '用户test7', 'qw@re.qwd', NULL, NULL, '', b'1', '2022-07-12 16:42:10', '2022-07-12 16:42:30', NULL, b'0');
INSERT INTO `tb_user` VALUES (8, 'test8', '$2a$10$2ug5dT9.nXjRd4XkkYP3U.U2aRroBqgGC348jjF6x88iwe1rxLMTy', '用户8', 'wd@qwd.dqwd', NULL, NULL, '', b'1', '2022-07-12 20:27:23', '2022-07-12 20:27:23', NULL, b'0');
INSERT INTO `tb_user` VALUES (9, 'test9', '$2a$10$LwlxQ.O0cYG00pOwj1REuuIy/BbdqUPbkWPidOhZRddsxn.jATmUa', '用户9', 'wdad@qwd.dasd', NULL, 'http://db-community.oss-cn-guangzhou.aliyuncs.com/avatar/9.jpg', '', b'1', '2022-07-12 22:09:05', '2022-07-21 10:40:24', NULL, b'0');
INSERT INTO `tb_user` VALUES (10, 'test10', '$2a$10$41n5.ISZiOxclLyhmisT1eODSQAo3CJB8MH4qwNPzBmwB21sTQQIe', '用户10', '123456@qd.das', NULL, NULL, '', b'1', '2022-07-12 22:13:24', '2022-07-12 22:13:37', NULL, b'0');
INSERT INTO `tb_user` VALUES (11, 'test11', '$2a$10$ER9INszL1R4Ihx7EyB8Xruh4pQ7Eog6LUfYny3fsknZN9xYBtPxGq', '用户11', 'we@qw.qwe', NULL, 'http://db-community.oss-cn-guangzhou.aliyuncs.com/avatar/11.jpg', '12', b'1', '2022-07-21 10:58:28', '2022-07-21 10:59:11', NULL, b'0');
INSERT INTO `tb_user` VALUES (12, 'system-01', '', '系统消息', ' ', NULL, 'https://photo-static-api.fotomore.com/creative/vcg/veer/400/new/VCG41N691108204.jpg', '', b'1', '2022-07-25 16:42:45', '2022-07-25 16:42:48', NULL, b'0');
INSERT INTO `tb_user` VALUES (13, '11111111', '$2a$10$meIulJlub0WoQUW3QmLuweGDp85mk3TCwvRch8Rw2M42Uvgvrlhku', '用户510c3eb0589043d5ad097be6650cd5ad', 'q614713403@126.com', NULL, NULL, '', b'1', '2022-11-01 16:06:32', '2022-11-01 16:06:32', NULL, b'0');
INSERT INTO `tb_user` VALUES (14, 'zhuiyi', '$2a$10$5/LFYRSBNz9huOXTXzWRIu0hrcD/nEPt8SN0tvm9.FKvwW9t8hBfW', '用户e7bf548523ba46e88b2df9398c8cb8ca', '15884527273@163.com', NULL, NULL, '', b'1', '2022-11-03 16:44:08', '2022-11-03 16:44:08', NULL, b'0');
INSERT INTO `tb_user` VALUES (15, '123', '$2a$10$np5AHi09GpG9456uCZk.XeihS2I.gEL4tgT.3fkujtuqCuNCtSTLK', '用户db26fa56a916457484491b1e73370562', '123456@qq.com', NULL, NULL, '', b'1', '2022-11-06 18:55:16', '2022-11-06 18:55:16', NULL, b'0');

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
-- Records of tb_verifyword
-- ----------------------------
INSERT INTO `tb_verifyword` VALUES (1, '儬');
INSERT INTO `tb_verifyword` VALUES (2, '儷');
INSERT INTO `tb_verifyword` VALUES (3, '儽');
INSERT INTO `tb_verifyword` VALUES (4, '兣');
INSERT INTO `tb_verifyword` VALUES (5, '劖');
INSERT INTO `tb_verifyword` VALUES (6, '勓');
INSERT INTO `tb_verifyword` VALUES (7, '厵');
INSERT INTO `tb_verifyword` VALUES (8, '髡');
INSERT INTO `tb_verifyword` VALUES (9, '嗀');
INSERT INTO `tb_verifyword` VALUES (10, '﨨');
INSERT INTO `tb_verifyword` VALUES (11, '蘒');
INSERT INTO `tb_verifyword` VALUES (12, '乷');
INSERT INTO `tb_verifyword` VALUES (13, '僂');
INSERT INTO `tb_verifyword` VALUES (14, '嚋');
INSERT INTO `tb_verifyword` VALUES (15, '嚮');
INSERT INTO `tb_verifyword` VALUES (16, '埵');
INSERT INTO `tb_verifyword` VALUES (17, '鐻');
INSERT INTO `tb_verifyword` VALUES (18, '鰪');
INSERT INTO `tb_verifyword` VALUES (19, '崋');
INSERT INTO `tb_verifyword` VALUES (20, '幞');
INSERT INTO `tb_verifyword` VALUES (21, '庺');
INSERT INTO `tb_verifyword` VALUES (22, '彋');
INSERT INTO `tb_verifyword` VALUES (23, '悌');
INSERT INTO `tb_verifyword` VALUES (24, '慑');
INSERT INTO `tb_verifyword` VALUES (25, '懋');
INSERT INTO `tb_verifyword` VALUES (26, '揔');
INSERT INTO `tb_verifyword` VALUES (27, '擺');
INSERT INTO `tb_verifyword` VALUES (28, '暕');
INSERT INTO `tb_verifyword` VALUES (29, '曁');
INSERT INTO `tb_verifyword` VALUES (30, '湽');

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

-- ----------------------------
-- Records of tb_view
-- ----------------------------
INSERT INTO `tb_view` VALUES ('1556967607560507393', 3, '1539129937350066178', '2022-08-09 19:36:19', '2022-08-09 19:36:19', b'0');
INSERT INTO `tb_view` VALUES ('1556967642633277442', 3, '1538832627030269953', '2022-08-09 19:36:28', '2022-08-09 19:36:28', b'0');
INSERT INTO `tb_view` VALUES ('1556967677139816449', 3, '1555096151044993026', '2022-08-09 19:36:36', '2022-08-09 19:36:36', b'0');
INSERT INTO `tb_view` VALUES ('1556967868295221250', 1, '1555023170033750017', '2022-08-09 19:37:22', '2022-08-09 19:37:22', b'0');
INSERT INTO `tb_view` VALUES ('1556968504269148161', 1, '1552867151534895106', '2022-08-09 19:39:53', '2022-08-09 19:39:53', b'0');
INSERT INTO `tb_view` VALUES ('1557184289767854081', 1, '1555023170033750017', '2022-08-10 09:57:20', '2022-08-10 09:57:20', b'0');
INSERT INTO `tb_view` VALUES ('1557325417877966849', 1, '1545031777205411842', '2022-08-10 19:18:08', '2022-08-10 19:18:08', b'0');
INSERT INTO `tb_view` VALUES ('1557325921404162049', 1, '1552867151534895106', '2022-08-10 19:20:08', '2022-08-10 19:20:08', b'0');
INSERT INTO `tb_view` VALUES ('1557326235163291649', 1, '1555023170033750017', '2022-08-10 19:21:23', '2022-08-10 19:21:23', b'0');
INSERT INTO `tb_view` VALUES ('1557326486976720897', 1, '1552867151534895106', '2022-08-10 19:22:23', '2022-08-10 19:22:23', b'0');
INSERT INTO `tb_view` VALUES ('1557332034438688769', 1, '1555096151044993026', '2022-08-10 19:44:25', '2022-08-10 19:44:25', b'0');
INSERT INTO `tb_view` VALUES ('1557332202231820290', 1, '1538832627030269953', '2022-08-10 19:45:06', '2022-08-10 19:45:06', b'0');
INSERT INTO `tb_view` VALUES ('1557333628278403073', 1, '1554437029450559489', '2022-08-10 19:50:45', '2022-08-10 19:50:45', b'0');
INSERT INTO `tb_view` VALUES ('1557333796067340290', 1, '1539129937350066178', '2022-08-10 19:51:26', '2022-08-10 19:51:26', b'0');
INSERT INTO `tb_view` VALUES ('1557333879953420290', 1, '1545031777205411842', '2022-08-10 19:51:46', '2022-08-10 19:51:46', b'0');
INSERT INTO `tb_view` VALUES ('1557335183920558081', 1, '1555023170033750017', '2022-08-10 19:56:56', '2022-08-10 19:56:56', b'0');
INSERT INTO `tb_view` VALUES ('1557561955756052482', 1, '1555096151044993026', '2022-08-11 10:58:03', '2022-08-11 10:58:03', b'0');
INSERT INTO `tb_view` VALUES ('1557561955756052483', 1, '1538832627030269953', '2022-08-11 10:58:03', '2022-08-11 10:58:03', b'0');
INSERT INTO `tb_view` VALUES ('1557562039621160961', 1, '1555096151044993026', '2022-08-11 10:58:23', '2022-08-11 10:58:23', b'0');
INSERT INTO `tb_view` VALUES ('1557562459072532482', 1, '1538832627030269953', '2022-08-11 11:00:03', '2022-08-11 11:00:03', b'0');
INSERT INTO `tb_view` VALUES ('1557562542971195393', 1, '1544505476711612418', '2022-08-11 11:00:23', '2022-08-11 11:00:23', b'0');
INSERT INTO `tb_view` VALUES ('1557626529547296770', 1, '1555096151044993026', '2022-08-11 15:14:39', '2022-08-11 15:14:39', b'0');
INSERT INTO `tb_view` VALUES ('1557626781050347522', 1, '1538832627030269953', '2022-08-11 15:15:39', '2022-08-11 15:15:39', b'0');
INSERT INTO `tb_view` VALUES ('1557629129906724865', 1, '1555096151044993026', '2022-08-11 15:24:59', '2022-08-11 15:24:59', b'0');
INSERT INTO `tb_view` VALUES ('1557630807611547649', 1, '1539129937350066178', '2022-08-11 15:31:39', '2022-08-11 15:31:39', b'0');
INSERT INTO `tb_view` VALUES ('1557634079172861953', 1, '1538832627030269953', '2022-08-11 15:44:39', '2022-08-11 15:44:39', b'0');
INSERT INTO `tb_view` VALUES ('1557635015580626946', 1, '1555023170033750017', '2022-08-11 15:48:22', '2022-08-11 15:48:22', b'0');
INSERT INTO `tb_view` VALUES ('1557642900876341250', 1, '1557642820295372802', '2022-08-11 16:19:42', '2022-08-11 16:19:42', b'0');
INSERT INTO `tb_view` VALUES ('1557644075331792897', 1, '1557643991160500225', '2022-08-11 16:24:22', '2022-08-11 16:24:22', b'0');
INSERT INTO `tb_view` VALUES ('1557925698339938306', 1, '1539129937350066178', '2022-08-12 11:03:26', '2022-08-12 11:03:26', b'0');
INSERT INTO `tb_view` VALUES ('1557925949985595394', 1, '1538832627030269953', '2022-08-12 11:04:26', '2022-08-12 11:04:26', b'0');
INSERT INTO `tb_view` VALUES ('1557926537179766786', 3, '1557643991160500225', '2022-08-12 11:06:46', '2022-08-12 11:06:46', b'0');
INSERT INTO `tb_view` VALUES ('1557926621095206913', 3, '1538832627030269953', '2022-08-12 11:07:06', '2022-08-12 11:07:06', b'0');
INSERT INTO `tb_view` VALUES ('1557926621095206914', 3, '1555096151044993026', '2022-08-12 11:07:06', '2022-08-12 11:07:06', b'0');
INSERT INTO `tb_view` VALUES ('1557926621095206915', 3, '1539129937350066178', '2022-08-12 11:07:06', '2022-08-12 11:07:06', b'0');
INSERT INTO `tb_view` VALUES ('1557926788858978306', 3, '1557643991160500225', '2022-08-12 11:07:46', '2022-08-12 11:07:46', b'0');
INSERT INTO `tb_view` VALUES ('1557926788858978307', 3, '1549923841471094785', '2022-08-12 11:07:46', '2022-08-12 11:07:46', b'0');
INSERT INTO `tb_view` VALUES ('1557996210441183233', 5, '1557643991160500225', '2022-08-12 15:43:37', '2022-08-12 15:43:37', b'0');
INSERT INTO `tb_view` VALUES ('1557996880187645954', 5, '1554437029450559489', '2022-08-12 15:46:17', '2022-08-12 15:46:17', b'0');
INSERT INTO `tb_view` VALUES ('1557998176135356418', 5, '1555023170033750017', '2022-08-12 15:51:26', '2022-08-12 15:51:26', b'0');
INSERT INTO `tb_view` VALUES ('1557998353290113026', 5, '1554806968044810242', '2022-08-12 15:52:08', '2022-08-12 15:52:08', b'0');
INSERT INTO `tb_view` VALUES ('1557999108285804546', 5, '1547018567550246913', '2022-08-12 15:55:08', '2022-08-12 15:55:08', b'0');
INSERT INTO `tb_view` VALUES ('1557999276078936065', 5, '1557643991160500225', '2022-08-12 15:55:48', '2022-08-12 15:55:48', b'0');
INSERT INTO `tb_view` VALUES ('1558002835247861762', 5, '1549923841471094785', '2022-08-12 16:09:57', '2022-08-12 16:09:57', b'0');
INSERT INTO `tb_view` VALUES ('1558002919129747458', 5, '1538832627030269953', '2022-08-12 16:10:17', '2022-08-12 16:10:17', b'0');
INSERT INTO `tb_view` VALUES ('1558003590193221633', 5, '1558003573789298689', '2022-08-12 16:12:57', '2022-08-12 16:12:57', b'0');
INSERT INTO `tb_view` VALUES ('1558003998273933313', 5, '1557643991160500225', '2022-08-12 16:14:34', '2022-08-12 16:14:34', b'0');
INSERT INTO `tb_view` VALUES ('1558004082101293057', 5, '1558003573789298689', '2022-08-12 16:14:54', '2022-08-12 16:14:54', b'0');
INSERT INTO `tb_view` VALUES ('1558004753173155842', 1, '1545031777205411842', '2022-08-12 16:17:34', '2022-08-12 16:17:34', b'0');
INSERT INTO `tb_view` VALUES ('1558004753173155843', 1, '1554437029450559489', '2022-08-12 16:17:34', '2022-08-12 16:17:34', b'0');
INSERT INTO `tb_view` VALUES ('1558004837147316226', 1, '1539129937350066178', '2022-08-12 16:17:54', '2022-08-12 16:17:54', b'0');
INSERT INTO `tb_view` VALUES ('1558004837147316227', 1, '1557643991160500225', '2022-08-12 16:17:54', '2022-08-12 16:17:54', b'0');
INSERT INTO `tb_view` VALUES ('1558005004856561666', 1, '1544505476711612418', '2022-08-12 16:18:34', '2022-08-12 16:18:34', b'0');
INSERT INTO `tb_view` VALUES ('1558005088776196098', 1, '1541610397336207361', '2022-08-12 16:18:54', '2022-08-12 16:18:54', b'0');
INSERT INTO `tb_view` VALUES ('1558005256468664322', 6, '1558003573789298689', '2022-08-12 16:19:34', '2022-08-12 16:19:34', b'0');
INSERT INTO `tb_view` VALUES ('1558020859359236097', 6, '1558020849255157762', '2022-08-12 17:21:34', '2022-08-12 17:21:34', b'0');
INSERT INTO `tb_view` VALUES ('1558022788743270402', 1, '1558020849255157762', '2022-08-12 17:29:14', '2022-08-12 17:29:14', b'0');
INSERT INTO `tb_view` VALUES ('1558022956536401922', 6, '1558020849255157762', '2022-08-12 17:29:54', '2022-08-12 17:29:54', b'0');
INSERT INTO `tb_view` VALUES ('1558039545185669122', 1, '1558003573789298689', '2022-08-12 18:35:49', '2022-08-12 18:35:49', b'0');
INSERT INTO `tb_view` VALUES ('1558039545185669123', 1, '1538832627030269953', '2022-08-12 18:35:49', '2022-08-12 18:35:49', b'0');
INSERT INTO `tb_view` VALUES ('1558039629109497858', 1, '1558003573789298689', '2022-08-12 18:36:09', '2022-08-12 18:36:09', b'0');
INSERT INTO `tb_view` VALUES ('1558040454112325633', 1, '1538832627030269953', '2022-08-12 18:39:26', '2022-08-12 18:39:26', b'0');
INSERT INTO `tb_view` VALUES ('1558040454112325634', 1, '1557643991160500225', '2022-08-12 18:39:26', '2022-08-12 18:39:26', b'0');
INSERT INTO `tb_view` VALUES ('1559012689492058113', 1, '1558003573789298689', '2022-08-15 11:02:45', '2022-08-15 11:02:45', b'0');
INSERT INTO `tb_view` VALUES ('1559012773361360898', 1, '1538832627030269953', '2022-08-15 11:03:05', '2022-08-15 11:03:05', b'0');
INSERT INTO `tb_view` VALUES ('1559014925219774465', 1, '1558003573789298689', '2022-08-15 11:11:38', '2022-08-15 11:11:38', b'0');
INSERT INTO `tb_view` VALUES ('1560553563690745858', 5, '1557643991160500225', '2022-08-19 17:05:38', '2022-08-19 17:05:38', b'0');
INSERT INTO `tb_view` VALUES ('1561250321467031553', 1, '1557643991160500225', '2022-08-21 15:14:18', '2022-08-21 15:14:18', b'0');
INSERT INTO `tb_view` VALUES ('1561250405357305858', 1, '1555023170033750017', '2022-08-21 15:14:38', '2022-08-21 15:14:38', b'0');
INSERT INTO `tb_view` VALUES ('1561250405357305859', 1, '1554806968044810242', '2022-08-21 15:14:38', '2022-08-21 15:14:38', b'0');
INSERT INTO `tb_view` VALUES ('1561611199387385858', 1, '1538832627030269953', '2022-08-22 15:08:18', '2022-08-22 15:08:18', b'0');
INSERT INTO `tb_view` VALUES ('1561611199387385859', 1, '1555096151044993026', '2022-08-22 15:08:18', '2022-08-22 15:08:18', b'0');
INSERT INTO `tb_view` VALUES ('1561611283269271554', 1, '1538832627030269953', '2022-08-22 15:08:38', '2022-08-22 15:08:38', b'0');
INSERT INTO `tb_view` VALUES ('1561611451041431554', 1, '1554806968044810242', '2022-08-22 15:09:18', '2022-08-22 15:09:18', b'0');
INSERT INTO `tb_view` VALUES ('1561645341021945857', 1, '1538832627030269953', '2022-08-22 17:23:58', '2022-08-22 17:23:58', b'0');
INSERT INTO `tb_view` VALUES ('1561690891159191553', 1, '1558003573789298689', '2022-08-22 20:24:58', '2022-08-22 20:24:58', b'0');
INSERT INTO `tb_view` VALUES ('1563814915326623746', 1, '1550365379057553410', '2022-08-28 17:05:05', '2022-08-28 17:05:05', b'0');
INSERT INTO `tb_view` VALUES ('1563814999195926529', 1, '1558003573789298689', '2022-08-28 17:05:25', '2022-08-28 17:05:25', b'0');
INSERT INTO `tb_view` VALUES ('1563814999195926530', 1, '1538832627030269953', '2022-08-28 17:05:25', '2022-08-28 17:05:25', b'0');
INSERT INTO `tb_view` VALUES ('1563815083082006529', 1, '1550365379057553410', '2022-08-28 17:05:45', '2022-08-28 17:05:45', b'0');
INSERT INTO `tb_view` VALUES ('1563815166963892226', 1, '1538832627030269953', '2022-08-28 17:06:05', '2022-08-28 17:06:05', b'0');
INSERT INTO `tb_view` VALUES ('1565327536043433986', 1, '1550365379057553410', '2022-09-01 21:15:42', '2022-09-01 21:15:42', b'0');
INSERT INTO `tb_view` VALUES ('1565327536043433987', 1, '1539129937350066178', '2022-09-01 21:15:42', '2022-09-01 21:15:42', b'0');
INSERT INTO `tb_view` VALUES ('1565967670711525377', 1, '1557643991160500225', '2022-09-03 15:39:22', '2022-09-03 15:39:22', b'0');
INSERT INTO `tb_view` VALUES ('1565967754593411074', 1, '1538832627030269953', '2022-09-03 15:39:42', '2022-09-03 15:39:42', b'0');
INSERT INTO `tb_view` VALUES ('1566712327443685377', 1, '1550365379057553410', '2022-09-05 16:58:22', '2022-09-05 16:58:22', b'0');
INSERT INTO `tb_view` VALUES ('1566712411325571073', 1, '1555096151044993026', '2022-09-05 16:58:42', '2022-09-05 16:58:42', b'0');
INSERT INTO `tb_view` VALUES ('1566712411325571074', 1, '1538832627030269953', '2022-09-05 16:58:42', '2022-09-05 16:58:42', b'0');
INSERT INTO `tb_view` VALUES ('1566715850659045377', 1, '1557643991160500225', '2022-09-05 17:12:22', '2022-09-05 17:12:22', b'0');
INSERT INTO `tb_view` VALUES ('1567147863966851074', 1, '1558003573789298689', '2022-09-06 21:49:02', '2022-09-06 21:49:02', b'0');
INSERT INTO `tb_view` VALUES ('1567148031739011073', 1, '1550365379057553410', '2022-09-06 21:49:42', '2022-09-06 21:49:42', b'0');
INSERT INTO `tb_view` VALUES ('1567148031739011074', 1, '1539129937350066178', '2022-09-06 21:49:42', '2022-09-06 21:49:42', b'0');
INSERT INTO `tb_view` VALUES ('1570608080880771074', 1, '1550365379057553410', '2022-09-16 10:58:42', '2022-09-16 10:58:42', b'0');
INSERT INTO `tb_view` VALUES ('1570608164766851073', 1, '1558003573789298689', '2022-09-16 10:59:02', '2022-09-16 10:59:02', b'0');
INSERT INTO `tb_view` VALUES ('1572064633110519809', 1, '1557643991160500225', '2022-09-20 11:26:31', '2022-09-20 11:26:31', b'0');
INSERT INTO `tb_view` VALUES ('1574378043412176897', 1, '1550365379057553410', '2022-09-26 20:39:11', '2022-09-26 20:39:11', b'0');
INSERT INTO `tb_view` VALUES ('1574378043416371202', 1, '1555023170033750017', '2022-09-26 20:39:11', '2022-09-26 20:39:11', b'0');
INSERT INTO `tb_view` VALUES ('1574378127294062593', 1, '1538832627030269953', '2022-09-26 20:39:31', '2022-09-26 20:39:31', b'0');
INSERT INTO `tb_view` VALUES ('1579087707496378369', 2, '1558003573789298689', '2022-10-09 20:33:42', '2022-10-09 20:33:42', b'0');
INSERT INTO `tb_view` VALUES ('1579087875255955458', 2, '1557643991160500225', '2022-10-09 20:34:22', '2022-10-09 20:34:22', b'0');
INSERT INTO `tb_view` VALUES ('1579088798002835457', 1, '1555096151044993026', '2022-10-09 20:38:02', '2022-10-09 20:38:02', b'0');
INSERT INTO `tb_view` VALUES ('1579091230694961153', 1, '1579091181562884098', '2022-10-09 20:47:42', '2022-10-09 20:47:42', b'0');
INSERT INTO `tb_view` VALUES ('1579094166707761154', 1, '1557643991160500225', '2022-10-09 20:59:22', '2022-10-09 20:59:22', b'0');
INSERT INTO `tb_view` VALUES ('1579284504227475458', 1, '1557643991160500225', '2022-10-10 09:35:42', '2022-10-10 09:35:42', b'0');
INSERT INTO `tb_view` VALUES ('1579651254165041154', 1, '1579651243008192513', '2022-10-11 09:53:02', '2022-10-11 09:53:02', b'0');
INSERT INTO `tb_view` VALUES ('1579651505823281154', 1, '1552867151534895106', '2022-10-11 09:54:02', '2022-10-11 09:54:02', b'0');
INSERT INTO `tb_view` VALUES ('1579729939312275458', 1, '1579091181562884098', '2022-10-11 15:05:42', '2022-10-11 15:05:42', b'0');
INSERT INTO `tb_view` VALUES ('1582177319416508418', 1, '1579651243008192513', '2022-10-18 09:10:43', '2022-10-18 09:10:43', b'0');
INSERT INTO `tb_view` VALUES ('1582177403290005506', 1, '1579091181562884098', '2022-10-18 09:11:03', '2022-10-18 09:11:03', b'0');
INSERT INTO `tb_view` VALUES ('1582178829349171202', 1, '1579091181562884098', '2022-10-18 09:16:43', '2022-10-18 09:16:43', b'0');
INSERT INTO `tb_view` VALUES ('1582311788785971201', 1, '1582311645919588354', '2022-10-18 18:05:03', '2022-10-18 18:05:03', b'0');
INSERT INTO `tb_view` VALUES ('1582710583206096898', 1, '1538832627030269953', '2022-10-19 20:29:43', '2022-10-19 20:29:43', b'0');
INSERT INTO `tb_view` VALUES ('1583459098702131202', 1, '1538832627030269953', '2022-10-21 22:04:03', '2022-10-21 22:04:03', b'0');
INSERT INTO `tb_view` VALUES ('1583459098702131203', 1, '1579091181562884098', '2022-10-21 22:04:03', '2022-10-21 22:04:03', b'0');
INSERT INTO `tb_view` VALUES ('1583459350360371202', 1, '1582311645919588354', '2022-10-21 22:05:03', '2022-10-21 22:05:03', b'0');
INSERT INTO `tb_view` VALUES ('1584001338319056898', 1, '1582311645919588354', '2022-10-23 09:58:43', '2022-10-23 09:58:43', b'0');
INSERT INTO `tb_view` VALUES ('1584001506095411202', 1, '1538832627030269953', '2022-10-23 09:59:23', '2022-10-23 09:59:23', b'0');
INSERT INTO `tb_view` VALUES ('1584808825725136898', 1, '1579091181562884098', '2022-10-25 15:27:23', '2022-10-25 15:27:23', b'0');
INSERT INTO `tb_view` VALUES ('1585063252205776897', 1, '1558003573789298689', '2022-10-26 08:18:23', '2022-10-26 08:18:23', b'0');
INSERT INTO `tb_view` VALUES ('1585293267841331202', 1, '1585293233150242818', '2022-10-26 23:32:23', '2022-10-26 23:32:23', b'0');
INSERT INTO `tb_view` VALUES ('1587265429577936897', 1, '1587265424255365122', '2022-11-01 10:09:03', '2022-11-01 10:09:03', b'0');
INSERT INTO `tb_view` VALUES ('1587443687497936897', 1, '1587443674290073601', '2022-11-01 21:57:23', '2022-11-01 21:57:23', b'0');
INSERT INTO `tb_view` VALUES ('1587444778016976898', 1, '1582311645919588354', '2022-11-01 22:01:43', '2022-11-01 22:01:43', b'0');
INSERT INTO `tb_view` VALUES ('1587444861907251202', 1, '1585293233150242818', '2022-11-01 22:02:03', '2022-11-01 22:02:03', b'0');
INSERT INTO `tb_view` VALUES ('1587628069110165505', 1, '1587628033315975169', '2022-11-02 10:10:03', '2022-11-02 10:10:03', b'0');
INSERT INTO `tb_view` VALUES ('1587712961818931201', 1, '1587712897608331266', '2022-11-02 15:47:23', '2022-11-02 15:47:23', b'0');
INSERT INTO `tb_view` VALUES ('1588090784723251201', 1, '1588090704523964417', '2022-11-03 16:48:43', '2022-11-03 16:48:43', b'0');
INSERT INTO `tb_view` VALUES ('1588530012238131201', 1, '1587628033315975169', '2022-11-04 21:54:03', '2022-11-04 21:54:03', b'0');
INSERT INTO `tb_view` VALUES ('1589521377931571202', 1, '1589521369916256257', '2022-11-07 15:33:23', '2022-11-07 15:33:23', b'0');
INSERT INTO `tb_view` VALUES ('1618884183501848577', 1, '1587265424255365122', '2023-01-27 16:10:41', '2023-01-27 16:10:41', b'0');
INSERT INTO `tb_view` VALUES ('1618884686776385538', 1, '1587628033315975169', '2023-01-27 16:12:41', '2023-01-27 16:12:41', b'0');
INSERT INTO `tb_view` VALUES ('1618886867822854145', 1, '1589521369916256257', '2023-01-27 16:21:21', '2023-01-27 16:21:21', b'0');
INSERT INTO `tb_view` VALUES ('1618887203354591233', 1, '1588090704523964417', '2023-01-27 16:22:41', '2023-01-27 16:22:41', b'0');
INSERT INTO `tb_view` VALUES ('1618887371135139841', 1, '1587443674290073601', '2023-01-27 16:23:21', '2023-01-27 16:23:21', b'0');
INSERT INTO `tb_view` VALUES ('1618887538882134018', 1, '1587712897608331266', '2023-01-27 16:24:01', '2023-01-27 16:24:01', b'0');

SET FOREIGN_KEY_CHECKS = 1;
