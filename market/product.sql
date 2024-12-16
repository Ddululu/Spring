SET VARIABLES LIKE 'secure_file_priv';

-- Categories
INSERT INTO categories (name, description) VALUES ('Electronics', 'Electronic gadgets and devices');
INSERT INTO categories (name, description) VALUES ('Books', 'Various kinds of books and literature');
INSERT INTO categories (name, description) VALUES ('Clothing', 'Apparel and clothing items');
INSERT INTO categories (name, description) VALUES ('Home Appliances', 'Appliances for household use');
INSERT INTO categories (name, description) VALUES ('Sports', 'Sporting goods and equipment');

-- Products
INSERT INTO product (name, description, price, stock_quantity, category_id, created_at, updated_at)
VALUES ('Smartphone', 'Latest model smartphone with advanced features', 699.99, 50, 1, NOW(), NOW());
INSERT INTO product (name, description, price, stock_quantity, category_id, created_at, updated_at)
VALUES ('Laptop', 'High-performance laptop for professionals', 1199.99, 30, 1, NOW(), NOW());
INSERT INTO product (name, description, price, stock_quantity, category_id, created_at, updated_at)
VALUES ('Fiction Book', 'Bestselling fiction book', 14.99, 100, 2, NOW(), NOW());
INSERT INTO product (name, description, price, stock_quantity, category_id, created_at, updated_at)
VALUES ('Blender', 'High-speed blender for smoothies', 89.99, 40, 4, NOW(), NOW());
INSERT INTO product (name, description, price, stock_quantity, category_id, created_at, updated_at)
VALUES ('Running Shoes', 'Comfortable running shoes for all terrains', 59.99, 75, 5, NOW(), NOW());

INSERT INTO product (name, description, price, stock_quantity, category_id, created_at, updated_at)
VALUES ('Tablet', 'Portable tablet for reading and entertainment', 299.99, 60, 1, NOW(), NOW());
INSERT INTO product (name, description, price, stock_quantity, category_id, created_at, updated_at)
VALUES ('Headphones', 'Noise-cancelling over-ear headphones', 199.99, 80, 1, NOW(), NOW());
INSERT INTO product (name, description, price, stock_quantity, category_id, created_at, updated_at)
VALUES ('Non-fiction Book', 'Inspirational non-fiction book', 19.99, 120, 2, NOW(), NOW());
INSERT INTO product (name, description, price, stock_quantity, category_id, created_at, updated_at)
VALUES ('Microwave Oven', 'Compact microwave oven with digital controls', 149.99, 35, 4, NOW(), NOW());
INSERT INTO product (name, description, price, stock_quantity, category_id, created_at, updated_at)
VALUES ('Yoga Mat', 'Eco-friendly yoga mat with non-slip surface', 24.99, 150, 5, NOW(), NOW());

-- Product Images
INSERT INTO product_image (product_id, image, alt_text) VALUES (1, LOAD_FILE('C:/Program Files/MySQL/MySQL Server 8.0/Uploads/emoji_1.png'), 'Emoji 1');
INSERT INTO product_image (product_id, image, alt_text) VALUES (2, LOAD_FILE('C:/Program Files/MySQL/MySQL Server 8.0/Uploads/emoji_2.png'), 'Emoji 2');
INSERT INTO product_image (product_id, image, alt_text) VALUES (3, LOAD_FILE('C:/Program Files/MySQL/MySQL Server 8.0/Uploads/emoji_3.png'), 'Emoji 3');
INSERT INTO product_image (product_id, image, alt_text) VALUES (4, LOAD_FILE('C:/Program Files/MySQL/MySQL Server 8.0/Uploads/emoji_4.png'), 'Emoji 4');
INSERT INTO product_image (product_id, image, alt_text) VALUES (5, LOAD_FILE('C:/Program Files/MySQL/MySQL Server 8.0/Uploads/emoji_5.png'), 'Emoji 5');
INSERT INTO product_image (product_id, image, alt_text) VALUES (6, LOAD_FILE('C:/Program Files/MySQL/MySQL Server 8.0/Uploads/emoji_6.png'), 'Emoji 6');
INSERT INTO product_image (product_id, image, alt_text) VALUES (7, LOAD_FILE('C:/Program Files/MySQL/MySQL Server 8.0/Uploads/emoji_7.png'), 'Emoji 7');
INSERT INTO product_image (product_id, image, alt_text) VALUES (8, LOAD_FILE('C:/Program Files/MySQL/MySQL Server 8.0/Uploads/emoji_8.png'), 'Emoji 8');
INSERT INTO product_image (product_id, image, alt_text) VALUES (9, LOAD_FILE('C:/Program Files/MySQL/MySQL Server 8.0/Uploads/emoji_9.png'), 'Emoji 9');
INSERT INTO product_image (product_id, image, alt_text) VALUES (10, LOAD_FILE('C:/Program Files/MySQL/MySQL Server 8.0/Uploads/emoji_10.png'), 'Emoji 10');
INSERT INTO product_image (product_id, image, alt_text) VALUES (11, LOAD_FILE('C:/Program Files/MySQL/MySQL Server 8.0/Uploads/emoji_11.png'), 'Emoji 11');
INSERT INTO product_image (product_id, image, alt_text) VALUES (12, LOAD_FILE('C:/Program Files/MySQL/MySQL Server 8.0/Uploads/emoji_12.png'), 'Emoji 12');
INSERT INTO product_image (product_id, image, alt_text) VALUES (13, LOAD_FILE('C:/Program Files/MySQL/MySQL Server 8.0/Uploads/emoji_13.png'), 'Emoji 13');
INSERT INTO product_image (product_id, image, alt_text) VALUES (14, LOAD_FILE('C:/Program Files/MySQL/MySQL Server 8.0/Uploads/emoji_14.png'), 'Emoji 14');
INSERT INTO product_image (product_id, image, alt_text) VALUES (15, LOAD_FILE('C:/Program Files/MySQL/MySQL Server 8.0/Uploads/emoji_15.png'), 'Emoji 15');
INSERT INTO product_image (product_id, image, alt_text) VALUES (16, LOAD_FILE('C:/Program Files/MySQL/MySQL Server 8.0/Uploads/emoji_16.png'), 'Emoji 16');
INSERT INTO product_image (product_id, image, alt_text) VALUES (17, LOAD_FILE('C:/Program Files/MySQL/MySQL Server 8.0/Uploads/emoji_17.png'), 'Emoji 17');
INSERT INTO product_image (product_id, image, alt_text) VALUES (18, LOAD_FILE('C:/Program Files/MySQL/MySQL Server 8.0/Uploads/emoji_18.png'), 'Emoji 18');
INSERT INTO product_image (product_id, image, alt_text) VALUES (19, LOAD_FILE('C:/Program Files/MySQL/MySQL Server 8.0/Uploads/emoji_19.png'), 'Emoji 19');
INSERT INTO product_image (product_id, image, alt_text) VALUES (20, LOAD_FILE('C:/Program Files/MySQL/MySQL Server 8.0/Uploads/emoji_20.png'), 'Emoji 20');