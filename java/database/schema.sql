BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

create TABLE landmarks(
    landmark_id SERIAL,
    landmark_name varchar(50) NOT NULL UNIQUE,
    street_name varchar(50) NOT NULL,
    house_number varchar(15),
    zip_code varchar(10) NOT NULL,
    city varchar(50) NOT NULL,
    state varchar(50) NOT NULL,

    CONSTRAINT PK_landmark PRIMARY KEY (landmark_id)

);

create TABLE itineraries(
    itinerary_id SERIAL,
    name varchar(50) NOT NULL UNIQUE ,
    starting_location varchar(50),
    start_date DATE,
    start_time TIME,
    CONSTRAINT PK_itinerary PRIMARY KEY (itinerary_id)


)
COMMIT TRANSACTION;
