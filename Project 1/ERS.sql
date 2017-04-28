/*******************************************************************************
   Project 1 - ERS
   Script: project1ers.sql
   Description: Creates and populates the ERS database.
   DB Server: Oracle
   Author: Mehrab Rahman
*******************************************************************************/

/*******************************************************************************
   Drop database if it exists
*******************************************************************************/
DROP USER ersdb CASCADE;

/*******************************************************************************
   Create database
*******************************************************************************/
CREATE USER ersdb
IDENTIFIED BY p4ss
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to ersdb;
GRANT resource to ersdb;
GRANT create session TO ersdb;
GRANT create table TO ersdb;
GRANT create view TO ersdb;

CONNECT ersdb/p4ss

/*******************************************************************************
   Create Tables
*******************************************************************************/
CREATE TABLE ERS_USER_ROLES
(
    UR_ID NUMBER(*,0) NOT NULL,
    UR_ROLE VARCHAR2(40),
    CONSTRAINT ERS_USER_ROLES_PK PRIMARY KEY (UR_ID)
);

CREATE TABLE ERS_USERS
(
    U_ID NUMBER(*,0) NOT NULL,
    U_USERNAME VARCHAR2(40) NOT NULL,
    U_PASSWORD VARCHAR2(40) NOT NULL,
    U_FIRSTNAME VARCHAR2(30),
    U_LASTNAME VARCHAR2(30),
    U_EMAIL VARCHAR2(100),
    UR_ID NUMBER(*,0) NOT NULL,
    CONSTRAINT ERS_USERS_PK PRIMARY KEY (U_ID),
    CONSTRAINT ERS_USERS_U_USERNAME_UN UNIQUE (U_USERNAME),
    CONSTRAINT ERS_USERS_U_EMAIL_UN UNIQUE (U_EMAIL),
    FOREIGN KEY (UR_ID) REFERENCES ERS_USER_ROLES(UR_ID) ON DELETE CASCADE
);

CREATE TABLE ERS_REIMBURSEMENT_TYPE
(
    RT_ID NUMBER(*,0) NOT NULL,
    RT_TYPE VARCHAR2(30) NOT NULL,
    CONSTRAINT ERS_REIMBURSEMENT_TYPE_PK PRIMARY KEY (RT_ID)
);

CREATE TABLE ERS_REIMBURSEMENT_STATUS
(
    RS_ID NUMBER(*,0) NOT NULL,
    RS_STATUS VARCHAR2(30) NOT NULL,
    CONSTRAINT ERS_REIMBURSEMENT_STATUS_PK PRIMARY KEY (RS_ID)
);

CREATE TABLE ERS_REIMBURSEMENTS
(
    R_ID NUMBER(*,0) NOT NULL,
    R_AMOUNT NUMBER(22,2) NOT NULL,
    R_DESCRIPTION VARCHAR2(100),
    R_RECEIPT BLOB,
    R_SUBMITTED TIMESTAMP NOT NULL,
    R_RESOLVED TIMESTAMP,
    U_ID_AUTHOR NUMBER(*,0) NOT NULL,
    U_ID_RESOLVER NUMBER(*,0),
    RT_TYPE NUMBER(*,0) NOT NULL,
    RS_STATUS NUMBER(*,0) NOT NULL,
    CONSTRAINT ERS_REIMBURSEMENTS_PK PRIMARY KEY (R_ID),
    FOREIGN KEY (U_ID_AUTHOR) REFERENCES ERS_USERS(U_ID) ON DELETE CASCADE,
    FOREIGN KEY (U_ID_RESOLVER) REFERENCES ERS_USERS(U_ID) ON DELETE CASCADE,
    FOREIGN KEY (RT_TYPE) REFERENCES ERS_REIMBURSEMENT_TYPE(RT_ID) ON DELETE CASCADE,
    FOREIGN KEY (RS_STATUS) REFERENCES ERS_REIMBURSEMENT_STATUS(RS_ID) ON DELETE CASCADE
);

