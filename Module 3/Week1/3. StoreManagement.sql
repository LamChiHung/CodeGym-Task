-- create database StoreManagement;
-- use StoreManagement;

-- CREATE TABLE Customer (
--     cID INT PRIMARY KEY AUTO_INCREMENT,
--     cName VARCHAR(50) NOT NULL,
--     cAge INT
-- );

-- CREATE TABLE `Order` (
--     oID INT PRIMARY KEY AUTO_INCREMENT,
--     cID INT NOT NULL,
--     oDate DATETIME NOT NULL,
--     oTotalPrice FLOAT NOT NULL,
--     FOREIGN KEY (cID)
--         REFERENCES customer (cID)
-- );

-- CREATE TABLE product (
--     pID INT PRIMARY KEY AUTO_INCREMENT,
--     pName VARCHAR(50) NOT NULL,
--     pPrice FLOAT NOT NULL
-- );

-- CREATE TABLE orderdetail (
--     odID INT PRIMARY KEY AUTO_INCREMENT,
--     oID INT NOT NULL,
--     pID INT NOT NULL,
--     odQTY INT NOT NULL,
--     FOREIGN KEY (oID)
--         REFERENCES `Order` (oID),
--     FOREIGN KEY (pID)
--         REFERENCES Product (pID)
-- );

