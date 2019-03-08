CREATE TABLE car_rental.users(
	id BIGINT PRIMARY KEY,
	name VARCHAR(30),
	password VARCHAR(30),
	role VARCHAR(8),
	status VARCHAR(12),
	email VARCHAR(30)
);
CREATE TABLE car_rental.cars(
	id BIGINT PRIMARY KEY ,
	model VARCHAR(30),
	mark VARCHAR(30),
	car_class VARCHAR(12),
	cost INT		
);
CREATE TABLE car_rental.orders(
	id BIGINT PRIMARY KEY ,
	userId BIGINT,
	driver VARCHAR(30),
	bill INT,
	status VARCHAR(15),
	start_date DATE,
	end_date DATE,
	FOREIGN KEY(userId) REFERENCES car_rental.users(id) ON DELETE SET NULL
);
CREATE TABLE car_rental.order_items(
	order_id BIGINT,
	car_id BIGINT,
	PRIMARY KEY(order_id, car_id),
	FOREIGN KEY(order_id) REFERENCES car_rental.orders(id) ON DELETE CASCADE,
	FOREIGN KEY(car_id) REFERENCES car_rental.cars(id) ON DELETE CASCADE
);
CREATE TABLE car_rental.feedback(
	id BIGINT PRIMARY KEY,
	text_field VARCHAR(128),
	rating INT,
	user_name VARCHAR(32)	
);