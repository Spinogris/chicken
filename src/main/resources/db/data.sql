create table IF NOT EXISTS accounts (
    id           int not null primary key,
    first_name   varchar(128) null,
    last_name    varchar(128) null
);

create table IF NOT EXISTS account_info (
    id int not null primary key,
    name         varchar(128) null,
    email        varchar(128) null,
    city         varchar(128) null,
    phone_number varchar(128) null,
    password     varchar(128) null
);

create table IF NOT EXISTS products (
    id          bigint not null primary key,
    image       varchar(128) not null,
    article     varchar(128) null,
    name        varchar(128) null,
    price       double null,
    price_kg    double null
);

create table IF NOT EXISTS roles (
    id          int not null primary key,
    role_name   varchar(128) null
);

-- Создание таблицы "cart" с внешним ключом product_id и связью с таблицей account_info
CREATE TABLE IF NOT EXISTS cart (
    id              INT NOT NULL PRIMARY KEY,
    product_id      BIGINT NOT NULL,
    product_name    VARCHAR(128) NULL,
    quantity        INT NULL,
    FOREIGN KEY (product_id) REFERENCES products(id)
    );


-- ==============================================================================================

-- Таблица "account"
INSERT INTO  accounts (id, first_name, last_name)
VALUES
    (1, 'Иван', 'Иванов'),
    (2, 'Петр', 'Петров'),
    (3, 'Мария', 'Сидорова');

-- Таблица "account_info"
INSERT INTO account_info (id, name, email, city, phone_number, password)
VALUES
    (1, 'Иван Иванов', 'ivan@example.com', 'Altötting', '+7 (123) 456-78-90', 'password123'),
    (2, 'Петр Петров', 'petr@example.com', 'Garching', '+7 (987) 654-32-10', 'qwerty456'),
    (3, 'Мария Сидорова', 'maria@example.com', 'Traunreut', '+7 (111) 222-33-44', 'securepass123');

-- Таблица "product"
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

-- Таблица "role"
INSERT INTO roles (id, role_name)
VALUES
    (1, 'ROLE_USER'),
    (2, 'ROLE_ADMIN');
    (3, 'ROLE_MANAGER');

-- Таблица "cart" в данном случае не требует заполнения, поскольку она будет заполняться с учетом действий пользователей.



