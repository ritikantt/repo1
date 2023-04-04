CREATE TABLE shipment(
shipment_id int NOT NULL,
order_id int NOT NULL,
shipment_date date NOT NULL,
shipment_address char(50) NOT NULL,
PRIMARY KEY (shipment_id)
);