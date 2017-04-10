--CREATE TABLE STRUCTURE
CREATE TABLE EMPLOYEE(
  EMP_ID          NUMBER NOT NULL,
  EMP_FIRSTNAME   VARCHAR2(100) NOT NULL,
  EMP_LASTNAME    VARCHAR2(100) NOT NULL,
  DEPT_ID         NUMBER NOT NULL,
  SALARY          NUMBER NOT NULL,
  EMP_EMAIL       VARCHAR2(100) NOT NULL,
  CONSTRAINT      PK_EMPLOYEE PRIMARY KEY (EMP_ID)
);

CREATE TABLE DEPARTMENT(
  DEPT_ID         NUMBER NOT NULL,
  DEPT_NAME       VARCHAR2(100) NOT NULL,
  CONSTRAINT      PK_DEPARTMENT PRIMARY KEY  (DEPT_ID)
);

--ADD FK REQUIREMENT
ALTER TABLE EMPLOYEE ADD CONSTRAINT FK_DEPT
  FOREIGN KEY (DEPT_ID) REFERENCES DEPARTMENT (DEPT_ID);
  
--ADD SEQUENCE AND TRIGGER TO TRACK ID'S
CREATE SEQUENCE SQ_DEPT_PK
  START WITH 1
  INCREMENT BY 1;
CREATE SEQUENCE SQ_EMP_PK
  START WITH 1
  INCREMENT BY 1;
  
CREATE OR REPLACE TRIGGER TR_INSERT_DEPT
  BEFORE INSERT ON DEPARTMENT
  FOR EACH ROW
  BEGIN
    SELECT SQ_DEPT_PK.NEXTVAL INTO :NEW.DEPT_ID FROM DUAL;
  END;
CREATE OR REPLACE TRIGGER TR_INSERT_EMP
  BEFORE INSERT ON EMPLOYEE
  FOR EACH ROW
  BEGIN
    SELECT SQ_EMP_PK.NEXTVAL INTO :NEW.EMP_ID FROM DUAL;
  END;
  
--ADD SAMPLE DEPTS AND EMPS
INSERT INTO DEPARTMENT  (DEPT_NAME) VALUES ('Finance');
INSERT INTO DEPARTMENT  (DEPT_NAME) VALUES ('Quality Control');
INSERT INTO DEPARTMENT  (DEPT_NAME) VALUES ('Training');
INSERT INTO EMPLOYEE 
(EMP_FIRSTNAME, EMP_LASTNAME, DEPT_ID, SALARY, EMP_EMAIL)
VALUES
('Rich', 'Wing', 3, 666, 'rich@wing.com');
INSERT INTO EMPLOYEE 
(EMP_FIRSTNAME, EMP_LASTNAME, DEPT_ID, SALARY, EMP_EMAIL)
VALUES
('Fel', 'Sum', 1, 777, 'fel@sum.com');
INSERT INTO EMPLOYEE 
(EMP_FIRSTNAME, EMP_LASTNAME, DEPT_ID, SALARY, EMP_EMAIL)
VALUES
('Emil', 'Higg', 2, 888, 'emil@higg.com');
INSERT INTO EMPLOYEE 
(EMP_FIRSTNAME, EMP_LASTNAME, DEPT_ID, SALARY, EMP_EMAIL)
VALUES
('Luis', 'Niev', 3, 999, 'luis@niev.com');
INSERT INTO EMPLOYEE 
(EMP_FIRSTNAME, EMP_LASTNAME, DEPT_ID, SALARY, EMP_EMAIL)
VALUES
('Amel', 'Hack', 3, 555, 'amel@hack.com');
INSERT INTO EMPLOYEE 
(EMP_FIRSTNAME, EMP_LASTNAME, DEPT_ID, SALARY, EMP_EMAIL)
VALUES
('Jas', 'Rey', 3, 444, 'jas@rey.com');

--ADD REQUIRED SP'S
CREATE OR REPLACE PROCEDURE SP_GIVE_RAISE (DEPART_ID IN NUMBER, RAISE_AMT IN NUMBER, NEW_AVERAGE OUT NUMBER, IS_VALID_DEPT OUT NUMBER, TEXT_OUT OUT VARCHAR)
IS 
CNT NUMBER:=0;
BEGIN
  SAVEPOINT SP;
  SELECT COUNT(DEPT_ID) INTO CNT FROM DEPARTMENT WHERE DEPARTMENT.DEPT_ID=DEPART_ID;
  IF CNT >0 THEN
    UPDATE EMPLOYEE SET SALARY = SALARY*(1+ (RAISE_AMT/100)) WHERE EMPLOYEE.DEPT_ID=DEPART_ID;
    IS_VALID_DEPT:=1;
    SELECT AVG(SALARY) INTO NEW_AVERAGE FROM EMPLOYEE WHERE EMPLOYEE.DEPT_ID=DEPART_ID;
    TEXT_OUT:='Successfully updated employee salaries';
    COMMIT;
  ELSE
    IS_VALID_DEPT:=0;
    TEXT_OUT:='Department does not exist';
  END IF;
  EXCEPTION WHEN OTHERS THEN 
    TEXT_OUT:='Error!';
    ROLLBACK TO SP;
END;



