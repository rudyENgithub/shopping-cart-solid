

INSERT INTO customers (address, name) VALUES ('san carlos, calle 2', 'Julian Alvarez');
INSERT INTO customers (address, name) VALUES ('san juan, calle 22', 'Jose Moran');

INSERT INTO products (title, price, category, description,image) VALUES ('camisas polo S', 15.50, 'ROPA', 'camisa', 'image.png');
INSERT INTO products (title, price, category, description,image) VALUES ('pantalones levis 514', 30.50, 'ROPA', 'pantalon', 'image.png');
INSERT INTO products (title, price, category, description,image) VALUES ('Boxer Tommy set 3', 20.50, 'ROPA', 'boxer', 'image.png');

INSERT INTO users (username, password, enabled, name, lastname, email) VALUES ('rudy','$2a$10$C3Uln5uqnzx/GswADURJGOIdBqYrly9731fnwKDaUdBkt/M3qvtLq',1, 'Rudy', 'Sorto','rudy@gruposites.com');
INSERT INTO users (username, password, enabled, name, lastname, email) VALUES ('admin','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK',1, 'Admin', 'Admin','admin@gruposites.com');

INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 1);


INSERT INTO orders (state, shippingdate, orderdate, customer_id, user_id) VALUES ( 'ORDENADO', '2022-12-12 15:24:51', '2022-12-10 15:24:51', 1, 1);
INSERT INTO orders ( state, shippingdate, orderdate, customer_id, user_id) VALUES ( 'ORDENADO', '2022-12-10 15:24:51', '2022-12-08 15:24:51', 2, 1);
INSERT INTO orders ( state, shippingdate, orderdate, customer_id, user_id) VALUES ('PAGADO', '2022-12-15 15:24:51', '2022-12-07 15:24:51', 2, 1);

INSERT INTO ordersdetail (quantity, price, order_id, product_id) VALUES (1, 25, 1,  1);
INSERT INTO ordersdetail (quantity, price, order_id, product_id) VALUES (2, 60, 1,  2);
INSERT INTO ordersdetail (quantity, price, order_id, product_id) VALUES (3, 40, 1,  3);

INSERT INTO ordersdetail (quantity, price, order_id, product_id) VALUES (3, 25, 2,  1);
INSERT INTO ordersdetail (quantity, price, order_id, product_id) VALUES (2, 40, 2,  3);

INSERT INTO ordersdetail (quantity, price, order_id, product_id) VALUES (5, 25, 3,  1);

INSERT INTO payments (paymentdate, method, amount, order_id) VALUES ('2022-12-16 15:24:51', 'TARJETA',  25, 3);



