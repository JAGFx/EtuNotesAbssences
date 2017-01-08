CREATE TABLE NOTE (
  ID_NOTE         NUMBER(10)    NOT NULL,
  VALUE           NUMBER(12, 5) NOT NULL,
  STUDENT_STUD_ID NUMBER(10),
  PRIMARY KEY (ID_NOTE)
);
CREATE TABLE GROUP (
  ID_GROUPE NUMBER(10) NOT NULL,
  NAME      VARCHAR    NOT NULL UNIQUE,
  PRIMARY KEY (ID_GROUPE)
);
CREATE TABLE STUDENT (
  STUD_ID         NUMBER(10) NOT NULL,
  FIRSTNAME       VARCHAR    NOT NULL,
  LASTNAME        VARCHAR    NOT NULL,
  GROUP_ID_GROUPE NUMBER(10),
  PRIMARY KEY (STUD_ID)
);
ALTER TABLE NOTE
  ADD CONSTRAINT FK_NOTE_STUDENT_STUD_ID FOREIGN KEY (STUDENT_STUD_ID) REFERENCES STUDENT (STUD_ID);
ALTER TABLE STUDENT
  ADD CONSTRAINT FK_STUDENT_GROUP_ID_GROUPE FOREIGN KEY (GROUP_ID_GROUPE) REFERENCES GROUP (ID_GROUPE);
CREATE TABLE SEQUENCE (
  SEQ_NAME  VARCHAR(50) NOT NULL,
  SEQ_COUNT NUMBER(19),
  PRIMARY KEY (SEQ_NAME)
);

INSERT INTO SEQUENCE (SEQ_NAME, SEQ_COUNT) VALUES ('SEQ_GEN_IDENTITY', 0);
INSERT INTO SEQUENCE (SEQ_NAME, SEQ_COUNT) VALUES ('SEQ_GEN', 0);
