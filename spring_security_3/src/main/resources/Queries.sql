CREATE TABLE EMPLOYEE
(
    ID         SERIAL PRIMARY KEY,
    FIRST_NAME character varying(50),
    LAST_NAME  character varying(50),
    EMAIL      character varying(50)
);
COMMIT;

INSERT INTO EMPLOYEE(FIRST_NAME, LAST_NAME, EMAIL)
VALUES ('Sandeera', 'Jayampathi', 'sandeera@gmail.com'),
       ('Uthpala', 'Hewage', 'uthpala@gmail.com'),
       ('Nadun', 'Dhananjaya', 'nadun@gmail.com');

COMMIT;

CREATE TABLE IF NOT EXISTS users
(
    username character varying(50) NOT NULL,
    password character varying(50) NOT NULL,cd ..
    enabled  numeric(1, 0)         NOT NULL DEFAULT 1,
    CONSTRAINT users_pkey PRIMARY KEY (username)
);

CREATE TABLE IF NOT EXISTS authorities
(
    username  character varying(50) NOT NULL,
    authority character varying(50) NOT NULL,
    CONSTRAINT username_authority UNIQUE (username, authority),
    CONSTRAINT fk_username FOREIGN KEY (username)
        REFERENCES users (username)
);

insert into authorities
values ('sandeera', 'ROLE_EMPLOYEE'),
       ('sandeera', 'ROLE_MANAGER'),
       ('uthpala', 'ROLE_EMPLOYEE'),
       ('uthpala', 'ROLE_MANAGER'),
       ('uthpala', 'ROLE_ADMIN'),
       ('nadun', 'ROLE_EMPLOYEE');


create table users
(
    username character varying(50) primary key,
    password character varying(100) not null,
    enabled  numeric(1)             not null default 1
);

insert into users
values ('uthpala', '{bcrypt}$2a$10$fEokxiEOic2mdtQcUujzfe6gDPMKvhUYohzebcKROSKu6XcxmNM7i', 1),
       ('sandeera', '{bcrypt}$2a$10$kDtMWg2vuHcvLPrd1/BNL.EX/Rlxt6RZssZI0jBkqU2Amg6jbuVyW', 1),
       ('nadun', '{bcrypt}$2a$10$kDtMWg2vuHcvLPrd1/BNL.EX/Rlxt6RZssZI0jBkqU2Amg6jbuVyW', 1);


CREATE TABLE IF NOT EXISTS members
(
    user_id character varying(50) NOT NULL,
    pw character varying(100) NOT NULL,
    active  numeric(1, 0)         NOT NULL DEFAULT 1,
    CONSTRAINT users_pkey PRIMARY KEY (user_id)
);

insert into members
values ('uthpala', '{bcrypt}$2a$10$fEokxiEOic2mdtQcUujzfe6gDPMKvhUYohzebcKROSKu6XcxmNM7i', 1),
       ('sandeera', '{bcrypt}$2a$10$kDtMWg2vuHcvLPrd1/BNL.EX/Rlxt6RZssZI0jBkqU2Amg6jbuVyW', 1),
       ('nadun', '{bcrypt}$2a$10$kDtMWg2vuHcvLPrd1/BNL.EX/Rlxt6RZssZI0jBkqU2Amg6jbuVyW', 1);


CREATE TABLE IF NOT EXISTS roles
(
    user_id  character varying(50) NOT NULL,
    role character varying(50) NOT NULL,
    CONSTRAINT username_authority UNIQUE (user_id, role),
    CONSTRAINT fk_username FOREIGN KEY (user_id)
        REFERENCES members (user_id)
);

insert into roles
values ('sandeera', 'ROLE_EMPLOYEE'),
       ('sandeera', 'ROLE_MANAGER'),
       ('uthpala', 'ROLE_EMPLOYEE'),
       ('uthpala', 'ROLE_MANAGER'),
       ('uthpala', 'ROLE_ADMIN'),
       ('nadun', 'ROLE_EMPLOYEE');