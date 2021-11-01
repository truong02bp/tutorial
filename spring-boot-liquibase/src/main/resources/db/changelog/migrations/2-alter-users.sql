--liquibase formatted sql
--changeset TRUONG:2 runOnChange;
--comment: add column username;
alter table users add column username nvarchar(255);
--rollback alter table users drop column username;
