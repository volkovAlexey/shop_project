CREATE TABLE shops (
  id                  SERIAL NOT NULL CONSTRAINT shop_key PRIMARY KEY,
  name                VARCHAR(20),
  phone_number        VARCHAR(20),
  type                VARCHAR(20),
  number_of_cash_desk INT,
  deliverable         BOOLEAN
);

CREATE TABLE products (
  id                  SERIAL NOT NULL CONSTRAINT products_key PRIMARY KEY,
  name                VARCHAR(20),
  cost                FLOAT,
  manufacturer        VARCHAR(25),
  date_of_manufacture DATE
);