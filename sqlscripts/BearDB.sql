
/*******************************************************************************
   Bear Database - Version 0.1
   Script: BearDB.sql
   Description: Creates and populates the Bear database.
   DB Server: Oracle
   Author: Mehrab Rahman
********************************************************************************/

/*******************************************************************************
   Drop database if it exists
********************************************************************************/
DROP USER bear CASCADE;


/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER bear
IDENTIFIED BY bear
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to bear;
GRANT resource to bear;
GRANT create session TO bear;
GRANT create table TO bear;
GRANT create view TO bear;



conn bear/bear


/*******************************************************************************
   Create Tables
********************************************************************************/
CREATE TABLE CAVE
(
    Cave_Id INTEGER PRIMARY KEY,
    Cave_Name VARCHAR2(50),
    Max_Bears INTEGER DEFAULT 4,
    CONSTRAINT Unique_Cave_Name UNIQUE (Cave_Name)
);

CREATE TABLE BEAR_TYPE
(
    Bear_Type_Id INTEGER PRIMARY KEY,
    Bear_Type_Name VARCHAR2(50)
);

CREATE TABLE BEAR
(
    Bear_ID INTEGER PRIMARY KEY,
    Bear_Name VARCHAR2(50),
    Bear_Age INTEGER,
    Bear_Weight INTEGER,
    Bear_Type_Id INTEGER,
    Cave_Id INTEGER,
    CONSTRAINT Check_Bear_Age CHECK (Bear_Age > 0),
    CONSTRAINT Check_Bear_Weight CHECK (Bear_Weight > 0)
);

CREATE TABLE BEEHIVE
(
    Beehive_Id INTEGER PRIMARY KEY,
    Hive_Weight INTEGER DEFAULT 50,
    CONSTRAINT Check_Hive_Weight CHECK (Hive_Weight > 0)
);

CREATE TABLE BEAR_BEEHIVE
(
    Bear_Id INTEGER,
    Beehive_Id INTEGER,
    CONSTRAINT FK_BearBeehive PRIMARY KEY (Bear_Id, Beehive_Id)
);



/*******************************************************************************
   Create Foreign Keys
********************************************************************************/
ALTER TABLE BEAR ADD CONSTRAINT FK_Bear_Type_Id
    FOREIGN KEY (Bear_Type_Id) REFERENCES BEAR_TYPE (Bear_Type_Id)  ;

ALTER TABLE BEAR ADD CONSTRAINT FK_Cave_Id
    FOREIGN KEY (Cave_Id) REFERENCES CAVE (Cave_Id)  ;


ALTER TABLE BEAR_BEEHIVE ADD CONSTRAINT FK_Bear_Id
    FOREIGN KEY (Bear_Id) REFERENCES BEAR (Bear_Id)  ;

ALTER TABLE BEAR_BEEHIVE ADD CONSTRAINT FK_Beehive_Id
    FOREIGN KEY (Beehive_Id) REFERENCES BEEHIVE (Beehive_Id)  ;


commit;
/*******************************************************************************
   Populate Tables
********************************************************************************/
INSERT INTO CAVE (Cave_Id, Cave_Name, Max_Bears) VALUES (1, 'Yosemite', 4);
INSERT INTO CAVE (Cave_Id, Cave_Name, Max_Bears) VALUES (2, 'Yellostone', 4);
INSERT INTO BEEHIVE VALUES (1, 35);
INSERT INTO BEEHIVE VALUES (2, 50);
INSERT INTO BEAR_TYPE (Bear_Type_Id, Bear_Type_Name) VALUES (1, 'Picnic');
INSERT INTO BEAR (Bear_Id, Bear_Name, Bear_Age, Bear_Weight, Bear_Type_Id, Cave_Id) VALUES (1, 'Yogi', 10, 150, 1, 1);
INSERT INTO BEAR (Bear_Id, Bear_Name, Bear_Age, Bear_Weight, Bear_Type_Id, Cave_Id) VALUES (2, 'Boo Boo', 8, 50, 1, 1);

INSERT INTO BEAR_BEEHIVE VALUES(1, 2);

/*Truncating tables with FKs*/
TRUNCATE TABLE BEAR_BEEHIVE;
ALTER TABLE BEAR_BEEHIVE DROP CONSTRAINT FK_Bear_Id;
TRUNCATE TABLE BEAR;

--Create sequence for BEAR primary keys
CREATE SEQUENCE SQ_BEAR_PK
START WITH 1
INCREMENT BY 2;

--Create before insert trigger
CREATE OR REPLACE TRIGGER TR_INSERT_BEAR
BEFORE INSERT ON BEAR
FOR EACH ROW
BEGIN
  SELECT SQ_BEAR_PK.NEXTVAL INTO :NEW.Bear_Id FROM DUAL;
  --DUAL is a dummy table for when you don't require one but need syntax
END;

