-- Drop the table if it exists
DROP TABLE IF EXISTS book;

-- Create the BOOK table with an auto-increment ID
CREATE TABLE book (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    author VARCHAR(255),
    category VARCHAR(255)
);
