/*
2.0 SQL Queries
In this section you will be performing various queries against the Oracle Chinook database.

2.1 SELECT
Task – Select all records from the Employee table.
Task – Select all records from the Employee table where last name is King.
Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
*/
SELECT * FROM EMPLOYEE;
SELECT * FROM EMPLOYEE WHERE LASTNAME='King';
SELECT * FROM EMPLOYEE WHERE FIRSTNAME='Andrew' AND REPORTSTO is NULL;
/*
2.2 ORDER BY
Task – Select all albums in Album table and sort result set in descending order by title.
Task – Select first name from Customer and sort result set in ascending order by city
*/
SELECT * FROM ALBUM ORDER BY TITLE DESC;
SELECT FIRSTNAME,CITY FROM CUSTOMER ORDER BY CITY ASC;
/*
2.3 INSERT INTO
Task – Insert two new records into Genre table
Task – Insert two new records into Employee table
Task – Insert two new records into Customer table
*/
INSERT INTO GENREID VALUES(0,"ROCK");
INSERT INTO GENREID VALUES(1,"COUNTRY");

INSERT INTO EMPLOYEE VALUES(16,'KENT','BENJAMIN','INTERN',3,14-FEB-94,27-MAR-2017,'9402 STATION CIRCLE','DEDHAM','MA','U.S',02026,5084068215,NULL,'KENTB@WIT.EDU');

INSERT INTO CUSTOMER VALUES(16,'BENJAMIN','KENT','REVATURE',3,14-FEB-94,27-MAR-2017,'9402 STATION CIRCLE','DEDHAM','MA','U.S',02026,5084068215,NULL,'KENTB@WIT.EDU',NULL);

/*
2.4 UPDATE
Task – Update Aaron Mitchell in Customer table to Robert Walter
Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
*/
UPDATE CUSTOMER
SET FIRSTNAME='Aaron',LASTNAME='Mitchell' WHERE FIRSTNAME='Robert' AND LASTNAME='Walter';

UPDATE ARTIST
SET NAME='Creedence Clearwater Revival' WHERE NAME='CCR';

/*
2.5 LIKE
Task – Select all invoices with a billing address like “T%”
*/
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';
/*
2.6 BETWEEN
Task – Select all invoices that have a total between 15 and 50
*/
SELECT * FROM INVOICE WHERE TOTAL>15 AND TOTAL<50; 
/*
Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
*/
/*
2.7 DELETE
Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
*/
INSERT INTO CUSTOMER(CUSTOMERID,FIRSTNAME,LASTNAME,EMAIL) VALUES(60,'Robert','Walter','SOMETHING@gmail.com');
DELETE FROM CUSTOMER WHERE FIRSTNAME='Robert' AND LASTNAME='Walter';
SELECT * FROM CUSTOMER WHERE FIRSTNAME='Robert' AND LASTNAME= 'Walter';
/*
3.0	SQL Functions
In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
3.1 System Defined Functions
Task – Create a function that returns the current time.

*/



create or replace FUNCTION RETURN_TIME
RETURN DATE IS Y DATE;
BEGIN

Y:=SYSTIMESTAMP;
RETURN Y;
END;

BEGIN
DBMS_OUTPUT.PUT_LINE(RETURN_TIME());
END;



/*
Task – create a function that returns the length of a mediatype from the mediatype table
*/
CREATE OR REPLACE FUNCTION MEDIATYPELENGTH(C IN VARCHAR2) 
RETURN number IS 
   length number(2) := 0;
BEGIN 
   SELECT LENGTH(NAME) into length 
   FROM CHINOOK.MEDIATYPE WHERE NAME=C; 
    
   RETURN length; 
END; 

BEGIN
DBMS_OUTPUT.PUT_LINE(MEDIATYPELENGTH('AAC audio file'));
END;
/*
3.2 System Defined Aggregate Functions
Task – Create a function that returns the average total of all invoices
*/
CREATE OR REPLACE FUNCTION avtotalInvoices 
RETURN number IS 
   avtotal number(2) := 0; 
BEGIN 
   SELECT AVG(TOTAL) into avtotal 
   FROM CHINOOK.INVOICE; 
    
   RETURN avtotal; 
END; 

BEGIN
DBMS_OUTPUT.PUT_LINE(AVTOTALINVOICES);
END;

/*
Task – Create a function that returns the most expensive track
3.3 User Defined Scalar Functions
Task – Create a function that returns the average price of invoiceline items in the invoiceline table
*/
CREATE OR REPLACE FUNCTION AVGINVOICELINEPRICE(C IN VARCHAR2) 
RETURN number IS 
   price number(2) := 0;
BEGIN 
   SELECT AVG(UNITPRICE) into price 
   FROM CHINOOK.INVOICELINE WHERE INVOICEID=C; 
    
   RETURN price; 