/*******************************************************************************
   Create Sequences
*******************************************************************************/
CREATE SEQUENCE SQ_ERS_USERS_PK
START WITH 1
INCREMENT BY 1;
/

CREATE SEQUENCE SQ_ERS_REIMBURSEMENTS_PK
START WITH 1
INCREMENT BY 1;
/

/*******************************************************************************
   Create Triggers
*******************************************************************************/
CREATE OR REPLACE TRIGGER TR_INSERT_ERS_USERS
BEFORE INSERT ON ERS_USERS
FOR EACH ROW
BEGIN
  SELECT SQ_ERS_USERS_PK.NEXTVAL INTO :NEW.U_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TR_INSERT_ERS_REIMBURSEMENTS
BEFORE INSERT ON ERS_REIMBURSEMENTS
FOR EACH ROW
BEGIN
  SELECT SQ_ERS_REIMBURSEMENTS_PK.NEXTVAL INTO :NEW.R_ID FROM DUAL;
END;
/

/*******************************************************************************
   Create Procedures
*******************************************************************************/
CREATE OR REPLACE PROCEDURE SP_ERS_SUBMIT (AMOUNT IN NUMBER, DESCRIPTION IN VARCHAR, USERID IN NUMBER, R_TYPE IN NUMBER)
IS
  ID_STATUS NUMBER;
BEGIN
  SELECT RS_ID INTO ID_STATUS FROM ERS_REIMBURSEMENT_STATUS WHERE RS_STATUS = 'Pending' ;
  INSERT INTO ERS_REIMBURSEMENTS (R_AMOUNT, R_DESCRIPTION, R_SUBMITTED, U_ID_AUTHOR, RT_TYPE, RS_STATUS) VALUES (AMOUNT, DESCRIPTION, LOCALTIMESTAMP, USERID, R_TYPE, ID_STATUS);
END;
/

CREATE OR REPLACE PROCEDURE SP_ERS_RESOLVE (
REIMB_ID IN NUMBER, STATUS_ID IN NUMBER, RESOLVERID IN NUMBER)
IS 
BEGIN
  UPDATE ERS_REIMBURSEMENTS SET RS_STATUS = STATUS_ID, R_RESOLVED = LOCALTIMESTAMP, U_ID_RESOLVER = RESOLVERID WHERE ERS_REIMBURSEMENTS.R_ID = REIMB_ID;
END;
/

/*******************************************************************************
   Populate Tables
*******************************************************************************/
INSERT INTO ERS_USER_ROLES VALUES(1, 'Manager');
INSERT INTO ERS_USER_ROLES VALUES(2, 'Employee');
INSERT INTO ERS_REIMBURSEMENT_STATUS VALUES(1, 'Pending');
INSERT INTO ERS_REIMBURSEMENT_STATUS VALUES(2, 'Approved');
INSERT INTO ERS_REIMBURSEMENT_STATUS VALUES(3, 'Denied');
INSERT INTO ERS_REIMBURSEMENT_TYPE VALUES(1, 'Tools');
INSERT INTO ERS_REIMBURSEMENT_TYPE VALUES(2, 'Training');
INSERT INTO ERS_REIMBURSEMENT_TYPE VALUES(3, 'Travel');
INSERT INTO ERS_USERS (U_USERNAME, U_PASSWORD, U_FIRSTNAME, U_LASTNAME, U_EMAIL, UR_ID)
  VALUES ('mehrab', 'p4ss', 'Mehrab', 'Rahman', 'mehrabmrahman@gmail.com', 1);
INSERT INTO ERS_USERS (U_USERNAME, U_PASSWORD, U_FIRSTNAME, U_LASTNAME, U_EMAIL, UR_ID)
  VALUES ('emp1', 'p4ssw0rd', 'John', 'Smith', 'johnsmith@gmail.com', 2);
  
COMMIT;