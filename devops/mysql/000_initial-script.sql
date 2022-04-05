CREATE SCHEMA IF NOT EXISTS javaAndMagic DEFAULT CHARACTER SET utf8;
USE javaAndMagic;

CREATE TABLE IF NOT EXISTS weapon(
  weaponID INT AUTO_INCREMENT,
  owner VARCHAR(20),
  weaponType ENUM('WITHOUT_WEAPON', 'AXE', 'BOW', 'LANCE', 'MAGIC_STAFF', 'SWORD'),
  durability INT,
  physicalDamage INT,
  magicalDamage INT,
  level INT,
  criticalHitChance INT,
  PRIMARY KEY (weaponID)
);

CREATE TABLE IF NOT EXISTS armor(
  armorID INT AUTO_INCREMENT,
  owner VARCHAR(20),
  armorClass ENUM('WITHOUT_ARMOR', 'ARMOR_SUIT', 'LEATHER_ARMOR', 'MAGICAL_SHIELD', 'SHIELD'),
  durability INT,
  physicalDefense INT,
  magicalDefense INT,
  PRIMARY KEY (armorID)
);

CREATE TABLE IF NOT EXISTS heroes(
  name VARCHAR(20),
  heroClass ENUM('ARCHER', 'KNIGHT', 'THIEF', 'WIZARD'),
  health INT,
  strength INT,
  level INT,
  dexterity INT,
  weaponID INT,
  armorID INT,
  skillBook VARCHAR(200),
  PRIMARY KEY (name),
  FOREIGN KEY (weaponID) REFERENCES weapon(weaponID),
  FOREIGN KEY (armorID) REFERENCES armor(armorID)
)
  ENGINE = INNODB