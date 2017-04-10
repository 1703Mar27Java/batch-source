/*******************************************************************************
   Drop database if it exists
*******************************************************************************/
DROP USER sqlchallenge CASCADE;

/*******************************************************************************
   Create database
*******************************************************************************/
CREATE USER sqlchallenge
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to sqlchallenge;
GRANT resource to sqlchallenge;
GRANT create session TO sqlchallenge;
GRANT create table TO sqlchallenge;
GRANT create view TO sqlchallenge;

CONNECT sqlchallenge/p4ssw0rd

/*******************************************************************************
   Create Tables
*******************************************************************************/
CREATE TABLE EMPLOYEE
(
    EMPLOYEE_ID NUMBER,
    EMP_FIRSTNAME VARCHAR2(50),
    EMP_LASTNAME VARCHAR2(50),
    DEPARTMENT_ID NUMBER,
    SALARY NUMBER,
    EMP_EMAIL VARCHAR2(50),
    CONSTRAINT PK_EMP PRIMARY KEY (EMPLOYEE_ID)
);

CREATE TABLE DEPARTMENT
(
    DEPARTMENT_ID INTEGER,
    DEPARTMENT_NAME VARCHAR2(50),
    CONSTRAINT PK_DEPARTMENT PRIMARY KEY (DEPARTMENT_ID)
);

/*******************************************************************************
   Create Foreign Keys
*******************************************************************************/
ALTER TABLE EMPLOYEE ADD CONSTRAINT FK_DEPT_ID
    FOREIGN KEY (DEPARTMENT_ID) REFERENCES DEPARTMENT (DEPARTMENT_ID) 
    ON DELETE CASCADE;
    
/*******************************************************************************
   Create Sequences
*******************************************************************************/
CREATE SEQUENCE SQ_EMPLOYEE_PK
START WITH 1
INCREMENT BY 1;
/

CREATE SEQUENCE SQ_DEPARTMENT_PK
START WITH 1
INCREMENT BY 1;
/

/*******************************************************************************
   Create Triggers
*******************************************************************************/
CREATE OR REPLACE TRIGGER TR_INSERT_EMPLOYEE
BEFORE INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
  SELECT SQ_EMPLOYEE_PK.NEXTVAL INTO :NEW.EMPLOYEE_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TR_INSERT_DEPARTMENT
BEFORE INSERT ON DEPARTMENT
FOR EACH ROW
BEGIN
  SELECT SQ_DEPARTMENT_PK.NEXTVAL INTO :NEW.DEPARTMENT_ID FROM DUAL;
END;
/

/*******************************************************************************
   Create Procedures
*******************************************************************************/
CREATE OR REPLACE PROCEDURE SP_GIVE_RAISE(
DEPT_ID IN NUMBER, R_NUM IN NUMBER, AVGSAL OUT NUMBER, VALID_DEPT OUT BOOLEAN)
IS 
BEGIN
  IF TRUE THEN
    VALID_DEPT := 1;
  ELSE
    VALID_DEPT := 0;
  END IF;
  
  UPDATE EMPLOYEE SET DEPARTMENT.SALARY = (SALARY * R_NUM)
  WHERE DEPARTMENT.DEPARTMENT_ID = DEPT_ID;
  SELECT AVG(SALARY) INTO AVGSAL FROM DEPARTMENT WHERE DEPARTMENT.DEPARTMENT_ID = DEPT_ID;
  RETURN AVGSAL;
  RETURN VALID_DEPT;
  COMMIT;
  
  EXCEPTION
  WHEN OTHERS THEN
  ROLLBACK;
END;
/

/*******************************************************************************
   Populate Tables
*******************************************************************************/
INSERT INTO DEPARTMENT(DEPARTMENT_NAME) VALUES('SALES');
INSERT INTO DEPARTMENT(DEPARTMENT_NAME) VALUES('FINANCE');
INSERT INTO DEPARTMENT(DEPARTMENT_NAME) VALUES('MARKETING');
INSERT INTO EMPLOYEE(
EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL) 
VALUES ('GEORGE', 'WASHINGTON', 1, 40000, 'gwash@gmail.com');
INSERT INTO EMPLOYEE(
EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL) 
VALUES ('JOHN', 'ADAMS', 1, 41000, 'gadams@gmail.com');
INSERT INTO EMPLOYEE(
EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL) 
VALUES ('THOMAS', 'JEFFERSON', 2, 42000, 'tjeff@gmail.com');
INSERT INTO EMPLOYEE(
EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL) 
VALUES ('ABRAHAM', 'LINCOLN', 2, 43000, 'alincoln@gmail.com');
INSERT INTO EMPLOYEE(
EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL) 
VALUES ('TEDDY', 'ROOSEVELT', 3, 44000, 'troose@gmail.com');
INSERT INTO EMPLOYEE(
EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL) 
VALUES ('JOHN', 'KENNEDY', 3, 45000, 'jkennedy@gmail.com');

COMMIT;
EXIT;