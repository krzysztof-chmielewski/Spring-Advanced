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
  (2, 'Hypnotize'),
  (3, 'Use Your Illusion I'),
  (3, 'Use Your Illusion II'),
  (4, 'Master of Puppets'),
  (4, 'Death Magnetic')
;

INSERT INTO song (album_id, artist_id, title)
VALUES
  (1, 1, 'For the Greater Good of God'),
  (1, 1, 'Lord of Light'),
  (2, 1, 'Fear of the Dark'),
  (3, 2, 'Toxicity'),
  (3, 2, 'Aerials'),
  (4, 2, 'B.Y.O.B'),
  (4, 2, 'Lost in Hollywood'),
  (5, 2, 'Lonely Day'),
  (5, 2, 'Holy Mountains'),
  (5, 2, 'Attack'),
  (6, 3, 'November Rain'),
  (7, 3, 'Don`t Cry'),
  (8, 4, 'Master of Puppets'),
  (8, 4, 'Orion'),
  (9, 4, 'The Unforgiven III')
;