END;
/*
3.4 User Defined Table Valued Functions
Task – Create a function that returns all employees who are born after 1968.
*/
CREATE OR REPLACE FUNCTION YOUNGEMPLOYEES 
RETURN number IS 
   age number(2) := 0;
BEGIN 
   SELECT BIRTHDATE into price 
   FROM CHINOOK.EMPLYEE WHERE BIRTHDATE>1968; 
    
   RETURN age; 
END;
/*
4.0 Stored Procedures
 In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
4.1 Basic Stored Procedure
Task – Create a stored procedure that selects the first and last names of all the employees.
*/
create or replace PROCEDURE GETEMPLOYEENAMES(S OUT SYS_REFCURSOR)

AS
BEGIN
OPEN S FOR
SELECT EMPLOYEE.FIRSTNAME,EMPLOYEE.LASTNAME FROM CHINOOK.EMPLOYEE;
END;

DECLARE
S SYS_REFCURSOR;
FNAME CHINOOK.EMPLOYEE.FIRSTNAME%TYPE;
LNAME CHINOOK.EMPLOYEE.LASTNAME%TYPE;

BEGIN 
GETEMPLOYEENAMES(S);

LOOP
FETCH S INTO FNAME,LNAME;
EXIT WHEN S%NOTFOUND;
DBMS_OUTPUT.PUT('FIRST NAME: '||FNAME||'LAST NAME: '||LNAME);
END LOOP;
CLOSE S;
DBMS_OUTPUT.PUT_LINE('LOOP ENDED');
END;


/*
4.2 Stored Procedure Input Parameters
Task – Create a stored procedure that updates the personal information of an employee.
*/
create or replace PROCEDURE UPDATEEMPLOYEE(ID IN VARCHAR2,NAME IN VARCHAR)

AS
BEGIN

UPDATE EMPLOYEE SET FIRSTNAME=NAME WHERE EMPLOYEEID=ID;
END;
/*
Task – Create a stored procedure that returns the managers of an employee.
*/
create or replace PROCEDURE GETMANAGERS(S OUT SYS_REFCURSOR)

AS
BEGIN
OPEN S FOR
SELECT * FROM CHINOOK.EMPLOYEE WHERE EMPLOYEE.TITLE LIKE 'MANAGER';
END;
/*
4.3 Stored Procedure Output Parameters
Task – Create a stored procedure that returns the name and company of a customer.
5.0 Transactions
In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
*/
ALTER TABLE INVOICE DROP CONSTRAINT FK_INVOICECUSTOMERID;
ALTER TABLE INVOICE ADD CONSTRAINT FK_INVOICECUSTOMERID  FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMER(CUSTOMERID);
CREATE OR REPLACE PROCEDURE DELETEINVOICE(ID IN INTEGER)
IS
BEGIN
SAVEPOINT LASTINVOICEDELETE;
DELETE FROM CHINOOK.INVOICE WHERE INVOICEID=ID;
END;
BEGIN
DELETEINVOICE(1);
END;
BEGIN
ROLLBACK TO LASTINVOICEDELETE;
END;

/*
Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
6.0 Triggers
In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
6.1 AFTER/FOR
Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
Task – Create an after update trigger on the album table that fires after a row is inserted in the table
Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
7.0 JOINS
In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
7.1 INNER
Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
*/
SELECT CUSTOMER.CUSTOMERID,CUSTOMER.FIRSTNAME,CUSTOMER.LASTNAME,INVOICE.INVOICEID FROM CUSTOMER INNER JOIN  INVOICE ON CUSTOMER.CUSTOMERID=INVOICE.INVOICEID;
/*
7.2 OUTER
Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
*/
SELECT CUSTOMER.CUSTOMERID,CUSTOMER.FIRSTNAME,CUSTOMER.LASTNAME,INVOICE.INVOICEID,INVOICE.TOTAL FROM CUSTOMER LEFT JOIN INVOICE ON CUSTOMER.CUSTOMERID=INVOICE.INVOICEID;
/*
7.3 RIGHT
Task – Create a right join that joins album and artist specifying artist name and title.
*/
SELECT ALBUM.TITLE,ARTIST.NAME FROM ALBUM RIGHT JOIN ARTIST ON ALBUMID=ARTISTID;
/*
7.4 CROSS
Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
*/
SELECT * FROM ARTIST CROSS JOIN ALBUM ORDER BY ASC;
/*
7.5 SELF
Task – Perform a self-join on the employee table, joining on the reportsto column.
*/
SELECT A.REPORTSTO AS EMPLOYEE1,B.REPORTSTO AS EMPLOYEE2 FROM EMPLOYEE A,EMPLOYEE B WHERE A.REPORTSTO <> B.REPORTSTO;
/*
9.0 Administration
In this section you will be creating backup files of your database. After you create the backup file you will also restore the database.
Task – Create a .bak file for the Chinook database.

*/