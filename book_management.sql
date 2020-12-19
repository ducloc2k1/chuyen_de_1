CREATE DATABASE book_management

GO

USE book_management

GO

CREATE TABLE tblBook
(
	id VARCHAR(50) PRIMARY KEY,
	title NVARCHAR(255),
	author NVARCHAR(255),
	publishing NVARCHAR(255),
	year INT,
	price FLOAT,
	dateType DATE,
)

GO

INSERT INTO tblBook VALUES
('S001',N'Đế quốc Mỹ là con hổ giấy',N'Nguyễn viết Chung',N'Nói Phét',1955,35,'2018-05-31'),
('S002',N'Con Chim Xanh Biếc Bay Về',N'Nguyễn Nhật Ánh',N'Tiểu Thuyết',2020,103.900,'2018-05-31'),
('S003',N'Tiệm Sách Cơn Mưa',N' Rieko Hinata',N'Tiểu Thuyết',2019,49.600,'2018-05-31'),
('S004',N'Nỗi Đau Rồi Sẽ Qua Đi',N'Laura Tims',N'Tiểu Thuyết',2020,65.200 ,'2018-05-31'),
('S005',N'Kiêu Hãnh Và Định Kiến',N'Jane Austen',N'Tác phẩm kinh điển',2017,57.000 ,'2018-05-31')

GO

CREATE PROC ListAllBook
AS
BEGIN 
	SELECT * FROM tblBook
END

GO 

CREATE PROC FindById
@id VARCHAR(50)
AS
BEGIN
	SELECT * FROM tblBook WHERE id = @id
END

GO 

CREATE PROC UpdateBook
	@id VARCHAR(50),
	@title NVARCHAR(255),
	@author NVARCHAR(255),
	@publishing NVARCHAR(255),
	@year INT,
	@price FLOAT,
	@dateType DATE
AS
BEGIN 
	UPDATE tblBook
	SET 
		title = @title,
		author = @author,
		publishing = @publishing,
		year = @year,
		price = @price,
		dateType = @dateType
	WHERE id = @id
END

GO

CREATE PROC RemoveBook
@id VARCHAR(50)
AS
BEGIN 
	DELETE  FROM tblBook WHERE id = @id
END

GO
	