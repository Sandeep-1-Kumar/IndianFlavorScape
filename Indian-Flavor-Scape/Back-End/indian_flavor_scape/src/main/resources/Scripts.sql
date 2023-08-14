CREATE SCHEMA `indian_flavor_scape` ;
#Create user Spring user and grant access
grant all on indian_flavor_scape.* to 'springuser'@'%';

CREATE TABLE indian_flavor_scape.Customer (
  customerId INT(11) AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL
) AUTO_INCREMENT = 1001;

CREATE TABLE indian_flavor_scape.Employ (
  employId INT(11) AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL
) AUTO_INCREMENT = 2001;

CREATE TABLE indian_flavor_scape.Main (
  id INT(11) AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  image_url VARCHAR(255) NOT NULL 
);


CREATE TABLE indian_flavor_scape.Additives (
  id INT(11) AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  main INT(11) NOT NULL,
  image_url VARCHAR(255) NOT NULL,
  FOREIGN KEY (main) REFERENCES Main(id)
);

CREATE TABLE indian_flavor_scape.Sides (
  id INT(11) AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  main INT(11) NOT NULL,
  image_url VARCHAR(255) NOT NULL,
  FOREIGN KEY (main) REFERENCES Main(id)
);

CREATE TABLE indian_flavor_scape.Orders (
  id INT(11) AUTO_INCREMENT PRIMARY KEY,
  customerid INT(11) NOT NULL,
  main INT(11) NOT NULL,
  additives INT(11) NOT NULL,
  sides INT(11) NOT NULL,
  Order_Time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  orderStatus  VARCHAR(255) NOT NULL,
  FOREIGN KEY (customerId) REFERENCES Customer(customerId),
  FOREIGN KEY (main) REFERENCES Main(id),
  FOREIGN KEY (additives) REFERENCES Additives(id),
  FOREIGN KEY (sides) REFERENCES Sides(id)
) AUTO_INCREMENT = 1;


INSERT INTO indian_flavor_scape.Employ (name, email, password)
VALUES (  'Bhanu', 'Bhanu@gmail.com', 'password123');

INSERT INTO indian_flavor_scape.Main(name) values('Biryani');
INSERT INTO indian_flavor_scape.Main(name) values('Bread');
INSERT INTO indian_flavor_scape.Main(name) values('Rice');

INSERT INTO indian_flavor_scape.ADDITIVES(name,main) values('Chicken',1);
INSERT INTO indian_flavor_scape.ADDITIVES(name,main) values('Egg',1);
INSERT INTO indian_flavor_scape.ADDITIVES(name,main) values('Veg',1);

INSERT INTO indian_flavor_scape.ADDITIVES(name,main) values('Jam',2);
INSERT INTO indian_flavor_scape.ADDITIVES(name,main) values('Omlet',2);
INSERT INTO indian_flavor_scape.ADDITIVES(name,main) values('Cheese',2);

INSERT INTO indian_flavor_scape.ADDITIVES(name,main) values('Curry',3);
INSERT INTO indian_flavor_scape.ADDITIVES(name,main) values('Veggies',3);
INSERT INTO indian_flavor_scape.ADDITIVES(name,main) values('Curd',3);

INSERT INTO indian_flavor_scape.SIDES(name,main) values('Gravy',1);
INSERT INTO indian_flavor_scape.SIDES(name,main) values('Raitha',1);
INSERT INTO indian_flavor_scape.SIDES(name,main) values('Salad',1);

INSERT INTO indian_flavor_scape.SIDES(name,main) values('Salad',2);
INSERT INTO indian_flavor_scape.SIDES(name,main) values('Butter',2);
INSERT INTO indian_flavor_scape.SIDES(name,main) values('Ranch',2);

INSERT INTO indian_flavor_scape.SIDES(name,main) values('Desert',3);
INSERT INTO indian_flavor_scape.SIDES(name,main) values('Smoothie',3);
INSERT INTO indian_flavor_scape.SIDES(name,main) values('SweetPie',3);

