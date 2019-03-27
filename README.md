You can check out version deployed on local server through web on https://f95622fc.ngrok.io . Here is "manager" : login Antonio ; password Ant555 ; Here is "customer" : login Poland ; password Rol111 ;

In order to run this application from command line - java path variable is requiered.

Open(cmd) command line, then go into project repository through cmd. To generate jar file type out command in cmd: mvnw package. After that in order to start the application type this command: java -jar target/Rental-0.0.1-SNAPSHOT.jar

The project requieres access to PostgreSQL database. Sequence of generating database schema:

CREATE TABLE car_rental.users( id BIGINT PRIMARY KEY, name VARCHAR(30), password VARCHAR(30), role VARCHAR(8), status VARCHAR(12), email VARCHAR(30) ); CREATE TABLE car_rental.cars( id BIGINT PRIMARY KEY , model VARCHAR(30), mark VARCHAR(30), car_class VARCHAR(12), cost INT ); CREATE TABLE car_rental.orders( id BIGINT PRIMARY KEY , userId BIGINT, driver VARCHAR(30), bill INT, status VARCHAR(15), start_date DATE, end_date DATE, FOREIGN KEY(userId) REFERENCES car_rental.users(id) ON DELETE SET NULL ); CREATE TABLE car_rental.order_items( order_id BIGINT, car_id BIGINT, PRIMARY KEY(order_id, car_id), FOREIGN KEY(order_id) REFERENCES car_rental.orders(id) ON DELETE CASCADE, FOREIGN KEY(car_id) REFERENCES car_rental.cars(id) ON DELETE CASCADE ); CREATE TABLE car_rental.feedback( id BIGINT PRIMARY KEY, text_field VARCHAR(128), rating INT, user_name VARCHAR(32) );

-- Adding new users -- INSERT INTO car_rental.users VALUES(1,'Garry', 'Sed111' , 'admin' , 'confirmed', 'garry@mail.com' ); INSERT INTO car_rental.users VALUES(2,'Johny', 'Ba7777' , 'manager' , 'confirmed', 'johny@mail.com' ); INSERT INTO car_rental.users VALUES(3,'Daniel', '789oP' , 'user' , 'confirmed', 'dan@mail.com' ); INSERT INTO car_rental.users VALUES(4,'Steve', 'Cvr123' , 'user' , 'unconfirmed', 'steve@mail.com' );

--Inserting new cars -- INSERT INTO car_rental.cars VALUES(1, 'mustang', 'ford', 'sedan', '250'); INSERT INTO car_rental.cars VALUES(2, 'golf', 'volkswagen', 'hatchback', '150'); INSERT INTO car_rental.cars VALUES(3, 'X6', 'bmw', 'crossover', '300'); INSERT INTO car_rental.cars VALUES(4, 'camry', 'toyota', 'sedan', '250'); INSERT INTO car_rental.cars VALUES(5, 'cayen', 'porsche', 'crossover', '350');

-- Adding new order -- INSERT INTO car_rental.orders VALUES(1,3,'no', 1350 ,'requested', '2018-12-04', '2018-12-07');

--Adding order items -- INSERT INTO car_rental.order_items VALUES( 1,2); INSERT INTO car_rental.order_items VALUES( 1,3);

-- Adding new order -- INSERT INTO car_rental.orders VALUES(2,3,'yes', 2000 ,'requested', '2019-01-07', '2018-01-09');

--Adding order items -- INSERT INTO car_rental.order_items VALUES( 2,1); INSERT INTO car_rental.order_items VALUES( 2,4); INSERT INTO car_rental.order_items VALUES( 2,5);
