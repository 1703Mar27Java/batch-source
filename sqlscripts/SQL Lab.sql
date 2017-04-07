/*******************************************************************************
2.1 SELECT
Task – Select all records from the Employee table.
Task – Select all records from the Employee table where last name is King.
Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
*******************************************************************************/

SELECT * FROM EMPLOYEE;
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO = NULL;

/*******************************************************************************
2.2 ORDER BY
Task – Select all albums in Album table and sort result set in descending order by title.
Task – Select first name from Customer and sort result set in ascending order by city
*******************************************************************************/

SELECT * FROM ALBUM ORDER BY TITLE DESC;
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY ASC;

/*******************************************************************************
2.3 INSERT INTO
Task – Insert two new records into Genre table
Task – Insert two new records into Employee table
Task – Insert two new records into Customer table
*******************************************************************************/

INSERT INTO GENRE VALUES(26, 'International');
INSERT INTO GENRE VALUES(27, 'Independent');
INSERT INTO EMPLOYEE VALUES(9, 'George', 'Smith', 'IT Staff', 6, TO_DATE('04/01/1970', 'DD/MM/YYYY'), TO_DATE('05/10/2005', 'DD/MM/YYYY'), '11730 America Plaza Dr', 'Reston', 'VA', 'USA', '20190', '+1 (555) 555-5555', '+1 (555) 555-5566', 'gsmith@gmail.com');
INSERT INTO EMPLOYEE VALUES(10, 'Sam', 'Wallace', 'IT Staff', 6, TO_DATE('01/04/1973', 'DD/MM/YYYY'), TO_DATE('06/11/2005', 'DD/MM/YYYY'), '11740 America Plaza Dr', 'Reston', 'VA', 'USA', '20190', '+1 (555) 555-5577', '+1 (555) 555-5588', 'swallace@gmail.com');
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES(60, 'Tim', 'Drake', 'tdrake@batcave.com');
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES(61, 'Jason', 'Todd', 'jtodd@batcave.com');

/*******************************************************************************
2.4 UPDATE
Task – Update Aaron Mitchell in Customer table to Robert Walter
Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
*******************************************************************************/

UPDATE CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
UPDATE ARTIST SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';

/*******************************************************************************
2.5 LIKE
Task – Select all invoices with a billing address like “T%”
*******************************************************************************/

SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

/*******************************************************************************
2.6 BETWEEN
Task – Select all invoices that have a total between 15 and 50
Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
*******************************************************************************/

SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

/*******************************************************************************
2.7 DELETE
Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
*******************************************************************************/

ALTER TABLE INVOICE DROP CONSTRAINT FK_INVOICECUSTOMERID;
ALTER TABLE INVOICE ADD CONSTRAINT FK_INVOICECUSTOMERID
  FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMER (CUSTOMERID) ON DELETE CASCADE;
    
ALTER TABLE INVOICELINE DROP CONSTRAINT FK_INVOICELINEINVOICEID;
ALTER TABLE INVOICELINE ADD CONSTRAINT FK_INVOICELINEINVOICEID
  FOREIGN KEY (INVOICEID) REFERENCES INVOICE (INVOICEID)  ON DELETE CASCADE;
    
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

/*******************************************************************************
3.1 System Defined Functions
Task – Create a function that returns the current time.
Task – create a function that returns the length of a mediatype from the mediatype table
*******************************************************************************/

CREATE OR REPLACE FUNCTION CURTIME
RETURN TIMESTAMP IS
BEGIN
  RETURN SYSTIMESTAMP;
END;

CREATE OR REPLACE FUNCTION MEDIATYPE_LENGTH (MEDIATYPE_ID IN NUMBER) RETURN INTEGER IS
  MEDIATYPE_L INTEGER;
BEGIN
  SELECT LENGTH(NAME) INTO MEDIATYPE_L FROM MEDIATYPE WHERE MEDIATYPEID = MEDIATYPE_ID;    
  RETURN MEDIATYPE_L;
END;

/*******************************************************************************
3.2 System Defined Aggregate Functions
Task – Create a function that returns the average total of all invoices
Task – Create a function that returns the most expensive track
*******************************************************************************/

CREATE OR REPLACE FUNCTION AVG_INVOICETOTAL RETURN NUMBER AS AVG_TOTAL NUMBER;
BEGIN
  SELECT (SUM(TOTAL)/COUNT(TOTAL)) INTO AVG_TOTAL FROM INVOICE;
  RETURN AVG_TOTAL;
END;

CREATE OR REPLACE FUNCTION MAX_EXPENSIVETRACK RETURN INTEGER AS MAX_TRACKID NUMBER;
BEGIN
    SELECT TRACKID INTO MAX_TRACKID FROM TRACK 
    WHERE UNITPRICE = (SELECT MAX(UNITPRICE) FROM TRACK)
    AND ROWNUM = 1;    
    RETURN MAX_TRACKID;
