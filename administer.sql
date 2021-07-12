CREATE TABLE `administer`
(
    `id`          bigint      NOT NULL AUTO_INCREMENT,
    `create_time` datetime    NOT NULL COMMENT '记录创建时间',
    `update_time` datetime   DEFAULT NULL COMMENT '记录更新时间',
    `is_deleted`  tinyint(1) DEFAULT '0' COMMENT '逻辑删除，默认0（未删除）',
    `username`    varchar(16) NOT NULL COMMENT '登录用户名',
    `password`    varchar(64) NOT NULL COMMENT '登录密码',
    `name`        varchar(10) NOT NULL COMMENT '用户的名字',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='网站后台管理员';

insert into administer (create_time, update_time, is_deleted, username, password, name)
values (now(), now(), 0, 'user1', 'e10adc3949ba59abbe56e057f20f883e', 'tlf');