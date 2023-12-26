-- Active: 1702625852400@@127.0.0.1@3306@demo2006

-- Mức 1
-- 1. In ra các sản phẩm có số lượng từ 30 trở lên.
SELECT * FROM product WHERE product.quantity >= 30;

-- 2. In ra các sản phẩm có số lượng từ 30 trở lên và có giá trong khoảng 100 đến 200.
SELECT * FROM product WHERE product.quantity >= 30 AND product.price BETWEEN 100 AND 200; 

-- 3. In ra thông tin khách hàng tuổi lớn hơn 18
SELECT * FROM customer WHERE customer.age > 18;

-- 4. In ra thông tin khách hàng họ Nguyễn và lớn hơn 20 tuổi
SELECT * FROM customer WHERE customer.name LIKE "Nguyễn%" and customer.age > 20;

-- 5. In ra sản phẩm tên bắt đầu bằng chữ M
SELECT * FROM product WHERE product.name LIKE "M%";

-- 6.In ra sản phẩm kết thúc bằng chữ E
SELECT * FROM product WHERE product.name LIKE "%e";

-- 7.In ra danh sách sản phẩm số lượng tăng dần,
SELECT * FROM product ORDER BY quantity ASC;

-- 8. In ra danh sách sản phẩm giá giảm dần
SELECT * FROM product ORDER BY price DESC;

-- Mức 2
-- 1. In ra tên khách hàng và thời gian mua hàng.
SELECT customer.name, `order`.time FROM customer INNER JOIN `order` ON customer.id = `order`.`customerId`

-- 2. In ra tên khách hàng và tên sản phẩm đã mua
SELECT customer.name, product.name FROM customer INNER JOIN `order` ON customer.id = `order`.`customerId` INNER JOIN orderdetail on `order`.id = orderdetail.`orderId` INNER JOIN product ON orderdetail.`productId` = product.id;

-- 3. In ra thông tin hóa đơn và sản phẩm bán ra trong ngày 19/6/2006 và ngày 20/6/2006

SELECT `order`.*, product.name, orderdetail.quantity  FROM `order` INNER JOIN orderdetail on `order`.id = orderdetail.`orderId` INNER JOIN product ON orderdetail.`productId` = product.id 
WHERE `order`.time = '2006-6-19' or `order`.time = '2006-6-20'

-- Mức 3
-- 1. In ra tổng số lượng sản phẩm giá nhỏ hơn 300
SELECT COUNT(product.id) FROM product WHERE product.price <300;

-- 2. In tổng số sản phẩm theo từng giá
SELECT COUNT(product.id), product.price FROM product GROUP BY product.price ORDER BY product.price;

-- 3. In ra sản phẩm có giá cao nhất
SELECT product.name, product.price
FROM product
having product.price = (select MAX(product.price) FROM product);

-- 4. In ra giá trung bình của tất cả các sản phẩm
select AVG(product.price) from product;

-- 5. In ra tổng số tiền nếu bán hết tất cả sản phẩm.

SELECT SUM( product.price * product.quantity) from product;

-- 6. Tính tổng số sản phẩm giá <300.
select sum(product.id) FROM product WHERE product.price <300;

-- 7. Tìm giá bán cao nhất của các sản phẩm bắt đầu bằng chữ M.
select product.price, product.name FROM product HAVING product.name LIKE "M%" and product.price = (SELECT MAX(product.price) FROM product);

-- 8. Tìm giá bán thấp nhất của các sản phẩm bắt đầu bằng chữ M.
SELECT product.price, product.name FROM product HAVING product.name LIKE "M%" and product.price = (SELECT MIN(product.price) FROM product);

-- 9. Tìm giá bán trung bình của các sản phẩm bắt đầu bằng chữ M.
SELECT AVG(product.price) FROM product WHERE product.name LIKE "M%";

-- Mức 4
-- 8. Đếm số lần mua hàng của từng khách hàng
SELECT `order`.`customerId`, COUNT(`order`.id) FROM `order` GROUP BY `order`.`customerId`;

-- 9. Đếm số lượng hóa đơn theo từng tháng

select CONCAT(MONTH(`order`.time),"-", YEAR(`order`.time)) , COUNT(`order`.id) FROM `order` GROUP BY CONCAT(MONTH(`order`.time),"-", YEAR(`order`.time));


