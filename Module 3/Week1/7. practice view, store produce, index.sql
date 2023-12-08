EXPLAIN SELECT * FROM customers WHERE customerName = 'Land of Toys Inc.'; 
ALTER TABLE customers ADD INDEX idx_customerName(customerName);

ALTER TABLE customers ADD INDEX idx_full_name(contactFirstName, contactLastName);

EXPLAIN SELECT * FROM customers WHERE contactFirstName = 'Jean' or contactFirstName = 'King';

DELIMITER //

CREATE PROCEDURE findAllCustomers()

BEGIN

  SELECT * FROM customers;

END //

DELIMITER ;

call findAllCustomers();

ALTER TABLE customers ADD INDEX idx_city (city);

EXPLAIN SELECT * FROM customers WHERE city = 'Las Vegas';

CREATE VIEW product_for_user AS 
(SELECT customers.customerName, customers.phone FROM customers);

SELECT * FROM product_for_user;

create or REPLACE VIEW product_for_user AS
SELECT customerName FROM customers;

DELIMITER //

CREATE PROCEDURE findAllCustomers()

BEGIN

  SELECT * FROM customers;

END //

DELIMITER ;

CALL findAllCustomers();

DELIMITER //

CREATE PROCEDURE findAllCustomerByID(IN id INT)

BEGIN

  SELECT * FROM customers WHERE customerNumber = id;

END //

DELIMITER ;

call findAllCustomerByID(131);