CREATE TABLE IF NOT EXISTS FLIGHT (
                                      ID INT PRIMARY KEY AUTO_INCREMENT,
                                      FLIGHT_NUMBER VARCHAR(50) NOT NULL,
    ORIGIN VARCHAR(50) NOT NULL,
    DESTINATION VARCHAR(50) NOT NULL,
    DEPARTURE_TIME TIME NOT NULL,
    ARRIVAL_TIME TIME NOT NULL,
    PRICE DECIMAL(10, 2) NOT NULL
    );

INSERT INTO flight (flight_number, origin, destination, departure_time, arrival_time, price)
VALUES ('A101', 'AMS', 'DEL', '11:00', '17:00', 850.0);
INSERT INTO flight (flight_number, origin, destination, departure_time, arrival_time, price)
VALUES ('B101', 'AMS', 'BOM', '12:00', '19:30', 750.0);
INSERT INTO flight (flight_number, origin, destination, departure_time, arrival_time, price)
VALUES ('C101', 'AMS', 'BLR', '13:00', '18:30', 800.0);
INSERT INTO flight (flight_number, origin, destination, departure_time, arrival_time, price)
VALUES ('D101', 'AMS', 'MAA', '09:00', '15:00', 600.0);
INSERT INTO flight (flight_number, origin, destination, departure_time, arrival_time, price)
VALUES ('E101', 'MAA', 'BOM', '16:00', '17:30', 100.0);
INSERT INTO flight (flight_number, origin, destination, departure_time, arrival_time, price)
VALUES ('F101', 'BOM', 'DEL', '20:30', '21:30', 80.0);
INSERT INTO flight (flight_number, origin, destination, departure_time, arrival_time, price)
VALUES ('G101', 'BOM', 'DEL', '18:00', '19:30', 100.0);
INSERT INTO flight (flight_number, origin, destination, departure_time, arrival_time, price)
VALUES ('A201', 'LHR', 'DEL', '11:30', '17:00', 600.0);
INSERT INTO flight (flight_number, origin, destination, departure_time, arrival_time, price)
VALUES ('B201', 'LHR', 'BOM', '12:35', '19:30', 750.0);
INSERT INTO flight (flight_number, origin, destination, departure_time, arrival_time, price)
VALUES ('C201', 'LHR', 'BLR', '13:45', '18:30', 800.0);
INSERT INTO flight (flight_number, origin, destination, departure_time, arrival_time, price)
VALUES ('D201', 'LHR', 'MAA', '09:00', '15:00', 600.0);
INSERT INTO flight (flight_number, origin, destination, departure_time, arrival_time, price)
VALUES ('E201', 'DEL', 'BOM', '18:45', '20:15', 100.0);
INSERT INTO flight (flight_number, origin, destination, departure_time, arrival_time, price)
VALUES ('F201', 'BOM', 'DEL', '21:15', '22:30', 80.0);
INSERT INTO flight (flight_number, origin, destination, departure_time, arrival_time, price)
VALUES ('G01', 'BOM', 'DEL', '20:20', '21:30', 100.0);
