CREATE TABLE IF NOT EXISTS account_personal_data (
                                                     id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                                     name VARCHAR(128) NULL,
    email VARCHAR(128) NULL,
    city VARCHAR(128) NULL,
    phone_number VARCHAR(128) NULL,
    password VARCHAR(128) NULL
    );

CREATE TABLE IF NOT EXISTS accounts (
                                        id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                        first_name VARCHAR(128) NULL,
    last_name VARCHAR(128) NULL,
    account_personal_data_id INT,
    FOREIGN KEY (account_personal_data_id) REFERENCES account_personal_data(id)
    );

CREATE TABLE IF NOT EXISTS products (
                                        id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                        image VARCHAR(128) NOT NULL,
    article VARCHAR(128) NULL,
    name VARCHAR(128) NULL,
    price DOUBLE NULL,
    price_kg DOUBLE NULL
    );

CREATE TABLE IF NOT EXISTS roles (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(128) NOT NULL,
    account_personal_data_id INT,
    FOREIGN KEY (account_personal_data_id) REFERENCES account_personal_data(id)
    );

-- Создание таблицы "cart" с внешним ключом product_id и связью с таблицей account_personal_data
CREATE TABLE IF NOT EXISTS cart (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    product_id BIGINT NOT NULL,
    product_name VARCHAR(128) NULL,
    quantity INT NULL,
    account_personal_data_id INT,
    FOREIGN KEY (product_id) REFERENCES products(id),
    FOREIGN KEY (account_personal_data_id) REFERENCES account_personal_data(id)
    );


-- ==============================================================================================

-- Таблица "account_personal_data"
INSERT INTO account_personal_data (id, name, email, city, phone_number, password)
VALUES
    (1, 'Ivan', 'ivan@example.com', 'Altötting', '+7 (123) 456-78-90', 'password123'),
    (2, 'Petr', 'petr@example.com', 'Garching', '+7 (987) 654-32-10', 'qwerty456'),
    (3, 'Maria', 'maria@example.com', 'Traunreut', '+7 (111) 222-33-44', 'securepass123');

-- Таблица "accounts"
INSERT INTO accounts (id, first_name, last_name, account_personal_data_id)
VALUES
    (1, 'Ivan', 'Ivanov', 1),
    (2, 'Petr', 'Petrov', 2),
    (3, 'Maria', 'Sidorova', 3);

-- Таблица "products"
INSERT INTO products (id, image, article, name, price, price_kg)
VALUES
    (1, 'chicken.jpg', 'CHI001', 'Курица целиком', 5.99, 3.50),
    (2, 'chicken_wings.jpg', 'CHI002', 'Крылья куриные', 3.49, NULL),
    (3, 'chicken_breast.jpg', 'CHI003', 'Грудка куриная', 7.99, 5.00),
    (4, 'chicken_legs.jpg', 'CHI004', 'Ножки куриные', 2.99, NULL),
    (5, 'chicken_thighs.jpg', 'CHI005', 'Бедра куриные', 4.49, NULL),
    (6, 'chicken_fillets.jpg', 'CHI006', 'Филе куриное', 8.99, 6.50),
    (7, 'whole_duck.jpg', 'DUC001', 'Утка целиком', 12.99, 9.00),
    (8, 'duck_legs.jpg', 'DUC002', 'Ножки утиные', 6.99, NULL),
    (9, 'duck_breast.jpg', 'DUC003', 'Грудка утиная', 10.49, NULL),
    (10, 'turkey_whole.jpg', 'TUR001', 'Индейка целиком', 15.99, 11.50);

-- Таблица "roles"
INSERT INTO roles (id, role_name, account_personal_data_id)
VALUES
    (1, 'ROLE_USER', 3),
    (2, 'ROLE_ADMIN', 1),
    (3, 'ROLE_MANAGER', 2);

-- Таблица "cart"
-- Заполнение не требуется, так как она будет заполняться пользователями.



