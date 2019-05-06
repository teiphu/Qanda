CREATE TABLE `user` (
`id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
`user_name` varchar(255) NULL,
`password` varchar(255) NULL,
`email` varchar(255) NULL,
`phone` varchar(255) NULL,
`sex` varchar(255) NULL,
`birthday` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
`job` varchar(255) NULL,
`signature` varchar(255) NULL,
`gmt_create` datetime NULL,
`gmt_modified` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
`gmt_logout` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
`status` tinyint(1) UNSIGNED NULL DEFAULT 1 COMMENT '0表示封号，1表示启用',
`delete` tinyint(1) NULL DEFAULT 1 COMMENT '0表示已注销，1表示在册用户',
PRIMARY KEY (`id`)
);
CREATE TABLE `question` (
`id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
`user_id` int(11) UNSIGNED NULL,
`topic_id` int(11) UNSIGNED NULL,
`content` varchar(255) NULL,
`gmt_create` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
`gmt_modified` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
`status` tinyint(1) UNSIGNED NULL,
PRIMARY KEY (`id`)
);
CREATE TABLE `answer` (
`id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
`user_id` int(11) UNSIGNED NULL,
`question_id` int(11) UNSIGNED NULL,
`answer_content` varchar(255) NULL,
`gmt_create` datetime NULL,
`gmt_modified` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`)
);
CREATE TABLE `topic` (
`id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
`user_id` int(11) UNSIGNED NULL,
`topic_name` varchar(16) NULL,
`topic_detail` varchar(255) NULL,
`gmt_create` datetime NULL,
`gmt_modified` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`)
);
CREATE TABLE `comment` (
`id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
`parent_comment_id` int(11) UNSIGNED NULL,
`user_id` int(11) UNSIGNED NULL,
`answer_id` int(11) UNSIGNED NULL,
`comment_content` varchar(255) NULL,
`gmt_create` datetime NULL,
`gmt_modified` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
`delete` tinyint UNSIGNED NULL,
PRIMARY KEY (`id`)
);
CREATE TABLE `updownvote` (
`id` int UNSIGNED NOT NULL AUTO_INCREMENT,
`comment_id` int UNSIGNED NULL,
`answer_id` int UNSIGNED NULL,
`sender_id` int UNSIGNED NULL,
`receiver_id` int NULL,
`up_or_down` tinyint UNSIGNED NULL COMMENT 'up:1; down:0',
`gmt_create` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
`gmt_modified` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`)
);
CREATE TABLE `user_topic` (
`id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
`user_id` int(11) UNSIGNED NULL,
`topic_id` int(11) UNSIGNED NULL,
PRIMARY KEY (`id`)
);
CREATE TABLE `topic_question` (
`id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
`topic_id` int(11) UNSIGNED NULL,
`question_id` int(11) UNSIGNED NULL,
PRIMARY KEY (`id`)
);
