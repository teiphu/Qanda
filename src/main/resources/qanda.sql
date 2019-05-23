/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80014
 Source Host           : localhost:3306
 Source Schema         : qanda

 Target Server Type    : MySQL
 Target Server Version : 80014
 File Encoding         : 65001

 Date: 23/05/2019 19:57:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(11) UNSIGNED NULL DEFAULT NULL,
  `question_id` int(11) UNSIGNED NULL DEFAULT NULL,
  `answer_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `gmt_create` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES (1, 2, 26, '古代中国你是什么意思？传统上，第一个王朝是公元前2200年到1600年之间的夏，但它的存在是不确定的。商代（公元前1600年至1046年）从未征服过中国北方的所有地区，也没有征服过周（公元前1046-221）事实上，在这段时期的大部分时间里，周朝都无法控制中国的大部分地区。它的影响主要是仪式性的。秦始皇第一个皇帝强有力地征服并统一了中国大部分的传统省份，但只有在下一个朝代，西汉（公元前202年至公元9年）才对韩国进行了尝试。即便如此，我认为这只是部分成功。平壤被征服，后来被称为朝鲜北部的高句丽王国。韩国的一部分成为中华帝国的一个省。然而，该省后来失踪了。汉朝变弱了，中国分裂成三国。然后内战导致了三个世纪的分裂和外来入侵（六朝时期）。显然到了这个时候，中国没有进攻韩国！  后来，当强大的隋朝在581年联合中国时，一个认真的尝试是要重新征服朝鲜。这个王朝非常具有攻击性和野心，但非常不受欢迎，而且很短暂。它崩溃了，取而代之的是着名的唐朝（公元618 - 906年）。唐朝曾短暂地征服过朝鲜北部的高丽或高句丽王国，但我们现在不再谈论古代中国。618-906恰逢中世纪早期，在西欧，识字和城市化进程正在下降。文学主要是口头的，盎格鲁撒克逊人统治英格兰，但凯尔特文学仍然繁荣，查理曼统治法国和德国，穆斯林进入西班牙，维京长船出现在许多沿海地区的地平线上。在某些方面，欧洲就像权力的游戏世界。  中国非常不同。对中国而言，我们的黑暗时代和中世纪是一个文化程度更高，城市化，繁荣，精致和和平的时期。  但无论当时中国有多么强大，它只能征服韩国的一部分 - 高句丽王国，当高句丽王国不受中国控制时，它能够统治北部边界以外的大片地区。今天的朝鲜，包括现在的俄罗斯和中国的部分地区。高丽王朝是高句丽统治者统一朝鲜时的名字。可能是因为我们这个词来自韩国。  现代韩国人称他们的国家Choseon（在朝鲜）或Hanguk（在韩国）。', '2019-04-30 15:17:03', NULL);
INSERT INTO `answer` VALUES (2, 3, 26, '我认为汉族已经对韩国大部分地区进行了长达数年的控制，并且唐已经短暂停留了50年？但是，除此之外，总的来说，大多数时候韩国只是一个附庸国。  你需要从古老的技术角度来思考它：  在古代，没有飞机，没有电话，没有火车，没有汽车，没有大型工程设备，没有先进的供暖系统等。  收入的主要来源是农业和狩猎，所以是的，今天的韩国在过去被认为具有很小的经济价值，离中国大多数华人居住的东亚中心区太远了。  在过去的中国法治中，他们只是控制了最有利可图的恐怖主义：东亚的中心平面。  有一种中国谚语叫“朱禄中元”，这简直就是追逐中央飞机区的控制，这是最具经济价值的恐怖，这是过去所有人都想做的，没有人说他们的目标是征服山/ derserts /高地等  不仅仅是韩国，在过去，甚至像广东/广东这样的地区被认为除了派遣囚犯（比如英国帝国时代的澳大利亚）之外用处不多，而且长期以来广州/福建被认为不合适让人活下去  因此，在过去，中国皇帝通常控制中央飞机区域，并将其余部分作为贡品国家或仅为了纯粹的安全原因而建立控制。  然而，东周时代或类似时期有一些被击败的中国领主，一路逃到今天的朝鲜，至少在那里建立了一些殖民地/王国。', '2019-04-30 15:22:06', '2019-05-10 01:34:46');
INSERT INTO `answer` VALUES (4, 2, 6, '没有什么看法', '2019-05-10 02:13:19', NULL);
INSERT INTO `answer` VALUES (5, 2, 7, '新加坡人虽然是大多是华人，但是新加坡已经达到相当程度西化，已经很少具有中华文化。', '2019-05-10 02:15:30', NULL);
INSERT INTO `answer` VALUES (6, 2, 5, '无限小时', '2019-05-12 15:39:59', NULL);
INSERT INTO `answer` VALUES (7, 2, 5, '小时', '2019-05-12 15:40:35', NULL);
INSERT INTO `answer` VALUES (8, 2, 6, '看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法看法', '2019-05-12 15:41:01', NULL);
INSERT INTO `answer` VALUES (9, 2, 6, '看法看法看法看法看法看法看法看法看法看法', '2019-05-12 15:41:30', NULL);
INSERT INTO `answer` VALUES (10, 2, 7, '不相似', '2019-05-12 15:46:23', NULL);
INSERT INTO `answer` VALUES (11, 2, 12, '没有什么令人头疼的事', '2019-05-14 01:09:30', NULL);
INSERT INTO `answer` VALUES (12, 2, 15, '秦朝的徐福有去', '2019-05-14 03:41:49', NULL);
INSERT INTO `answer` VALUES (14, 8, 9, '没有多少个', '2019-05-16 23:27:39', NULL);
INSERT INTO `answer` VALUES (15, 2, 7, 'kdjg a', '2019-05-18 13:55:03', NULL);
INSERT INTO `answer` VALUES (17, 8, 7, '推送测试', '2019-05-21 03:02:42', NULL);
INSERT INTO `answer` VALUES (18, 7, 5, '这个不确定', '2019-05-21 12:11:29', NULL);
INSERT INTO `answer` VALUES (19, 7, 7, '有点相似', '2019-05-21 12:32:18', NULL);
INSERT INTO `answer` VALUES (20, 7, 6, '没什么看法', '2019-05-21 14:19:19', NULL);
INSERT INTO `answer` VALUES (21, 1, 51, '答案', '2019-05-23 00:14:47', NULL);
INSERT INTO `answer` VALUES (22, 86, 24, '应该没有这种事', '2019-05-23 15:48:04', NULL);
INSERT INTO `answer` VALUES (23, 86, 54, '今天，作为印度获得回报的这一决定现在已经成为一个经济强国和一个主要的核武器国家。它也已开始成为印度 - 太平洋地区的净安全伙伴。印度现在是少数几个与俄罗斯和美国以及法国，英国，日本和德国等主要大国关系良好的国家之一。', '2019-05-23 15:52:16', NULL);
INSERT INTO `answer` VALUES (24, 86, 56, '第一次提到日本列岛的是中国历史教科书“后汉书”。该书指出，在57年，汉朝皇帝给Wa（日本）留下了金印章。金封在十八世纪在九州北部被发现。', '2019-05-23 15:57:44', NULL);
INSERT INTO `answer` VALUES (25, 86, 57, '一旦你知道了这种方法，Nukes很容易制造。你可以在高中物理教科书中找到它。但是，核武维修费用相当昂贵。自苏联解体以来，俄罗斯的核武库一直在减少，因为预算不足以维持所有2000多个核武器在战备模式。', '2019-05-23 16:01:18', NULL);
INSERT INTO `answer` VALUES (26, 86, 58, '显然，一些中国古兰经似乎忽视了这一点。我要求印度人效仿中国人，即发展务实和务实的态度，并将宗教限制在个人层面，而不是贬低。', '2019-05-23 16:05:02', NULL);
INSERT INTO `answer` VALUES (27, 7, 58, '中国的GDP可能高于印度，但经济差距与印度的水平相当。例如，我父亲的父母在长沙的一个小镇生活得相当好，可以通过互联网和电视等工作来获得奢侈品。但是，如果你住在农村，是农民或农民的孩子，生活很难 我的言语不是那么好，但为了最好地回答这个问题，我必须在个人层面上看到这个问题。', '2019-05-23 16:06:00', NULL);
INSERT INTO `answer` VALUES (28, 5, 59, '我想你可能有关于中国软实力弱于日本或韩国的信息不完整。\n让我们首先定义什么是权力。正如大多数人所理解的那样，权力是影响和胁迫其他人实现其意志的能力。或者说服人们成为你的盟友或支持者的力量。\n', '2019-05-23 16:45:06', NULL);
INSERT INTO `answer` VALUES (29, 8, 68, '“中国将赢得与美国的\'贸易战\'。”彼得森国际经济研究所的尼古拉斯拉迪', '2019-05-23 17:33:29', NULL);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `parent_comment_id` int(11) UNSIGNED NULL DEFAULT NULL,
  `user_id` int(11) UNSIGNED NULL DEFAULT NULL,
  `answer_id` int(11) UNSIGNED NULL DEFAULT NULL,
  `comment_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_create` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `delete` tinyint(3) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (2, NULL, 2, 6, '劈里啪啦', '2019-05-20 01:33:00', NULL, NULL);

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(11) UNSIGNED NULL DEFAULT NULL,
  `topic_id` int(11) UNSIGNED NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_create` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `status` tinyint(1) UNSIGNED NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES (5, 2, NULL, '如果台湾，韩国，越南和日本联合攻击中国，中国可以抗拒几个小时？', '2019-04-30 14:34:41', NULL, 1);
