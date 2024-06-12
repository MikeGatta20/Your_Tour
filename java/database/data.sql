BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO landmarks (landmark_name, address, category, description, landmark_image, distance)
VALUES
    ('Montreal Museum of Fine Arts', '1380 Rue Sherbrooke O, Montreal, QC H3G 1J5', 'Museum', 'The Montreal Museum of Fine Arts (MMFA) is an art museum in Montreal, Quebec, Canada.', '/montreal_museum_of_fine_arts.jpg', 0.5),
    ('Old Montreal', '303 Notre-Dame St E, Montreal, QC H2Y 3Y8', 'Historic Site', 'Old Montreal is a historic area located in the borough of Ville-Marie in Montreal, Quebec, Canada.', '/old_montreal.jpg', 2.5),
    ('Mount Royal Park', '1260 Remembrance Rd, Montreal, QC H3H 1A2', 'Park', 'Mount Royal Park is a large volcanic-related hill or small mountain in the city of Montreal, immediately west of Downtown Montreal, Quebec, Canada.', '/mount_royal_park.jpg', 2.0),
    ('Notre-Dame Basilica', '110 Notre-Dame St W, Montreal, QC H2Y 1T1', 'Church', 'Notre-Dame Basilica is a basilica in the historic district of Old Montreal, in Montreal, Quebec, Canada.', '/notre_dame_basilica.jpg', 1.0),
    ('Montreal Botanical Garden', '4101 Sherbrooke St E, Montreal, QC H1X 2B2', 'Garden', 'The Montreal Botanical Garden is a large botanical garden in Montreal, Quebec, Canada comprising 75 hectares of thematic gardens and greenhouses.', '/montreal_botanical_garden.jpg', 5.0),
    ('La Ronde', '22 Chemin Macdonald, Montreal, QC H3C 6A3', 'Amusement Park', 'La Ronde is a popular amusement park in Montreal with a variety of rides and entertainment.', '/la_ronde.jpg', 5.7),
    ('Jean-Talon Market', '7070 Avenue Henri-Julien, Montreal, QC H2S 3S3', 'Market', 'Jean-Talon Market is one of the largest public markets in North America, offering a wide variety of fresh produce.', '/jean_talon_market.jpg', 6.1),
    ('Montreal Science Centre', '2 de la Commune St W, Montreal, QC H2Y 4B2', 'Museum', 'The Montreal Science Centre is a science museum in Montreal located on the King Edward Pier in the Old Port of Montreal.', '/montreal_science_centre.jpg', 2.8),
    ('McGill University', '845 Sherbrooke St W, Montreal, QC H3A 0G4', 'Educational Institution', 'McGill University is a public research university in Montreal, renowned for its medical school and other programs.', '/mcgill_university.jpg', 0.7),
    ('Eaton Centre Montreal', '705 Rue Sainte-Catherine O, Montreal, QC H3B 4G5', 'Shopping', 'Eaton Centre Montreal is a large shopping mall in downtown Montreal, featuring a variety of shops and restaurants.', '/eaton_centre.jpg', 1.2),
    ('The Montreal Museum of Contemporary Art', '185 Sainte-Catherine St W, Montreal, QC H2X 3X5', 'Museum', 'The Montreal Museum of Contemporary Art is a contemporary art museum in Montreal.', '/museum_of_contemporary_art.jpg', 1.5),
    ('Bell Centre', '1909 Avenue des Canadiens-de-Montréal, Montreal, QC H4B 5G0', 'Stadium', 'The Bell Centre is a sports and entertainment complex in Montreal, best known as the home of the Montreal Canadiens.', '/bell_centre.jpg', 0.9),
    ('Mount Royal Chalet', '1196 Voie Camillien-Houde, Montreal, QC H3H 1A1', 'Park', 'Mount Royal Chalet offers stunning views of the city of Montreal and is a popular spot for tourists and locals alike.', '/mount_royal_chalet.jpg', 2.0);

