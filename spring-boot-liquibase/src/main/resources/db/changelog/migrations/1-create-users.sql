--liquibase formatted sql
--changeset TRUONG:1 runOnChange;
--comment: create table users;
create table users(
  id int primary key,
  name nvarchar(255),
  email nvarchar(255),
  phone nvarchar(255),
  address nvarchar(255)
);
--rollback drop table users;
