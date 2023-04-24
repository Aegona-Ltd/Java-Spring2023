CREATE TABLE users(
    id int not null AUTO_INCREMENT,
    email varchar(145),
    password varchar(145),
    fullname varchar(145),
    phone varchar(145),
    primary key (id)
);

CREATE TABLE contact(
    id int not null AUTO_INCREMENT,
    email varchar(255),
    message varchar(255),
    name varchar(10),
    subject varchar(255),
    primary key (id)
);

CREATE TABLE manufacturer(
    manufacturer_id int not null AUTO_INCREMENT,
    name varchar(45),
    primary key (manufacturer_id)
);

CREATE TABLE product(
    product_id int not null AUTO_INCREMENT,
    manufacturer_id int not null,
    name varchar(45),
    primary key (product_id),
    FOREIGN KEY (manufacturer_id) REFERENCES manufacturer(manufacturer_id)
);

CREATE TABLE category_description(
    category_description_id int not null AUTO_INCREMENT,
    name varchar(45),
    primary key (category_description_id)
);

CREATE TABLE category(
    category_id int not null AUTO_INCREMENT,
    category_description_id int not null,
    image varchar(255),
    primary key (category_id),
    FOREIGN KEY (category_description_id) REFERENCES category_description(category_description_id)
);

CREATE TABLE product_category(
	id int not null AUTO_INCREMENT,
    product_id int not null,
    category_id int not null,
	primary key (id),
	FOREIGN KEY (product_id) REFERENCES product(product_id),
	FOREIGN KEY (category_id) REFERENCES category(category_id)
);