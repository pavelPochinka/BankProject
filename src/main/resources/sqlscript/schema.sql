CREATE TABLE USERS
(
    OBJECT_ID   UUID PRIMARY KEY,
    FIRST_NAME  VARCHAR NOT NULL,
    SECOND_NAME VARCHAR
);


CREATE TABLE CARDS
(
    OBJECT_ID   UUID PRIMARY KEY,
    CARD_NUMBER NUMERIC(16) UNIQUE NOT NULL,
    USER_ID     UUID               NOT NULL,
    COUNT_ID    UUID               NOT NULL
);

CREATE TABLE COUNTS
(
    OBJECT_ID UUID PRIMARY KEY,
    COUNT     NUMERIC(18) UNIQUE NOT NULL,
    AMOUNT    NUMERIC(20, 2),
    CURRENCY  VARCHAR            NOT NULL
);

CREATE TABLE CURRENCIES
(
    CURRENCY  VARCHAR PRIMARY KEY,
    FULL_NAME VARCHAR NOT NULL
);

ALTER TABLE CARDS
    ADD FOREIGN KEY (USER_ID) REFERENCES USERS (OBJECT_ID);


ALTER TABLE CARDS
    ADD FOREIGN KEY (COUNT_ID) REFERENCES COUNTS (OBJECT_ID);

ALTER TABLE COUNTS
    ADD FOREIGN KEY (CURRENCY) REFERENCES CURRENCIES (CURRENCY);

    INSERT INTO CURRENCIES

VALUES ('RU', 'РУБЛИ');

    INSERT INTO CURRENCIES
VALUES ('EU', 'ЕВРО');

    INSERT INTO CURRENCIES
VALUES ('DOL', 'ДОЛЛАР')