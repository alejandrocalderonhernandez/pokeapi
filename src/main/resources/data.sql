DROP TABLE IF EXISTS request;

CREATE TABLE request (
  ip varchar(20) PRIMARY KEY,
  url varchar(250) NOT NULL,
  date_req timestamp NOT NULL
);