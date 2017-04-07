/*2.1 SELECT*/
SELECT * FROM EMPLOYEE;
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King'; 
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;
SELECT * FROM GENRE;

/*2.2 ORDER BY*/
SELECT * FROM ALBUM ORDER BY TITLE DESC;
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY;

/*2.3 INSERT INTO*/
INSERT INTO GENRE (GENREID, NAME) VALUES (26, 'Grunge');
INSERT INTO GENRE (GENREID, NAME) VALUES (27, 'Rockabilly');
INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME) VALUES (16, 'Hendrix', 'Ty');
INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME) VALUES (17, 'Welch', 'Logan');
INSERT INTO CUSTOMER (CUSTOMERID, LASTNAME, FIRSTNAME, EMAIL) VALUES (60, 'Crawley', 'Mike', 'pigfoot@email.onion');
INSERT INTO CUSTOMER (CUSTOMERID, LASTNAME, FIRSTNAME, EMAIL) VALUES (61, 'Thompson', 'Kaarin', 'rubychase@smail.org');

/*2.4 UPDATE*/
UPDATE CUSTOMER SET LASTNAME = 'Walter', FIRSTNAME = 'Robert' WHERE (LASTNAME = 'Mitchell' AND FIRSTNAME = 'Aaron');
UPDATE ARTIST SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';

/*2.5 UPDATE*/
SELECT BILLINGADDRESS FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

/*2.6*/
SELECT TOTAL FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN TO_DATE ('2003/06/01', 'yyyy/mm/dd')
AND TO_DATE ('2004/03/01', 'yyyy/mm/dd');

/*2.7*/

SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
SELECT CUSTOMERID FROM INVOICE WHERE CUSTOMERID = (SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter');

--FIRST, WE DELETE INVOICEID FROM INVOICELINE. We use in instead of = because we have to use a where clause against multiple entries instead of just one
DELETE FROM INVOICELINE WHERE INVOICEID in (SELECT INVOICEID FROM INVOICE WHERE CUSTOMERID in (SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter'));

--THEN WE MUST REMOVE THE CUSTOMER ID FROM INVOICE
DELETE FROM INVOICE WHERE CUSTOMERID in (SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter');

--AFTER WE DO THIS, WE CAN DELETE THE RECORD FROM CUSTOMER
DELETE FROM CUSTOMER WHERE FIRSTNAME in 'Robert' AND LASTNAME in 'Walter';
  
/*3.1*/

CREATE OR REPLACE FUNCTION calculeTime
RETURN TIMESTAMP
IS
salesOrderTotal TIMESTAMP;
BEGIN
  RETURN CURRENT_TIMESTAMP();
END;

DECLARE
BEGIN
  DBMS_OUTPUT.PUT_LINE(calculeTime);
END;

--create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION lengthOfMediatype
RETURN NUMBER
IS
len NUMBER;
BEGIN
  len := 0;
  RETURN len;
END;

DECLARE
BEGIN
  DBMS_OUTPUT.PUT_LINE(lengthOfMediaType);
END;

/*3.2*/
--Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION invoiceAverage
RETURN NUMBER
IS
ave NUMBER(3,2);
totalSum NUMBER;
numberOfTotals NUMBER;
BEGIN
  totalSum:=0;
  numberOfTotals:=0;
  FOR totals IN (SELECT TOTAL FROM INVOICE)
  LOOP
    totalSum := totalSum + totals.TOTAL;
    numberOfTotals := numberOfTotals + 1;
  END LOOP;
  
  ave := totalSum / numberOfTotals;
  RETURN ave;
END;

DECLARE
BEGIN
  DBMS_OUTPUT.PUT_LINE(invoiceAverage);
END;

--Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION mostExpensiveTrack
RETURN NUMBER
IS
price NUMBER;
BEGIN
  price := 0;
  FOR prices IN (SELECT UNITPRICE FROM TRACK)
  LOOP
    IF prices.UNITPRICE > price THEN
      price := prices.UNITPRICE;
    END IF;
  END LOOP;
  RETURN price;
END;

DECLARE
BEGIN
  DBMS_OUTPUT.PUT_LINE(mostExpensiveTrack);
END;

/*3.3*/
--Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION avePriceInvoiceLine
RETURN NUMBER
IS
avePrice NUMBER(3,2);
totalSum NUMBER;
numberOfTotals NUMBER;
BEGIN
  totalSum:=0;
  numberOfTotals:=0;
  FOR ivlPrices IN (SELECT UNITPRICE FROM INVOICELINE)
  LOOP
    totalSum := totalSum + ivlPrices.UNITPRICE;
    numberOfTotals := numberOfTotals + 1;
  END LOOP;
  avePrice := totalSum / numberOfTotals;
  RETURN avePrice;
END;

DECLARE
BEGIN
  DBMS_OUTPUT.PUT_LINE(avePriceInvoiceLine);
END;

/*3.4*/
--Create a function that returns all employees who are born after 1968.
--This will require cursers
CREATE OR REPLACE Function empsAfer1968
  RETURN SYS_REFCURSOR
IS
  S SYS_REFCURSOR;
BEGIN
OPEN S FOR
SELECT * FROM EMPLOYEE WHERE EXTRACT(YEAR FROM TO_DATE(BIRTHDATE, 'DD-MON-RR')) > 1968;  --A DML COMMAND
return S;
CLOSE S;
END;

DECLARE
  S SYS_REFCURSOR;
  varrow employee%ROWTYPE;
BEGIN
  S := empsAfer1968;
  
  --THIS IS A LOOP THAT MOVES THROUGH LIST
  LOOP
    FETCH S INTO varrow;
    DBMS_OUTPUT.PUT_LINE('FirstName' || varrow.firstname || ' ' || 'Birthdate' || varrow.birthdate);
    EXIT WHEN S%NOTFOUND;
  END LOOP;
  CLOSE S;
END;


/*4.1*/
--Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE FIRSTANDLASTNAME(S OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN S FOR
    SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;  --A DML COMMAND
  --CLOSE S;
END;

DECLARE
  S SYS_REFCURSOR;
  FNAME employee.FIRSTNAME%TYPE;
  LNAME employee.LASTNAME%TYPE;
BEGIN
  FIRSTANDLASTNAME(S);
  
  --THIS IS A LOOP THAT MOVES THROUGH LIST
  LOOP
    FETCH S INTO FNAME, LNAME;
    DBMS_OUTPUT.PUT_LINE('FirstName ' || FNAME || ' Lastname ' || LNAME);
    EXIT WHEN S%NOTFOUND;
  END LOOP;
  CLOSE S;
END;

/*4.2*/
--Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE UPDATEEMPLOYEE(S OUT SYS_REFCURSOR, origNum IN NUMBER)
IS
BEGIN
  OPEN S FOR
    SELECT EMPLOYEEID FROM EMPLOYEE WHERE EMPLOYEEID = origNum;
END;

DECLARE
  S SYS_REFCURSOR;
  EMPID employee.EMPLOYEEID%TYPE;
BEGIN
  UPDATEEMPLOYEE(S, 1);
  
  --THIS IS A LOOP THAT MOVES THROUGH LIST
  LOOP
    FETCH S INTO EMPID;
    UPDATE EMPLOYEE SET FIRSTNAME = 'JOHN' WHERE EMPLOYEEID = EMPID;
    EXIT WHEN S%NOTFOUND;
  END LOOP;
  CLOSE S;
END;

--Create a stored procedure that returns the managers of an employee.

/*4.3*/
--Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE NAME_AND_COMPANY_OF_CUSTOMER(S OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN S FOR
    SELECT FIRSTNAME, LASTNAME, COMPANY FROM CUSTOMER;  --A DML COMMAND
  --CLOSE S;
END;

DECLARE
  S SYS_REFCURSOR;
  FNAME customer.FIRSTNAME%TYPE;
  LNAME customer.LASTNAME%TYPE;
  COMP customer.COMPANY%TYPE;
BEGIN
   NAME_AND_COMPANY_OF_CUSTOMER(S);
  
  --THIS IS A LOOP THAT MOVES THROUGH LIST
  LOOP
    FETCH S INTO FNAME, LNAME, COMP;
    DBMS_OUTPUT.PUT_LINE('FirstName ' || FNAME || ' Lastname ' || LNAME || ' Company ' || COMP);
    EXIT WHEN S%NOTFOUND;
  END LOOP;
  CLOSE S;
END;


/*5.0*/
--Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE deleteInvoice(num NUMBER)
IS
BEGIN
  DELETE FROM INVOICELINE WHERE INVOICEID in (SELECT INVOICEID FROM INVOICE WHERE INVOICEID = num); 
  DELETE FROM INVOICE WHERE INVOICEID = num;
  COMMIT;
END;

DECLARE

BEGIN
  deleteInvoice(324);
END;

--Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE INSERTCUSTOMER(num Number, fName VARCHAR2, lName VARCHAR2, email VARCHAR2)
IS
BEGIN
  INSERT INTO CUSTOMER (CUSTOMERID, LASTNAME, FIRSTNAME, EMAIL) VALUES (num, fName, lName, email);
  COMMIT;
END;

DECLARE

--used to test
BEGIN
  INSERTCUSTOMER(62, 'Aron', 'Gabe', 'smith@email.something');
END;

/*6.1*/
--insert record to test trigger for test
--INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME) VALUES (9, 'user', 'test');
--CREATE AFTER INSERT TRIGGER FOR EMPLOYEE PRIMARY KEYS
CREATE OR REPLACE TRIGGER TR_INSERT_EMP
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
  dbms_output.put_line('Something was inserted into EMPLOYEE');
END;

--Create an after update trigger on the album table that fires after a row is inserted in the table
--TEST
--INSERT INTO ALBUM (ALBUMID, TITLE, ARTISTID) VALUES (348, 'INCESTICIDE', 1);
CREATE OR REPLACE TRIGGER TR_INSERT_ALB
AFTER INSERT ON ALBUM
FOR EACH ROW
BEGIN
  dbms_output.put_line('Something was inserted into ALBUM');
END;

--Create an after delete trigger on the customer table that fires after a row is deleted from the table.
--TEST
/*DELETE FROM INVOICELINE WHERE INVOICEID in (SELECT INVOICEID FROM INVOICE WHERE CUSTOMERID in (SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME = 'Kathy' AND LASTNAME = 'Chase'));
DELETE FROM INVOICE WHERE CUSTOMERID in (SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME = 'Kathy' AND LASTNAME = 'Chase');
DELETE FROM CUSTOMER WHERE FIRSTNAME in 'Kathy' AND LASTNAME in 'Chase';*/

CREATE OR REPLACE TRIGGER TR_DELETE_CUST
AFTER DELETE ON CUSTOMER
FOR EACH ROW
BEGIN
  dbms_output.put_line('Something was deleted from CUSTOMER');
END;

/*7.1*/
--Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT CUSTOMER.CUSTOMERID, INVOICE.INVOICEID
FROM CUSTOMER
INNER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

/*7.2*/
--Create an outer join that joins the customer and invoice table, 
--specifying the CustomerId,firstname, lastname, invoiceId, and total.
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER
FULL OUTER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

/*7.3*/
--Create a right join that joins album and artist specifying artist name and title.
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ALBUM
RIGHT JOIN ARTIST
ON ALBUM.ARTISTID = ARTIST.ARTISTID;

/*7.4*/
--Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * 
FROM ALBUM 
CROSS JOIN ARTIST
WHERE ALBUM.ARTISTID = ARTIST.ARTISTID 
ORDER BY ARTIST.NAME ASC;

/*7.5*/
--Perform a self-join on the employee table, joining on the reportsto column.
SELECT E1.REPORTSTO, E2.REPORTSTO
FROM EMPLOYEE E1, EMPLOYEE E2
WHERE E1.REPORTSTO = E2.REPORTSTO;

/*9.0*/
--Create a .bak file for the Chinook database.
--BACKUP DATABASE "chinook" TO DISK "C:\Program Files\Microsoft SQL Server\MSSQL\Backup\Testdb.bak";
/*Make backup with .back Export SQL database to .back*/

