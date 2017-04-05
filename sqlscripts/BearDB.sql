
/*******************************************************************************
   Bear Database - Version 0.1
   Script: BearDB.sql
   Description: Creates and populates the Bear database.
   DB Server: Oracle
   Author: Mehrab Rahman
********************************************************************************/

/*******************************************************************************
   Drop database if it exists
********************************************************************************/
DROP USER bear CASCADE;


/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER bear
IDENTIFIED BY bear
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to bear;
GRANT resource to bear;
GRANT create session TO bear;
GRANT create table TO bear;
GRANT create view TO bear;



conn bear/bear


/*******************************************************************************
   Create Tables
********************************************************************************/
CREATE TABLE CAVE
(
    Cave_Id INTEGER PRIMARY KEY,
    Cave_Name VARCHAR2(50),
    Max_Bears INTEGER DEFAULT 4,
    CONSTRAINT Unique_Cave_Name UNIQUE (Cave_Name)
);

CREATE TABLE BEAR_TYPE
(
    Bear_Type_Id INTEGER PRIMARY KEY,
    Bear_Type_Name VARCHAR2(50)
);

CREATE TABLE BEAR
(
    Bear_ID INTEGER PRIMARY KEY,
    Bear_Name VARCHAR2(50),
    Bear_Age INTEGER,
    Bear_Weight INTEGER,
    Bear_Type_Id INTEGER,
    Cave_Id INTEGER,
    CONSTRAINT Check_Bear_Age CHECK (Bear_Age > 0),
    CONSTRAINT Check_Bear_Weight CHECK (Bear_Weight > 0)
);

CREATE TABLE BEEHIVE
(
    Beehive_Id INTEGER PRIMARY KEY,
    Hive_Weight INTEGER DEFAULT 50,
    CONSTRAINT Check_Hive_Weight CHECK (Hive_Weight > 0)
);

CREATE TABLE BEAR_BEEHIVE
(
    Bear_Id INTEGER,
    Beehive_Id INTEGER,
    CONSTRAINT FK_BearBeehive PRIMARY KEY (Bear_Id, Beehive_Id)
);



/*******************************************************************************
   Create Foreign Keys
********************************************************************************/
ALTER TABLE BEAR ADD CONSTRAINT FK_Bear_Type_Id
    FOREIGN KEY (Bear_Type_Id) REFERENCES BEAR_TYPE (Bear_Type_Id)  ;

ALTER TABLE BEAR ADD CONSTRAINT FK_Cave_Id
    FOREIGN KEY (Cave_Id) REFERENCES CAVE (Cave_Id)  ;


ALTER TABLE BEAR_BEEHIVE ADD CONSTRAINT FK_Bear_Id
    FOREIGN KEY (Bear_Id) REFERENCES BEAR (Bear_Id)  ;

ALTER TABLE BEAR_BEEHIVE ADD CONSTRAINT FK_Beehive_Id
    FOREIGN KEY (Beehive_Id) REFERENCES BEEHIVE (Beehive_Id)  ;


/*******************************************************************************
   Populate Tables
********************************************************************************/
INSERT INTO CAVE (Cave_Id, Cave_Name, Max_Bears) VALUES (1, 'Yosemite', 2);
INSERT INTO BEAR_TYPE (Bear_Type_Id, Bear_Type_Name) VALUES (1, 'Picnic');
INSERT INTO BEAR (Bear_Id, Bear_Name, Bear_Age, Bear_Weight, Bear_Type_Id, Cave_Id) VALUES (1, 'Yogi', 10, 150, 1, 1);
INSERT INTO BEAR (Bear_Id, Bear_Name, Bear_Age, Bear_Weight, Bear_Type_Id, Cave_Id) VALUES (2, 'Boo Boo', 8, 50, 1, 1);

SELECT * FROM BEAR;

commit;
exit;