INSERT INTO BEAR (Bear_Name, Bear_Type_Id, Bear_Age, Cave_Id)
VALUES ('Jeff', 1, 4, 1);
INSERT INTO BEAR (Bear_Name, Bear_Type_Id, Bear_Age, Cave_Id)
VALUES ('Reginald', 1, 7, 1);
INSERT INTO BEAR (Bear_Name, Bear_Type_Id, Bear_Age, Cave_Id)
VALUES ('Teddy', 1, 1, 2);
INSERT INTO BEAR (Bear_Name, Bear_Type_Id, Bear_Age, Cave_Id)
VALUES ('Pooh', 1, 1, 2);

--Create View to show how many bears per cave
CREATE VIEW VW_BEARS_PER_CAVE (Location, Total) 
AS SELECT Cave_Name, COUNT(Bear_Id) 
FROM CAVE, BEAR
WHERE BEAR.Cave_Id = CAVE.Cave_Id
GROUP BY Cave_Name;

SELECT * FROM VW_BEARS_PER_CAVE;

--fun with functions
CREATE OR REPLACE FUNCTION FIND_MAX_NUMBER(X IN NUMBER, Y IN NUMBER)
  RETURN NUMBER IS Z NUMBER;  
BEGIN
  IF X > Y THEN Z:=X;
  ELSE Z:=Y;
  END IF;
  RETURN Z;
END;
--BEGIN/END blocks are not tied to transactions at all

DECLARE
  FIRST_NUM NUMBER;
  SECOND_NUM NUMBER;
  MAX_NUM NUMBER;
BEGIN
  FIRST_NUM:=22;
  SECOND_NUM:=42;
  MAX_NUM:= FIND_MAX_NUMBER(FIRST_NUM,SECOND_NUM);
  DBMS_OUTPUT.PUT_LINE('MAX: '||MAX_NUM);
END;

--Stored Procedures
CREATE OR REPLACE PROCEDURE HELLO_WORLD_PROCEDURE
IS
BEGIN
  DBMS_OUTPUT.PUT_LINE('HELLO WORLD');
END;
BEGIN
  HELLO_WORLD_PROCEDURE;
END;

--Cursors
CREATE OR REPLACE PROCEDURE GET_ALL_BEARS(S OUT SYS_REFCURSOR)
IS 
BEGIN
  OPEN S FOR
  SELECT BEAR_ID, BEAR_NAME FROM BEAR;
END;

DECLARE
  S SYS_REFCURSOR;
  SOME_ID BEAR.BEAR_ID%TYPE;
  SOME_NAME BEAR.BEAR_NAME%TYPE;
BEGIN
  GET_ALL_BEARS(S);
  LOOP
    FETCH S INTO SOME_ID, SOME_NAME;
    EXIT WHEN S%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(SOME_ID||' IS CURRENT ID, '||SOME_NAME||' IS CURRENT NAME');
  END LOOP;
  CLOSE S;
END;

/*Stored Procedure: SP_FEED_BEAR
IN: BEAR_ID BEEHIVE_ID, HONEY_AMT
CHECK BEAR/HIVE PAIRING VALIDIDTY
DECREASE/INCREASE HIVE_WEIGHT/BEAR_WEIGHT BY HONEY_AMT
DBMS_OUTPUT RESULT*/
CREATE OR REPLACE PROCEDURE SP_FEED_BEAR(
  B_ID IN NUMBER, H_ID IN NUMBER, HONEY_AMT IN NUMBER)
IS
BEGIN
  IF TRUE THEN
    DBMS_OUTPUT.PUT_LINE('VALID PAIRING');
  ELSE
    DBMS_OUTPUT.PUT_LINE('INVALID PAIRING');
  END IF;
  
  UPDATE BEEHIVE SET HIVE_WEIGHT = HIVE_WEIGHT - HONEY_AMT WHERE BEEHIVE_ID = H_ID;
  UPDATE BEAR SET BEAR_WEIGHT = BEAR_WEIGHT + HONEY_AMT WHERE BEAR_ID = B_ID;
  DBMS_OUTPUT.PUT_LINE('FED BEAR '||HONEY_AMT||' POUNDS OF HONEY');
  COMMIT;
  
  EXCEPTION
  WHEN OTHERS THEN
  DBMS_OUTPUT.PUT_LINE('FAILED TO FEED BEAR');
  ROLLBACK;
END;

BEGIN
  SP_FEED_BEAR(1, 1, 5);
END;

--Create sequence and trigger for pk generation on CAVE
CREATE SEQUENCE SQ_CAVE_PK
START WITH 8
INCREMENT BY 3;

CREATE OR REPLACE TRIGGER TR_INSERT_CAVE
BEFORE INSERT ON CAVE
FOR EACH ROW
BEGIN
  SELECT SQ_CAVE_PK.NEXTVAL INTO :NEW.CAVE_ID FROM DUAL;
END;