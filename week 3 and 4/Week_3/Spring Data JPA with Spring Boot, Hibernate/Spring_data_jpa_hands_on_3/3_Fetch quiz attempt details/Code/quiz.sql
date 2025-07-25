-- Create database
CREATE DATABASE quiz_app;
USE quiz_app;

-- User table
CREATE TABLE user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL
);

-- Question table
CREATE TABLE question (
    id INT PRIMARY KEY AUTO_INCREMENT,
    text VARCHAR(255) NOT NULL,
    score DECIMAL(5,2) NOT NULL
);

-- Options table
CREATE TABLE options (
    id INT PRIMARY KEY AUTO_INCREMENT,
    text VARCHAR(100) NOT NULL,
    is_correct BOOLEAN NOT NULL,
    question_id INT,
    FOREIGN KEY (question_id) REFERENCES question(id)
);

-- Attempt table
CREATE TABLE attempt (
    id INT PRIMARY KEY AUTO_INCREMENT,
    attempted_date DATETIME NOT NULL,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES user(id)
);

-- Attempt Question table
CREATE TABLE attempt_question (
    id INT PRIMARY KEY AUTO_INCREMENT,
    attempt_id INT,
    question_id INT,
    FOREIGN KEY (attempt_id) REFERENCES attempt(id),
    FOREIGN KEY (question_id) REFERENCES question(id)
);

-- Attempt Option table
CREATE TABLE attempt_option (
    id INT PRIMARY KEY AUTO_INCREMENT,
    attempt_question_id INT,
    option_id INT,
    selected BOOLEAN NOT NULL,
    FOREIGN KEY (attempt_question_id) REFERENCES attempt_question(id),
    FOREIGN KEY (option_id) REFERENCES options(id)
);


-- Users
INSERT INTO user (username) VALUES
('Meera'),
('Raju');

-- Questions
INSERT INTO question (text, score) VALUES
('What is the extension of the hyper text markup language file?', 1.0),
('What is the maximum level of heading tag in HTML?', 1.0);

-- Options
INSERT INTO options (text, is_correct, question_id) VALUES
('.xhtm', FALSE, 1),
('.ht', FALSE, 1),
('.html', TRUE, 1),
('.htmx', FALSE, 1),
('5', FALSE, 2),
('3', FALSE, 2),
('4', FALSE, 2),
('6', TRUE, 2);

-- Attempts
INSERT INTO attempt (attempted_date, user_id) VALUES
(NOW(), 1);

-- Attempt Questions
INSERT INTO attempt_question (attempt_id, question_id) VALUES
(1, 1),
(1, 2);

-- Attempt Options (simulate Alice selected options)
INSERT INTO attempt_option (attempt_question_id, option_id, selected) VALUES
(1, 3, TRUE), -- selected correct .html
(2, 8, TRUE); -- selected correct 6


