/*
db |  gui
---|------     
 X |     | -An Employee can login
N/A|     | -An Employee can view the Employee Homepage
N/A|     | -An Employee can logout
 X |     | -An Employee can submit a reimbursement request
   |     | -An Employee can upload an image of his/her receipt as part of the reimbursement request
 X |     | -An Employee can view their pending reimbursement requests
 X |     | -An Employee can view their resolved reimbursement requests
 X |     | -An Employee can view their information
   |     | -An Employee can update their information
   |     | -An Employee receives an email when one of their reimbursement requests is resolved (optional)
   |     | 
 X |     | -A Manager can login
N/A|     | -A Manager can view the Manager Homepage
N/A|     | -A Manager can logout
   |     | -A Manager can approve/deny pending reimbursement requests
 X |     | -A Manager can view all pending requests from all employees
   |     | -A Manager can view images of the receipts from reimbursement requests
 X |     | -A Manager can view all resolved requests from all employees and see which manager resolved it
 X |     | -A Manager can view all Employees
 X |     | -A Manager can view reimbursement requests from a single Employee
   |     | 
---|--------------------------------------------------------------
 X |     | -A Manager can register an Employee, which sends the Employee an email with their username and temp password (optional)
 X |     | -An Employee can reset their password (Optional - tied with above functional requirement)
*/





/*******************************************************
*                Create Table Structure                *
*******************************************************/

CREATE TABLE ERS_REIMBURSEMENTS(
  R_ID          NUMBER NOT NULL,
  R_AMOUNT      NUMBER NOT NULL, 
  R_DESCR       VARCHAR2(100),
  R_RECEIPT     BLOB, 
  R_SUBMITTED   TIMESTAMP NOT NULL,
  R_RESOLVED    TIMESTAMP, 
  U_ID_AUTHOR   NUMBER NOT NULL,
  U_ID_RESOLVER NUMBER,
  RT_TYPE       NUMBER NOT NULL,
  RS_STATUS     NUMBER NOT NULL,
  CONSTRAINT    PK_ERS_REIMBURSEMENTS PRIMARY KEY  (R_ID)
);
CREATE TABLE ERS_REIMBURSEMENT_STATUS(
  RS_ID         NUMBER NOT NULL,
  RS_STATUS     VARCHAR2(30) NOT NULL,
  CONSTRAINT    PK_ERS_REIMBURSEMENT_STATUS PRIMARY KEY (RS_ID)
);
CREATE TABLE ERS_REIMBURSEMENT_TYPE (
  RT_ID         NUMBER NOT NULL,
  RT_TYPE       VARCHAR2(30) NOT NULL,
  CONSTRAINT    PK_ERS_REIMBURSEMENT_TYPE PRIMARY KEY (RT_ID)
);
CREATE TABLE ERS_USER_ROLES(
  UR_ID         NUMBER NOT NULL,
  UR_ROLE       VARCHAR2(40),
  CONSTRAINT    PK_ERS_USER_ROLES PRIMARY KEY (UR_ID)
);
CREATE TABLE ERS_USERS(
  U_ID          NUMBER NOT NULL,
  U_USERNAME    VARCHAR2(40) UNIQUE NOT NULL,
  U_PASSWORD    VARCHAR2(40) NOT NULL,
  U_FIRSTNAME   VARCHAR2(30),
  U_LASTNAME    VARCHAR2(30),
  U_EMAIL       VARCHAR2(100) UNIQUE,
  UR_ID         NUMBER NOT NULL,
  CONSTRAINT PK_ERS_USERS PRIMARY KEY (U_ID)
);


/*******************************************************
*                Create Constraint Reqs                *
*******************************************************/

ALTER TABLE ERS_REIMBURSEMENTS ADD CONSTRAINT FK_ERS_REIMBURSEMENTS_AUTHOR
  FOREIGN KEY (U_ID_AUTHOR) REFERENCES ERS_USERS (U_ID);
ALTER TABLE ERS_REIMBURSEMENTS ADD CONSTRAINT FK_ERS_REIMBURSEMENTS_RESOLV
  FOREIGN KEY (U_ID_RESOLVER) REFERENCES ERS_USERS (U_ID);
