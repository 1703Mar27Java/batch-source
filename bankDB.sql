--------------------------------------------------------
--  File created - Monday-April-10-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table BANK_ACCOUNT
--------------------------------------------------------

  CREATE TABLE "BANK"."BANK_ACCOUNT" 
   (	"BANK_ACCOUNT_ID" NUMBER, 
	"BALANCE" NUMBER, 
	"ACCOUNT_NAME" VARCHAR2(100 BYTE), 
	"USER_ID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table BANK_USER
--------------------------------------------------------

  CREATE TABLE "BANK"."BANK_USER" 
   (	"USER_ID" NUMBER, 
	"USERNAME" VARCHAR2(50 BYTE), 
	"USER_PW" VARCHAR2(50 BYTE), 
	"FIRSTNAME" VARCHAR2(100 BYTE), 
	"LASTNAME" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Sequence SQ_BANK_ACCOUNT_PK
--------------------------------------------------------

   CREATE SEQUENCE  "BANK"."SQ_BANK_ACCOUNT_PK"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 11 START WITH 227 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SQ_BANK_USER_PK
--------------------------------------------------------

   CREATE SEQUENCE  "BANK"."SQ_BANK_USER_PK"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 13 START WITH 271 CACHE 20 NOORDER  NOCYCLE ;
REM INSERTING into BANK.BANK_ACCOUNT
SET DEFINE OFF;
Insert into BANK.BANK_ACCOUNT (BANK_ACCOUNT_ID,BALANCE,ACCOUNT_NAME,USER_ID) values (183,9001,null,76);
Insert into BANK.BANK_ACCOUNT (BANK_ACCOUNT_ID,BALANCE,ACCOUNT_NAME,USER_ID) values (194,9002,null,76);
Insert into BANK.BANK_ACCOUNT (BANK_ACCOUNT_ID,BALANCE,ACCOUNT_NAME,USER_ID) values (205,910101010,null,76);
Insert into BANK.BANK_ACCOUNT (BANK_ACCOUNT_ID,BALANCE,ACCOUNT_NAME,USER_ID) values (139,22000,null,63);
Insert into BANK.BANK_ACCOUNT (BANK_ACCOUNT_ID,BALANCE,ACCOUNT_NAME,USER_ID) values (172,10000,null,76);
Insert into BANK.BANK_ACCOUNT (BANK_ACCOUNT_ID,BALANCE,ACCOUNT_NAME,USER_ID) values (150,50000,null,76);
Insert into BANK.BANK_ACCOUNT (BANK_ACCOUNT_ID,BALANCE,ACCOUNT_NAME,USER_ID) values (161,1,null,76);
Insert into BANK.BANK_ACCOUNT (BANK_ACCOUNT_ID,BALANCE,ACCOUNT_NAME,USER_ID) values (95,15003,null,50);
REM INSERTING into BANK.BANK_USER
SET DEFINE OFF;
Insert into BANK.BANK_USER (USER_ID,USERNAME,USER_PW,FIRSTNAME,LASTNAME) values (24,'Chad','chad','Chad','Smith');
Insert into BANK.BANK_USER (USER_ID,USERNAME,USER_PW,FIRSTNAME,LASTNAME) values (50,'register','abc123','Reggae','Master');
Insert into BANK.BANK_USER (USER_ID,USERNAME,USER_PW,FIRSTNAME,LASTNAME) values (63,'bobby','bobby','Bob','Saget');
Insert into BANK.BANK_USER (USER_ID,USERNAME,USER_PW,FIRSTNAME,LASTNAME) values (76,'bobobobob','bob','bobob','bobob');
Insert into BANK.BANK_USER (USER_ID,USERNAME,USER_PW,FIRSTNAME,LASTNAME) values (7,'MOMONEY','ChaChing','Warren','Buffett');
--------------------------------------------------------
--  DDL for Index USER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "BANK"."USER_PK" ON "BANK"."BANK_USER" ("USER_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Trigger TR_INSERT_BANK_ACCOUNT
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "BANK"."TR_INSERT_BANK_ACCOUNT" 
BEFORE INSERT ON BANK_ACCOUNT
FOR EACH ROW
BEGIN
  SELECT SQ_BANK_ACCOUNT_PK.NEXTVAL INTO :new.BANK_ACCOUNT_ID FROM DUAL;
END;
/
ALTER TRIGGER "BANK"."TR_INSERT_BANK_ACCOUNT" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TR_INSERT_BANK_USER
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "BANK"."TR_INSERT_BANK_USER" 
BEFORE INSERT ON BANK_USER
FOR EACH ROW
BEGIN
  SELECT SQ_BANK_USER_PK.NEXTVAL INTO :new.USER_ID FROM DUAL;
END;
/
ALTER TRIGGER "BANK"."TR_INSERT_BANK_USER" ENABLE;
--------------------------------------------------------
--  Constraints for Table BANK_ACCOUNT
--------------------------------------------------------

  ALTER TABLE "BANK"."BANK_ACCOUNT" ADD PRIMARY KEY ("BANK_ACCOUNT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table BANK_USER
--------------------------------------------------------

  ALTER TABLE "BANK"."BANK_USER" ADD UNIQUE ("USERNAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "BANK"."BANK_USER" ADD CONSTRAINT "USER_PK" PRIMARY KEY ("USER_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BANK_ACCOUNT
--------------------------------------------------------

  ALTER TABLE "BANK"."BANK_ACCOUNT" ADD CONSTRAINT "BANK_ACCOUNT_FK" FOREIGN KEY ("USER_ID")
	  REFERENCES "BANK"."BANK_USER" ("USER_ID") ON DELETE CASCADE ENABLE;