INSERT INTO schedule (day_of_week, open_time, close_time, landmark_id)
VALUES
    ('Monday', '08:00 AM', '06:00 PM', 1),
    ('Tuesday', '08:00 AM', '06:00 PM', 1),
    ('Wednesday', '08:00 AM', '06:00 PM', 1),
    ('Thursday', '08:00 AM', '06:00 PM', 1),
    ('Friday', '08:00 AM', '06:00 PM', 1),
    ('Saturday', '09:00 AM', '05:00 PM', 1),
    ('Sunday', '09:00 AM', '05:00 PM', 1),

    ('Monday', '09:00 AM', '07:00 PM', 2),
    ('Tuesday', '09:00 AM', '07:00 PM', 2),
    ('Wednesday', '09:00 AM', '07:00 PM', 2),
    ('Thursday', '09:00 AM', '07:00 PM', 2),
    ('Friday', '09:00 AM', '07:00 PM', 2),
    ('Saturday', '10:00 AM', '06:00 PM', 2),
    ('Sunday', '10:00 AM', '06:00 PM', 2),

    ('Monday', '10:00 AM', '08:00 PM', 3),
    ('Tuesday', '10:00 AM', '08:00 PM', 3),
    ('Wednesday', '10:00 AM', '08:00 PM', 3),
    ('Thursday', '10:00 AM', '08:00 PM', 3),
    ('Friday', '10:00 AM', '08:00 PM', 3),
    ('Saturday', '11:00 AM', '07:00 PM', 3),
    ('Sunday', '11:00 AM', '07:00 PM', 3),

    ('Monday', '11:00 AM', '09:00 PM', 4),
    ('Tuesday', '11:00 AM', '09:00 PM', 4),
    ('Wednesday', '11:00 AM', '09:00 PM', 4),
    ('Thursday', '11:00 AM', '09:00 PM', 4),
    ('Friday', '11:00 AM', '09:00 PM', 4),
    ('Saturday', '12:00 PM', '08:00 PM', 4),
    ('Sunday', '12:00 PM', '08:00 PM', 4),

    ('Monday', '12:00 PM', '10:00 PM', 5),
    ('Tuesday', '12:00 PM', '10:00 PM', 5),
    ('Wednesday', '12:00 PM', '10:00 PM', 5),
    ('Thursday', '12:00 PM', '10:00 PM', 5),
    ('Friday', '12:00 PM', '10:00 PM', 5),
    ('Saturday', '01:00 PM', '09:00 PM', 5),
    ('Sunday', '01:00 PM', '09:00 PM', 5),

    ('Monday', '07:00 AM', '03:00 PM', 6),
    ('Tuesday', '07:00 AM', '03:00 PM', 6),
    ('Wednesday', '07:00 AM', '03:00 PM', 6),
    ('Thursday', '07:00 AM', '03:00 PM', 6),
    ('Friday', '07:00 AM', '03:00 PM', 6),
    ('Saturday', '08:00 AM', '04:00 PM', 6),
    ('Sunday', '08:00 AM', '04:00 PM', 6),

    ('Monday', '08:00 AM', '04:00 PM', 7),
    ('Tuesday', '08:00 AM', '04:00 PM', 7),
    ('Wednesday', '08:00 AM', '04:00 PM', 7),
    ('Thursday', '08:00 AM', '04:00 PM', 7),
    ('Friday', '08:00 AM', '04:00 PM', 7),
    ('Saturday', '09:00 AM', '05:00 PM', 7),
    ('Sunday', '09:00 AM', '05:00 PM', 7),

    ('Monday', '09:00 AM', '05:00 PM', 8),
    ('Tuesday', '09:00 AM', '05:00 PM', 8),
    ('Wednesday', '09:00 AM', '05:00 PM', 8),
    ('Thursday', '09:00 AM', '05:00 PM', 8),
    ('Friday', '09:00 AM', '05:00 PM', 8),
    ('Saturday', '10:00 AM', '06:00 PM', 8),
    ('Sunday', '10:00 AM', '06:00 PM', 8),

    ('Monday', '10:00 AM', '06:00 PM', 9),
    ('Tuesday', '10:00 AM', '06:00 PM', 9),
    ('Wednesday', '10:00 AM', '06:00 PM', 9),
    ('Thursday', '10:00 AM', '06:00 PM', 9),
    ('Friday', '10:00 AM', '06:00 PM', 9),
    ('Saturday', '11:00 AM', '07:00 PM', 9),
    ('Sunday', '11:00 AM', '07:00 PM', 9),

    ('Monday', '11:00 AM', '07:00 PM', 10),
    ('Tuesday', '11:00 AM', '07:00 PM', 10),
    ('Wednesday', '11:00 AM', '07:00 PM', 10),
    ('Thursday', '11:00 AM', '07:00 PM', 10),
    ('Friday', '11:00 AM', '07:00 PM', 10),
    ('Saturday', '12:00 PM', '08:00 PM', 10),
    ('Sunday', '12:00 PM', '08:00 PM', 10),

    ('Monday', '12:00 PM', '08:00 PM', 11),
    ('Tuesday', '12:00 PM', '08:00 PM', 11),
    ('Wednesday', '12:00 PM', '08:00 PM', 11),
    ('Thursday', '12:00 PM', '08:00 PM', 11),
    ('Friday', '12:00 PM', '08:00 PM', 11),
    ('Saturday', '01:00 PM', '09:00 PM', 11),
    ('Sunday', '01:00 PM', '09:00 PM', 11),

    ('Monday', '01:00 PM', '09:00 PM', 12),
    ('Tuesday', '01:00 PM', '09:00 PM', 12),
    ('Wednesday', '01:00 PM', '09:00 PM', 12),
    ('Thursday', '01:00 PM', '09:00 PM', 12),
    ('Friday', '01:00 PM', '09:00 PM', 12),
    ('Saturday', '02:00 PM', '10:00 PM', 12),
    ('Sunday', '02:00 PM', '10:00 PM', 12),

    ('Monday', '02:00 PM', '10:00 PM', 13),
    ('Tuesday', '02:00 PM', '10:00 PM', 13),
    ('Wednesday', '02:00 PM', '10:00 PM', 13),
    ('Thursday', '02:00 PM', '10:00 PM', 13),
    ('Friday', '02:00 PM', '10:00 PM', 13),
    ('Saturday', '03:00 PM', '11:00 PM', 13),
    ('Sunday', '03:00 PM', '11:00 PM', 13);




INSERT INTO landmark_ratings (user_id,landmark_id,thumbs_up,thumbs_down)
VALUES(2,1,1,0),
      (1,2,0,1),
      (1,3,0,1),
      (1,4,1,0),
      (1,5,1,0);


COMMIT TRANSACTION;