ALTER TABLE ERS_REIMBURSEMENTS ADD CONSTRAINT FK_ERS_REIMBURSEMENTS_TYPE
  FOREIGN KEY (RT_TYPE) REFERENCES ERS_REIMBURSEMENT_TYPE (RT_ID);
ALTER TABLE ERS_REIMBURSEMENTS ADD CONSTRAINT FK_ERS_REIMBURSEMENTS_STATUS
  FOREIGN KEY (RS_STATUS) REFERENCES ERS_REIMBURSEMENT_STATUS (RS_ID);
ALTER TABLE ERS_USERS ADD CONSTRAINT FK_ERS_USERS_ROLE_ID
  FOREIGN KEY (UR_ID) REFERENCES ERS_USER_ROLES (UR_ID);
  
  
/*******************************************************
*                  Create Sequences                    *
*******************************************************/

CREATE SEQUENCE SQ_ERS_REIMBURSEMENTS_PK
  START WITH 1
  INCREMENT BY 1;
CREATE SEQUENCE SQ_ERS_REIMBURSEMENTS_STAT_PK
  START WITH 1
  INCREMENT BY 1;
CREATE SEQUENCE SQ_ERS_REIMBURSEMENTS_TYPE_PK
  START WITH 1
  INCREMENT BY 1;
CREATE SEQUENCE SQ_ERS_USER_ROLES_PK
  START WITH 1
  INCREMENT BY 1;
CREATE SEQUENCE SQ_ERS_USERS_PK
  START WITH 1
  INCREMENT BY 1;
  
  
/*******************************************************
*                   Create Triggers                    *
*******************************************************/

CREATE OR REPLACE TRIGGER TR_INSERT_ERS_REIMBURS
  BEFORE INSERT ON ERS_REIMBURSEMENTS
  FOR EACH ROW
  BEGIN
    SELECT SQ_ERS_REIMBURSEMENTS_PK.NEXTVAL INTO :NEW.R_ID FROM DUAL;
  END;
CREATE OR REPLACE TRIGGER TR_INSERT_ERS_REIMBURS_TYPE
  BEFORE INSERT ON ERS_REIMBURSEMENT_TYPE
  FOR EACH ROW
  BEGIN
    SELECT SQ_ERS_REIMBURSEMENTS_TYPE_PK.NEXTVAL INTO :NEW.RT_ID FROM DUAL;
  END;
CREATE OR REPLACE TRIGGER TR_INSERT_ERS_REIMBURS_STAT
  BEFORE INSERT ON ERS_REIMBURSEMENT_STATUS
  FOR EACH ROW
  BEGIN
    SELECT SQ_ERS_REIMBURSEMENTS_STAT_PK.NEXTVAL INTO :NEW.RS_ID FROM DUAL;
  END;
CREATE OR REPLACE TRIGGER TR_INSERT_ERS_USER_ROLES
  BEFORE INSERT ON ERS_USER_ROLES
  FOR EACH ROW
  BEGIN
    SELECT SQ_ERS_USER_ROLES_PK.NEXTVAL INTO :NEW.UR_ID FROM DUAL;
  END;
CREATE OR REPLACE TRIGGER TR_INSERT_ERS_USERS
  BEFORE INSERT ON ERS_USERS
  FOR EACH ROW
  BEGIN
    SELECT SQ_ERS_USERS_PK.NEXTVAL INTO :NEW.U_ID FROM DUAL;
  END;


/*******************************************************
*               Add Sample Table Data                  *
*******************************************************/

