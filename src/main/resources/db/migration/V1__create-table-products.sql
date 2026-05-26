CREATE TABLE products (

    id INTEGER AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,

    PRIMARY KEY (id)

);