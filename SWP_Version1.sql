CREATE TABLE [role]
(
    role_id   INT PRIMARY KEY,
    role_name varchar(50)
)

CREATE TABLE [admin]
(
    admin_id INTEGER IDENTITY(1,1) PRIMARY KEY,
    email    VARCHAR(50) UNIQUE NOT NULL,
    active   BIT DEFAULT 1,
    password VARCHAR(100)       NOT NULL,
    role_id  INT                not null,
    FOREIGN KEY (role_id) REFERENCES [role] (role_id)
)


CREATE TABLE tourist
(
    instructor_id  INTEGER IDENTITY(1,1) PRIMARY KEY,
    active         BIT DEFAULT 1,
    password       VARCHAR(100) NOT NULL,
    full_name      VARCHAR(100) NOT NULL,
    email          VARCHAR(100) NOT NULL,
    role_id        INT          not null,
    phonenumber    VARCHAR(10) DEFAULT 0,
    picture        VARCHAR(255),
    FOREIGN KEY (role_id) REFERENCES [role] (role_id)
)

CREATE TABLE travel_agent
(
    travel_agent_id      INTEGER IDENTITY(1,1) PRIMARY KEY,
    email           VARCHAR(100) UNIQUE NOT NULL,
    email_verified  BIT         DEFAULT 0,
    phone_number    VARCHAR(10) DEFAULT 0,
    active          BIT         DEFAULT 1,
    password        VARCHAR(100),
    full_name       NVARCHAR(100)       NOT NULL,
    date_of_birth   DATE,
    picture_Url     VARCHAR(255),
    enrollment_date DATE,
    role_id         INT                 not null,
    FOREIGN KEY (role_id) REFERENCES [role] (role_id)
)

CREATE TABLE category_tour
(
    category_id   INT PRIMARY KEY,
    category_name VARCHAR(50) NOT NULL
)

CREATE TABLE tour 
(
    tour_id     INT Identity(1,1) PRIMARY KEY,
    tour_name   VARCHAR(50)  NOT NULL,
    img_URL       VARCHAR(255) NOT NULL,
    start_date    DATE         NOT NULL,
    end_date      DATE         NOT NULL,
    description   VARCHAR(250) NOT NULL,
    category_id   INT          NOT NULL,
    travel_agent_id INT          NOT NULL,
    active        INT          NOT NULL,
    price         FLOAT        NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category_tour (category_id),
    FOREIGN KEY (travel_agent_id) REFERENCES travel_agent (travel_agent_id)
)



CREATE TABLE hotel
(
    hotel_id     INT Identity(1,1) PRIMARY KEY,
    hotel_name   VARCHAR(50)  NOT NULL,
    img_URL       VARCHAR(255) NOT NULL,
    start_date    DATE         NOT NULL,
    end_date      DATE         NOT NULL,
    description   VARCHAR(250) NOT NULL,
    travel_agent_id INT          NOT NULL,
    active        INT          NOT NULL,
    price         FLOAT        NOT NULL,
    FOREIGN KEY (travel_agent_id) REFERENCES travel_agent (travel_agent_id)
)

CREATE TABLE hotel_detail
(
    hotel_detail_id     INT Identity(1,1) PRIMARY KEY,
    hotel_id     INT,
	tour_id INT,
	FOREIGN KEY (hotel_id) REFERENCES hotel (hotel_id),
    FOREIGN KEY (tour_id) REFERENCES tour (tour_id)
)

CREATE TABLE restaurant
(
    restaurant_id     INT Identity(1,1) PRIMARY KEY,
    restaurant_name   VARCHAR(50)  NOT NULL,
    img_URL       VARCHAR(255) NOT NULL,
    start_date    DATE         NOT NULL,
    end_date      DATE         NOT NULL,
    description   VARCHAR(250) NOT NULL,
    travel_agent_id INT          NOT NULL,
    active        INT          NOT NULL,
    price         FLOAT        NOT NULL,
    FOREIGN KEY (travel_agent_id) REFERENCES travel_agent (travel_agent_id)
)


CREATE TABLE restaurant_detail
(
    restaurant_detail_id     INT Identity(1,1) PRIMARY KEY,
    restaurant_id     INT,
	tour_id INT,
	FOREIGN KEY (restaurant_id) REFERENCES restaurant (restaurant_id),
    FOREIGN KEY (tour_id) REFERENCES tour (tour_id)
)


CREATE TABLE vehicle
(
    vehicle_id     INT Identity(1,1) PRIMARY KEY,
    vehicle_name   VARCHAR(50)  NOT NULL,
    img_URL       VARCHAR(255) NOT NULL,
    start_date    DATE         NOT NULL,
    end_date      DATE         NOT NULL,
    description   VARCHAR(250) NOT NULL,
    travel_agent_id INT          NOT NULL,
    active        INT          NOT NULL,
    price         FLOAT        NOT NULL,
    FOREIGN KEY (travel_agent_id) REFERENCES travel_agent (travel_agent_id)
)

CREATE TABLE vehicle_detail
(
    vehicle_detail_id     INT Identity(1,1) PRIMARY KEY,
    vehicle_id     INT,
	tour_id INT,
	FOREIGN KEY (vehicle_id) REFERENCES vehicle (vehicle_id),
    FOREIGN KEY (tour_id) REFERENCES tour (tour_id)
)