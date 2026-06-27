BEGIN

   FOR c IN (
      SELECT CustomerID
      FROM BANK_CUSTOMERS
      WHERE Balance > 10000
   )
   LOOP

      UPDATE BANK_CUSTOMERS
      SET IsVIP = 'TRUE'
      WHERE CustomerID = c.CustomerID;

   END LOOP;

   COMMIT;

   DBMS_OUTPUT.PUT_LINE('VIP customers updated successfully.');

END;
/
BEGIN

   FOR c IN (
      SELECT CustomerID
      FROM BANK_CUSTOMERS
      WHERE Age > 60
   )
   LOOP

      UPDATE BANK_LOANS
      SET InterestRate = InterestRate - 1
      WHERE CustomerID = c.CustomerID;

   END LOOP;

   COMMIT;

   DBMS_OUTPUT.PUT_LINE('Interest rates updated successfully.');

END;
/
BEGIN

   FOR c IN (
      SELECT CustomerID
      FROM BANK_CUSTOMERS
      WHERE Age > 60
   )
   LOOP

      UPDATE BANK_LOANS
      SET InterestRate = InterestRate - 1
      WHERE CustomerID = c.CustomerID;

   END LOOP;

   COMMIT;

   DBMS_OUTPUT.PUT_LINE('Interest rates updated successfully.');

END;
/
CREATE TABLE BANK_ACCOUNTS
(
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER(10,2)
);
INSERT INTO BANK_ACCOUNTS VALUES (1001,101,'SAVINGS',10000);
INSERT INTO BANK_ACCOUNTS VALUES (1002,102,'SAVINGS',15000);
INSERT INTO BANK_ACCOUNTS VALUES (1003,103,'CURRENT',20000);
INSERT INTO BANK_ACCOUNTS VALUES (1004,104,'SAVINGS',25000);

COMMIT;
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN

   UPDATE BANK_ACCOUNTS
   SET Balance = Balance + (Balance * 0.01)
   WHERE AccountType='SAVINGS';

   COMMIT;

END;
/
BEGIN
   ProcessMonthlyInterest;
END;
/
CREATE TABLE EMPLOYEES
(
    EmployeeID NUMBER PRIMARY KEY,
    EmployeeName VARCHAR2(50),
    Department VARCHAR2(30),
    Salary NUMBER(10,2)
);
INSERT INTO EMPLOYEES VALUES (1,'Amit','HR',40000);
INSERT INTO EMPLOYEES VALUES (2,'Neha','IT',50000);
INSERT INTO EMPLOYEES VALUES (3,'Rahul','IT',60000);
INSERT INTO EMPLOYEES VALUES (4,'Sneha','Finance',55000);

COMMIT;
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus
(
    p_department VARCHAR2,
    p_bonus NUMBER
)
AS
BEGIN

   UPDATE EMPLOYEES
   SET Salary = Salary + (Salary * p_bonus /100)
   WHERE Department = p_department;

   COMMIT;

END;
/
BEGIN
   UpdateEmployeeBonus('IT',10);
END;
/
CREATE OR REPLACE PROCEDURE TransferFunds
(
    p_source NUMBER,
    p_destination NUMBER,
    p_amount NUMBER
)
AS

v_balance NUMBER;

BEGIN

   SELECT Balance
   INTO v_balance
   FROM BANK_ACCOUNTS
   WHERE AccountID=p_source;

   IF v_balance >= p_amount THEN

      UPDATE BANK_ACCOUNTS
      SET Balance=Balance-p_amount
      WHERE AccountID=p_source;

      UPDATE BANK_ACCOUNTS
      SET Balance=Balance+p_amount
      WHERE AccountID=p_destination;

      COMMIT;

      DBMS_OUTPUT.PUT_LINE('Transfer Successful');

   ELSE

      DBMS_OUTPUT.PUT_LINE('Insufficient Balance');

   END IF;

END;
/
BEGIN
   TransferFunds(1001,1002,3000);
END;
/
SELECT * FROM BANK_ACCOUNTS;