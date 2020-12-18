CREATE DATABASE book_management

GO

USE book_management

GO

CREATE TABLE tblBook
(
	id VARCHAR(50) PRIMARY KEY,
	title VARCHAR(255),
	author VARCHAR(255),
	publishing VARCHAR(255),
	year INT,
	price FLOAT,
	dateType DATE,
)