END;

/*******************************************************************************
3.3 User Defined Scalar Functions
Task – Create a function that returns the average price of invoiceline items in the invoiceline table
*******************************************************************************/

SELECT SUM(UNITPRICE)/COUNT(INVOICELINEID) FROM INVOICELINE;
CREATE OR REPLACE FUNCTION AVG_INVOICELINEPRICE
RETURN NUMBER AS AVG_PRICE NUMBER;
BEGIN
    SELECT AVG(UNITPRICE) INTO AVG_PRICE FROM INVOICELINE;    
    RETURN AVG_PRICE;
END;

/*******************************************************************************
3.4 User Defined Table Valued Functions
Task – Create a function that returns all employees who are born after 1968.
*******************************************************************************/

CREATE OR REPLACE TYPE EMPLOYEE_BORN_AFTER_O AS OBJECT (
  NAME VARCHAR2(50)
);

CREATE OR REPLACE TYPE EMPLOYEE_BORN_AFTER_RS AS TABLE OF EMPLOYEE_BORN_AFTER_O;

CREATE OR REPLACE FUNCTION EMPLOYEE_BORN_AFTER 
RETURN EMPLOYEE_BORN_AFTER_RS AS
O_TABLE EMPLOYEE_BORN_AFTER_RS;
BEGIN
    SELECT CAST(MULTISET(SELECT FIRSTNAME||' '||LASTNAME FROM EMPLOYEE 
    WHERE BIRTHDATE > '12-DEC-1968') AS EMPLOYEE_BORN_AFTER_RS)
    INTO O_TABLE FROM DUAL;  
    RETURN O_TABLE;
END; 

/*******************************************************************************
4.1 Basic Stored Procedure
Task – Create a stored procedure that selects the first and last names of all the employees.
*******************************************************************************/
CREATE OR REPLACE PROCEDURE FULLNAME_PROCEDURE(S OUT SYS_REFCURSOR)
IS 
BEGIN
  OPEN S FOR
  SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;

DECLARE
  S SYS_REFCURSOR;
  P_FIRSTNAME EMPLOYEE.FIRSTNAME%TYPE;
  P_LASTNAME EMPLOYEE.LASTNAME%TYPE;
BEGIN
  FULLNAME_PROCEDURE(S);
  LOOP
    FETCH S INTO P_FIRSTNAME, P_LASTNAME;
    EXIT WHEN S%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('Employee Name: '||P_FIRSTNAME||' '||P_LASTNAME);
  END LOOP;
  CLOSE S;
END;

/*******************************************************************************
4.2 Stored Procedure Input Parameters
Task – Create a stored procedure that updates the personal information of an employee.
Task – Create a stored procedure that returns the managers of an employee.
*******************************************************************************/

CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE_PROCEDURE(
  E_EMPLOYEEID IN NUMBER, 
  E_LASTNAME IN VARCHAR2, 
  E_FIRSTNAME IN VARCHAR2, 
  E_BIRTHDATE IN DATE,
  E_ADDRESS IN VARCHAR2,
  E_CITY IN VARCHAR2,
  E_STATE IN VARCHAR2,
  E_COUNTRY IN VARCHAR2,
  E_POSTALCODE IN VARCHAR2,
  E_PHONE IN VARCHAR2,
  E_FAX IN VARCHAR2,
  E_EMAIL IN VARCHAR2)
IS
BEGIN  
  UPDATE EMPLOYEE SET 
  LASTNAME = E_LASTNAME,
  FIRSTNAME = E_FIRSTNAME,
  BIRTHDATE = E_BIRTHDATE,
  ADDRESS = E_ADDRESS,
  CITY = E_CITY,
  STATE = E_STATE,
  COUNTRY = E_COUNTRY,
  POSTALCODE = E_POSTALCODE,
  PHONE = E_PHONE,
  FAX = E_FAX,
  EMAIL = E_EMAIL
  WHERE EMPLOYEEID = E_EMPLOYEEID;
  COMMIT;
END;

CREATE OR REPLACE PROCEDURE EMPLOYEE_MANAGER_PROCEDURE (
  E_EMPLOYEEID IN NUMBER, M_FIRSTNAME OUT VARCHAR2, M_LASTNAME OUT VARCHAR2)
IS
BEGIN
  SELECT FIRSTNAME, LASTNAME INTO M_FIRSTNAME, M_LASTNAME
  FROM EMPLOYEE 
  WHERE EMPLOYEEID = (
    SELECT REPORTSTO FROM EMPLOYEE WHERE EMPLOYEEID = E_EMPLOYEEID);
