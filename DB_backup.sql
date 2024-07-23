--------------------------------------------------------
--  파일이 생성됨 - 화요일-7월-23-2024   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence FILEBOARD_NUM
--------------------------------------------------------

   CREATE SEQUENCE  "HOERI"."FILEBOARD_NUM"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 10 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence FREEBOARD_NUM
--------------------------------------------------------

   CREATE SEQUENCE  "HOERI"."FREEBOARD_NUM"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 11 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence QNABOARD_NUM
--------------------------------------------------------

   CREATE SEQUENCE  "HOERI"."QNABOARD_NUM"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 3 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Table FILE_BOARD
--------------------------------------------------------

  CREATE TABLE "HOERI"."FILE_BOARD" 
   (	"NUM" VARCHAR2(5 BYTE), 
	"ID" VARCHAR2(50 BYTE), 
	"TITLE" VARCHAR2(50 BYTE), 
	"CONTENT" VARCHAR2(2000 BYTE), 
	"POSTDATE" DATE DEFAULT sysdate, 
	"OFILE" VARCHAR2(50 BYTE), 
	"SFILE" VARCHAR2(30 BYTE), 
	"DOWNCOUNT" NUMBER(5,0) DEFAULT 0, 
	"VISITCOUNT" NUMBER DEFAULT 0
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table FREE_BOARD
--------------------------------------------------------

  CREATE TABLE "HOERI"."FREE_BOARD" 
   (	"NUM" VARCHAR2(5 BYTE), 
	"ID" VARCHAR2(50 BYTE), 
	"TITLE" VARCHAR2(50 BYTE), 
	"CONTENT" VARCHAR2(2000 BYTE), 
	"POSTDATE" DATE DEFAULT sysdate, 
	"OFILE" VARCHAR2(50 BYTE), 
	"SFILE" VARCHAR2(30 BYTE), 
	"DOWNCOUNT" NUMBER(5,0) DEFAULT 0, 
	"VISITCOUNT" NUMBER DEFAULT 0
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table MEMBER
--------------------------------------------------------

  CREATE TABLE "HOERI"."MEMBER" 
   (	"ID" VARCHAR2(10 BYTE), 
	"PASS" VARCHAR2(10 BYTE), 
	"NAME" VARCHAR2(30 BYTE), 
	"EMAIL" VARCHAR2(30 BYTE), 
	"PHONE" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table QNA_BOARD
--------------------------------------------------------

  CREATE TABLE "HOERI"."QNA_BOARD" 
   (	"NUM" VARCHAR2(5 BYTE), 
	"ID" VARCHAR2(50 BYTE), 
	"TITLE" VARCHAR2(50 BYTE), 
	"CONTENT" VARCHAR2(2000 BYTE), 
	"POSTDATE" DATE DEFAULT sysdate, 
	"VISITCOUNT" NUMBER DEFAULT 0
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into HOERI.FILE_BOARD
SET DEFINE OFF;
Insert into HOERI.FILE_BOARD (NUM,ID,TITLE,CONTENT,POSTDATE,OFILE,SFILE,DOWNCOUNT,VISITCOUNT) values ('5','hoeri','자료실 - 사진','사진 테스트입니다.',to_date('24/07/23','RR/MM/DD'),'다옹.jpg','20240723_95329149.jpg',0,4);
Insert into HOERI.FILE_BOARD (NUM,ID,TITLE,CONTENT,POSTDATE,OFILE,SFILE,DOWNCOUNT,VISITCOUNT) values ('6','hoeri','자료실 - 동영상','동영상 테스트입니다.',to_date('24/07/23','RR/MM/DD'),'윤슬.mp4','20240723_95342532.mp4',0,9);
Insert into HOERI.FILE_BOARD (NUM,ID,TITLE,CONTENT,POSTDATE,OFILE,SFILE,DOWNCOUNT,VISITCOUNT) values ('7','hoeri','자료실 - 음악','음악 테스트입니다.',to_date('24/07/23','RR/MM/DD'),'Bring_It_All_Back.mp3','20240723_95420166.mp3',0,5);
REM INSERTING into HOERI.FREE_BOARD
SET DEFINE OFF;
Insert into HOERI.FREE_BOARD (NUM,ID,TITLE,CONTENT,POSTDATE,OFILE,SFILE,DOWNCOUNT,VISITCOUNT) values ('10','hoeri','dddd','ddddd',to_date('24/07/23','RR/MM/DD'),'다옹.jpg','20240723_16398333.jpg',0,8);
Insert into HOERI.FREE_BOARD (NUM,ID,TITLE,CONTENT,POSTDATE,OFILE,SFILE,DOWNCOUNT,VISITCOUNT) values ('9','hoeri','자유게시판 - 사진','테스트입니다.',to_date('24/07/23','RR/MM/DD'),'도래.jpg','20240723_9571666.jpg',0,31);
Insert into HOERI.FREE_BOARD (NUM,ID,TITLE,CONTENT,POSTDATE,OFILE,SFILE,DOWNCOUNT,VISITCOUNT) values ('1','hoeri','자유게시판 1','첫번째 게시글입니다.',to_date('24/07/22','RR/MM/DD'),'도래.jpg','20240723_11321857.jpg',0,19);
Insert into HOERI.FREE_BOARD (NUM,ID,TITLE,CONTENT,POSTDATE,OFILE,SFILE,DOWNCOUNT,VISITCOUNT) values ('2','musthave','자유게시판 2','두번째 게시글입니다.',to_date('24/07/22','RR/MM/DD'),null,null,0,15);
REM INSERTING into HOERI.MEMBER
SET DEFINE OFF;
Insert into HOERI.MEMBER (ID,PASS,NAME,EMAIL,PHONE) values ('leehr','5825','횔','leehr@naver.com','010-0102-0102');
Insert into HOERI.MEMBER (ID,PASS,NAME,EMAIL,PHONE) values ('musthave','1234','머스트해브','musthave@naver.com','010-1234-1234');
Insert into HOERI.MEMBER (ID,PASS,NAME,EMAIL,PHONE) values ('hoeri','1212','횔투','hoeri12@naver.com','010-1212-1212');
REM INSERTING into HOERI.QNA_BOARD
SET DEFINE OFF;
Insert into HOERI.QNA_BOARD (NUM,ID,TITLE,CONTENT,POSTDATE,VISITCOUNT) values ('2','musthave','문의글 2','두번째 질문입니다.',to_date('24/07/23','RR/MM/DD'),6);
--------------------------------------------------------
--  DDL for Index SYS_C008428
--------------------------------------------------------

  CREATE UNIQUE INDEX "HOERI"."SYS_C008428" ON "HOERI"."MEMBER" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C008502
--------------------------------------------------------

  CREATE UNIQUE INDEX "HOERI"."SYS_C008502" ON "HOERI"."FREE_BOARD" ("NUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C008525
--------------------------------------------------------

  CREATE UNIQUE INDEX "HOERI"."SYS_C008525" ON "HOERI"."FILE_BOARD" ("NUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C008532
--------------------------------------------------------

  CREATE UNIQUE INDEX "HOERI"."SYS_C008532" ON "HOERI"."QNA_BOARD" ("NUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C008525
--------------------------------------------------------

  CREATE UNIQUE INDEX "HOERI"."SYS_C008525" ON "HOERI"."FILE_BOARD" ("NUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C008502
--------------------------------------------------------

  CREATE UNIQUE INDEX "HOERI"."SYS_C008502" ON "HOERI"."FREE_BOARD" ("NUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C008428
--------------------------------------------------------

  CREATE UNIQUE INDEX "HOERI"."SYS_C008428" ON "HOERI"."MEMBER" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C008532
--------------------------------------------------------

  CREATE UNIQUE INDEX "HOERI"."SYS_C008532" ON "HOERI"."QNA_BOARD" ("NUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table FILE_BOARD
--------------------------------------------------------

  ALTER TABLE "HOERI"."FILE_BOARD" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "HOERI"."FILE_BOARD" MODIFY ("TITLE" NOT NULL ENABLE);
  ALTER TABLE "HOERI"."FILE_BOARD" MODIFY ("CONTENT" NOT NULL ENABLE);
  ALTER TABLE "HOERI"."FILE_BOARD" MODIFY ("POSTDATE" NOT NULL ENABLE);
  ALTER TABLE "HOERI"."FILE_BOARD" MODIFY ("OFILE" NOT NULL ENABLE);
  ALTER TABLE "HOERI"."FILE_BOARD" MODIFY ("SFILE" NOT NULL ENABLE);
  ALTER TABLE "HOERI"."FILE_BOARD" MODIFY ("DOWNCOUNT" NOT NULL ENABLE);
  ALTER TABLE "HOERI"."FILE_BOARD" MODIFY ("VISITCOUNT" NOT NULL ENABLE);
  ALTER TABLE "HOERI"."FILE_BOARD" ADD PRIMARY KEY ("NUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table FREE_BOARD
--------------------------------------------------------

  ALTER TABLE "HOERI"."FREE_BOARD" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "HOERI"."FREE_BOARD" MODIFY ("TITLE" NOT NULL ENABLE);
  ALTER TABLE "HOERI"."FREE_BOARD" MODIFY ("CONTENT" NOT NULL ENABLE);
  ALTER TABLE "HOERI"."FREE_BOARD" MODIFY ("POSTDATE" NOT NULL ENABLE);
  ALTER TABLE "HOERI"."FREE_BOARD" MODIFY ("DOWNCOUNT" NOT NULL ENABLE);
  ALTER TABLE "HOERI"."FREE_BOARD" MODIFY ("VISITCOUNT" NOT NULL ENABLE);
  ALTER TABLE "HOERI"."FREE_BOARD" ADD PRIMARY KEY ("NUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table MEMBER
--------------------------------------------------------

  ALTER TABLE "HOERI"."MEMBER" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "HOERI"."MEMBER" MODIFY ("PASS" NOT NULL ENABLE);
  ALTER TABLE "HOERI"."MEMBER" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "HOERI"."MEMBER" MODIFY ("EMAIL" NOT NULL ENABLE);
  ALTER TABLE "HOERI"."MEMBER" MODIFY ("PHONE" NOT NULL ENABLE);
  ALTER TABLE "HOERI"."MEMBER" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table QNA_BOARD
--------------------------------------------------------

  ALTER TABLE "HOERI"."QNA_BOARD" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "HOERI"."QNA_BOARD" MODIFY ("TITLE" NOT NULL ENABLE);
  ALTER TABLE "HOERI"."QNA_BOARD" MODIFY ("CONTENT" NOT NULL ENABLE);
  ALTER TABLE "HOERI"."QNA_BOARD" MODIFY ("POSTDATE" NOT NULL ENABLE);
  ALTER TABLE "HOERI"."QNA_BOARD" MODIFY ("VISITCOUNT" NOT NULL ENABLE);
  ALTER TABLE "HOERI"."QNA_BOARD" ADD PRIMARY KEY ("NUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table FILE_BOARD
--------------------------------------------------------

  ALTER TABLE "HOERI"."FILE_BOARD" ADD CONSTRAINT "FILE_FK" FOREIGN KEY ("ID")
	  REFERENCES "HOERI"."MEMBER" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table QNA_BOARD
--------------------------------------------------------

  ALTER TABLE "HOERI"."QNA_BOARD" ADD CONSTRAINT "QNA_FK" FOREIGN KEY ("ID")
	  REFERENCES "HOERI"."MEMBER" ("ID") ENABLE;
