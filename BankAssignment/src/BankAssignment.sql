/*******************************************************************************
   Bank Assignment
   Script: BankAssignment.sql
   Description: Creates and populates the BankAssignment database.
   DB Server: Oracle
   Author: Mehrab Rahman
   
   Assignment: Bank Assignment

    Console application: 
    
    A registered user can login with their username and password 
    An unregistered user can register by creating a username and password 
    A superuser can view, create, update, and delete all users.
    
    A user can view their own existing accounts and balances. 
    A user can create an account.
    A user can delete an account if it is empty.  
    A user can add to or withdraw from an account. 
    A user can execute multiple deposits or withrawals in a session. 
    A user can logout. 
    
    Use sequences to generate USER_ID and BANK_ACCOUNT_ID. 
    Use at least one stored procedure with IN and OUT parameters. 
    Throw custom exceptions in the event of user error 
        (overdraft, incorrect password, etc). 
    Provide validation messages through the console for all user actions. 
    Use the DAO design pattern. 
    Store superuser username/password and database connection information 
        in a properties file. 
    
    Required technologies: 
    PL/SQL with at least one stored procedure, JDBC with prepared and 
        callable statements,
    Scanner for user input, JUnit tests on as much of the program as possible.  
    
    Bonus: 
    A user's transactions are recorded.
    A user may view transaction history. 
*******************************************************************************/

/*******************************************************************************
   Drop database if it exists
*******************************************************************************/
DROP USER banker CASCADE;

/*******************************************************************************
   Create database
*******************************************************************************/
CREATE USER banker
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to banker;
GRANT resource to banker;
GRANT create session TO banker;
GRANT create table TO banker;
GRANT create view TO banker;

CONNECT banker/p4ssw0rd

/*******************************************************************************
   Create Tables
*******************************************************************************/
CREATE TABLE USERS
(
    USER_ID INTEGER,
    USER_NAME VARCHAR2(50),
    PASSWORD VARCHAR2(50),
    CONSTRAINT PK_USER PRIMARY KEY (USER_ID),
    CONSTRAINT UQ_USER_NAME UNIQUE (USER_NAME)
);

CREATE TABLE BANK_ACCOUNT
(
    BANK_ACCOUNT_ID INTEGER,
    USER_ID INTEGER,
    BANK_ACCOUNT_NAME VARCHAR2(50),
    BALANCE INTEGER,
    CONSTRAINT PK_BANK_ACCOUNT PRIMARY KEY (BANK_ACCOUNT_ID)
);

/*******************************************************************************
   Create Foreign Keys
*******************************************************************************/
ALTER TABLE BANK_ACCOUNT ADD CONSTRAINT FK_USER_ID
    FOREIGN KEY (USER_ID) REFERENCES USERS (USER_ID) ON DELETE CASCADE;
    
/*******************************************************************************
   Create Sequences
*******************************************************************************/
CREATE SEQUENCE SQ_USER_PK
START WITH 1
INCREMENT BY 1;
/

CREATE SEQUENCE SQ_BANK_ACCOUNT_PK
START WITH 1
INCREMENT BY 1;
/

/*******************************************************************************
   Create Triggers
*******************************************************************************/
CREATE OR REPLACE TRIGGER TR_INSERT_USER
BEFORE INSERT ON USERS
FOR EACH ROW
BEGIN
  SELECT SQ_USER_PK.NEXTVAL INTO :NEW.USER_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TR_INSERT_BANK_ACCOUNT
BEFORE INSERT ON BANK_ACCOUNT
FOR EACH ROW
BEGIN
  SELECT SQ_BANK_ACCOUNT_PK.NEXTVAL INTO :NEW.BANK_ACCOUNT_ID FROM DUAL;
END;
/

/*******************************************************************************
   Create Procedures
*******************************************************************************/
CREATE OR REPLACE PROCEDURE SP_READ_ACCOUNTS(U_ID IN NUMBER, S OUT SYS_REFCURSOR)
IS 
BEGIN
  OPEN S FOR
  SELECT * 
  FROM BANK_ACCOUNT 
  WHERE USER_ID = U_ID;
END;
/

/*******************************************************************************
   Populate Tables
*******************************************************************************/
INSERT INTO USERS VALUES (1, 'SYSTEM', 'admin');

COMMIT;
EXIT;