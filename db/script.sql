DROP DATABASE IF EXISTS animals;
CREATE DATABASE animals;
USE animals;

CREATE TABLE human_friends (
id INT NOT NULL AUTO_INCREMENT,
type_name VARCHAR(45) NOT NULL UNIQUE,
PRIMARY KEY (id)
);

INSERT INTO human_friends (type_name)
VALUES ("pets"), ("pack_animals");

CREATE TABLE pets (
id INT NOT NULL AUTO_INCREMENT,
id_type INT NOT NULL,
group_name VARCHAR(100) NOT NULL UNIQUE,
PRIMARY KEY (id),
FOREIGN KEY (id_type) REFERENCES human_friends (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO pets (id_type, group_name)
VALUES
  (1, "dogs"),
  (1, "cats"),
  (1, "hamsters");

CREATE TABLE pack_animals (
id INT NOT NULL AUTO_INCREMENT,
id_type INT NOT NULL,
group_name VARCHAR(100) NOT NULL UNIQUE,
PRIMARY KEY (id),
FOREIGN KEY (id_type) REFERENCES human_friends (id) ON DELETE CASCADE
);

INSERT INTO pack_animals (id_type, group_name)
VALUES
  (2, "horses"),
  (2, "camels"),
  (2, "donkeys");

CREATE TABLE dogs (
id INT NOT NULL AUTO_INCREMENT,
id_group INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (id_group) REFERENCES pets (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE cats (
id INT NOT NULL AUTO_INCREMENT,
id_group INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (id_group) REFERENCES pets (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE hamsters (
id INT NOT NULL AUTO_INCREMENT,
id_group INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (id_group) REFERENCES pets (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE horses (
id INT NOT NULL AUTO_INCREMENT,
id_group INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (id_group) REFERENCES pack_animals (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE camels (
id INT NOT NULL AUTO_INCREMENT,
id_group INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (id_group) REFERENCES pack_animals (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE donkeys (
id INT NOT NULL AUTO_INCREMENT,
id_group INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (id_group) REFERENCES pack_animals (id) ON DELETE CASCADE ON UPDATE CASCADE
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

INSERT INTO dogs(animal_name, birthday, command, id_group)
VALUES
	("Chester", "2020-01-01", "run", 1),
    ("Bob", "2020-06-01", "jump", 1),
    ("Milo", "2021-01-01", "eat", 1);

INSERT INTO cats(animal_name, birthday, command, id_group)
VALUES
	("Cooper", "2019-01-01", "run", 2),
    ("Charlie", "2018-06-01", "play", 2),
    ("Max", "2022-01-01", "sleep", 2);

INSERT INTO hamsters(animal_name, birthday, command, id_group)
VALUES
	("Bear", "2023-01-01", "eat", 3),
    ("MrBig", "2022-06-01", "eat", 3),
    ("Tucker", "2022-01-01", "run", 3);

INSERT INTO horses(animal_name, birthday, command, id_group)
VALUES
	("April", "2018-01-01", "jump", 1),
    ("Apple", "2019-06-01", "run", 1);

INSERT INTO camels(animal_name, birthday, command, id_group)
VALUES
	("Elliot", "2018-01-01", "go", 2),
    ("Iron", "2022-06-01", "stay", 2);

INSERT INTO donkeys(animal_name, birthday, command, id_group)
VALUES
	("Henry ", "2010-01-01", "do nothing", 3),
    ("Oscar", "2022-12-01", "go", 3);

DELETE FROM pack_animals
WHERE group_name = "camels";

CREATE TABLE pack_animals_no_camels (
id INT AUTO_INCREMENT,
id_group INT NOT NULL,
animal_name VARCHAR(100) NOT NULL,
birthday DATE,
command VARCHAR(100),
PRIMARY KEY (id),
FOREIGN KEY (id_group) REFERENCES pack_animals (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO pack_animals_no_camels (id_group, animal_name, birthday, command)
SELECT id_group, animal_name, birthday, command FROM horses;

INSERT INTO pack_animals_no_camels (id_group, animal_name, birthday, command)
SELECT id_group, animal_name, birthday, command FROM donkeys;

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