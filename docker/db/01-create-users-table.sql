CREATE TABLE users (
   username VARCHAR(255) NOT NULL,
   password VARCHAR(255) NOT NULL,
   account_non_locked BOOL NOT NULL DEFAULT TRUE,
   PRIMARY KEY (username)
);
