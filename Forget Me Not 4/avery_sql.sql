--
-- File generated with SQLiteStudio v3.1.1 on Tue Oct 31 22:06:47 2017
--
-- Text encoding used: GB2312
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: trust
DROP TABLE IF EXISTS trust;

CREATE TABLE trust (
    address      STRING,
    picture      BLOB,
    relationship STRING,
    name         STRING,
    phone        INTEGER
);


-- Table: trust_family
DROP TABLE IF EXISTS trust_family;

CREATE TABLE trust_family (
    address      STRING,
    picture      BLOB,
    relationship STRING,
    name         STRING,
    phone        INTEGER
);


-- Table: trust_friends
DROP TABLE IF EXISTS trust_friends;

CREATE TABLE trust_friends (
    address      STRING,
    picture      BLOB,
    relationship STRING,
    name         STRING,
    phone        INTEGER
);


-- Table: user
DROP TABLE IF EXISTS user;

CREATE TABLE user (
    language    STRING,
    username    STRING,
    password    STRING,
    passcode    INTEGER,
    fingerprint BLOB,
    name        STRING,
    address     STRING,
    birthday    DATE,
    picture     BLOB
);


COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
