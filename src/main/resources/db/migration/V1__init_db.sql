CREATE TABLE IF NOT EXISTS court
( 
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255),
	latitude DOUBLE(7,5),
	longitude DOUBLE(7,5),
	renovation_status VARCHAR(255),
	court_type VARCHAR(255)
);

INSERT INTO court(id, name, latitude, longitude, renovation_status, court_type) VALUES
	(1, 'Sub Tampa/Vointa', 45.64316, 25.59418, 'RENOVATED', 'INDOOR'),
	(2, 'Fartec', 45.66966, 25.59241,'RENOVATED','OUTDOOR'),
	(3, 'Livada/Schaeffler', 45.64739, 25.58583,'NOT_RENOVATED','OUTDOOR'),
	(4, 'Triaj', 45.67742, 25.64408,'NOT_RENOVATED','OUTDOOR'),
	(5, 'Agricultorilor', 45.66968, 25.57605,'RENOVATED','INDOOR'),
	(6, 'Stefan cel Mare', 45.64369, 25.63480,'RENOVATED','OUTDOOR'),
	(7, 'Aluminiului', 45.67135, 25.59787,'UNDER_RENOVATION','OUTDOOR'),
	(8, 'Popa Sapca', 45.65250, 25.61752,'RENOVATED','OUTDOOR');