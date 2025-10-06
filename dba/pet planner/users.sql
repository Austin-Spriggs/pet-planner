drop table if exists `users`;
create table users
(
    id        int auto_increment primary key,
    firstName varchar(15)  not null,
    lastName  varchar(20)  not null,
    email     varchar(50)  not null,
    username  varchar(15)  not null
);

