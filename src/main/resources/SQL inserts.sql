
-- Adding new users --
INSERT INTO car_rental.users VALUES(1,'Garry', 'Sed111' , 'admin' , 'confirmed', 'garry@mail.com' );
INSERT INTO car_rental.users VALUES(2,'Johny', 'Ba7777' , 'manager' , 'confirmed', 'johny@mail.com' );
INSERT INTO car_rental.users VALUES(3,'Daniel', '789oP' , 'user' , 'confirmed', 'dan@mail.com' );
INSERT INTO car_rental.users VALUES(4,'Steve', 'Cvr123' , 'user' , 'unconfirmed', 'steve@mail.com' );

--Inserting new cars --
INSERT INTO car_rental.cars VALUES(1, 'mustang', 'ford', 'sedan', '250');
INSERT INTO car_rental.cars VALUES(2, 'golf', 'volkswagen', 'hatchback', '150');
INSERT INTO car_rental.cars VALUES(3, 'X6', 'bmw', 'crossover', '300');
INSERT INTO car_rental.cars VALUES(4, 'camry', 'toyota', 'sedan', '250');
INSERT INTO car_rental.cars VALUES(5, 'cayen', 'porsche', 'crossover', '350');

-- Adding new order --
INSERT INTO car_rental.orders VALUES(1,3,'no', 1350 ,'requested', '2018-12-04', '2018-12-07');

--Adding order items --
INSERT INTO car_rental.order_items VALUES( 1,2);
INSERT INTO car_rental.order_items VALUES( 1,3);


-- Adding new order --
INSERT INTO car_rental.orders VALUES(2,3,'yes', 2000 ,'requested', '2019-01-07', '2018-01-09');

--Adding order items --
INSERT INTO car_rental.order_items VALUES( 2,1);
INSERT INTO car_rental.order_items VALUES( 2,4);
INSERT INTO car_rental.order_items VALUES( 2,5);