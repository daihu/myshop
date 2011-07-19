#1.创建数据库：
CREATE DATABASE  MY_SHOP;
#2.指定使用的数据库：
USE MY_SHOP;

########################################
#3.创建CATEGORY表：
CREATE TABLE CATEGORY(
    ID           INTEGER    AUTO_INCREMENT,
    NAME	  VARCHAR(200),
    PRIMARY KEY (ID)
);
#4.CATEGORY表中添加数据：
INSERT INTO CATEGORY (NAME) VALUES ('books');
INSERT INTO CATEGORY (NAME) VALUES ('cars');
INSERT INTO CATEGORY (NAME) VALUES ('toys');
########################################
#5.创建MERCHANDISE表：
CREATE TABLE MERCHANDISE(
	ID		INTEGER		AUTO_INCREMENT,
	NAME		VARCHAR(200),
	PRICE		INTEGER,
	ADD_TIME	TIMESTAMP,
	CATEGORY_ID	INTEGER,
	PRIMARY KEY (ID)
);
#6.MERCHANDISE表中添加数据：
INSERT INTO   MERCHANDISE(name,price,add_time,category_id)  VALUES ('b1',111,'1999-03-30',1);
INSERT INTO   MERCHANDISE(name,price,add_time,category_id)  VALUES ('b2',122,'2005-05-30',1);
INSERT INTO   MERCHANDISE(name,price,add_time,category_id)  VALUES ('b3',233,'2006-08-30',1);
INSERT INTO   MERCHANDISE(name,price,add_time,category_id)  VALUES ('b4',566,'1998-02-12',1);
INSERT INTO   MERCHANDISE(name,price,add_time,category_id)  VALUES ('b5',888,'2003-09-10',1);
INSERT INTO   MERCHANDISE(name,price,add_time,category_id)  VALUES ('c1',111111,'1999-03-30',2);
INSERT INTO   MERCHANDISE(name,price,add_time,category_id)  VALUES ('c2',122222,'2005-05-30',2);
INSERT INTO   MERCHANDISE(name,price,add_time,category_id)  VALUES ('c3',233333,'2006-08-30',2);

########################################
#7.又如，创建pet表如下：
CREATE TABLE  pet (
       id           INTEGER    AUTO_INCREMENT,
       name     VARCHAR(20), 
       owner   VARCHAR(20),
       sex        CHAR(1), 
       birth      DATE, 
       PRIMARY KEY (ID)
);

#8.向pet表中添加数据：
INSERT INTO   pet (name,owner,sex,birth)  VALUES ('dog1','Tom','f','1999-03-30');
INSERT INTO   pet (name,owner,sex,birth)  VALUES ('dog2','Jack','f','2006-02-18');
INSERT INTO   pet (name,owner,sex,birth)  VALUES ('pig1','Mary','m','2005-05-05');
INSERT INTO   pet (name,owner,sex,birth)  VALUES ('cat1','Tom','f','1998-08-10');
INSERT INTO   pet (name,owner,sex,birth)  VALUES ('dog3','Mary','f','2006-06-22');




