-- DROP TABLE IF EXISTS users;
-- CREATE TABLE users(
--                       user_id BIGSERIAL  PRIMARY KEY,
--                       username varchar(50) NOT NULL ,
--                       password varchar(50) NOT NULL,
--                       enabled BOOLEAN NOT NULL
-- );
--
-- DROP TABLE IF EXISTS authorities;
-- CREATE TABLE authorities (
--                              authority_id BIGSERIAL PRIMARY KEY,
--                              username varchar(50) NOT NULL,
--                              authority varchar(50) NOT NULL
-- );
--
-- Drop TABLE IF EXISTS customer;
-- CREATE TABLE customer (
--                              customer_id BIGSERIAL PRIMARY KEY,
--                              email varchar(50) NOT NULL,
--                              password varchar(50) NOT NULL,
--                              role varchar(50) NOT NULL
-- );
--
-- insert into users(username, password, enabled) values ('hosam','123456',true);
-- insert into authorities(username, authority) VALUES ('hosam','write');
--
-- insert into customer (email, password, role) values ('hosam@gmail.com','123456','admin');