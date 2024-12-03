CREATE TABLE address (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cep VARCHAR(255),
    street VARCHAR(255),
    complement VARCHAR(255),
    neighbohood VARCHAR(255),
    state VARCHAR(255),
    region VARCHAR(255)
);

CREATE TABLE user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    address_id BIGINT,
    FOREIGN KEY (address_id) REFERENCES address(id)
);

CREATE TABLE store (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    creator_id BIGINT NOT NULL,
    address_id BIGINT,
    FOREIGN KEY (creator_id) REFERENCES user(id),
    FOREIGN KEY (address_id) REFERENCES address(id)
);

CREATE TABLE product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    subtipo VARCHAR(255),
    creator_id BIGINT,
    FOREIGN KEY (creator_id) REFERENCES user(id)
);

CREATE TABLE price (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    address_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    store_id BIGINT,
    created DATETIME NOT NULL,
    FOREIGN KEY (address_id) REFERENCES address(id),
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (store_id) REFERENCES store(id)
);


ALTER TABLE price
ADD COLUMN creator_id BIGINT;

ALTER TABLE price
ADD CONSTRAINT fk_price_criator FOREIGN KEY (creator_id) REFERENCES user(id);


INSERT INTO user (id, email, address_id)
VALUES (1, 'john.doe@example.com', NULL);


ALTER TABLE user
ADD COLUMN role VARCHAR(255) NOT NULL;

UPDATE user
SET role = 'USER'
WHERE email = 'john.doe@example.com';

ALTER TABLE product
ADD COLUMN name VARCHAR(255) NOT NULL;


INSERT INTO product (id, name, subtipo, creator_id)
VALUES
(1, 'Smartphone', 'Eletrônicos', 1),
(2, 'Camiseta', 'Roupas', 1);

--ALTER table product AD

ALTER TABLE user
ADD COLUMN password VARCHAR(255) NOT NULL;


ALTER TABLE price
ADD COLUMN value DECIMAL(10,2) NOT NULL;

ALTER TABLE product CHANGE COLUMN subtipo subtype VARCHAR(255);

ALTER TABLE address CHANGE COLUMN neighbohood neighborhood VARCHAR(255);

UPDATE user
SET password = '$2a$10$1LWwJI0zOaLeDRCIEE8j/OcYpfktCJ2jb/nx7yDWnwN.VKuaj2Toq'
WHERE email = 'john.doe@example.com';
