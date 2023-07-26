DROP DATABASE IF EXISTS animals;
CREATE DATABASE animals;
USE animals;

CREATE TABLE human_friends (
type_name VARCHAR(45) NOT NULL UNIQUE,
PRIMARY KEY (type_name)
);

INSERT INTO human_friends
VALUES ("pets"), ("pack_animals");

CREATE TABLE pets (
group_name VARCHAR(100) NOT NULL UNIQUE,
type_name VARCHAR(45) NOT NULL,
PRIMARY KEY (group_name),
FOREIGN KEY (type_name) REFERENCES human_friends (type_name) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO pets (group_name, type_name)
VALUES ("dogs", "pets"), ("cats", "pets"), ("hamsters", "pets");

CREATE TABLE pack_animals (
group_name VARCHAR(100) NOT NULL UNIQUE,
type_name VARCHAR(45) NOT NULL,
PRIMARY KEY (group_name),
FOREIGN KEY (type_name) REFERENCES human_friends (type_name) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO pack_animals (group_name, type_name)
VALUES ("horses", "pack_animals"), ("camels", "pack_animals"), ("donkeys", "pack_animals");

CREATE TABLE dogs (
type_name VARCHAR(45) NOT NULL,
group_name VARCHAR(100) NOT NULL,
id INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id, group_name, type_name),
FOREIGN KEY (type_name) REFERENCES human_friends (type_name) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (group_name) REFERENCES pets (group_name) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE cats (
type_name VARCHAR(45) NOT NULL,
group_name VARCHAR(100) NOT NULL,
id INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id, group_name, type_name),
FOREIGN KEY (type_name) REFERENCES human_friends (type_name) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (group_name) REFERENCES pets (group_name) ON DELETE CASCADE ON UPDATE CASCADE
); 

CREATE TABLE hamsters (
type_name VARCHAR(45) NOT NULL,
group_name VARCHAR(100) NOT NULL,
id INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id, group_name, type_name),
FOREIGN KEY (type_name) REFERENCES human_friends (type_name) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (group_name) REFERENCES pets (group_name) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE horses (
type_name VARCHAR(45) NOT NULL,
group_name VARCHAR(100) NOT NULL,
id INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id, group_name, type_name),
FOREIGN KEY (type_name) REFERENCES human_friends (type_name) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (group_name) REFERENCES pack_animals (group_name) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE camels (
type_name VARCHAR(45) NOT NULL,
group_name VARCHAR(100) NOT NULL,
id INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id, group_name, type_name),
FOREIGN KEY (type_name) REFERENCES human_friends (type_name) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (group_name) REFERENCES pack_animals (group_name) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE donkeys (
type_name VARCHAR(45) NOT NULL,
group_name VARCHAR(100) NOT NULL,
id INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id, group_name, type_name),
FOREIGN KEY (type_name) REFERENCES human_friends (type_name) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (group_name) REFERENCES pack_animals (group_name) ON DELETE CASCADE ON UPDATE CASCADE
);

ALTER TABLE dogs
ADD animal_name VARCHAR(100) NOT NULL,
ADD birthday DATE, 
ADD command VARCHAR(100);

ALTER TABLE cats
ADD animal_name VARCHAR(100) NOT NULL,
ADD birthday DATE, 
ADD command VARCHAR(100);

ALTER TABLE hamsters
ADD animal_name VARCHAR(100) NOT NULL,
ADD birthday DATE, 
ADD command VARCHAR(100);

ALTER TABLE horses
ADD animal_name VARCHAR(100) NOT NULL,
ADD birthday DATE, 
ADD command VARCHAR(100);

ALTER TABLE camels
ADD animal_name VARCHAR(100) NOT NULL,
ADD birthday DATE, 
ADD command VARCHAR(100);

ALTER TABLE donkeys
ADD animal_name VARCHAR(100) NOT NULL,
ADD birthday DATE, 
ADD command VARCHAR(100);

INSERT INTO dogs(animal_name, birthday, command, group_name, type_name)
VALUES 
	("Chester", "2020-01-01", "run", "dogs", "pets"),
    ("Bob", "2020-06-01", "jump", "dogs", "pets"),
    ("Milo", "2021-01-01", "eat", "dogs", "pets");

INSERT INTO cats(animal_name, birthday, command, group_name, type_name)
VALUES 
	("Cooper", "2019-01-01", "run", "cats", "pets"),
    ("Charlie", "2018-06-01", "play", "cats", "pets"),
    ("Max", "2022-01-01", "sleep", "cats", "pets");

INSERT INTO hamsters(animal_name, birthday, command, group_name, type_name)
VALUES 
	("Bear", "2023-01-01", "eat", "hamsters", "pets"),
    ("MrBig", "2022-06-01", "eat", "hamsters", "pets"),
    ("Tucker", "2022-01-01", "run", "hamsters", "pets");

INSERT INTO horses(animal_name, birthday, command, group_name, type_name)
VALUES 
	("April", "2018-01-01", "jump", "horses", "pack_animals"),
    ("Apple", "2019-06-01", "run", "horses", "pack_animals");

INSERT INTO camels(animal_name, birthday, command, group_name, type_name)
VALUES 
	("Elliot", "2018-01-01", "go", "camels", "pack_animals"),
    ("Iron", "2022-06-01", "stay", "camels", "pack_animals");

INSERT INTO donkeys(animal_name, birthday, command, group_name, type_name)
VALUES 
	("Henry ", "2010-01-01", "do nothing", "donkeys", "pack_animals"),
    ("Oscar", "2022-12-01", "go", "donkeys", "pack_animals");

DELETE FROM pack_animals
WHERE group_name = "camels";

CREATE TABLE pack_animals_no_camels
AS
SELECT * FROM horses
UNION SELECT * FROM donkeys;

DROP TABLE IF EXISTS animals;
CREATE TEMPORARY TABLE animals
AS 
SELECT * FROM pack_animals_no_camels 
UNION SELECT * FROM cats
UNION SELECT * FROM hamsters
UNION SELECT * FROM dogs;

DROP TABLE IF EXISTS young_animals;
CREATE TABLE young_animals
AS
SELECT *, TIMESTAMPDIFF(MONTH, birthday, current_date()) AS age_months 
FROM animals
WHERE TIMESTAMPDIFF(YEAR, birthday, current_date()) BETWEEN 1 AND 3; 

CREATE TABLE all_animals
AS
SELECT * FROM animals;