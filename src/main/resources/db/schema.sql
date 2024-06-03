CREATE TABLE IF NOT EXISTS account_personal_data (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(128),
    email VARCHAR(128),
    city VARCHAR(128),
    phone_number VARCHAR(128),
    password VARCHAR(128) );

CREATE TABLE IF NOT EXISTS accounts (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(128),
    last_name VARCHAR(128),
    account_personal_data_id INT,
    FOREIGN KEY (account_personal_data_id) REFERENCES account_personal_data (id)
    );

CREATE TABLE IF NOT EXISTS products (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    image VARCHAR(128) NOT NULL,
    article VARCHAR(128),
    name VARCHAR(128),
    price DOUBLE,
    price_kg DOUBLE
    );

CREATE TABLE IF NOT EXISTS roles (
    id INT PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(128),
    account_personal_data_id INT,
    FOREIGN KEY (account_personal_data_id) REFERENCES account_personal_data(id)
    );

CREATE TABLE IF NOT EXISTS cart (
    id INT PRIMARY KEY AUTO_INCREMENT,
    product_id BIGINT NOT NULL,
    product_name VARCHAR(128),
    quantity INT,
    account_personal_data_id INT,
    FOREIGN KEY (product_id) REFERENCES products(id),
    FOREIGN KEY (account_personal_data_id) REFERENCES account_personal_data(id)
    );
