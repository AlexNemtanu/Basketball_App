UPDATE court
SET name = 'ALEI SUB TAMPA', court_type = 'MODULAR_FIBA'
WHERE id = 1;

UPDATE court
SET name = 'PARC FARTEC', court_type = 'TARTAN'
WHERE id = 2;

UPDATE court
SET name = 'LIVADA SCHAEFFLER', court_type = 'MODULAR_FIBA', renovation_status = 'RENOVATED'
WHERE id = 3;

UPDATE court
SET name = 'PARC TIMIS TRIAJ', court_type = 'TARTAN'
WHERE id = 4;

UPDATE court
SET name = 'PARC AGRICULTORILOR', court_type = 'TARTAN'
WHERE id = 5;

UPDATE court
SET name = 'PARC STEFAN CEL MARE', court_type = 'TARTAN'
WHERE id = 6;

-- DELETE
DELETE FROM court
WHERE id = 7;

UPDATE court
SET name = 'PARC AGRICULTORILOR', court_type = 'TARTAN'
WHERE id = 8;

UPDATE court
SET name = 'ARGINTULUI - BRONZULUI BASCHET', court_type = 'MODULAR_FIBA'
WHERE id = 9;

UPDATE court
SET name = 'HONTERUS TIRIAC', court_type = 'MODULAR_FIBA'
WHERE id = 10;

UPDATE court
SET name = 'SATURN 15 - APOLLO', court_type = 'TARTAN'
WHERE id = 11;

UPDATE court
SET renovation_status = 'RENOVATED', court_type = 'TARTAN'
WHERE id = 12;

UPDATE court
SET name = 'SCOALA GIMNAZIALA NR.1 BARBU LAUTARU', court_type = 'TARTAN'
WHERE id = 13;

UPDATE court
SET name = 'LICEUL DE ARTE MATTIS TEUTCHS', court_type = 'TARTAN'
WHERE id = 14;

UPDATE court
SET court_type = 'TARTAN'
WHERE id = 15;

UPDATE court
SET name = 'PARC MAGNOLIA - CENTRUL CIVIC BASCHET', court_type = 'MODULAR_FIBA', renovation_status = 'NOT_RENOVATED'
WHERE id = 16;

UPDATE court
SET renovation_status = 'RENOVATED', court_type = 'TARTAN'
WHERE id = 17;