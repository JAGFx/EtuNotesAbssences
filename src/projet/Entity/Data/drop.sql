ALTER TABLE NOTE
  DROP CONSTRAINT FK_NOTE_STUDENT_STUD_ID;
ALTER TABLE STUDENT
  DROP CONSTRAINT FK_STUDENT_GROUP_ID_GROUPE;
DROP TABLE NOTE;
DROP TABLE GROUP;
DROP TABLE STUDENT;
