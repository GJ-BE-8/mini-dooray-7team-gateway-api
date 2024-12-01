DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
	`project_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT',
	`project_name`	VARCHAR(50)	NOT NULL,
	`project_status`	VARCHAR(255)	NOT NULL
);

DROP TABLE IF EXISTS `task`;

CREATE TABLE `task` (
	`task_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT',
	`task_name`	VARCHAR(50)	NOT NULL,
	`task_content`	VARCHAR(500)	NOT NULL,
	`project_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT'
);

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
	`user_id`	VARCHAR(50)	NOT NULL,
	`user_email`	VARCHAR(50)	NOT NULL,
	`user_password`	VARCHAR(50)	NOT NULL,
	`user_auth`	VARCHAR(255)	NOT NULL,
	`user_status`	VARCHAR(255)	NOT NULL
);

DROP TABLE IF EXISTS `milestone`;

CREATE TABLE `milestone` (
	`milestone_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT',
	`milestone_name`	VARCHAR(50)	NOT NULL,
	`task_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT'
);

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
	`comment_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT',
	`comment_content`	VARCHAR(200)	NOT NULL,
	`task_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT',
	`user_id`	VARCHAR(50)	NOT NULL
);

DROP TABLE IF EXISTS `tag`;

CREATE TABLE `tag` (
	`tag_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT',
	`tag_name`	VARCHAR(50)	NOT NULL,
	`task_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT'
);

DROP TABLE IF EXISTS `user_project`;

CREATE TABLE `user_project` (
	`user_id`	VARCHAR(50)	NOT NULL,
	`project_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT'
);

ALTER TABLE `project` ADD CONSTRAINT `PK_PROJECT` PRIMARY KEY (
	`project_id`
);

ALTER TABLE `task` ADD CONSTRAINT `PK_TASK` PRIMARY KEY (
	`task_id`
);

ALTER TABLE `user` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
	`user_id`
);

ALTER TABLE `milestone` ADD CONSTRAINT `PK_MILESTONE` PRIMARY KEY (
	`milestone_id`
);

ALTER TABLE `comment` ADD CONSTRAINT `PK_COMMENT` PRIMARY KEY (
	`comment_id`
);

ALTER TABLE `tag` ADD CONSTRAINT `PK_TAG` PRIMARY KEY (
	`tag_id`
);

ALTER TABLE `task` ADD CONSTRAINT `FK_project_TO_task_1` FOREIGN KEY (
	`project_id`
)
REFERENCES `project` (
	`project_id`
);

ALTER TABLE `milestone` ADD CONSTRAINT `FK_task_TO_milestone_1` FOREIGN KEY (
	`task_id`
)
REFERENCES `task` (
	`task_id`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_task_TO_comment_1` FOREIGN KEY (
	`task_id`
)
REFERENCES `task` (
	`task_id`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_user_TO_comment_1` FOREIGN KEY (
	`user_id`
)
REFERENCES `user` (
	`user_id`
);

ALTER TABLE `tag` ADD CONSTRAINT `FK_task_TO_tag_1` FOREIGN KEY (
	`task_id`
)
REFERENCES `task` (
	`task_id`
);

ALTER TABLE `user_project` ADD CONSTRAINT `FK_user_TO_user_project_1` FOREIGN KEY (
	`user_id`
)
REFERENCES `user` (
	`user_id`
);

ALTER TABLE `user_project` ADD CONSTRAINT `FK_project_TO_user_project_1` FOREIGN KEY (
	`project_id`
)
REFERENCES `project` (
	`project_id`
);

