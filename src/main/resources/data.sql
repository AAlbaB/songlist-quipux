-- Listas de canciones
INSERT INTO song_list (name, description) VALUES ('Billie Eilish - Top 5', 'Canciones más populares de Billie Eilish');
INSERT INTO song_list (name, description) VALUES ('Rüfüs Du Sol - Top 5', 'Canciones más populares de Rüfüs Du Sol');

-- Canciones de Billie Eilish
INSERT INTO song (title, artist, album, release_year, genre, song_list_id) VALUES ('bad guy', 'Billie Eilish', 'WHEN WE ALL FALL ASLEEP, WHERE DO WE GO?', '2019', 'Pop', 1);
INSERT INTO song (title, artist, album, release_year, genre, song_list_id) VALUES ('bury a friend', 'Billie Eilish', 'WHEN WE ALL FALL ASLEEP, WHERE DO WE GO?', '2019', 'Pop', 1);
INSERT INTO song (title, artist, album, release_year, genre, song_list_id) VALUES ('when the party''s over', 'Billie Eilish', 'WHEN WE ALL FALL ASLEEP, WHERE DO WE GO?', '2019', 'Ballad', 1);
INSERT INTO song (title, artist, album, release_year, genre, song_list_id) VALUES ('ocean eyes', 'Billie Eilish', 'Don''t Smile at Me', '2016', 'Indie', 1);
INSERT INTO song (title, artist, album, release_year, genre, song_list_id) VALUES ('everything i wanted', 'Billie Eilish', 'Single', '2019', 'Pop', 1);

-- Canciones de Rüfüs Du Sol
INSERT INTO song (title, artist, album, release_year, genre, song_list_id) VALUES ('Innerbloom', 'Rüfüs Du Sol', 'Bloom', '2015', 'Electronic', 2);
INSERT INTO song (title, artist, album, release_year, genre, song_list_id) VALUES ('Underwater', 'Rüfüs Du Sol', 'SOLACE', '2018', 'Electronic', 2);
INSERT INTO song (title, artist, album, release_year, genre, song_list_id) VALUES ('Alive', 'Rüfüs Du Sol', 'Surrender', '2021', 'Electronic', 2);
INSERT INTO song (title, artist, album, release_year, genre, song_list_id) VALUES ('On My Knees', 'Rüfüs Du Sol', 'Surrender', '2021', 'Electronic', 2);
INSERT INTO song (title, artist, album, release_year, genre, song_list_id) VALUES ('Next to Me', 'Rüfüs Du Sol', 'Surrender', '2021', 'Electronic', 2);
