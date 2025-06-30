CREATE TABLE customers (
    customer_id NUMBER,
    c_name VARCHAR2(50),
    age NUMBER,
    interest_rate NUMBER
);

INSERT INTO customers VALUES (1, 'Ram', 62, 7.5);
INSERT INTO customers VALUES (2, 'Sneha', 45, 6.9);
INSERT INTO customers VALUES (3, 'Jacob', 67, 8.0);
INSERT INTO customers VALUES (4, 'Rahul', 60, 5.0);
INSERT INTO customers VALUES (5, 'Ria', 55, 8.0);
INSERT INTO customers VALUES (6, 'Ryan', 23, 9.0);
INSERT INTO customers VALUES (7, 'Ben', 70, 5.2);
INSERT INTO customers VALUES (8, 'John', 58, 6.5);
INSERT INTO customers VALUES (9, 'Sunil', 35, 4.5);
COMMIT;

--scenario 1--

BEGIN
FOR cust IN (SELECT * FROM customers) LOOP
IF cust.age > 60 THEN
UPDATE customers
SET interest_rate = interest_rate - 1
WHERE customer_id = cust.customer_id;
END IF;
END LOOP;
COMMIT;
END;
/

-- Scenario 2--
ALTER TABLE customers ADD (balance NUMBER);
ALTER TABLE customers ADD (is_vip VARCHAR2(5));

UPDATE customers SET balance = 15000 WHERE customer_id = 1;
UPDATE customers SET balance = 9000 WHERE customer_id = 4;  
UPDATE customers SET balance = 22000 WHERE customer_id = 5;
UPDATE customers SET balance = 3000 WHERE customer_id = 7; 
COMMIT;


BEGIN
FOR cust IN (SELECT * FROM customers) LOOP
IF cust.balance > 10000 THEN
UPDATE customers
SET is_vip = 'TRUE'
WHERE customer_id = cust.customer_id;
END IF;
END LOOP;
COMMIT;
END;
/

--scenario 3--

UPDATE customers SET due = 10 WHERE customer_id = 8;
UPDATE customers SET due = 5 WHERE customer_id = 3;  
UPDATE customers SET due = 25 WHERE customer_id = 2;

BEGIN
FOR cust IN (SELECT * FROM customers) LOOP
IF cust.due <= 30 THEN
DBMS_OUTPUT.PUT_LINE('Reminder: Loan for ' || cust.c_name || ' is due in ' || cust.due || ' days.');
END IF;
END LOOP;
END;
/






