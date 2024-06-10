-- -- Вставка данных в таблицы
-- INSERT INTO account_personal_data (name, email, city, phone_number, password)
-- VALUES
--     ('Ivan', 'ivan@example.com', 'Altötting', '+7 (123) 456-78-90', 'password123'),
--     ('Petr', 'petr@example.com', 'Garching', '+7 (987) 654-32-10', 'qwerty456'),
--     ('Maria', 'maria@example.com', 'Traunreut', '+7 (111) 222-33-44', 'securepass123');
--
-- INSERT INTO accounts (first_name, last_name, account_personal_data_id)
-- VALUES
--     ('Ivan', 'Ivanov', 1),
--     ('Petr', 'Petrov', 2),
--     ('Maria', 'Sidorova', 3);
--
-- INSERT INTO products (image, article, name, price, price_kg)
-- VALUES
--     ('chicken.jpg', 'CHI001', 'Курица целиком', 5.99, 3.50),
--     ('chicken_wings.jpg', 'CHI002', 'Крылья куриные', 3.49, NULL),
--     ('chicken_breast.jpg', 'CHI003', 'Грудка куриная', 7.99, 5.00),
--     ('chicken_legs.jpg', 'CHI004', 'Ножки куриные', 2.99, NULL),
--     ('chicken_thighs.jpg', 'CHI005', 'Бедра куриные', 4.49, NULL),
--     ('chicken_fillets.jpg', 'CHI006', 'Филе куриное', 8.99, 6.50),
--     ('whole_duck.jpg', 'DUC001', 'Утка целиком', 12.99, 9.00),
--     ('duck_legs.jpg', 'DUC002', 'Ножки утиные', 6.99, NULL),
--     ('duck_breast.jpg', 'DUC003', 'Грудка утиная', 10.49, NULL),
--     ('turkey_whole.jpg', 'TUR001', 'Индейка целиком', 15.99, 11.50);
--
-- INSERT INTO roles (role_name, account_personal_data_id)
-- VALUES
--     ('ROLE_USER', 1),
--     ('ROLE_ADMIN', 2),
--     ('ROLE_MANAGER', 3);

--=============================================================================================================================

-- Вставка данных в таблицы account_personal_data
INSERT INTO account_personal_data (name, email, city, phone_number, password)
VALUES
    ('Ivan', 'ivan@example.com', 'Altötting', '+7 (123) 456-78-90', 'password123'),
    ('Petr', 'petr@example.com', 'Garching', '+7 (987) 654-32-10', 'qwerty456'),
    ('Maria', 'maria@example.com', 'Traunreut', '+7 (111) 222-33-44', 'securepass123');

-- Вставка данных в таблицу accounts
INSERT INTO accounts (first_name, last_name, account_personal_data_id)
VALUES
    ('Ivan', 'Ivanov', 1),
    ('Petr', 'Petrov', 2),
    ('Maria', 'Sidorova', 3);

-- Вставка данных в таблицу products
INSERT INTO products (image, article, name, descriptions, price, price_kg)
VALUES
    ('chicken.jpg', 'CHI001', 'Курица целиком', '', 5.99, 3.50),
    ('chicken_wings.jpg', 'CHI002', 'Крылья куриные', '', 3.49, NULL),
    ('chicken_breast.jpg', 'CHI003', 'Грудка куриная', '', 7.99, 5.00),
    ('chicken_legs.jpg', 'CHI004', 'Ножки куриные', '', 2.99, NULL),
    ('chicken_thighs.jpg', 'CHI005', 'Бедра куриные', '', 4.49, NULL),
    ('chicken_fillets.jpg', 'CHI006', 'Филе куриное', '', 8.99, 6.50),
    ('whole_duck.jpg', 'DUC001', 'Утка целиком', '', 12.99, 9.00),
    ('duck_legs.jpg', 'DUC002', 'Ножки утиные', '', 6.99, NULL),
    ('duck_breast.jpg', 'DUC003', 'Грудка утиная', '', 10.49, NULL),
    ('turkey_whole.jpg', 'TUR001', 'Индейка целиком', '', 15.99, 11.50);

-- Вставка данных в таблицу roles
INSERT INTO roles (role_name, account_personal_data_id)
VALUES
    ('USER', 2),
    ('ADMIN', 1),
    ('MANAGER', 3);
