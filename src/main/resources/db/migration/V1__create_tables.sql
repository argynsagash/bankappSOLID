-- -- CREATE TABLE Account
-- -- (
-- --     id               NVARCHAR(40) UNIQUE,
-- --     account_type     NVARCHAR(40) NOT NULL,
-- --     client_id        NVARCHAR(40) NOT NULL,
-- --     balance          FLOAT   NOT NULL,
-- --     withdraw_allowed BOOLEAN NOT NULL,
-- --
-- --     CONSTRAINT PK_Account PRIMARY KEY (id)
-- -- );
-- -- insert into Account_Entity values ('001000001', 'SAVING','1', 0.0, true);
-- --
-- -- CREATE TABLE Transaction
-- -- (
-- --
-- --     id IDENTITY NOT NULL,
-- --     transaction_info NVARCHAR(128) NOT NULL,
-- --     account_id       NVARCHAR(40) NOT NULL,
-- --
-- --     CONSTRAINT PK_Transaction PRIMARY KEY (id),
-- --     FOREIGN KEY (account_id) REFERENCES Account (id)
-- -- );
--
-- -- CREATE TABLE Role
-- -- (
-- --     id bigint auto_increment,
-- --     name NVARCHAR(20) NOT NULL,
-- --     CONSTRAINT PK_Roletable PRIMARY KEY (id)
-- -- );
-- --
-- -- --
-- -- INSERT INTO Role(name) values ('ROLE_ADMIN');
-- -- INSERT INTO Role(name) values ('ROLE_USER');
-- --
-- -- CREATE TABLE Userapp
-- -- (
-- --     id integer  auto_increment  NOT NULL ,
-- --     login    NVARCHAR(50) ,
-- --     password NVARCHAR(500)NOT NULL,
-- --     roletableid  INTEGER,
-- --
-- --     CONSTRAINT PK_Userapp PRIMARY KEY (id),
-- --     FOREIGN KEY (roletableid) REFERENCES Role (id)
-- -- );
-- CREATE TABLE account
-- (
--     id               VARCHAR(255) NOT NULL,
--     account_type     INTEGER,
--     balance          DOUBLE PRECISION,
--     withdraw_allowed BOOLEAN,
--     CONSTRAINT pk_account PRIMARY KEY (id)
-- );
--
-- CREATE TABLE app_user
-- (
--     id       BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
--     login    VARCHAR(255),
--     password VARCHAR(255),
--     role_id  BIGINT,
--     CONSTRAINT pk_app_user PRIMARY KEY (id)
-- );
--
-- CREATE TABLE role
-- (
--     id   BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
--     name VARCHAR(255),
--     CONSTRAINT pk_role PRIMARY KEY (id)
-- );
--
-- CREATE TABLE transaction
-- (
--     id               BIGINT NOT NULL,
--     transaction_info VARCHAR(255),
--     account_id       VARCHAR(255),
--     CONSTRAINT pk_transaction PRIMARY KEY (id)
-- );
--
-- ALTER TABLE app_user
--     ADD CONSTRAINT FK_APP_USER_ON_ROLE FOREIGN KEY (role_id) REFERENCES role (id);
--
-- ALTER TABLE transaction
--     ADD CONSTRAINT FK_TRANSACTION_ON_ACCOUNT FOREIGN KEY (account_id) REFERENCES account (id);
--
-- ALTER TABLE rate
--     DROP CONSTRAINT fk6v436rrf5sonr67ncxxga9mwg;
--
-- DROP TABLE rate CASCADE;
--
-- DROP TABLE student CASCADE;
-- CREATE TABLE account
-- (
--     id               VARCHAR(255) NOT NULL,
--     account_type     INTEGER,
--     balance          DOUBLE PRECISION,
--     withdraw_allowed BOOLEAN,
--     CONSTRAINT pk_account PRIMARY KEY (id)
-- );
--
-- CREATE TABLE app_user
-- (
--     id       BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
--     login    VARCHAR(255),
--     password VARCHAR(255),
--     role_id  BIGINT,
--     CONSTRAINT pk_app_user PRIMARY KEY (id)
-- );
--
-- CREATE TABLE role
-- (
--     id   BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
--     name VARCHAR(255),
--     CONSTRAINT pk_role PRIMARY KEY (id)
-- );
--
-- CREATE TABLE transaction
-- (
--     id               BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
--     transaction_info VARCHAR(255),
--     account_id       VARCHAR(255),
--     CONSTRAINT pk_transaction PRIMARY KEY (id)
-- );
--
-- ALTER TABLE app_user
--     ADD CONSTRAINT FK_APP_USER_ON_ROLE FOREIGN KEY (role_id) REFERENCES role (id);
--
-- ALTER TABLE transaction
--     ADD CONSTRAINT FK_TRANSACTION_ON_ACCOUNT FOREIGN KEY (account_id) REFERENCES account (id);
--
