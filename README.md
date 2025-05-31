

DB Details

CREATE TABLE emp_schema.Employee_Personal_Details (
    People_Soft_Id INT AUTO_INCREMENT PRIMARY KEY,
    EmpID VARCHAR(20) UNIQUE NOT NULL,
    First_Name VARCHAR(50) NOT NULL,
    Last_Name VARCHAR(50) NOT NULL,
    Date_Of_Birth DATE,
    Gender ENUM('Male', 'Female', 'Other'),
    Email VARCHAR(100) UNIQUE,
    Phone VARCHAR(20),
    Address TEXT,
    Created_At TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE emp_schema.Department (
    DepartmentID INT AUTO_INCREMENT PRIMARY KEY,
    Department_Name VARCHAR(100) NOT NULL UNIQUE,
    Location VARCHAR(100),
    Created_At TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE emp_schema.Employee_Details (
    DetailID INT AUTO_INCREMENT PRIMARY KEY,
    EmpID VARCHAR(20) NOT NULL,
    Join_Date DATE NOT NULL,
    Job_Title VARCHAR(100),
    Department_ID INT,
    Manager_Emp_ID VARCHAR(20),
    Created_At TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (EmpID) REFERENCES EmployeePersonalDetails(EmpID),
    FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID),
    FOREIGN KEY (ManagerEmpID) REFERENCES EmployeePersonalDetails(EmpID)
);

CREATE TABLE emp_schema.Employee_Salary_Details (
    SalaryID INT AUTO_INCREMENT PRIMARY KEY,
    EmpID VARCHAR(20) NOT NULL,
    Basic_Salary DECIMAL(10,2) NOT NULL,
    Bonus DECIMAL(10,2) DEFAULT 0.00,
    Deductions DECIMAL(10,2) DEFAULT 0.00,
    Effective_Date DATE NOT NULL,
    Created_At TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (EmpID) REFERENCES EmployeePersonalDetails(EmpID)
);

INSERT INTO emp_schema.Department (Department_Name, Location) VALUES
('VIP', 'Ayodhya'),
('Human Resources', 'kishkinda'),
('Engineering', 'Ayodhya'),
('Finance', 'Ayodhya');


INSERT INTO emp_schema.EmployeePersonalDetails (EmpID, First_Name, Last_Name, Date_Of_Birth, Gender, Email, Phone, Address)
VALUES
('EMP1001', 'Rama', 'Ayodhya', '1985-04-12', 'Male', 'john.ayodhya@example.com', '1234567890', '123 Main St, BharathaVarsh '),
('EMP1002', 'Lakshmana', 'Ayodhya', '1990-08-22', 'Male', 'lakshmana.ayodhya@example.com', '9876543210', '456 Elm St, BharathaVarsh'),
('EMP1003', 'Bharatha', 'Ayodhya', '1992-01-10', 'Male', 'bharatha.ayodhya@example.com', '1231231234', '789 Oak St, BharathaVarsh'),
('EMP1004', 'Sugriva', 'kishkinda', '1992-01-10', 'Male', 'sugriva.kishkinda@example.com', '1231231234', '789 Oak St, BharathaVarsh');

INSERT INTO emp_schema.EmployeeDetails (EmpID, JoinDate, JobTitle, DepartmentID, ManagerEmpID)
VALUES
('EMP1001', '2010-06-01', 'CEO', 1, NULL),
('EMP1002', '2015-09-15', 'Vice President', 1, 'EMP1003'),
('EMP1003', '2012-03-20', 'Director', 1, 'EMP1001'),
('EMP1004', '2012-03-20', 'Director', 1, 'EMP1001'),
('EMP1005', '2012-03-20', 'Engineering Lead', 3, 'EMP1001');

INSERT INTO emp_schema.EmployeeSalaryDetails (EmpID, BasicSalary, Bonus, Deductions, EffectiveDate)
VALUES
('EMP1001', 80000.00, 5000.00, 1000.00, '2023-01-01'),
('EMP1002', 70000.00, 3000.00, 800.00, '2023-02-01'),
('EMP1003', 90000.00, 7000.00, 1200.00, '2023-03-01'),
('EMP1004', 90000.00, 7000.00, 1200.00, '2023-03-01'),
('EMP1005', 90000.00, 7000.00, 1200.00, '2023-03-01');


select * from emp_schema.Employee_Personal_Details;

select * from emp_schema.Employee_details;

select * from emp_schema.Department;

select * from emp_schema.Employee_Details;

select * from emp_schema.Employee_Salary_Details;