INSERT INTO `question` VALUES (6, 2, NULL, '您对中国和中国人有何看法？', '2019-04-30 14:35:09', NULL, 1);
INSERT INTO `question` VALUES (7, 2, NULL, '台湾文化是否与新加坡文化相似？', '2019-04-30 14:36:44', NULL, 1);
INSERT INTO `question` VALUES (8, 4, NULL, '新一代越南人会改变政府吗？', '2019-04-30 14:37:16', '2019-05-09 01:19:38', 1);
INSERT INTO `question` VALUES (9, 2, NULL, '有多少非洲国家比中国更发达？', '2019-04-30 14:37:39', NULL, 1);
INSERT INTO `question` VALUES (10, 2, NULL, '沙特阿拉伯将在全面战争中战胜印度吗？', '2019-04-30 14:38:29', NULL, 1);
INSERT INTO `question` VALUES (12, 5, NULL, '中国：关于中国有哪些令人头疼的事实？', '2019-04-30 14:39:50', '2019-05-09 01:19:43', 1);
INSERT INTO `question` VALUES (13, 6, NULL, '中国会成为无与伦比的超级大国吗？', '2019-04-30 14:41:52', '2019-05-09 01:19:47', 1);
INSERT INTO `question` VALUES (14, 6, NULL, '韩国人是否会瞧不起其他亚洲人（例如东南亚人）？', '2019-04-30 14:46:23', '2019-05-09 01:19:51', 1);
INSERT INTO `question` VALUES (15, 3, NULL, '古代有没有从中国到日本的移民？', '2019-04-30 14:47:35', NULL, 1);
INSERT INTO `question` VALUES (16, 7, NULL, '中文“与”是什么意思？怎么用？', '2019-04-30 14:47:58', '2019-05-09 01:20:00', 1);
INSERT INTO `question` VALUES (17, 3, NULL, 'Why are Filipinos being belittled when we go to other countries?', '2019-04-30 14:53:17', NULL, 1);
INSERT INTO `question` VALUES (18, 3, NULL, 'Do Chinese youth trust the state of China?', '2019-04-30 14:53:50', NULL, 1);
INSERT INTO `question` VALUES (19, 5, NULL, 'What are some Chinese characters that stand for more than one syllable?', '2019-04-30 14:54:11', '2019-05-09 01:20:06', 1);
INSERT INTO `question` VALUES (20, 5, NULL, 'Why doesn\'t China invade Vietnam? Do you think it will do so in the next couple of years/decades?', '2019-04-30 14:57:06', '2019-05-09 01:20:09', 1);
INSERT INTO `question` VALUES (21, 7, NULL, '什么是中国帝国的着装？', '2019-04-30 15:10:53', '2019-05-09 01:20:10', 1);
INSERT INTO `question` VALUES (23, 8, NULL, '到目前为止，哪些国家已经签署了中国的一带一路项目？', '2019-04-30 15:11:29', '2019-05-09 01:20:12', 1);
INSERT INTO `question` VALUES (24, 8, NULL, '为什么希特勒认为日本人是亚洲大师赛？', '2019-04-30 15:11:50', '2019-05-09 01:20:13', 1);
INSERT INTO `question` VALUES (25, 4, NULL, '为什么中国未能向世界其他地区宣传自己的形象？', '2019-04-30 15:12:03', '2019-05-09 01:20:19', 1);
INSERT INTO `question` VALUES (26, 5, NULL, '为什么中国古代从未试图征服韩国？', '2019-04-30 15:12:16', '2019-05-09 01:20:20', 1);
INSERT INTO `question` VALUES (27, 6, NULL, '在人口统计方面，发展中国家哪个国家将拥有最有趣的未来？', '2019-04-30 15:36:10', '2019-05-09 01:20:22', 1);
INSERT INTO `question` VALUES (28, 3, NULL, '越南的人均国内生产总值很低，但当我访问越南时，商业和消费似乎比预期的要多得多。为什么是这样？', '2019-04-30 15:40:34', NULL, 1);
INSERT INTO `question` VALUES (51, 1, NULL, '你的问题', '2019-05-23 00:14:35', NULL, 1);
INSERT INTO `question` VALUES (52, 1, NULL, 'fshshs', '2019-05-23 00:27:52', NULL, 1);
INSERT INTO `question` VALUES (53, 1, NULL, 'gaaadgdadgsa', '2019-05-23 00:28:15', NULL, 1);
INSERT INTO `question` VALUES (54, 86, NULL, '1971年战争结束后，为什么印度没有加入华沙条约，当时美国派遣海军舰艇进入印度洋？', '2019-05-23 15:51:39', NULL, 1);
INSERT INTO `question` VALUES (55, 86, NULL, '越南人认为文化上更接近中国，韩国和日本而不是东盟邻国吗？', '2019-05-23 15:54:12', NULL, 1);
INSERT INTO `question` VALUES (56, 86, NULL, '古代中国人如何首先看到日本人在日本做出反应？', '2019-05-23 15:56:44', NULL, 1);
INSERT INTO `question` VALUES (57, 86, NULL, '为什么中国拥有如此少的核武器？如果260已足够，为什么美国和俄罗斯需要更多？如果260还不够，为什么中国不能获得更多？', '2019-05-23 15:59:59', NULL, 1);
INSERT INTO `question` VALUES (58, 86, NULL, '为什么中国富国和印度如此贫穷？', '2019-05-23 16:04:14', NULL, 1);
INSERT INTO `question` VALUES (59, 5, NULL, '为什么中国的软实力弱于日本或韩国？', '2019-05-23 16:43:40', NULL, 1);
INSERT INTO `question` VALUES (60, 5, NULL, '哪个国家有更深的中国影响力：日本还是韩国？', '2019-05-23 17:01:36', NULL, 1);
INSERT INTO `question` VALUES (61, 5, NULL, '作为一个对中国人有一定经验并且了解中国的人，你会说中国人是谦虚的人吗？', '2019-05-23 17:02:11', NULL, 1);
INSERT INTO `question` VALUES (62, 5, NULL, '为什么华裔美国人投票红？', '2019-05-23 17:02:32', NULL, 1);
INSERT INTO `question` VALUES (63, 5, NULL, '罗马人知道中国人这样的亚洲人吗？', '2019-05-23 17:04:48', NULL, 1);
INSERT INTO `question` VALUES (64, 5, NULL, '当这两个国家大小相同时，为什么汉朝的军队比罗马军队更大呢？', '2019-05-23 17:07:06', NULL, 1);
INSERT INTO `question` VALUES (65, 5, NULL, '战前韩国是什么样的？', '2019-05-23 17:12:19', NULL, 1);
INSERT INTO `question` VALUES (66, 5, NULL, '尽管中国拥有丰富的历史和众多景点，但为什么中国吸引尽可能多的游客？', '2019-05-23 17:17:21', NULL, 1);
INSERT INTO `question` VALUES (67, 5, NULL, '关于印度人印度人普遍不了解的一些事实是什么？', '2019-05-23 17:21:25', NULL, 1);
INSERT INTO `question` VALUES (68, 5, NULL, '美国能否“赢得”与中国的贸易战？', '2019-05-23 17:31:29', NULL, 1);
INSERT INTO `question` VALUES (69, 5, NULL, '印度尼西亚是否感到被大军（澳大利亚，中国，印度和越南）所包围？', '2019-05-23 18:01:25', NULL, 1);

