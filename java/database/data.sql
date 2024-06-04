BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO landmarks (landmark_name, address, category, description, landmark_image, distance)
VALUES
    ('Montreal Museum of Fine Arts', '1380 Rue Sherbrooke O, Montreal, QC H3G 1J5', 'Museum', 'The Montreal Museum of Fine Arts (MMFA) is an art museum in Montreal, Quebec, Canada.', 'museum_image.jpg', 0.5),
    ('Old Montreal', 'Montreal, Quebec, Canada', 'Historic Site', 'Old Montreal is a historic area located in the borough of Ville-Marie in Montreal, Quebec, Canada.', 'old_montreal_image.jpg', 2.5),
    ('Mount Royal Park', '1260 Remembrance Rd, Montreal, QC H3H 1A2', 'Park', 'Mount Royal Park is a large volcanic-related hill or small mountain in the city of Montreal, immediately west of Downtown Montreal, Quebec, Canada.', 'mount_royal_park_image.jpg', 2.0),
    ('Notre-Dame Basilica', '110 Notre-Dame St W, Montreal, QC H2Y 1T1', 'Church', 'Notre-Dame Basilica is a basilica in the historic district of Old Montreal, in Montreal, Quebec, Canada.', 'notre_dame_basilica_image.jpg', 1.0),
    ('Montreal Botanical Garden', '4101 Sherbrooke St E, Montreal, QC H1X 2B2', 'Garden', 'The Montreal Botanical Garden is a large botanical garden in Montreal, Quebec, Canada comprising 75 hectares of thematic gardens and greenhouses.', 'botanical_garden_image.jpg', 5.0);

INSERT INTO schedule (day_of_week, open_time, close_time, landmark_id)
VALUES
    ('Monday', '12:00', '21:30', 1),
    ('Tuesday', '12:00', '21:30', 1),
    ('Wednesday', '12:00', '21:30', 1),
    ('Thursday', '12:00', '21:30', 1),
    ('Friday', '12:00', '21:30', 1),
    ('Saturday', '12:00', '21:30', 1),
    ('Sunday', '12:00', '21:30', 1),
    ('Monday', '12:00', '21:30', 2),
    ('Tuesday', '12:00', '21:30', 2),
    ('Wednesday', '12:00', '21:30', 2),
    ('Thursday', '12:00', '21:30', 2),
    ('Friday', '12:00', '21:30', 2),
    ('Saturday', '12:00', '21:30', 2),
    ('Sunday', '12:00', '21:30', 2),
    ('Monday', '12:00', '21:30', 3),
    ('Tuesday', '12:00', '21:30', 3),
    ('Wednesday', '12:00', '21:30', 3),
    ('Thursday', '12:00', '21:30', 3),
    ('Friday', '12:00', '21:30', 3),
    ('Saturday', '12:00', '21:30', 3),
    ('Sunday', '12:00', '21:30', 3),
    ('Monday', '12:00', '21:30', 4),
    ('Tuesday', '12:00', '21:30', 4),
    ('Wednesday', '12:00', '21:30', 4),
    ('Thursday', '12:00', '21:30', 4),
    ('Friday', '12:00', '21:30', 4),
    ('Saturday', '12:00', '21:30', 4),
    ('Sunday', '12:00', '21:30', 4),
    ('Monday', '12:00', '21:30', 5),
    ('Tuesday', '12:00', '21:30', 5),
    ('Wednesday', '12:00', '21:30', 5),
    ('Thursday', '12:00', '21:30', 5),
    ('Friday', '12:00', '21:30', 5),
    ('Saturday', '12:00', '21:30', 5),
    ('Sunday', '12:00', '21:30', 5);

COMMIT TRANSACTION;
