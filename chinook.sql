/*SQL LAB*/

/*2.1 SELECT*/

/*Task – Select all records from the Employee table.*/
SELECT * 
FROM EMPLOYEE;

/*Task – Select all records from the Employee table 
  where last name is King.
*/
SELECT *
FROM EMPLOYEE
WHERE LASTNAME = 'King';

/*Task – Select all records from the Employee table 
  where first name is Andrew and REPORTSTO is NULL.*/
SELECT *
FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew'
AND REPORTSTO IS NULL;


/*2.2 ORDER BY*/
/*Task – Select all albums in Album table and sort result 
  set in descending order by title.
*/
SELECT TITLE
FROM ALBUM
ORDER BY TITLE DESC;

/*Task – Select first name from Customer and sort result set in ascending order by city
*/
SELECT FIRSTNAME
FROM CUSTOMER
ORDER BY CITY ASC;

/*2.3 INSERT INTO*/
/*Task – Insert two new records into Genre table
*/
INSERT ALL 
INTO GENRE (GENREID, NAME)
VALUES (26, 'Bluegrass')
INTO GENRE (GENREID, NAME)
VALUES (27, 'Classic Rock')
SELECT * FROM DUAL;

/*Task – Insert two new records into Employee table*/
INSERT ALL 
INTO EMPLOYEE 
(EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS)
VALUES 
(9, 'Smith', 'John', 'Janitor', 1, '28-FEB-08', '10-AUG-08', '123 Very Old Ave')
INTO EMPLOYEE 
(EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS)
VALUES 
(10, 'Doe', 'Jane', 'Staff Greeter', 6, '16-JUL-82', '10-SEP-07', '456 Sombee Cir')
SELECT * FROM DUAL;


/*Task – Insert two new records into Customer table*/
INSERT ALL 
INTO CUSTOMER 
(CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL)
VALUES 
(60, 'John', 'Smith', 'yakkity@yak.com')
INTO CUSTOMER 
(CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL)
VALUES 
(61, 'Jane', 'Doe', 'balogna167@oscarmayer.com')
SELECT * FROM DUAL;

/*2.4 UPDATE*/
/*Task – Update Aaron Mitchell in Customer table to Robert Walter*/
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE CUSTOMERID = 32;


/*Task – Update name of artist in the Artist table 
“Creedence Clearwater Revival” to “CCR”*/
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';


/*2.5 LIKE*/
/*Task – Select all invoices with a billing address like “T%”*/
SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

/*2.6 BETWEEN */
/*Task – Select all invoices that have a total between 15 and 50*/
SELECT * FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 20;

/*Task – Select all employees hired between 
1st of June 2003 and 1st of March 2004*/
SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

/*2.7 DELETE*/
/*Task – Delete a record in Customer table where the name is Robert Walter 
(There may be constraints that rely on this, find out how to resolve them).*/
DELETE FROM INVOICELINE
WHERE INVOICEID = 116 OR
INVOICEID = 245 OR
INVOICEID = 268 OR
INVOICEID = 290 OR
INVOICEID = 342 OR
INVOICEID = 50 OR
INVOICEID = 61;

DELETE FROM INVOICE
WHERE CUSTOMERID = 32;

DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

/*3.1 System Defined Functions
/*Task – Create a function that returns the current time.*/
  SELECT CURRENT_TIMESTAMP FROM DUAL;


/*Task – create a function that returns the length
of a mediatype from the mediatype table*/
SELECT LENGTH(NAME) FROM MEDIATYPE;


/*3.2 System Defined Aggregate Functions*/
--Task – Create a function that returns the average total of all invoices
SELECT AVG(TOTAL) AS INVOICE_AVG_TOTAL FROM INVOICE;


--Task – Create a function that returns the most expensive track
SELECT MAX(UNITPRICE) FROM TRACK;



/*3.3 User Defined Scalar Functions*/
--Task – Create a function that returns the average 
--price of invoiceline items in the invoiceline table



--SELECT AVG(UNITPRICE) FROM INVOICELINE;