UPDATE indian_flavor_scape.Main Set image_url = 'https://s4.scoopwhoop.com/ach/biryani/11.jpg' where name = 'Biryani' and id = 1;
UPDATE indian_flavor_scape.Main Set image_url = 'https://i.pinimg.com/564x/9b/87/24/9b8724dc3f7ba8a2a9674ae633e4064c.jpg' where name = 'Bread' and id = 2;
UPDATE indian_flavor_scape.Main Set image_url = 'https://i.pinimg.com/564x/d0/5e/93/d05e93b002ad8a8745f46b2d51b21af6.jpg' where name = 'Rice' and id = 3;
UPDATE indian_flavor_scape.ADDITIVES Set image_url = 'https://i.pinimg.com/564x/77/82/08/77820851543e238ab56d3d54bfe299ac.jpg' where name = 'Chicken' and id = 1;
UPDATE indian_flavor_scape.ADDITIVES Set image_url = 'https://i.pinimg.com/564x/9d/96/ad/9d96add5cb52ae8c1a7b99135e43bdad.jpg' where name = 'Egg' and id = 2;
UPDATE indian_flavor_scape.ADDITIVES Set image_url = 'https://i.pinimg.com/564x/e4/31/cd/e431cd839c97da7aa6a4359a710d8dd5.jpg' where name = 'Veg' and id = 3;
UPDATE indian_flavor_scape.ADDITIVES Set image_url = 'https://i.pinimg.com/564x/c0/90/77/c09077fddf2c8217ec1f263a4d35cf8e.jpg' where name = 'Jam' and id = 4;
UPDATE indian_flavor_scape.ADDITIVES Set image_url = 'https://i.pinimg.com/564x/7c/41/14/7c41142afe0ed6c823c4ec0e4a549a61.jpg' where name = 'Omlet' and id = 5;
UPDATE indian_flavor_scape.ADDITIVES Set image_url = 'https://i.pinimg.com/564x/a2/2b/83/a22b83f38dbaded1d110b49a8bb8a3cf.jpg' where name = 'Cheese' and id = 6;
UPDATE indian_flavor_scape.ADDITIVES Set image_url = 'https://i.pinimg.com/564x/ed/63/40/ed634081e44cdd62e36edc9dd440b7c0.jpg' where name = 'Curry' and id = 7;
UPDATE indian_flavor_scape.ADDITIVES Set image_url = 'https://i.pinimg.com/564x/e4/31/cd/e431cd839c97da7aa6a4359a710d8dd5.jpg' where name = 'Veggies' and id = 8;
UPDATE indian_flavor_scape.ADDITIVES Set image_url = 'https://i.pinimg.com/564x/7b/0d/a5/7b0da5e73426af55b13036dc0f377899.jpg' where name = 'Curd' and id = 9;
UPDATE indian_flavor_scape.SIDES Set image_url = 'https://i.pinimg.com/564x/94/4c/a7/944ca73f3b107afe6dbb52e2b612821d.jpg' where name = 'Gravy' and id = 1;
UPDATE indian_flavor_scape.SIDES Set image_url = 'https://i.pinimg.com/564x/3a/af/13/3aaf130ad5a1374bf97c59ef7d5bbd6f.jpg' where name = 'Raitha' and id = 2;
UPDATE indian_flavor_scape.SIDES Set image_url = 'https://i.pinimg.com/564x/60/58/9a/60589af47ae45e5b4391c3d630c28ebf.jpg' where name = 'Salad' and id = 3;
UPDATE indian_flavor_scape.SIDES Set image_url = 'https://i.pinimg.com/564x/60/58/9a/60589af47ae45e5b4391c3d630c28ebf.jpg' where name = 'Salad' and id = 4;
UPDATE indian_flavor_scape.SIDES Set image_url = 'https://i.pinimg.com/564x/6d/1c/fa/6d1cfa4e1a5e58d31cc935fad125e046.jpg' where name = 'Butter' and id = 5;
UPDATE indian_flavor_scape.SIDES Set image_url = 'https://i.pinimg.com/564x/83/47/0e/83470e31efc07a2aab0dd929788f091d.jpg' where name = 'Ranch' and id = 6;
UPDATE indian_flavor_scape.SIDES Set image_url = 'https://i.pinimg.com/564x/78/2f/24/782f242d4a0dbe24efe0e8a687a6d145.jpg' where name = 'Desert' and id = 7;
UPDATE indian_flavor_scape.SIDES Set image_url = 'https://i.pinimg.com/564x/32/13/99/321399695f5a79a1006602c9ed90f689.jpg' where name = 'Smoothie' and id = 8;
UPDATE indian_flavor_scape.SIDES Set image_url = 'https://irepo.primecp.com/2021/11/511538/1637701171_93154_Large400_ID-4571010.jpg' where name = 'SweetPie' and id = 9;

-- Select * From indian_flavor_scape.Customer;
-- Select * From indian_flavor_scape.Employ;
-- Select * from indian_flavor_scape.Main;
-- Select * from indian_flavor_scape.ADDITIVES;
-- Select * from indian_flavor_scape.SIDES;
-- Select * from indian_flavor_scape.Orders;

-- INSERT INTO indian_flavor_scape.Main(name,image_url) values('Roti','https://www.papasspicecafe.co.za/wp-content/uploads/2020/02/roti.jpg');
-- Delete from indian_flavor_scape.Main where id > 3;
-- INSERT INTO indian_flavor_scape.ADDITIVES(name,main,image_url) values('Chicken',4,'https://i.pinimg.com/564x/77/82/08/77820851543e238ab56d3d54bfe299ac.jpg');
-- INSERT INTO indian_flavor_scape.ADDITIVES(name,main,image_url) values('Curd',4,'https://i.pinimg.com/564x/7b/0d/a5/7b0da5e73426af55b13036dc0f377899.jpg');
-- INSERT INTO indian_flavor_scape.ADDITIVES(name,main,image_url) values('Veg',4,'https://i.pinimg.com/564x/e4/31/cd/e431cd839c97da7aa6a4359a710d8dd5.jpg');
-- INSERT INTO indian_flavor_scape.SIDES(name,main,image_url) values('Salad',4,'https://i.pinimg.com/564x/60/58/9a/60589af47ae45e5b4391c3d630c28ebf.jpg');
-- INSERT INTO indian_flavor_scape.SIDES(name,main,image_url) values('Desert',4,'https://i.pinimg.com/564x/78/2f/24/782f242d4a0dbe24efe0e8a687a6d145.jpg');
-- INSERT INTO indian_flavor_scape.SIDES(name,main,image_url) values('Smothiee',4,'https://i.pinimg.com/564x/32/13/99/321399695f5a79a1006602c9ed90f689.jpg');
