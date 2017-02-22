CREATE SCHEMA spring;
USE spring;

CREATE TABLE artist (
  id INT AUTO_INCREMENT,
  artist VARCHAR(100),
  PRIMARY KEY(id)
);

CREATE TABLE album (
  id INT AUTO_INCREMENT,
  album VARCHAR(100),
  artist_id INT,
  PRIMARY KEY(id),
  FOREIGN KEY (artist_id) REFERENCES artist(id)
);

CREATE TABLE song (
  id INT AUTO_INCREMENT,
  album_id INT,
  title VARCHAR(100),
  PRIMARY KEY(id),
  FOREIGN KEY (album_id) REFERENCES album(id)
);