CREATE OR REPLACE FUNCTION FIND_AVG_PRICE
RETURN NUMBER
IS 
AVERAGE NUMBER;
X NUMBER;
Y NUMBER;
CURSOR C_FIND_AVG IS SELECT UNITPRICE FROM INVOICELINE;
BEGIN
OPEN C_FIND_AVG;
  LOOP
    FETCH C_FIND_AVG INTO X;
    EXIT WHEN C_FIND_AVG%NOTFOUND;
    AVERAGE := AVERAGE + X;
    Y := Y + 1;
  END LOOP;
  CLOSE C_FIND_AVG;
  AVERAGE:= AVERAGE / Y;
  RETURN AVERAGE;
END;

DECLARE
AVERAGE_PRICE NUMBER;

BEGIN
  AVERAGE_PRICE := FIND_AVG_PRICE();
  DBMS_OUTPUT.PUT_LINE('AVG: ' || AVERAGE_PRICE);
END;



/*3.4 User Defined Table Valued Functions*/
--Task – Create a function that returns all employees who are born after 1968.
SELECT * FROM EMPLOYEE
WHERE BIRTHDATE >= '1-JAN-1969';


/*4.0 Stored Procedures*/
/* In this section you will be creating and executing stored 
procedures. You will be creating various types of stored 
procedures that take input and output parameters.*/
/*4.1 Basic Stored Procedure*/
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE EMPLOYEE_NAME_PROCEDURE
IS
E_FIRST VARCHAR2(2000);
E_LAST VARCHAR2(2000);
CURSOR C_EMPLOYEE IS
  SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;


BEGIN
  OPEN C_EMPLOYEE;
  LOOP
  FETCH C_EMPLOYEE INTO E_FIRST, E_LAST;
    EXIT WHEN C_EMPLOYEE%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(E_FIRST || ' ' || E_LAST);
  END LOOP;
  CLOSE C_EMPLOYEE;
END;

BEGIN
  EMPLOYEE_NAME_PROCEDURE();
END;


/*4.2 Stored Procedure Input Parameters*/
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE E_ADDRESS_UPDATE_PROCED
(E_ADDRESS IN VARCHAR2, E_ID IN NUMBER)
IS
BEGIN
  UPDATE EMPLOYEE SET ADDRESS = E_ADDRESS WHERE EMPLOYEEID = E_ID;
END;


/*
CURSOR C_E_UPDATE IS
  SELECT ADDRESS FROM EMPLOYEE WHERE EMPLOYEEID=E_ID FOR UPDATE;
  
  BEGIN
  OPEN C_E_UPDATE;
  UPDATE EMPLOYEE SET ADDRESS = E_ADDRESS WHERE CURRENT OF C_E_UPDATE; 
  CLOSE C_E_UPDATE;
  END;
 */ 
BEGIN
  E_ADDRESS_UPDATE_PROCED('456 Sombee Cir', 10);
END;


--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE MGR_OF_EMP_PROC(E_ID IN NUMBER)
IS
M_FIRST VARCHAR(100);
M_LAST VARCHAR(100);
CURSOR C_EMPLOYEE IS
  SELECT FIRSTNAME, LASTNAME 
  FROM EMPLOYEE 
  WHERE
  EMPLOYEEID = (SELECT REPORTSTO FROM EMPLOYEE WHERE EMPLOYEEID = E_ID);


BEGIN
  OPEN C_EMPLOYEE;
  LOOP
  FETCH C_EMPLOYEE INTO M_FIRST, M_LAST;
    EXIT WHEN C_EMPLOYEE%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(M_FIRST || ' ' || M_LAST);
  END LOOP;
  CLOSE C_EMPLOYEE;
END;

BEGIN
  MGR_OF_EMP_PROC(7);
END;

/*4.3 Stored Procedure Output Parameters*/
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE NAME_COMP_OF_CUST_PROC
(C_ID IN NUMBER, FIRST_N OUT VARCHAR2, LAST_N OUT VARCHAR2, COMP_N OUT VARCHAR2)
IS
CURSOR C_GET_NAMES IS
  SELECT FIRSTNAME, LASTNAME, COMPANY 
  FROM CUSTOMER
  WHERE
  CUSTOMERID = C_ID;


BEGIN
  OPEN C_GET_NAMES;
  LOOP
  FETCH C_GET_NAMES INTO FIRST_N, LAST_N, COMP_N;
    EXIT WHEN C_GET_NAMES%NOTFOUND;
  END LOOP;
  CLOSE C_GET_NAMES;
END;


