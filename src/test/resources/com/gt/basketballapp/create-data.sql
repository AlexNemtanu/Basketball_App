CREATE TABLE IF NOT EXISTS court
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    latitude DOUBLE(7,5),
    longitude DOUBLE(7,5),
    renovation_status ENUM('RENOVATED','UNDER_RENOVATION', 'NOT_RENOVATED'),
    court_type ENUM('INDOOR', 'OUTDOOR')
);
INSERT INTO COURT(id, name, latitude, longitude, renovation_status, court_type) VALUES ('3','testName1',45.64316, 25.59418, 'INDOOR','UNDER_RENOVATION');
INSERT INTO COURT(id, name, latitude, longitude, renovation_status, court_type) VALUES ('4','testName2',45.64316, 25.59418, 'OUTDOOR','RENOVATED');
INSERT INTO COURT(id, name, latitude, longitude, renovation_status, court_type) VALUES ('7','testName3',45.64316, 25.59418, 'OUTDOOR','NOT_RENOVATED');