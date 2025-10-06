drop table if exists `family`;
create table family (
    id int auto_increment primary key,
    familyName varchar(50) not null,
    userId int COMMENT 'head of family',
    CONSTRAINT `FK_family_head` FOREIGN KEY (userId)
        REFERENCES users(id)
        ON DELETE CASCADE
)
;