INSERT INTO ERS_USER_ROLES (UR_ROLE) VALUES ('Employee');
INSERT INTO ERS_USER_ROLES (UR_ROLE) VALUES ('Manager');
INSERT INTO ERS_USER_ROLES (UR_ROLE) VALUES ('Admin');
INSERT INTO ERS_REIMBURSEMENT_STATUS (RS_STATUS) VALUES ('Approved');
INSERT INTO ERS_REIMBURSEMENT_STATUS (RS_STATUS) VALUES ('Denied');
INSERT INTO ERS_REIMBURSEMENT_STATUS (RS_STATUS) VALUES ('Pending');
INSERT INTO ERS_REIMBURSEMENT_TYPE (RT_TYPE) VALUES ('Travel');
INSERT INTO ERS_REIMBURSEMENT_TYPE (RT_TYPE) VALUES ('Education');
INSERT INTO ERS_REIMBURSEMENT_TYPE (RT_TYPE) VALUES ('Certification');
INSERT INTO ERS_REIMBURSEMENT_TYPE (RT_TYPE) VALUES ('Equipment');
INSERT INTO ERS_REIMBURSEMENT_TYPE (RT_TYPE) VALUES ('Miscellaneous');
INSERT INTO ERS_USERS (U_USERNAME, U_PASSWORD, U_FIRSTNAME, U_LASTNAME, U_EMAIL, UR_ID)
VALUES                ('rich', 'wing', 'Richard', 'Wingert', 'rich@wing.com', 21);
INSERT INTO ERS_USERS (U_USERNAME, U_PASSWORD, U_FIRSTNAME, U_LASTNAME, U_EMAIL, UR_ID)
VALUES                ('cait', 'buck', 'Caitlin', 'Buckner', 'cait@buck.com', 21);
INSERT INTO ERS_USERS (U_USERNAME, U_PASSWORD, U_FIRSTNAME, U_LASTNAME, U_EMAIL, UR_ID)
VALUES                ('emil', 'higg', 'Emily', 'Higgens', 'emil@higg.com', 22);
INSERT INTO ERS_USERS (U_USERNAME, U_PASSWORD, U_FIRSTNAME, U_LASTNAME, U_EMAIL, UR_ID)
VALUES                ('stev', 'kels', 'Steven', 'Kelsey', 'steve@kels.com', 23);



/*******************************************************
*       Add views to make data more readable           *
*******************************************************/

--VIEW ALL USERS
--A Manager can view all Employees (WHERE UR_ROLE)
--An Employee can view their information (WHERE U_USERNAME)
CREATE OR REPLACE VIEW VW_ERS_USERS AS
  SELECT 
    ERS_USERS.U_USERNAME AS USER_NAME, 
    ERS_USERS.U_FIRSTNAME AS FIRST_NAME, 
    ERS_USERS.U_LASTNAME AS LAST_NAME, 
    ERS_USERS.U_EMAIL AS EMAIL, 
    ERS_USER_ROLES.UR_ROLE AS JOB_TITLE
  FROM ERS_USER_ROLES 
  JOIN ERS_USERS ON ERS_USER_ROLES.UR_ID=ERS_USERS.UR_ID;
  
--VIEW ALL REIMBURSMENTS
--An Employee can view their resolved reimbursement requests (WHERE U_USERNAME AND RS_STATUS)
--A Manager can view reimbursement requests from a single Employee (WHERE U_USERNAME)
CREATE OR REPLACE VIEW VW_ERS_REIMBURSEMENTS AS
  SELECT 
    ERS_REIMBURSEMENTS.R_ID, 
    ERS_REIMBURSEMENTS.R_DESCR AS DESCRIPTION, 
    ERS_REIMBURSEMENTS.R_SUBMITTED AS TIME_SUBMITTED,
    ERS_REIMBURSEMENTS.R_RESOLVED AS TIME_RESOLVED,
    ERS_REIMBURSEMENTS.R_AMOUNT AS AMOUNT, 
    ERS_REIMBURSEMENT_TYPE.RT_TYPE AS R_TYPE, 
    ERS_REIMBURSEMENT_STATUS.RS_STATUS AS R_STATUS, 
    ERS_USERS.U_USERNAME AS USERNAME,
    ERS_USERS.U_FIRSTNAME AS FIRST_NAME,
    ERS_USERS.U_LASTNAME AS LAST_NAME
  FROM ERS_REIMBURSEMENTS 
  INNER JOIN ERS_USERS ON ERS_USERS.U_ID=ERS_REIMBURSEMENTS.U_ID_AUTHOR
  INNER JOIN ERS_REIMBURSEMENT_STATUS ON ERS_REIMBURSEMENT_STATUS.RS_ID=ERS_REIMBURSEMENTS.RS_STATUS
  INNER JOIN ERS_REIMBURSEMENT_TYPE ON ERS_REIMBURSEMENT_TYPE.RT_ID=ERS_REIMBURSEMENTS.RT_TYPE;
  
