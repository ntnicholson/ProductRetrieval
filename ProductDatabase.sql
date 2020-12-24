Create table Product
(productID bigint auto_increment,
name Varchar(255),
price double
);

Insert into Product (name, price) Values ('Shirt', 10.00);
Insert into Product (name, price) Values ('Shoes', 20.25);
Insert into Product (name, price) Values ('Candy', 2.18);
Insert into Product (name, price) Values ('Bread', 3.45);

Select * from Product;
Drop table Product;