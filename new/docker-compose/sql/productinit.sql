CREATE TABLE discount(
discount_id int NOT NULL,
discount_percent int NOT NULL,
PRIMARY KEY (discount_id)
);

CREATE TABLE products(
product_id int NOT NULL,
product_name char(100) NOT NULL,
product_category char(30) NOT NULL,
product_description char(200) NOT NULL,
product_price int NOT NULL,
discount_id int NOT NULL,
product_available int NOT NULL,
PRIMARY KEY (product_id),
FOREIGN KEY (discount_id) REFERENCES discount(discount_id)
);

INSERT INTO discount(discount_id,discount_percent)
VALUES(100,0),
(102,2),
(105,5);

INSERT INTO products(product_id,product_name,product_category,product_description,product_price,discount_id,product_available)
VALUES(1001,'Lakme 9 to 5 Lipstick','Cosmetics','Pink Lipstick from Lakme',499,100,30),
(1002,'Sugar Lipstick','Cosmetics','Red Lipstick from Sugar',699,100,20),
(1003,'Colorbar Blush','Cosmetics','Pink Blush from Colorbar',399,100,20),
(1004,'Puma Tshirt','Clothing','Men Tshirt from Puma brand',2499,100,6),
(1005,'UCB Jeans','Clothing','Men Jeans from UCB',5999,100,50),
(1006,'UCB Tshirt','Clothing','Men Tshirt from UCB',1799,100,95),
(1007,'Bluetooth Speaker','Electronics','Bluetooth speaker from Boat brand',5999,100,17),
(1008,'Redmi Charger','Electronics','Mobile Charger from Redmi brand',899,100,33),
(1009,'Samsung Tablet','Electronics','Tablet from Samsung brand',9999,100,45),
(1010,'Apple Tablet','Electronics','Tab from Apple brand',12999,100,4090);


