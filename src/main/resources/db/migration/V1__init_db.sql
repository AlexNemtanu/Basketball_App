CREATE TABLE IF NOT EXISTS court
( 
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255),
	coordinates POINT,
	renovation_status ENUM('RENOVATED','UNDER_RENOVATION', 'NOT_RENOVATED'),
	court_type ENUM('INDOOR', 'OUTDOOR')
);

INSERT INTO court(id, name, coordinates, renovation_status, court_type) VALUES
	(1, 'Teren Basket - Sub Tampa/Vointa', POINT(45.64316, 25.59418), 'RENOVATED', 'OUTDOOR'),
	(2, 'Teren Basket - Fartec', POINT(45.66966, 25.59241),'RENOVATED','OUTDOOR'),
	(3, 'Teren Basket - Livada/Schaeffler', POINT(45.64739, 25.58583),'NOT_RENOVATED','OUTDOOR'),
	(4, 'Teren Basket - Triaj', POINT(45.67742, 25.64408),'RENOVATED','OUTDOOR'),
	(5, 'Teren Basket - Agricultorilor', POINT(45.66968, 25.57605),'RENOVATED','OUTDOOR'),
	(6, 'Teren Basket - Stefan cel Mare', POINT(45.64369, 25.63480),'RENOVATED','OUTDOOR'),
	(7, 'Teren Basket Aluminiului', POINT(45.67135, 25.59787),'RENOVATED','OUTDOOR'),
	(8, 'Teren Basket Popa Sapca', POINT(45.65250, 25.61752),'RENOVATED','OUTDOOR'),
	(9, 'Teren Fotbal Harmanului - Craiter', POINT(45.66553, 25.62609),'RENOVATED','OUTDOOR'),
	(10,'Teren Fotbal Stefan cel Mare', POINT(45.64438, 25.63386),'RENOVATED','OUTDOOR'),
	(11, 'Teren Fotbal - Cocorului', POINT(45.63986, 25.63156),'RENOVATED','OUTDOOR'),
	(12, 'Teren Fotbal - Aluminiului', POINT(45.67279, 25.59787),'RENOVATED','OUTDOOR');