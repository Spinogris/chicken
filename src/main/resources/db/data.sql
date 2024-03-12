create table IF NOT EXISTS account (
    id int not null primary key,
    city         varchar(128) null,
    email        varchar(128) null,
    first_name   varchar(128) null,
    last_name    varchar(128) null,
    password     varchar(128) null,
    phone_number varchar(128) null,
    role         varchar(16) not null
);

create table IF NOT EXISTS product (
    id      bigint not null primary key,
    image   varchar(128) not null,
    article varchar(128) null,
    name    varchar(128) null,
    price double null,
    price_kg double null
);

create table IF NOT EXISTS role (
    id int not null primary key,
    role_name varchar(128) null
);

create table IF NOT EXISTS cart (
    id int not null primary key,
    role_name varchar(128) null
);

-- Заполнение таблицы account случайными данными
INSERT INTO account (id, city, email, first_name, last_name, password, phone_number, role)
VALUES (555, 'Traunreut', 'email1@example.com', 'Eduard', 'Miller', '111', '1234567890', 'user'),
       (777, 'Traunreut', 'email2@example.com', 'Vladislav', 'Gorin', '222', '0987654321', 'admin');

-- Заполнение таблицы product с путями к изображениям из папки pictures
-- Предполагая, что путь к папке pictures в вашей системе - /Users/vladislavgorin/Documents/chicken/Chicken/src/main/resources/static/pictures
INSERT INTO product (id, image, article, name, price, price_kg)
VALUES (1, '/Users/vladislavgorin/Documents/chicken/Chicken/src/main/resources/static/pictures/teilen/B.png', 'article_1', 'foot', 10.99, 5.99),
       (2, '/Users/vladislavgorin/Documents/chicken/Chicken/src/main/resources/static/pictures/teilen/boots.jpeg', 'article_2', 'boots', 19.99, 7.99);

-- Заполнение таблицы role рандомными данными
INSERT INTO role (id, role_name)
VALUES (1, 'user'),
       (2, 'admin');

