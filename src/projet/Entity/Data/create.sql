CREATE TABLE ABSENCE
(
  ID_ABSENCE      REAL NOT NULL,
  FROMDATE        REAL NOT NULL,
  TODATE          REAL NOT NULL,
  STUDENT_STUD_ID REAL
);
CREATE UNIQUE INDEX sqlite_autoindex_ABSENCE_1
  ON ABSENCE (ID_ABSENCE);
CREATE TABLE GROUPSTUDENTS
(
  ID_GROUPE REAL NOT NULL,
  NAME      TEXT NOT NULL
);
CREATE UNIQUE INDEX sqlite_autoindex_GROUPSTUDENTS_1
  ON GROUPSTUDENTS (ID_GROUPE);
CREATE TABLE NOTE
(
  ID_NOTE         REAL NOT NULL,
  COEF            REAL NOT NULL,
  GRADDINGSCALE   REAL NOT NULL,
  NAME            TEXT NOT NULL,
  VALUE           REAL NOT NULL,
  STUDENT_STUD_ID REAL
);
CREATE UNIQUE INDEX sqlite_autoindex_NOTE_1
  ON NOTE (ID_NOTE);
CREATE TABLE SEQUENCE
(
  SEQ_NAME  TEXT NOT NULL,
  SEQ_COUNT REAL
);
CREATE UNIQUE INDEX sqlite_autoindex_SEQUENCE_1
  ON SEQUENCE (SEQ_NAME);
CREATE TABLE STUDENT
(
  STUD_ID         REAL NOT NULL,
  FIRSTNAME       TEXT NOT NULL,
  LASTNAME        TEXT NOT NULL,
  GROUP_ID_GROUPE REAL
);
CREATE UNIQUE INDEX sqlite_autoindex_STUDENT_1
  ON STUDENT (STUD_ID);