-- ----------------------------
-- Table structure for question_attention
-- ----------------------------
DROP TABLE IF EXISTS `question_attention`;
CREATE TABLE `question_attention`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `question_id` int(10) UNSIGNED NULL DEFAULT NULL,
  `user_id` int(10) UNSIGNED NULL DEFAULT NULL,
  `gmt_create` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question_attention
-- ----------------------------
INSERT INTO `question_attention` VALUES (39, 5, 2, '2019-05-20 05:16:03');
INSERT INTO `question_attention` VALUES (40, 6, 2, '2019-05-20 05:16:20');
INSERT INTO `question_attention` VALUES (42, 8, 2, '2019-05-20 23:29:08');
INSERT INTO `question_attention` VALUES (43, 7, 2, '2019-05-21 03:02:10');
INSERT INTO `question_attention` VALUES (44, 5, 3, '2019-05-22 14:42:18');
INSERT INTO `question_attention` VALUES (45, 58, 86, '2019-05-23 16:04:22');
INSERT INTO `question_attention` VALUES (46, 68, 5, '2019-05-23 17:32:36');

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(11) UNSIGNED NULL DEFAULT NULL,
  `topic_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `topic_detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_create` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of topic
-- ----------------------------
INSERT INTO `topic` VALUES (1, NULL, '中国', '这是一个关于中国所有问题的话题', '2019-05-06 22:28:43', '2019-05-15 01:21:13');
INSERT INTO `topic` VALUES (2, NULL, '美国', '这是一个关于美国所有问题的话题', '2019-05-06 22:28:54', '2019-05-15 01:21:24');
INSERT INTO `topic` VALUES (3, NULL, '越南', '这是一个关于越南所有问题的话题', '2019-05-06 22:29:19', '2019-05-15 01:21:33');
INSERT INTO `topic` VALUES (4, NULL, '日本', '日本的话题', '2019-05-06 22:29:26', '2019-05-15 01:21:40');
INSERT INTO `topic` VALUES (5, NULL, '韩国', '关于韩国的话题', '2019-05-06 22:29:53', '2019-05-15 01:21:48');
INSERT INTO `topic` VALUES (6, NULL, '朝鲜', '关于朝鲜的话题', '2019-05-06 22:30:01', '2019-05-15 01:21:56');
INSERT INTO `topic` VALUES (7, NULL, '中国历史', '关于中国源远流长的历史', '2019-05-06 22:30:26', '2019-05-15 01:22:17');
INSERT INTO `topic` VALUES (8, NULL, '中国文化', '中国博大精深的文化', '2019-05-06 22:30:40', '2019-05-15 01:22:29');
INSERT INTO `topic` VALUES (9, NULL, '新加坡', '城市小国的话题', '2019-05-07 01:41:01', '2019-05-15 01:22:49');
INSERT INTO `topic` VALUES (10, NULL, '非洲', NULL, '2019-05-18 01:23:13', NULL);
INSERT INTO `topic` VALUES (11, NULL, '亚洲', NULL, '2019-05-18 01:23:26', NULL);
INSERT INTO `topic` VALUES (12, NULL, '美洲', NULL, '2019-05-18 01:23:35', NULL);
INSERT INTO `topic` VALUES (18, 2, '欧洲', '', '2019-05-18 02:18:47', NULL);
INSERT INTO `topic` VALUES (19, 2, '联合国', '', '2019-05-18 02:44:13', NULL);
INSERT INTO `topic` VALUES (20, 86, '印度', '南亚地区大国', '2019-05-23 15:53:05', NULL);
INSERT INTO `topic` VALUES (21, 86, '东盟', '东南亚十国联盟', '2019-05-23 15:55:21', NULL);
INSERT INTO `topic` VALUES (22, 86, '俄罗斯', '', '2019-05-23 16:01:55', NULL);

-- ----------------------------
-- Table structure for topic_question
-- ----------------------------
DROP TABLE IF EXISTS `topic_question`;
CREATE TABLE `topic_question`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `topic_id` int(11) UNSIGNED NULL DEFAULT NULL,
  `question_id` int(11) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of topic_question
-- ----------------------------
INSERT INTO `topic_question` VALUES (1, 5, 5);
INSERT INTO `topic_question` VALUES (2, 1, 5);
INSERT INTO `topic_question` VALUES (3, 9, 7);
INSERT INTO `topic_question` VALUES (5, 3, 5);
INSERT INTO `topic_question` VALUES (6, 4, 5);
INSERT INTO `topic_question` VALUES (7, 1, 6);
INSERT INTO `topic_question` VALUES (8, 3, 8);
INSERT INTO `topic_question` VALUES (9, 1, 12);
INSERT INTO `topic_question` VALUES (10, 4, 24);
INSERT INTO `topic_question` VALUES (11, 2, 54);
INSERT INTO `topic_question` VALUES (12, 20, 54);
INSERT INTO `topic_question` VALUES (13, 1, 55);
INSERT INTO `topic_question` VALUES (14, 3, 55);
INSERT INTO `topic_question` VALUES (15, 1, 26);
INSERT INTO `topic_question` VALUES (16, 4, 56);
INSERT INTO `topic_question` VALUES (17, 2, 57);
INSERT INTO `topic_question` VALUES (18, 20, 67);
INSERT INTO `topic_question` VALUES (19, 1, 68);
INSERT INTO `topic_question` VALUES (20, 2, 68);

-- ----------------------------
-- Table structure for updownvote
-- ----------------------------
DROP TABLE IF EXISTS `updownvote`;
CREATE TABLE `updownvote`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `comment_id` int(10) UNSIGNED NULL DEFAULT NULL,
  `answer_id` int(10) UNSIGNED NULL DEFAULT NULL,
  `sender_id` int(10) UNSIGNED NULL DEFAULT NULL,
  `receiver_id` int(11) NULL DEFAULT NULL,
  `up_or_down` tinyint(3) UNSIGNED NULL DEFAULT NULL,
  `gmt_create` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 77 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of updownvote
-- ----------------------------
INSERT INTO `updownvote` VALUES (1, NULL, 1, 2, 1, 1, '2019-05-06 23:56:13', '2019-05-06 23:59:33');
INSERT INTO `updownvote` VALUES (2, NULL, 1, 3, 1, 1, '2019-05-06 23:56:24', '2019-05-06 23:59:33');
INSERT INTO `updownvote` VALUES (3, NULL, 1, 4, 1, 1, '2019-05-06 23:56:32', '2019-05-06 23:59:40');
INSERT INTO `updownvote` VALUES (4, NULL, 2, 2, 1, 1, '2019-05-07 00:03:56', '2019-05-07 00:04:20');
INSERT INTO `updownvote` VALUES (5, NULL, 2, 3, 1, 0, '2019-05-07 00:03:58', '2019-05-07 00:08:27');
INSERT INTO `updownvote` VALUES (6, NULL, 2, 4, 1, 1, '2019-05-07 00:04:01', '2019-05-07 00:04:25');
INSERT INTO `updownvote` VALUES (39, NULL, 5, 2, 2, 1, '2019-05-13 23:45:55', NULL);
INSERT INTO `updownvote` VALUES (40, NULL, 10, 2, 2, 1, '2019-05-13 23:46:03', NULL);
INSERT INTO `updownvote` VALUES (41, NULL, 7, 2, 2, 1, '2019-05-13 23:46:56', '2019-05-18 10:05:48');
INSERT INTO `updownvote` VALUES (42, NULL, 8, 2, 2, 0, '2019-05-13 23:47:16', NULL);
INSERT INTO `updownvote` VALUES (43, NULL, 9, 2, 2, 1, '2019-05-13 23:47:17', NULL);
INSERT INTO `updownvote` VALUES (44, NULL, 4, 2, 2, 1, '2019-05-13 23:47:31', NULL);
INSERT INTO `updownvote` VALUES (46, NULL, 6, 2, 2, 1, '2019-05-15 01:35:10', '2019-05-20 01:33:09');
INSERT INTO `updownvote` VALUES (47, NULL, 6, 8, 2, 1, '2019-05-16 23:27:01', NULL);
INSERT INTO `updownvote` VALUES (48, NULL, 7, 8, 2, 1, '2019-05-16 23:27:01', NULL);
INSERT INTO `updownvote` VALUES (49, NULL, 14, 8, 8, 1, '2019-05-16 23:27:42', NULL);
INSERT INTO `updownvote` VALUES (64, NULL, 11, 2, 2, 1, '2019-05-20 23:27:55', NULL);
INSERT INTO `updownvote` VALUES (65, NULL, 13, 2, 2, 1, '2019-05-20 23:29:16', NULL);
INSERT INTO `updownvote` VALUES (67, NULL, 11, 8, 2, 1, '2019-05-21 02:59:27', '2019-05-21 02:59:29');
INSERT INTO `updownvote` VALUES (68, NULL, 15, 8, 2, 1, '2019-05-21 02:59:35', NULL);
INSERT INTO `updownvote` VALUES (69, NULL, 15, 2, 2, 1, '2019-05-21 02:59:44', NULL);
INSERT INTO `updownvote` VALUES (74, NULL, 19, 7, 7, 1, '2019-05-21 14:25:57', '2019-05-21 14:25:58');
INSERT INTO `updownvote` VALUES (76, NULL, 20, 7, 7, 1, '2019-05-21 14:26:03', NULL);
INSERT INTO `updownvote` VALUES (78, NULL, 22, 86, 86, 1, '2019-05-23 15:48:23', NULL);
INSERT INTO `updownvote` VALUES (79, NULL, 24, 86, 86, 1, '2019-05-23 15:57:53', NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `job` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `signature` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'normal',
  `gmt_create` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `gmt_logout` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `status` tinyint(1) UNSIGNED NULL DEFAULT 1 COMMENT '0表示封号，1表示启用',
  `delete` tinyint(1) NULL DEFAULT 1 COMMENT '0表示已注销，1表示在册用户',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 86 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456', 'admin@qq.com', '13684736586', '男', '2019-05-23 00:27:20', NULL, NULL, 'admin', '2019-05-06 23:58:40', '2019-05-23 00:27:20', '2019-05-23 00:27:20', 1, 1, NULL);
INSERT INTO `user` VALUES (2, '郑立富', '1111', 'teiphu@qq.com', '18476837273', '女', '2019-05-22 01:21:08', 'Java开发工程师', NULL, 'normal', '2019-04-17 22:47:47', '2019-05-22 01:21:08', '2019-05-22 01:21:08', 1, 1, NULL);
INSERT INTO `user` VALUES (3, 'longjuan', '123456', 'longjuan@qq.com', '13631465253', '女', '2019-05-18 23:16:25', NULL, NULL, 'normal', '2019-04-27 23:58:08', '2019-05-18 23:16:25', '2019-05-18 23:16:25', 1, 1, NULL);
INSERT INTO `user` VALUES (4, 'qiuju', '23456', 'qiuju@qq.com', '13673849047', '女', '2019-05-18 23:16:27', NULL, NULL, 'normal', '2019-05-06 23:57:45', '2019-05-18 23:16:27', '2019-05-18 23:16:27', 1, 1, NULL);
INSERT INTO `user` VALUES (5, '卡卡罗特', '345678', 'kakaluote@qq.com', '13576429874', '男', '2019-05-23 17:48:54', NULL, NULL, 'normal', '2019-05-09 01:07:38', '2019-05-23 17:48:54', '2019-05-23 17:48:54', 1, 1, NULL);
INSERT INTO `user` VALUES (6, '贝吉塔', '456789', 'beijita@qq.com', '13531956173', '男', '2019-05-18 23:16:30', NULL, NULL, 'normal', '2019-05-09 01:09:04', '2019-05-18 23:16:30', '2019-05-18 23:16:30', 1, 1, NULL);
INSERT INTO `user` VALUES (7, '娜美', '567890', 'namei@qq.com', '13456895637', '女', '2019-05-18 23:16:31', NULL, NULL, 'normal', '2019-05-09 01:11:24', '2019-05-18 23:16:31', '2019-05-18 23:16:31', 1, 1, NULL);
INSERT INTO `user` VALUES (8, '汉库克', '678901', 'hankuke@qq.com', '13243564355', '女', '2019-05-18 23:16:33', NULL, NULL, 'normal', '2019-05-09 01:17:54', '2019-05-18 23:16:33', '2019-05-18 23:16:33', 1, 1, NULL);
INSERT INTO `user` VALUES (84, 'lifu', '2f7b52aacfbf6f44e13d27656ecb1f59', 'lifu@qq.com', '18476837273', NULL, '2019-05-19 23:22:14', NULL, NULL, 'normal', '2019-05-19 23:21:59', '2019-05-19 23:22:14', '2019-05-19 23:22:14', 1, 1, NULL);
INSERT INTO `user` VALUES (85, 'li', '2f7b52aacfbf6f44e13d27656ecb1f59', 'teiphu@qq.com', '15816021142', NULL, '2019-05-19 23:27:19', NULL, NULL, 'normal', '2019-05-19 23:26:16', '2019-05-19 23:27:19', '2019-05-19 23:27:19', 1, 1, NULL);
INSERT INTO `user` VALUES (86, '索隆', '123456', 'suolong@qq.com', '15816021142', NULL, '2019-05-23 15:46:55', NULL, NULL, 'normal', '2019-05-23 15:46:33', '2019-05-23 15:46:55', '2019-05-23 15:46:55', 1, 1, NULL);

-- ----------------------------
-- Table structure for user_topic
-- ----------------------------
DROP TABLE IF EXISTS `user_topic`;
CREATE TABLE `user_topic`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(11) UNSIGNED NULL DEFAULT NULL,
  `topic_id` int(11) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 74 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_topic
-- ----------------------------
INSERT INTO `user_topic` VALUES (6, 2, 6);
INSERT INTO `user_topic` VALUES (7, 3, 1);
INSERT INTO `user_topic` VALUES (8, 3, 2);
INSERT INTO `user_topic` VALUES (9, 4, 1);
INSERT INTO `user_topic` VALUES (10, 4, 3);
INSERT INTO `user_topic` VALUES (17, 2, 9);
INSERT INTO `user_topic` VALUES (18, 2, 8);
INSERT INTO `user_topic` VALUES (21, 2, 3);
INSERT INTO `user_topic` VALUES (22, 2, 5);
INSERT INTO `user_topic` VALUES (23, 2, 18);
INSERT INTO `user_topic` VALUES (24, 2, 19);
INSERT INTO `user_topic` VALUES (25, 2, 12);
INSERT INTO `user_topic` VALUES (30, 80, 1);
INSERT INTO `user_topic` VALUES (31, 80, 2);
INSERT INTO `user_topic` VALUES (35, 2, 11);
INSERT INTO `user_topic` VALUES (36, 2, 2);
INSERT INTO `user_topic` VALUES (39, 8, 1);
INSERT INTO `user_topic` VALUES (40, 8, 2);
INSERT INTO `user_topic` VALUES (41, 8, 3);
INSERT INTO `user_topic` VALUES (42, 8, 4);
INSERT INTO `user_topic` VALUES (43, 8, 5);
INSERT INTO `user_topic` VALUES (44, 8, 6);
INSERT INTO `user_topic` VALUES (45, 8, 7);
INSERT INTO `user_topic` VALUES (46, 8, 8);
INSERT INTO `user_topic` VALUES (47, 8, 9);
INSERT INTO `user_topic` VALUES (48, 8, 10);
INSERT INTO `user_topic` VALUES (49, 8, 11);
INSERT INTO `user_topic` VALUES (50, 8, 12);
INSERT INTO `user_topic` VALUES (51, 8, 18);
INSERT INTO `user_topic` VALUES (52, 8, 19);
INSERT INTO `user_topic` VALUES (53, 7, 1);
INSERT INTO `user_topic` VALUES (54, 7, 2);
INSERT INTO `user_topic` VALUES (55, 7, 3);
INSERT INTO `user_topic` VALUES (56, 7, 4);
INSERT INTO `user_topic` VALUES (57, 7, 5);
INSERT INTO `user_topic` VALUES (58, 7, 6);
INSERT INTO `user_topic` VALUES (59, 7, 7);
INSERT INTO `user_topic` VALUES (60, 7, 8);
INSERT INTO `user_topic` VALUES (61, 7, 9);
INSERT INTO `user_topic` VALUES (62, 7, 11);
INSERT INTO `user_topic` VALUES (63, 7, 10);
INSERT INTO `user_topic` VALUES (64, 7, 12);
INSERT INTO `user_topic` VALUES (65, 7, 18);
INSERT INTO `user_topic` VALUES (66, 7, 19);
INSERT INTO `user_topic` VALUES (67, 1, 1);
INSERT INTO `user_topic` VALUES (68, 1, 2);
INSERT INTO `user_topic` VALUES (69, 1, 4);
INSERT INTO `user_topic` VALUES (70, 1, 5);
INSERT INTO `user_topic` VALUES (71, 1, 6);
INSERT INTO `user_topic` VALUES (72, 1, 9);
INSERT INTO `user_topic` VALUES (73, 1, 10);
INSERT INTO `user_topic` VALUES (74, 86, 1);
INSERT INTO `user_topic` VALUES (75, 86, 2);
INSERT INTO `user_topic` VALUES (76, 86, 3);
INSERT INTO `user_topic` VALUES (77, 86, 4);
INSERT INTO `user_topic` VALUES (78, 86, 5);
INSERT INTO `user_topic` VALUES (79, 86, 6);
INSERT INTO `user_topic` VALUES (80, 86, 7);
INSERT INTO `user_topic` VALUES (81, 86, 8);
INSERT INTO `user_topic` VALUES (82, 86, 10);
INSERT INTO `user_topic` VALUES (83, 86, 11);
INSERT INTO `user_topic` VALUES (84, 86, 12);
INSERT INTO `user_topic` VALUES (85, 86, 18);
INSERT INTO `user_topic` VALUES (86, 86, 19);
INSERT INTO `user_topic` VALUES (87, 86, 20);
INSERT INTO `user_topic` VALUES (88, 86, 21);
INSERT INTO `user_topic` VALUES (89, 5, 1);
INSERT INTO `user_topic` VALUES (90, 5, 2);
INSERT INTO `user_topic` VALUES (91, 5, 3);
INSERT INTO `user_topic` VALUES (92, 5, 4);
INSERT INTO `user_topic` VALUES (93, 5, 5);
INSERT INTO `user_topic` VALUES (94, 5, 6);
INSERT INTO `user_topic` VALUES (95, 5, 7);
INSERT INTO `user_topic` VALUES (96, 5, 8);
INSERT INTO `user_topic` VALUES (97, 5, 9);
INSERT INTO `user_topic` VALUES (98, 5, 10);
INSERT INTO `user_topic` VALUES (99, 5, 11);
INSERT INTO `user_topic` VALUES (100, 5, 12);
INSERT INTO `user_topic` VALUES (101, 5, 18);
INSERT INTO `user_topic` VALUES (102, 5, 19);
INSERT INTO `user_topic` VALUES (103, 5, 20);
INSERT INTO `user_topic` VALUES (104, 5, 21);
INSERT INTO `user_topic` VALUES (105, 6, 1);
INSERT INTO `user_topic` VALUES (106, 6, 2);
INSERT INTO `user_topic` VALUES (107, 6, 3);
INSERT INTO `user_topic` VALUES (108, 6, 4);
INSERT INTO `user_topic` VALUES (109, 6, 5);
INSERT INTO `user_topic` VALUES (110, 6, 7);
INSERT INTO `user_topic` VALUES (111, 6, 8);

SET FOREIGN_KEY_CHECKS = 1;
