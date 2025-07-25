
CREATE TABLE skill (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

-- (many-to-many relationship)
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
('Amit Sharma', 60000.00, TRUE, '1990-05-15', 1), -- HR
('Priya Verma', 55000.00, FALSE, '1988-07-20', 2), -- Finance
('Rohan Mehta', 75000.00, TRUE, '1992-03-10', 3), -- IT
('Sneha Iyer', 80000.00, TRUE, '1995-12-01', 4); -- Operations

-- Insert skills
INSERT INTO skill (name) VALUES ('Java');
INSERT INTO skill (name) VALUES ('Spring Boot');
INSERT INTO skill (name) VALUES ('Hibernate');
INSERT INTO skill (name) VALUES ('SQL');
INSERT INTO skill (name) VALUES ('Python');


INSERT INTO employee_skill (employee_id, skill_id) VALUES (1, 1); -- Amit Sharma knows Java
INSERT INTO employee_skill (employee_id, skill_id) VALUES (1, 4); -- Amit Sharma knows SQL
INSERT INTO employee_skill (employee_id, skill_id) VALUES (2, 5); -- Priya Verma knows Python
INSERT INTO employee_skill (employee_id, skill_id) VALUES (3, 1); -- Rohan Mehta knows Java
INSERT INTO employee_skill (employee_id, skill_id) VALUES (3, 2); -- Rohan Mehta knows Spring Boot
INSERT INTO employee_skill (employee_id, skill_id) VALUES (3, 3); -- Rohan Mehta knows Hibernate
INSERT INTO employee_skill (employee_id, skill_id) VALUES (4, 2); -- Sneha Iyer knows Spring Boot
INSERT INTO employee_skill (employee_id, skill_id) VALUES (4, 3); -- Sneha Iyer knows Hibernate
INSERT INTO employee_skill (employee_id, skill_id) VALUES (4, 4); -- Sneha Iyer knows SQL
