/*******************************************************************************
   BankDB
   Script: BankDB.sql
   Description: Creates and populates a bank database.
   DB Server: Oracle
   Author: Mehrab Rahman
*******************************************************************************/

/*******************************************************************************
   Drop database if it exists
*******************************************************************************/
DROP USER BankDB CASCADE;

/*******************************************************************************
   Create database
*******************************************************************************/
CREATE USER BankDB
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to BankDB;
GRANT resource to BankDB;
GRANT create session TO BankDB;
GRANT create table TO BankDB;
GRANT create view TO BankDB;

CONNECT BankDB/p4ssw0rd

/*******************************************************************************
   Create Tables
*******************************************************************************/
CREATE TABLE BANK_USER
(
    BANK_USER_ID NUMBER(*,0) NOT NULL,
    BANK_USER_NAME VARCHAR2(25),
    BANK_USER_PASSWORD VARCHAR2(25),
    CONSTRAINT PK_BANK_USER PRIMARY KEY (BANK_USER_ID),
    CONSTRAINT UQ_BANK_USER_NAME UNIQUE (BANK_USER_NAME)
);

CREATE TABLE BANK_ACCOUNT
(
    BANK_ACCOUNT_ID NUMBER(*,0) NOT NULL,
    BANK_USER_ID NUMBER(*,0) NOT NULL,
    BANK_ACCOUNT_NAME VARCHAR2(25),
    BANK_ACCOUNT_BALANCE NUMBER(*,2) DEFAULT 0.00,
    CONSTRAINT PK_BANK_ACCOUNT PRIMARY KEY (BANK_ACCOUNT_ID),
    FOREIGN KEY (BANK_USER_ID) 
      REFERENCES BANK_USER(BANK_USER_ID) ON DELETE CASCADE
);

CREATE TABLE BANK_TRANSACTION
(
  BANK_TRANSACTION_ID NUMBER(*,0) NOT NULL, 
  BANK_USER_ID NUMBER(*,0) NOT NULL,  
  BANK_TRANSACTION_DESC VARCHAR2(100),
  CONSTRAINT PK_ACCOUNT_TRANSACTION PRIMARY KEY (BANK_TRANSACTION_ID),
  FOREIGN KEY (BANK_USER_ID) 
    REFERENCES BANK_USER(BANK_USER_ID) ON DELETE CASCADE
);
    
/*******************************************************************************
   Create Sequences
*******************************************************************************/
CREATE SEQUENCE SQ_BANK_USER_PK
START WITH 1
INCREMENT BY 1;
/

CREATE SEQUENCE SQ_BANK_ACCOUNT_PK
START WITH 1
INCREMENT BY 1;
/

CREATE SEQUENCE SQ_BANK_TRANSACTION_PK
START WITH 1
INCREMENT BY 1;
/

/*******************************************************************************
   Create Triggers
*******************************************************************************/
CREATE OR REPLACE TRIGGER TR_INSERT_BANK_USER
BEFORE INSERT ON BANK_USER
FOR EACH ROW
BEGIN
  SELECT SQ_BANK_USER_PK.NEXTVAL INTO :NEW.BANK_USER_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TR_INSERT_BANK_ACCOUNT
BEFORE INSERT ON BANK_ACCOUNT
FOR EACH ROW
BEGIN
  SELECT SQ_BANK_ACCOUNT_PK.NEXTVAL INTO :NEW.BANK_ACCOUNT_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TR_INSERT_BANK_TRANSACTION
BEFORE INSERT ON BANK_TRANSACTION
FOR EACH ROW
BEGIN
  SELECT SQ_BANK_TRANSACTION_PK.NEXTVAL INTO :NEW.BANK_TRANSACTION_ID FROM DUAL;
END;
/

/*******************************************************************************
   Create Procedures
*******************************************************************************/
CREATE OR REPLACE PROCEDURE SP_ACCOUNT_CREATE (
U_ID IN NUMBER, B_NAME IN VARCHAR2)
IS
  B_ID NUMBER;
BEGIN
  INSERT INTO BANK_ACCOUNT (BANK_USER_ID, BANK_ACCOUNT_NAME)
  VALUES (U_ID, B_NAME);
  
  SELECT BANK_ACCOUNT_ID INTO B_ID FROM BANK_ACCOUNT 
  WHERE BANK_USER_ID=U_ID AND BANK_ACCOUNT_NAME=B_NAME;
  
  INSERT INTO BANK_TRANSACTION (BANK_USER_ID, BANK_TRANSACTION_DESC) 
  VALUES (U_ID, LOCALTIMESTAMP||' CREATED ACCOUNT '||B_ID);
  
  DBMS_OUTPUT.PUT_LINE('CREATED ACCOUNT '||B_ID);
END;
/

CREATE OR REPLACE PROCEDURE SP_ACCOUNT_TRANSACTION (
B_ID IN NUMBER, U_ID IN NUMBER, AMOUNT IN NUMBER) 
IS
BEGIN
  UPDATE BANK_ACCOUNT SET BANK_ACCOUNT_BALANCE = BANK_ACCOUNT_BALANCE + AMOUNT
  WHERE BANK_USER_ID = U_ID AND BANK_ACCOUNT_ID = B_ID;
  
  INSERT INTO BANK_TRANSACTION (BANK_USER_ID, BANK_TRANSACTION_DESC) 
  VALUES (U_ID, LOCALTIMESTAMP||', AMOUNT $'||AMOUNT||', ACCOUNT '||B_ID);
  
  DBMS_OUTPUT.PUT_LINE('UPDATED ACCOUNT '||B_ID||' WITH $'||AMOUNT);
END;
/

CREATE OR REPLACE PROCEDURE SP_ACCOUNT_DELETE (
B_ID IN NUMBER, U_ID IN NUMBER)
IS
BEGIN
  DELETE FROM BANK_ACCOUNT WHERE BANK_USER_ID = U_ID AND BANK_ACCOUNT_ID = B_ID;
  
  INSERT INTO BANK_TRANSACTION (BANK_USER_ID, BANK_TRANSACTION_DESC) 
  VALUES (U_ID, LOCALTIMESTAMP||' DELETED ACCOUNT '||B_ID);
  
  DBMS_OUTPUT.PUT_LINE('DELETED ACCOUNT '||B_ID);
END;
/

/*******************************************************************************
   Populate Tables
*******************************************************************************/
INSERT INTO BANK_USER(BANK_USER_NAME, BANK_USER_PASSWORD) VALUES ('admin', 'p4ssw0rd');
INSERT INTO BANK_USER(BANK_USER_NAME, BANK_USER_PASSWORD) VALUES ('mehrab', 'p4ss');
INSERT INTO BANK_ACCOUNT(BANK_USER_ID, BANK_ACCOUNT_NAME,BANK_ACCOUNT_BALANCE) VALUES (2, 'savings', 100);
INSERT INTO BANK_TRANSACTION(BANK_USER_ID, BANK_TRANSACTION_DESC) VALUES (2, 'test');

COMMIT;
EXIT;