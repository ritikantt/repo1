CREATE TABLE customer(
customer_id int NOT NULL,
customer_name char(50) NOT NULL,
PRIMARY KEY (customer_id)
);

CREATE TABLE customercart(
cart_id int NOT NULL,
customer_id int NOT NULL UNIQUE,
PRIMARY KEY (cart_id)
);


CREATE TABLE shoppingcart(
cart_id int NOT NULL,
product_id int NOT NULL,
product_quantity int NOT NULL,
CONSTRAINT PK_cart PRIMARY KEY (cart_id,product_id)
);

INSERT INTO customer(customer_id,customer_name)
VALUES(555,'Ritika'),
(666,'Shafiq');