END;

/*******************************************************************************
4.3 Stored Procedure Output Parameters
Task – Create a stored procedure that returns the name and company of a customer.
*******************************************************************************/

CREATE OR REPLACE PROCEDURE CUSTOMER_COMPANY_PROCEDURE(
  CUSTOMER_ID IN NUMBER, 
  CUSTOMER_FIRSTNAME OUT VARCHAR2, 
  CUSTOMER_LASTNAME OUT VARCHAR2, 
  CUSTOMER_COMPANY OUT VARCHAR2 )
IS
BEGIN
    SELECT FIRSTNAME, LASTNAME, COMPANY
    INTO CUSTOMER_FIRSTNAME, CUSTOMER_LASTNAME, CUSTOMER_COMPANY
    FROM CUSTOMER WHERE
    CUSTOMERID = CUSTOMER_ID;
END;

/*******************************************************************************
5.0 Transactions
In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
*******************************************************************************/

CREATE OR REPLACE PROCEDURE DELETE_INVOICE(INVOICE_ID IN NUMBER) AS
BEGIN
    SAVEPOINT SP;    
    DELETE FROM INVOICELINE WHERE INVOICEID =
        (SELECT INVOICEID FROM INVOICE WHERE INVOICEID = INVOICE_ID);    
    DELETE FROM INVOICE WHERE INVOICEID = INVOICE_ID;    
    COMMIT;    
    EXCEPTION WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('FAILED TO COMMIT');
        ROLLBACK;
END;   

CREATE OR REPLACE PROCEDURE INSERT_CUSTOMER(
CUSTOMER_ID IN NUMBER, 
CUSTOMER_FIRSTNAME IN VARCHAR2, 
CUSTOMER_LASTNAME IN VARCHAR2, 
CUSTOMER_EMAIL IN VARCHAR2)
AS
BEGIN
    SAVEPOINT SP;    
    INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) 
    VALUES (CUSTOMER_ID, CUSTOMER_FIRSTNAME, CUSTOMER_LASTNAME, CUSTOMER_EMAIL);
    COMMIT;    
    EXCEPTION WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('FAILED TO COMMIT');
        ROLLBACK;
END; 

/*******************************************************************************
6.1 AFTER/FOR
Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
Task – Create an after update trigger on the album table that fires after a row is inserted in the table
Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
*******************************************************************************/

CREATE OR REPLACE TRIGGER TR_INSERT_EMPLOYEE AFTER INSERT ON EMPLOYEE
BEGIN
    DBMS_OUTPUT.PUT_LINE('Success'); 
END;

CREATE OR REPLACE TRIGGER TR_UPDATE_ALBUM AFTER UPDATE ON ALBUM
BEGIN
    DBMS_OUTPUT.PUT_LINE('Success'); 
END;

CREATE OR REPLACE TRIGGER TR_DELETE_CUSTOMER AFTER DELETE ON CUSTOMER
BEGIN
    DBMS_OUTPUT.PUT_LINE('Success'); 
END;

/*******************************************************************************
7.1 INNER
Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
*******************************************************************************/

SELECT FIRSTNAME, LASTNAME, INVOICEID FROM CUSTOMER INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

/*******************************************************************************
7.2 OUTER
Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
*******************************************************************************/

SELECT CUSTOMER.CUSTOMERID, FIRSTNAME, LASTNAME, INVOICEID, TOTAL FROM CUSTOMER LEFT JOIN INVOICE ON INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID;

/*******************************************************************************
7.3 RIGHT
Task – Create a right join that joins album and artist specifying artist name and title.
*******************************************************************************/

SELECT NAME, TITLE FROM ALBUM RIGHT JOIN ARTIST ON ALBUM.ARTISTID = ARTIST.ARTISTID;

/*******************************************************************************
7.4 CROSS
Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
*******************************************************************************/

SELECT * FROM ALBUM CROSS JOIN ARTIST ORDER BY NAME ASC;

/*******************************************************************************
7.5 SELF
Task – Perform a self-join on the employee table, joining on the reportsto column.
*******************************************************************************/

SELECT * FROM EMPLOYEE E1 INNER JOIN EMPLOYEE E2 ON E1.REPORTSTO = E2.REPORTSTO;

/*******************************************************************************
9.0 Administration
In this section you will be creating backup files of your database. 
After you create the backup file you will also restore the database.
Task – Create a .bak file for the Chinook database.
*******************************************************************************/

RMAN> CONNECT TARGET /
RMAN> BACKUP DATABASE PLUS ARCHIVELOG;

BACKUP 
  INCREMENTAL LEVEL 1 CUMULATIVE
  SKIP INACCESSIBLE 
  DATABASE;