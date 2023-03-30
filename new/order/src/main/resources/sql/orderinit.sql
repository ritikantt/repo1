CREATE TABLE orders(
order_id int NOT NULL,
customer_id int NOT NULL,
cart_id int NOT NULL,
order_date date NOT NULL,
shipment_address char(50) NOT NULL,
PRIMARY KEY (order_id)
);