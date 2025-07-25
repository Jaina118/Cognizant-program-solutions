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
