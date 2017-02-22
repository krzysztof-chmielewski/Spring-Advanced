USE spring;

INSERT INTO artist (artist)
VALUES ('Iron Maiden'), ('System of a Down'), ('Guns n` Roses'), ('Metallica')
;

INSERT INTO album (artist_id, album)
VALUES
  (1, 'A Matter of Life and Death'),
  (1, 'Fear of the Dark'),
  (2, 'Toxicity'),
  (2, 'Mesmerize'),
  (3, 'Hypnotize'),
  (3, 'Use Your Illusion I'),
  (3, 'Use Your Illusion II'),
  (4, 'Master of Puppets'),
  (4, 'Death Magnetic')
;

INSERT INTO song (album_id, title)
VALUES
  (1, 'For the Greater Good of God'),
  (1, 'Lord of Light'),
  (2, 'Fear of the Dark'),
  (3, 'Toxicity'),
  (3, 'Aerials'),
  (4, 'B.Y.O.B'),
  (4, 'Lost in Hollywood'),
  (5, 'Lonely Day'),
  (5, 'Holy Mountains'),
  (5, 'Attack'),
  (6, 'November Rain'),
  (7, 'Don`t Cry'),
  (8, 'Master of Puppets'),
  (8, 'Orion'),
  (9, 'The Unforgiven III')
;