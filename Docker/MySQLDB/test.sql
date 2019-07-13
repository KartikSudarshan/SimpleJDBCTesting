CREATE IF NOT EXISTS DATABASE TestData;
USE TestData;

DROP TABLE IF EXISTS customer;
CREATE TABLE IF NOT EXISTS `customer` (
    id              INTEGER PRIMARY KEY, 
    name            TEXT,
    address         TEXT,
    city            TEXT,
    state           TEXT,
    zip             TEXT
);
INSERT INTO customer VALUES(1,'Bill Smith','123 Main Street','Hope','CA','98765');
INSERT INTO customer VALUES(2,'Mary Smith','123 Dorian Street','Harmony','AZ','98765');
INSERT INTO customer VALUES(3,'Bob Smith','123 Laugh Street','Humor','CA','98765');
DROP TABLE IF EXISTS item;
CREATE TABLE IF NOT EXISTS `item` (
    id              INTEGER PRIMARY KEY,
    name            TEXT,
    description     TEXT
);
INSERT INTO item VALUES(1,'Box of 64 Pixels','64 RGB pixels in a decorative box');
INSERT INTO item VALUES(2,'Sense of Humor','Especially dry. Imported from England.');
INSERT INTO item VALUES(3,'Beauty','Inner beauty. No cosmetic surgery required!');
INSERT INTO item VALUES(4,'Bar Code','Unused. In original packaging.');
DROP TABLE IF EXISTS sale;
CREATE TABLE IF NOT EXISTS `sale` (
    id              INTEGER PRIMARY KEY,
    item_id         INTEGER,
    customer_id     INTEGER,
    date            TEXT,
    quantity        INTEGER,
    price           INTEGER     
);
INSERT INTO sale VALUES(1,1,2,'2009-02-27',3,2995);
INSERT INTO sale VALUES(2,2,2,'2009-02-27',1,1995);
INSERT INTO sale VALUES(3,1,1,'2009-02-28',1,2995);
INSERT INTO sale VALUES(4,4,3,'2009-02-28',2,999);
INSERT INTO sale VALUES(5,1,2,'2009-02-28',1,2995);
