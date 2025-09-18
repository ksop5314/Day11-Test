insert into orders (order_number) values ('주문1');
insert into orders (order_number) values ('주문2');
insert into orders (order_number) values ('주문3');
insert into orders (order_number) values ('주문4');

insert into product (product_name, product_price, order_id) values ('상품1', 12000, 1);
insert into product (product_name, product_price, order_id) values ('상품2', 23000, 2);
insert into product (product_name, product_price, order_id) values ('상품3', 42000, 3);
insert into product (product_name, product_price, order_id) values ('상품4', 38000, 4);

insert into delivery (delivery_address, delivery_zipcode, order_id) values ('주소1', '12345', 1);
insert into delivery (delivery_address, delivery_zipcode, order_id) values ('주소2', '45643', 2);
insert into delivery (delivery_address, delivery_zipcode, order_id) values ('주소3', '32354', 3);
insert into delivery (delivery_address, delivery_zipcode, order_id) values ('주소4', '65543', 4);
