BEGIN TRANSACTION;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS landmarks;
DROP TABLE IF EXISTS itinerary;
DROP TABLE IF EXISTS user_itinerary;
DROP TABLE IF EXISTS itinerary_landmarks;
CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT pk_user PRIMARY KEY (user_id)
);
create TABLE landmarks(
    landmark_id SERIAL,
    landmark_name varchar(50) NOT NULL UNIQUE,
	house_number varchar(15),
    street_name varchar(50) NOT NULL,
	city varchar(50) NOT NULL,
    state_name varchar(50) NOT NULL,
	zip_code varchar(10) NOT NULL,
	available_hours timestamp NOT NULL,
	category varchar(50) NOT NULL,
	description varchar (500) NOT NULL,
	landmark_image varchar (100) NOT NULL,
	distance decimal NOT NULL,

    CONSTRAINT pk_landmark PRIMARY KEY (landmark_id)
);
create TABLE itineraries(
    itinerary_id SERIAL,
    name varchar(50) NOT NULL UNIQUE ,
    starting_location varchar(50),
    start_date DATE,
    start_time TIME,
    CONSTRAINT pk_itinerary PRIMARY KEY (itinerary_id)

);
create TABLE user_itinerary(
	user_id int NOT NULL,
	itinerary_id int NOT NULL,
	CONSTRAINT pk_user_itinerary PRIMARY KEY (user_id, itinerary_id),
	CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (user_id),
	CONSTRAINT fk_itinerary_id FOREIGN KEY (itinerary_id) REFERENCES itineraries (itinerary_id)

);
create TABLE itinerary_landmarks(
	itinerary_id int NOT NULL,
	landmark_id int NOT NULL,
	CONSTRAINT pk_itinerary_landmarks PRIMARY KEY (itinerary_id, landmark_id),
	CONSTRAINT fk_itinerary_id FOREIGN KEY (itinerary_id) REFERENCES itineraries (itinerary_id),
	CONSTRAINT fk_landmark_id FOREIGN KEY (landmark_id) REFERENCES landmarks (landmark_id)

);

COMMIT TRANSACTION;
