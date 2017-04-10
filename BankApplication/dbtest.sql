/*CREATE TABLE BANKACCOUNT(
BANK_ACCOUNTID INTEGER PRIMARY KEY,
BANK_ACCOUNT_NAME VARCHAR2 (200),
BALANCE INTEGER,
USER_ID INTEGER);

CREATE TABLE BANKUSER(
USER_ID INTEGER PRIMARY KEY,
USER_NAME VARCHAR2(200),
BANK_PASSWORD VARCHAR2(200));

ALTER TABLE BANKACCOUNT
ADD CONSTRAINT FK_USER_ID
FOREIGN KEY (USER_ID) REFERENCES BANKUSER (USER_ID);

CREATE SEQUENCE SEQ_BANK_PK
START WITH 1
INCREMENT BY 9;

CREATE SEQUENCE SEQ_USER_PK
START WITH 1
INCREMENT BY 4;

CREATE OR REPLACE TRIGGER BANK_TRIGGER
BEFORE INSERT ON BANKACCOUNT
FOR EACH ROW 
BEGIN
  SELECT SEQ_ACCOUNT_PK.NEXTVAL INTO :NEW.BANK_ACCOUNTID FROM DUAL; 
END;

CREATE OR REPLACE TRIGGER USER_TRIGGER
BEFORE INSERT ON BANKUSER
FOR EACH ROW 
BEGIN
  SELECT SEQ_USER_PK.NEXTVAL INTO :NEW.USER_ID FROM DUAL; 
END;

CREATE OR REPLACE PROCEDURE CREATE_USER(USERNAME IN VARCHAR2, PASSWORD IN VARCHAR2)
IS
BEGIN
  INSERT INTO BANKUSER (USER_NAME, BANK_PASSWORD) VALUES (USERNAME, PASSWORD);
END;

*/
CREATE TABLE EMPLOYEE(
EMPLOYEE_ID INTEGER PRIMARY KEY,
EMP_FIRSTNAME VARCHAR2(20),
EMP_LASTNAME VARCHAR2(20),
DEPARTMENT_ID INTEGER,
SALARY INTEGER,
EMP_EMAIL VARCHAR2(20));

CREATE TABLE DEPARTMENT(
DEPARTMENT_ID INTEGER,
DEPARTMENT_NAME VARCHAR2(20));

ALTER TABLE DEPARTMENT
ADD CONSTRAINT PK_DEPT_ID
PRIMARY KEY (DEPARTMENT_ID);

ALTER TABLE EMPLOYEE
ADD CONSTRAINT FK_DEPT_ID
FOREIGN KEY (DEPARTMENT_ID) REFERENCES DEPARTMENT(DEPARTMENT_ID);

CREATE SEQUENCE SEQ_EMPLOYEE_PK
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE SEQ_DEPT_PK
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER EMP_TRIGGER
BEFORE INSERT ON EMPLOYEE
FOR EACH ROW 
BEGIN
  SELECT SEQ_EMPLOYEE_PK.NEXTVAL INTO :NEW.EMPLOYEE_ID FROM DUAL; 
END;

CREATE OR REPLACE TRIGGER DEPT_TRIGGER
BEFORE INSERT ON DEPARTMENT
FOR EACH ROW 
BEGIN
  SELECT SEQ_DEPT_PK.NEXTVAL INTO :NEW.DEPARTMENT_ID FROM DUAL; 
END;

INSERT INTO EMPLOYEE (EMPLOYEE_ID,
EMP_FIRSTNAME,
EMP_LASTNAME,
DEPARTMENT_ID,
SALARY,
EMP_EMAIL)
VALUES 
(1, PABLO, SMITH,2, 100, COMPANY); 
CREATE OR REPLACE PROCEDURE SP_GIVE_RAISE(SALARY IN NUMBER, USERID IN NUMBER, ACCOUNTID IN NUMBER)
IS
BEGIN
  UPDATE EMPLOYEE SET SALARY=(SALARY*.1)+SALARY WHERE EMPLOYEEID=EMPLOYEE.EMPLOYEE_ID;
  DBMS_OUTPUT.PUT_LINE('SALARY IS RAISED TO $'||SALARY||' ON EMPLOYEE ID '||EMPLOYEEID);
END;