CREATE TABLE EMPLOYEE(
                         ID SERIAL PRIMARY KEY,
                         FIRST_NAME character varying(50),
                         LAST_NAME character varying(50),
                         EMAIL character varying(50)
);
COMMIT;

INSERT INTO EMPLOYEE(FIRST_NAME,LAST_NAME,EMAIL)
VALUES
('Sandeera','Jayampathi','sandeera@gmail.com'),
('Uthpala','Hewage','uthpala@gmail.com'),
('Nadun','Dhananjaya','nadun@gmail.com');

COMMIT;