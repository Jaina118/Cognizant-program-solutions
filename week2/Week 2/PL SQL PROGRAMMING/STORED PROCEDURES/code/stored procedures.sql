-- Table for Savings Accounts
CREATE TABLE savings_acc (
    acc_id NUMBER PRIMARY KEY,
    acc_holder VARCHAR(50),
    balance NUMBER
);

INSERT INTO savings_acc VALUES (1,'Ram', 10000);
INSERT INTO savings_acc VALUES (2,'Rahul', 15000);
INSERT INTO savings_acc VALUES (3,'Ravi', 5000);
INSERT INTO savings_acc VALUES (4,'Kavya', 7500);
INSERT INTO savings_acc VALUES (5,'Ritu', 33000);
INSERT INTO savings_acc VALUES (6,'Disha', 25000);
COMMIT;



-- Table for Employees
CREATE TABLE employees (
    emp_id NUMBER PRIMARY KEY,
    emp_name VARCHAR2(50),
    salary NUMBER,
    department_id NUMBER
);

INSERT INTO employees VALUES (1, 'Rohit', 30000, 101);
INSERT INTO employees VALUES (2, 'Divya', 32000, 102);
INSERT INTO employees VALUES (3, 'Raju', 28000, 101);
INSERT INTO employees VALUES (4, 'Meena', 40000, 103);
INSERT INTO employees VALUES (5, 'Paul', 43000, 102);
COMMIT;




-- Stored Procedure 1: ProcessMonthlyInterest

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
UPDATE savings_acc
SET BALANCE = BALANCE + (BALANCE * 0.01); 
DBMS_OUTPUT.PUT_LINE('1% interest applied to all savings accounts !');
COMMIT;
END;
/
EXEC ProcessMonthlyInterest;




-- Stored Procedure 2: UpdateEmployeeBonus

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
deptId IN NUMBER,               
bonusPercent IN NUMBER
) IS
BEGIN
UPDATE employees
SET salary = salary + (salary * bonusPercent / 100)
WHERE department_id = deptId;
DBMS_OUTPUT.PUT_LINE(bonusPercent || '% bonus added to Department no. ' || deptId);
COMMIT;
END;
/
EXEC UpdateEmployeeBonus(102, 10);





-- Stored Procedure 3: Funds Transfer

CREATE OR REPLACE PROCEDURE TransferFunds(
source_acc_id IN NUMBER,
target_acc_id IN NUMBER,
amount IN NUMBER
) IS
source_balance NUMBER;
BEGIN

-- Step 1: Get source balance
SELECT balance INTO source_balance
FROM savings_acc
WHERE acc_id = source_acc_id;


-- Step 2: Check if enough funds are there
IF source_balance < amount THEN
DBMS_OUTPUT.PUT_LINE('Transfer failed: Insufficient balance in account ' || source_acc_id);
ELSE


-- Step 3: Deduct from source
UPDATE savings_acc
SET balance = balance - amount
WHERE acc_id = source_acc_id;


-- Step 4: Add to target
UPDATE savings_acc
SET balance = balance + amount
WHERE acc_id = target_acc_id;
DBMS_OUTPUT.PUT_LINE('₹' || amount || ' transferred from account ' || source_acc_id || ' to ' || target_acc_id);
COMMIT;
END IF;
END;
/
EXEC TransferFunds(1, 2, 3000);
EXEC TransferFunds(4, 6, 35000);

SHOW ERRORS PROCEDURE TransferFunds;

CREATE OR REPLACE PROCEDURE TransferFunds(
    source_acc_id IN NUMBER,
    target_acc_id IN NUMBER,
    amount         IN NUMBER
) IS
    source_balance NUMBER;
BEGIN
    -- Step 1: Get source account balance
    SELECT balance INTO source_balance
    FROM savings_acc
    WHERE acc_id = source_acc_id;

    -- Step 2: Check if sufficient funds
    IF source_balance < amount THEN
        DBMS_OUTPUT.PUT_LINE('Transfer failed: Insufficient balance in account ' || source_acc_id);
    ELSE
        -- Step 3: Deduct from source account
        UPDATE savings_acc
        SET balance = balance - amount
        WHERE acc_id = source_acc_id;

        -- Step 4: Add to target account
        UPDATE savings_acc
        SET balance = balance + amount
        WHERE acc_id = target_acc_id;

        DBMS_OUTPUT.PUT_LINE('₹' || amount || ' transferred from account ' || source_acc_id || ' to account ' || target_acc_id);
        COMMIT;
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Transfer failed: Account not found.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
END;
/

-- Recompile
SHOW ERRORS PROCEDURE TransferFunds;

-- Run test
EXEC TransferFunds(1, 2, 3000);    -- Should succeed
EXEC TransferFunds(4, 6, 35000);   -- Should fail: insufficient balance


SELECT * FROM savings_acc;
