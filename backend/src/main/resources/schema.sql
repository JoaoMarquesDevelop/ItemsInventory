-- steps to prepare your db in local environment

CREATE SCHEMA IF NOT EXISTS inventory;

ALTER TABLE inventory.product DROP FOREIGN KEY fk_product_category;

ALTER TABLE inventory.category DROP FOREIGN KEY fk_category_parent;

DROP TABLE IF EXISTS inventory.category;

DROP TABLE IF EXISTS inventory.product;

CREATE TABLE IF NOT EXISTS inventory.category
(
    id                 INT AUTO_INCREMENT PRIMARY KEY,
    name               VARCHAR(255) NOT NULL,
    description        TEXT,
    parent_category_id INT NULL,
    CONSTRAINT fk_category_parent FOREIGN KEY (parent_category_id) REFERENCES inventory.category (id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS inventory.product
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    name          VARCHAR(255)   NOT NULL,
    description   TEXT,
    price         DECIMAL(10, 2) NOT NULL,
    available     BOOLEAN        NOT NULL DEFAULT TRUE,
    stock_quantity INT           NOT NULL DEFAULT 0,
    category_id   INT            NOT NULL,
    CONSTRAINT fk_product_category FOREIGN KEY (category_id) REFERENCES inventory.category (id) ON DELETE CASCADE
);