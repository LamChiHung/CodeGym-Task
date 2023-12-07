use studentmanagement;

INSERT INTO customer(cName, cAge) VALUES ('Minh Quan',10),('Ngoc Oanh',20),('Hong Ha',50);

INSERT INTO product(pName,pPrice) VALUES ('may giat', 3),('tu lanh',5),('dieu hoa',7),('quat',1),('bep dien',2);

ALTER TABLE `order` MODIFY oTotalPrice float NULL;

INSERT INTO `order` (cID, oDate) VALUES (1,'2006-3-21'),(2,'2006-3-23'),(1,'2006-3-16');

insert into orderdetail (oID,pID,odQTY) VALUES (1,1,3),(1,3,7),(1,4,2),(2,1,1),(3,1,8),(2,5,4),(2,3,3);

SELECT * FROM  customer;
SELECT * FROM  `order`;
SELECT * FROM  orderdetail;
SELECT * FROM  product;

UPDATE `order`
JOIN 
(SELECT orderdetail.oID, SUM( product.pPrice * orderdetail.odQTY) as totalPrice
	FROM orderdetail JOIN product ON orderdetail.pID = product.pID
	GROUP BY orderdetail.oID) as subquery on `order`.oID = subquery.oID
    set `order`.oTotalPrice = subquery.totalPrice;
    
 SELECT subject.subname FROM subject JOIN mark ON mark.subjectID = subject.subjectID
having SUM(mark.mark) >= All
(SELECT SUM(mark.mark) FROM mark);

SELECT subject.subname
FROM subject
JOIN mark ON mark.subjectID = subject.subjectID
GROUP BY subject.subjectID
HAVING SUM(mark.mark) >= ALL
(SELECT SUM(m.mark) FROM mark m GROUP BY m.subjectID);

USE studentmanagement;
SELECT subject.subname, SUM(mark.mark) AS sumMark
FROM subject JOIN mark ON subject.subjectID = mark.subjectID
GROUP BY subject.subjectID
having SUM(mark.mark) >= ALL
(SELECT SUM(mark.mark) FROM mark GROUP BY mark.subjectID);


SELECT subject.subname, SUM(mark.mark) AS sumMark
FROM subject
JOIN mark ON subject.subjectID = mark.subjectID
GROUP BY subject.subjectID
HAVING SUM(mark.mark) >= ALL (
    SELECT SUM(mark.mark)
    FROM mark
    GROUP BY mark.subjectID
);

SELECT student.studentName, avg(mark.mark) AS avrMark
FROM student JOIN mark ON student.studentID = mark.studentID
GROUP BY student.studentName
ORDER BY AVG(mark.mark) DESC
;