--An Employee can view their pending reimbursement requests (WHERE U_ID)
--A Manager can view all pending requests from all employees
CREATE OR REPLACE VIEW VW_ERS_ALL_PEND_REIMBURSE AS
  SELECT
    ERS_REIMBURSEMENTS.R_ID, 
    ERS_REIMBURSEMENTS.R_DESCR AS DESCRIPTION,
    ERS_REIMBURSEMENTS.R_RECEIPT AS RECEIPT,
    ERS_REIMBURSEMENTS.R_SUBMITTED AS TIME_SUBMITTED,
    ERS_REIMBURSEMENTS.R_RESOLVED AS TIME_RESOLVED,
    ERS_REIMBURSEMENTS.R_AMOUNT AS AMOUNT, 
    ERS_REIMBURSEMENT_TYPE.RT_TYPE AS R_TYPE, 
    ERS_REIMBURSEMENT_STATUS.RS_STATUS AS R_STATUS, 
    ERS_USERS.U_USERNAME AS USERNAME,
    ERS_USERS.U_FIRSTNAME AS FIRST_NAME,
    ERS_USERS.U_LASTNAME AS LAST_NAME
    FROM ERS_REIMBURSEMENTS 
  INNER JOIN ERS_USERS ON ERS_USERS.U_ID=ERS_REIMBURSEMENTS.U_ID_AUTHOR
  INNER JOIN ERS_REIMBURSEMENT_STATUS ON ERS_REIMBURSEMENT_STATUS.RS_ID=ERS_REIMBURSEMENTS.RS_STATUS
  INNER JOIN ERS_REIMBURSEMENT_TYPE ON ERS_REIMBURSEMENT_TYPE.RT_ID=ERS_REIMBURSEMENTS.RT_TYPE
  WHERE ERS_REIMBURSEMENTS.RS_STATUS=(SELECT RS_ID FROM ERS_REIMBURSEMENT_STATUS WHERE RS_STATUS='Pending');
  
--A Manager can view all resolved requests from all employees and see which manager resolved it
--(did this separately because of the need to add the additional where clause and other changes)
CREATE OR REPLACE VIEW VW_ERS_ALL_RESOLVED_REIMBURSE AS
  SELECT
    REIMBUR.R_ID, 
    REIMBUR.R_DESCR AS DESCRIPTION,
    REIMBUR.R_RECEIPT AS RECEIPT,
    REIMBUR.R_SUBMITTED AS TIME_SUBMITTED,
    REIMBUR.R_RESOLVED AS TIME_RESOLVED,
    USERS_B.U_USERNAME AS RESOLVED_BY,
    REIMBUR.R_AMOUNT AS AMOUNT, 
    ERS_REIMBURSEMENT_TYPE.RT_TYPE AS R_TYPE, 
    ERS_REIMBURSEMENT_STATUS.RS_STATUS AS R_STATUS, 
    USERS_A.U_USERNAME AS USERNAME,
    USERS_A.U_FIRSTNAME AS FIRST_NAME,
    USERS_A.U_LASTNAME AS LAST_NAME
    FROM ERS_REIMBURSEMENTS REIMBUR
  INNER JOIN ERS_USERS USERS_A ON USERS_A.U_ID=REIMBUR.U_ID_AUTHOR
  LEFT JOIN ERS_USERS USERS_B ON USERS_B.U_ID=REIMBUR.U_ID_RESOLVER
  INNER JOIN ERS_REIMBURSEMENT_STATUS ON ERS_REIMBURSEMENT_STATUS.RS_ID=REIMBUR.RS_STATUS
  INNER JOIN ERS_REIMBURSEMENT_TYPE ON ERS_REIMBURSEMENT_TYPE.RT_ID=REIMBUR.RT_TYPE
  WHERE REIMBUR.RS_STATUS=(SELECT RS_ID FROM ERS_REIMBURSEMENT_STATUS WHERE RS_STATUS='Denied')
  OR REIMBUR.RS_STATUS=(SELECT RS_ID FROM ERS_REIMBURSEMENT_STATUS WHERE RS_STATUS='Approved');


