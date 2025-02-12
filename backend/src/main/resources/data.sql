-- Insert category if it doesn't exist
INSERT INTO inventory.category (id, name, description)
SELECT 1, 'Electronics', 'All things electronics'
    WHERE NOT EXISTS (SELECT 1 FROM inventory.category WHERE id = 1);

INSERT INTO inventory.category (id, name, description,parent_category_id)
SELECT 2, 'Mobile Phones', 'Smartphones and mobile devices',1
    WHERE NOT EXISTS (SELECT 1 FROM inventory.category WHERE id = 2);

INSERT INTO inventory.category (id, name, description,parent_category_id)
SELECT 3, 'Computers', 'Laptops, desktops, and accessories',1
    WHERE NOT EXISTS (SELECT 1 FROM inventory.category WHERE id = 3);

INSERT INTO inventory.category (id, name, description)
SELECT 4, 'Accessories', 'Accessories for electronics'
    WHERE NOT EXISTS (SELECT 1 FROM inventory.category WHERE id = 4);

INSERT INTO inventory.category (id, name, description,parent_category_id)
SELECT 5, 'Wearables', 'Smartwatches, fitness trackers, and wearables',4
    WHERE NOT EXISTS (SELECT 1 FROM inventory.category WHERE id = 5);


-- Now insert the product
INSERT INTO inventory.product (id, name, description, price, available, stock_quantity, category_id)
SELECT 1, 'Laptop', 'High-end laptop', 1200.00, TRUE, 50, 1
    WHERE NOT EXISTS (SELECT 1 FROM inventory.product WHERE id = 1);

-- Insert Laptop product if it does not exist
INSERT INTO inventory.product (id, name, description, price, available, stock_quantity, category_id)
SELECT 1, 'Laptop', 'High-performance laptop for work and gaming.', 1200.00, TRUE, 50, 3
    WHERE NOT EXISTS (SELECT 1 FROM inventory.product WHERE id = 1);

-- Insert Smartphone product if it does not exist
INSERT INTO inventory.product (id, name, description, price, available, stock_quantity, category_id)
SELECT 2, 'Smartphone', 'Latest model with high-end features.', 800.00, TRUE, 100, 2
    WHERE NOT EXISTS (SELECT 1 FROM inventory.product WHERE id = 2);

-- Insert Wireless Mouse product if it does not exist
INSERT INTO inventory.product (id, name, description, price, available, stock_quantity, category_id)
SELECT 3, 'Wireless Mouse', 'Ergonomic design with long battery life.', 25.00, TRUE, 200, 4
    WHERE NOT EXISTS (SELECT 1 FROM inventory.product WHERE id = 3);

-- Insert Bluetooth Headphones product if it does not exist
INSERT INTO inventory.product (id, name, description, price, available, stock_quantity, category_id)
SELECT 4, 'Bluetooth Headphones', 'Noise-canceling headphones with deep bass.', 60.00, TRUE, 150, 4
    WHERE NOT EXISTS (SELECT 1 FROM inventory.product WHERE id = 4);

-- Insert Power Bank product if it does not exist
INSERT INTO inventory.product (id, name, description, price, available, stock_quantity, category_id)
SELECT 5, 'Power Bank 10000mAh', 'Fast-charging power bank with dual USB output.', 40.00, TRUE, 120, 4
    WHERE NOT EXISTS (SELECT 1 FROM inventory.product WHERE id = 5);

-- Insert Tablet product if it does not exist
INSERT INTO inventory.product (id, name, description, price, available, stock_quantity, category_id)
SELECT 6, 'Tablet', 'Portable tablet with high-resolution display.', 600.00, TRUE, 80, 2
    WHERE NOT EXISTS (SELECT 1 FROM inventory.product WHERE id = 6);

-- Insert Gaming Monitor product if it does not exist
INSERT INTO inventory.product (id, name, description, price, available, stock_quantity, category_id)
SELECT 7, 'Gaming Monitor', '4K UHD monitor with 144Hz refresh rate.', 350.00, TRUE, 60, 3
    WHERE NOT EXISTS (SELECT 1 FROM inventory.product WHERE id = 7);

-- Insert Mechanical Keyboard product if it does not exist
INSERT INTO inventory.product (id, name, description, price, available, stock_quantity, category_id)
SELECT 8, 'Mechanical Keyboard', 'RGB backlit keyboard with tactile switches.', 100.00, TRUE, 90, 4
    WHERE NOT EXISTS (SELECT 1 FROM inventory.product WHERE id = 8);

-- Insert Smartwatch product if it does not exist
INSERT INTO inventory.product (id, name, description, price, available, stock_quantity, category_id)
SELECT 9, 'Smartwatch', 'Fitness tracker with heart rate monitor.', 150.00, TRUE, 75, 2
    WHERE NOT EXISTS (SELECT 1 FROM inventory.product WHERE id = 9);

-- Insert External Hard Drive product if it does not exist
INSERT INTO inventory.product (id, name, description, price, available, stock_quantity, category_id)
SELECT 10, 'External Hard Drive', '2TB USB 3.0 external storage.', 90.00, TRUE, 110, 3
    WHERE NOT EXISTS (SELECT 1 FROM inventory.product WHERE id = 10);