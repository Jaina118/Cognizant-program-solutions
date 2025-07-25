-- Table: department
CREATE TABLE department (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

-- Table: employee
CREATE TABLE employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    salary DECIMAL(10,2) NOT NULL,
    permanent BOOLEAN DEFAULT FALSE,
    date_of_birth DATE,
    department_id INT,
    CONSTRAINT fk_department FOREIGN KEY (department_id) REFERENCES department(id)
);

-- Table: skill
CREATE TABLE skill (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

-- Table: employee_skill (many-to-many relationship)
CREATE TABLE employee_skill (
    employee_id INT,
    skill_id INT,
    PRIMARY KEY(employee_id, skill_id),
    CONSTRAINT fk_employee FOREIGN KEY (employee_id) REFERENCES employee(id),
    CONSTRAINT fk_skill FOREIGN KEY (skill_id) REFERENCES skill(id)
);

INSERT INTO department (name) VALUES ('HR');
INSERT INTO department (name) VALUES ('Finance');
INSERT INTO department (name) VALUES ('IT');
INSERT INTO department (name) VALUES ('Operations');

INSERT INTO employee (name, salary, permanent, date_of_birth, department_id)
VALUES 
('Amit Sharma', 60000.00, TRUE, '1990-05-15', 1),
('Priya Verma', 55000.00, FALSE, '1988-07-20', 2),
('Rohan Mehta', 75000.00, TRUE, '1992-03-10', 3),
('Sneha Iyer', 80000.00, TRUE, '1995-12-01', 4);