DECLARE
FIRST_N VARCHAR2(100);
LAST_N VARCHAR2(100);
COMP_N VARCHAR2(100);
BEGIN
NAME_COMP_OF_CUST_PROC(19, FIRST_N, LAST_N, COMP_N);
END;





/*5.0 Transactions*/
/*Task – Create a transaction that given a invoiceId will delete that 
invoice (There may be constraints that rely on this, find out 
to resolve them).*/
CREATE OR REPLACE PROCEDURE DELETE_INV_PROC(I_ID IN NUMBER)
IS
BEGIN
DELETE FROM INVOICELINE
WHERE INVOICEID = I_ID;

DELETE FROM INVOICE
WHERE INVOICEID = I_ID;

COMMIT;

EXCEPTION
WHEN OTHERS THEN
ROLLBACK;

END;

BEGIN
DELETE_INV_PROC(115);
END;

/*Task – Create a transaction nested within a stored procedure 
that inserts a new record in the Customer table*/
CREATE OR REPLACE PROCEDURE NEW_CUST_PROC
(C_ID IN NUMBER, F_NAME IN VARCHAR2, L_NAME IN VARCHAR2, E_MAIL IN VARCHAR2)
IS
BEGIN
INSERT INTO CUSTOMER
(CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL)
VALUES
(C_ID, F_NAME, L_NAME, E_MAIL);
COMMIT;

EXCEPTION
WHEN OTHERS THEN
ROLLBACK;

END;

BEGIN
NEW_CUST_PROC(62, 'Trebor', 'Sretlaw', 'tsretlaw@email.com');
END;

/*6.0 Triggers*/
/*In this section you will create various kinds of triggers 
that work when certain DML statements are executed on a table.*/
/*6.1 AFTER/FOR*/
/*Task - Create an after insert trigger on the employee 
table fired after a new record is inserted into the table.*/
CREATE OR REPLACE TRIGGER NEW_EMPLOYEE_RECORD
AFTER INSERT ON EMPLOYEE
  BEGIN
    DBMS_OUTPUT.PUT_LINE('NEW RECORD INSERTED IN EMPLOYEE TABLE');
  END;
    



/*Task – Create an after update trigger on the album table 
that fires after a row is inserted in the table*/
CREATE OR REPLACE TRIGGER NEW_ALBUM_ROW
AFTER INSERT ON ALBUM
  BEGIN
    DBMS_OUTPUT.PUT_LINE('NEW ROW INSERTED IN ALBUM TABLE');
  END;



/*Task – Create an after delete trigger on the customer 
table that fires after a row is deleted from the table.*/
CREATE OR REPLACE TRIGGER NEW_CUSTOMER_DELETE
AFTER DELETE ON CUSTOMER
  BEGIN
    DBMS_OUTPUT.PUT_LINE('DELETE IN CUSTOMER TABLE OCCURRED');
  END;



/*7.0 JOINS*/
/*In this section you will be working with combing various 
tables through the use of joins. You will work with outer, 
inner, right, left, cross, and self joins.*/
/*7.1 INNER*/
/*Task – Create an inner join that joins customers and orders 
and specifies the name of the customer and the invoiceId.*/
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME,INVOICE.INVOICEID
FROM CUSTOMER
INNER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;



/*7.2 OUTER*/
/*Task – Create an outer join that joins the customer and 
invoice table, specifying the CustomerId, firstname, 
lastname, invoiceId, and total.*/
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, 
CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER
LEFT OUTER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;



/*7.3 RIGHT*/
/*Task – Create a right join that joins album and artist 
specifying artist name and title.*/
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST
RIGHT OUTER JOIN ALBUM
ON ARTIST.ARTISTID = ALBUM.ARTISTID;


/*7.4 CROSS*/
/*Task – Create a cross join that joins album and 
artist and sorts by artist name in ascending order*/
SELECT *
FROM ALBUM
CROSS JOIN ARTIST
ORDER BY ARTIST.NAME ASC;

/*7.5 SELF*/
/*Task – Perform a self-join on the employee table,
joining on the reportsto column.*/
SELECT TABLE_A.FIRSTNAME, TABLE_A.LASTNAME
FROM EMPLOYEE TABLE_A
INNER JOIN EMPLOYEE TABLE_B
ON (TABLE_A.REPORTSTO=TABLE_B.REPORTSTO);



/*9.0 Administration*/
/*Task – Create a .bak file for the Chinook database.*/
--COMPLETED
