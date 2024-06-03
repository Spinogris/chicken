CREATE TABLE IF NOT EXISTS 'account_personal_data' (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(128) NULL,
    email VARCHAR(128) NULL,
    city VARCHAR(128) NULL,
    phone_number VARCHAR(128) NULL,
    password VARCHAR(128) NULL);

CREATE TABLE IF NOT EXISTS 'accounts' (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(128),
    last_name VARCHAR(128),
    account_personal_data_id INT,
    FOREIGN KEY (account_personal_data_id) REFERENCES account_personal_data (id)
    );

-- CREATE TABLE IF NOT EXISTS products (
--     id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
--     image VARCHAR(128) NOT NULL,
--     article VARCHAR(128) NULL,
--     name VARCHAR(128) NULL,
--     price DOUBLE NULL,
--     price_kg DOUBLE NULL
--     );
--
-- CREATE TABLE IF NOT EXISTS roles (
--     id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
--     role_name VARCHAR(128) NULL,
--     account_personal_data_id INT,
--     FOREIGN KEY (account_personal_data_id) REFERENCES account_personal_data(id)
--     );
--
-- CREATE TABLE IF NOT EXISTS cart (
--     id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
--     product_id BIGINT NOT NULL,
--     product_name VARCHAR(128) NULL,
--     quantity INT NULL,
--     account_personal_data_id INT,
--     FOREIGN KEY (product_id) REFERENCES products(id),
--     FOREIGN KEY (account_personal_data_id) REFERENCES account_personal_data(id)
--     );
