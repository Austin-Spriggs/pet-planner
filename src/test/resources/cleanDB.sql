-- Disable foreign key checks
SET FOREIGN_KEY_CHECKS = 0;

-- Drop tables
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS family;

-- Create family table
CREATE TABLE family
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    familyName  VARCHAR(100) NOT NULL
);

-- Create users table
CREATE TABLE users
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(15)  NOT NULL,
    lastName  VARCHAR(20)  NOT NULL,
    email     VARCHAR(50)  NOT NULL,
    username  VARCHAR(15)  NOT NULL,
    familyId  INT NULL
);

-- Insert test data
INSERT INTO family (id, familyName)
VALUES (1, 'Spriggs Family');

INSERT INTO users (id, firstName, lastName, email, username, familyId)
VALUES (1, 'Austin', 'Spriggs', 'aspriggs@email.com', 'aspriggs', 1);

-- Add foreign key constraints
ALTER TABLE users
    ADD CONSTRAINT FK_family_id
        FOREIGN KEY (familyId) REFERENCES family(id) ON DELETE SET NULL;

-- Re-enable foreign key checks
SET FOREIGN_KEY_CHECKS = 1;