/*******************************************************
*               Various Stored Procedures              *
*******************************************************/

--SP FOR ADDING REIMBURSEMENTS W/O DESCR
CREATE OR REPLACE PROCEDURE ERS_SP_CREATE_REIMBURSEMENT (AMOUNT IN NUMBER, U_USER IN VARCHAR, RTYPE IN VARCHAR, TEXT_OUT OUT VARCHAR)
IS
  CURR_TIME TIMESTAMP:=CURRENT_TIMESTAMP;
  ID_OF_AUTHOR NUMBER;
  ID_OF_TYPE NUMBER;
  ID_OF_STATUS NUMBER;
  TYPE_OF_REIMBURSE VARCHAR2(50);
BEGIN
  SAVEPOINT SP;
  SELECT U_ID INTO ID_OF_AUTHOR FROM ERS_USERS WHERE U_USER=U_USERNAME;
  SELECT RT_ID INTO ID_OF_TYPE FROM ERS_REIMBURSEMENT_TYPE WHERE RTYPE=RT_TYPE;
  SELECT RS_ID INTO ID_OF_STATUS FROM ERS_REIMBURSEMENT_STATUS WHERE RS_STATUS='Pending'; 
  INSERT INTO ERS_REIMBURSEMENTS (R_AMOUNT, R_SUBMITTED, U_ID_AUTHOR, RT_TYPE, RS_STATUS )
                          VALUES (AMOUNT, CURR_TIME, ID_OF_AUTHOR, ID_OF_TYPE, ID_OF_STATUS);
  TEXT_OUT:='SUCCESSFULLY CREATED REIMBURSEMENT ENTRY.';
  COMMIT;
  --EXCEPTION HANDLING
  EXCEPTION WHEN NO_DATA_FOUND THEN
    TEXT_OUT:='NO DATA FOUND!';
    ROLLBACK TO SP;
  WHEN OTHERS THEN
    TEXT_OUT:='ERROR!';
    ROLLBACK TO SP;
END;



--SIMILAR TO ABOVE SP, EXCEPT ALSO INCLUDES THE DESCRIPTION FIELD
CREATE OR REPLACE PROCEDURE ERS_SP_CREATE_REIMBUR_DESCR (DESCRIP IN VARCHAR, AMOUNT IN NUMBER, U_USER IN VARCHAR, RTYPE IN VARCHAR, TEXT_OUT OUT VARCHAR)
IS
  CURR_TIME TIMESTAMP:=CURRENT_TIMESTAMP;
  ID_OF_AUTHOR NUMBER;
  ID_OF_TYPE NUMBER;
  ID_OF_STATUS NUMBER;
  TYPE_OF_REIMBURSE VARCHAR2(50);
BEGIN
  SAVEPOINT SP;
  SELECT U_ID INTO ID_OF_AUTHOR FROM ERS_USERS WHERE U_USER=U_USERNAME;
  SELECT RT_ID INTO ID_OF_TYPE FROM ERS_REIMBURSEMENT_TYPE WHERE RTYPE=RT_TYPE;
  SELECT RS_ID INTO ID_OF_STATUS FROM ERS_REIMBURSEMENT_STATUS WHERE RS_STATUS='Pending'; 
  INSERT INTO ERS_REIMBURSEMENTS (R_AMOUNT,R_DESCR, R_SUBMITTED, U_ID_AUTHOR, RT_TYPE, RS_STATUS )
                          VALUES (AMOUNT, DESCRIP, CURR_TIME, ID_OF_AUTHOR, ID_OF_TYPE, ID_OF_STATUS);
  TEXT_OUT:='SUCCESSFULLY CREATED REIMBURSEMENT ENTRY.';
  COMMIT;
  --EXCEPTION HANDLING
  EXCEPTION WHEN NO_DATA_FOUND THEN
    TEXT_OUT:='ENTERED DATA WAS NOT FOUND!';
    ROLLBACK TO SP;
  WHEN OTHERS THEN
    TEXT_OUT:='ERROR!';
    ROLLBACK TO SP;
