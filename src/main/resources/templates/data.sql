CREATE TABLE `microsoft_account` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '密码',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_score` bigint DEFAULT NULL,
  `latest_score` bigint DEFAULT NULL,
  `status` int DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `microsoft_account_rewards` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `account_id` int unsigned NOT NULL COMMENT '账户id',
  `total_score` int NOT NULL COMMENT '累计积分',
  `status` int NOT NULL COMMENT '更新状态',
  `day_score` int NOT NULL COMMENT '每日新增积分',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (1, 'kevinyulk@163.com', 'zhujing520', '2023-01-22 22:55:46', '2023-01-22 22:55:46', 4127, 4127, 1);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (2, 'hangzhouhuawei@hotmail.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', 1335, 1335, 1);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (3, 'hangzhouhuawei1@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', 866, 866, 1);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (4, 'hangzhouhuawei2@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', 632, 632, 1);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (5, 'hangzhouhuawei3@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', 427, 427, 1);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (6, 'shaoyifu1@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', 484, 484, 1);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (7, 'shaoyifu2@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', 450, 450, 1);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (8, 'shaoyifu3@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', 451, 451, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (9, 'yangguangcheng11@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', 423, 423, 1);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (10, 'fuyangnongshang1@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', 442, 442, 1);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (11, 'fuyangdongqiao@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (12, 'jingdongwuxianbao@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (13, 'hangzhouhaikang@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', 264, 264, 1);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (14, 'yulingkai110@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (15, 'yulingkai111@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (16, 'yulingkai120@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', 234, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (17, 'yulingkai122@hotmail.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (18, 'yulingkai123@hotmail.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (19, 'zhujing119@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (20, 'yuyouming110@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (21, 'yulingkai220@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', 201, NULL, 1);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (22, 'yulingkai221@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (23, 'yulingkai2021@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (24, 'yulingkai2022@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (25, 'yulingkai2023@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (26, 'yulingkai2024@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', 204, NULL, 1);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (27, 'yulingkai2025@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (28, 'yulingkai2026@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (29, 'yulingkai2027@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (30, 'yulingkai2028@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (31, 'yulingkai2029@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (32, 'yulingkai2030@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (33, 'yulingkai2031@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (34, 'yulingkai2032@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (35, 'yulingkai2033@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (36, 'yulingkai2034@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (37, 'yulingkai2035@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (38, 'yulingkai2036@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', 165, NULL, 1);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (39, 'yulingkai2037@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (40, 'yulingkai2038@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (41, 'yulingkai2039@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (42, 'yulingkai2040@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (43, 'yulingkai2041@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (44, 'yulingkai2042@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (45, 'yulingkai2043@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (46, 'yulingkai2044@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (47, 'yulingkai2045@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (48, 'yulingkai2046@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (49, 'yulingkai2047@outlook.com', 'yupaopao990', '2023-01-22 22:55:46', '2023-01-22 22:55:46', 87, NULL, 1);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (50, 'yulingkai2048@outlook.com', 'yupaopao990', '0023-01-22 22:55:46', '0023-01-22 22:55:46', NULL, NULL, 0);
INSERT INTO `microsoftrewards`.`microsoft_account` (`id`, `username`, `password`, `update_time`, `create_time`, `last_score`, `latest_score`, `status`) VALUES (51, 'yulingkai2049@outlook.com', 'yupaopao990', '0023-01-22 22:55:46', '0023-01-22 22:55:46', NULL, NULL, 0);