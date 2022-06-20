CREATE TABLE Role
(
    id bigint auto_increment,
    name NVARCHAR(20) NOT NULL,
    CONSTRAINT PK_Roletable PRIMARY KEY (id)
);

--
INSERT INTO Role(name) values ('ROLE_ADMIN');
INSERT INTO Role(name) values ('ROLE_USER');

CREATE TABLE Userapp
(
    id integer  auto_increment  NOT NULL ,
    login    NVARCHAR(50) ,
    password NVARCHAR(500)NOT NULL,
    roletableid  INTEGER,

    CONSTRAINT PK_Userapp PRIMARY KEY (id),
    FOREIGN KEY (roletableid) REFERENCES Role (id)
);