END;
  
--SP TO VALIDATE A USER'S INFO FOR LOGIN PURPOSES
CREATE OR REPLACE PROCEDURE SP_ERS_VALIDATE_USER(U_NAME VARCHAR, U_PASS VARCHAR, IS_VALID OUT NUMBER, TEXT_OUT OUT VARCHAR) 
IS 
BEGIN
  SELECT COUNT(U_USERNAME) INTO IS_VALID FROM ERS_USERS
    WHERE U_USERNAME=U_NAME AND U_PASSWORD=U_PASS;
  IF IS_VALID=0 THEN
    TEXT_OUT:='Username/Password combination is incorrect.';
  ELSE 
    TEXT_OUT:='Username/Password combination is correct.';
  END IF;
END;

--SP TO CREATE A USER
CREATE OR REPLACE PROCEDURE SP_ERS_CREATE_USER 
  (U_NAME IN VARCHAR, U_PASS IN VARCHAR, U_FIRST IN VARCHAR, U_LAST IN VARCHAR, EMAIL IN VARCHAR, U_ROLE IN VARCHAR, IS_VALID OUT NUMBER)
IS
  ROLE_ID NUMBER;
BEGIN
  SAVEPOINT SP;
  SELECT UR_ID INTO ROLE_ID FROM ERS_USER_ROLES WHERE UR_ROLE=U_ROLE;
  INSERT INTO ERS_USERS (U_USERNAME, U_PASSWORD, U_FIRSTNAME, U_LASTNAME, U_EMAIL, UR_ID)
                 VALUES (U_NAME, U_PASS, U_FIRST, U_LAST, EMAIL, ROLE_ID);
  COMMIT;
  IS_VALID:=1;
  EXCEPTION WHEN OTHERS THEN 
    IS_VALID:=0;
    ROLLBACK TO SP;
END;

--SP TO RESET A USER'S PASSWORD
CREATE OR REPLACE PROCEDURE SP_ERS_RESET_PASS(U_NAME IN VARCHAR)
IS
BEGIN
  SAVEPOINT SP;
  UPDATE ERS_USERS SET U_PASSWORD='password' WHERE U_USERNAME=U_NAME;
  COMMIT;
  EXCEPTION WHEN OTHERS THEN
    ROLLBACK TO SP;
END;

--A Manager can approve/deny pending reimbursement requests
CREATE OR REPLACE PROCEDURE SP_ERS_RESOLVE_REIMBURS(IN_ID IN NUMBER, STATUS IN VARCHAR, RESOLVED_BY IN VARCHAR, TEXT_OUT OUT VARCHAR)
IS 
  CNT NUMBER;
  USER_ID NUMBER;
  CURR_TIME TIMESTAMP:=CURRENT_TIMESTAMP; 
BEGIN
  SAVEPOINT SP;
  SELECT COUNT(*) INTO CNT FROM ERS_REIMBURSEMENT_STATUS WHERE RS_STATUS=STATUS;
  IF CNT=1 THEN
    SELECT U_ID INTO USER_ID FROM ERS_USERS WHERE U_USERNAME=RESOLVED_BY;
    UPDATE ERS_REIMBURSEMENTS SET RS_STATUS=STATUS, R_RESOLVED=CURR_TIME, U_ID_RESOLVER=USER_ID WHERE R_ID=IN_ID;
  ELSE
    TEXT_OUT:='ERROR WITH FINDING STATUS TYPE';
  END IF;
  COMMIT;
  TEXT_OUT:='SUCCESSFULLY UPDATED REIMBURSEMENT REQUEST';
  EXCEPTION WHEN OTHERS THEN
    TEXT_OUT:='ERROR UPDATING REIMBURSEMENT REQUEST';
    ROLLBACK TO SP;
END;
