drop table if exists t_user;

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   id                   bigint auto_increment,
   loginname            varchar(255),
   loginPWD             varchar(255),
   realName             varchar(255),
   primary key (id)
);
insert into t_user(loginname, loginPWD, realName) values('zhangsan', '123', 'zs');
insert into t_user(loginname, loginPWD, realName) values('jack', '123', 'jk');
commit;
select * from t_user;