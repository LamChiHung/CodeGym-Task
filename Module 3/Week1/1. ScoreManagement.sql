-- CREATE DATABASE TestScoreManagement; 

USE TestScoreManagement;

CREATE TABLE Student(
studentID VARCHAR(20) PRIMARY KEY,
studentName VARCHAR(50),
dayOfBirth DATE,
class VARCHAR(20),
gender VARCHAR(20)
);

CREATE TABLE Subject(
subjectID VARCHAR(20) PRIMARY KEY,
subjectName VARCHAR(50),
teacherID VARCHAR(20)
);

CREATE TABLE ScoreBoard(
studentID VARCHAR(20),
subjectID VARCHAR(20),
score INT,
testDate DATETIME,
PRIMARY KEY (studentID, subjectID)
);

CREATE TABLE Teacher(
teacherID VARCHAR(20) PRIMARY KEY,
teacherName VARCHAR(50),
phoneNumber VARCHAR(10)
);

ALTER TABLE Subject ADD CONSTRAINT FK_teacherID FOREIGN KEY (teacherID) REFERENCES Teacher(teacherID);

ALTER TABLE Teacher ADD COLUMN subjectID VARCHAR(20);
ALTER TABLE Teacher ADD CONSTRAINT FK_subjectID FOREIGN KEY (subjectID) REFERENCES Subject(subjectID);