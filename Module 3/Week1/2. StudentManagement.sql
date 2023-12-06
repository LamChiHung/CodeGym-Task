CREATE DATABASE StudentManagement;
USE StudentManagement;
CREATE TABLE Class(
	classID INT PRIMARY KEY AUTO_INCREMENT,
    className VARCHAR(60) NOT NULL,
    startDate DATETIME NOT NULL,
    status BOOLEAN
);

CREATE TABLE Student (
    studentID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    studentName VARCHAR(30) NOT NULL,
    address VARCHAR(50),
    phone VARCHAR(20),
    status BOOLEAN,
    classID INT,
    FOREIGN KEY (classID) REFERENCES Class(classID)
);

CREATE TABLE Subject (
    subjectID INT PRIMARY KEY AUTO_INCREMENT,
    subname VARCHAR(30) NOT NULL,
    credit TINYINT NOT NULL CHECK (credit >= 1),
    status BOOLEAN DEFAULT TRUE
);

create table Mark(
markID int PRIMARY key AUTO_INCREMENT,
subjectID int NOT NULL,
studentID int not NULL,
mark FLOAT DEFAULT 0 CHECK(mark BETWEEN 0 and 100),
examTimes TINYINT DEFAULT 1,
UNIQUE(subjectID, studentID),
FOREIGN KEY (subjectID) REFERENCES Subject(subjectID),
FOREIGN KEY (studentID) REFERENCES Student(studentID)
);
