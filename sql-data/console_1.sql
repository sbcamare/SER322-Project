INSERT INTO USER
    (Phone, Email, Password, First, Last)
VALUES ('5555025099', 'luisR@gmail.com', 'pass', 'Luis', 'Espinoza'),
       ('5523525254', 'ryanR@gmail.com', 'pass', 'Ryan', 'Granado'),
       ('4774672244', 'stevenR@gmail.com', 'pass', 'Steven', 'Camarena'),
       ('5114134144', 'braulioR@gmail.com', 'pass', 'Braulio', 'Espinoza'),
       ('5341343454', 'luisS@gmail.com', 'pass', 'Luis', 'Espinoza'),
       ('6345345533', 'ryanS@gmail.com', 'pass', 'Ryan', 'Granado'),
       ('7735345354', 'stevenS@gmail.com', 'pass', 'Steven', 'Camarena'),
       ('6466542452', 'braulioS@gmail.com', 'pass', 'Braulio', 'Espinoza'),
       ('5245245225', 'luisD@gmail.com', 'pass', 'Luis', 'Espinoza'),
       ('6564644244', 'ryanD@gmail.com', 'pass', 'Ryan', 'Granado'),
       ('6634455345', 'stevenD@gmail.com', 'pass', 'Steven', 'Camarena'),
       ('7724542525', 'braulioD@gmail.com', 'pass', 'Braulio', 'Espinoza');


INSERT INTO RECEIVER
    (Phone, Email, ToAddress)
VALUES ('5555025099', 'luisR@gmail.com', '5666 E 11th St 85301'),
       ('5551231125', 'ryanR@gmail.com', '3112 W 15th St 85313'),
       ('5553133112', 'stevenR@gmail.com', '1231 N 20th St 85112'),
       ('5551223511', 'braulioR@gmail.com', '1121 E 11th St 85301');


INSERT INTO SENDER
    (Phone, Email, FromAddress)
VALUES ('5555025099', 'luisS@gmail.com', '5351 E 11th St 85301'),
       ('5555025099', 'ryanS@gmail.com', '3134 W 15th St 85313'),
       ('5555025099', 'stevenS@gmail.com', '1123 N 20th St 85112'),
       ('5555025099', 'braulioS@gmail.com', '5512 E 11th St 85301');


INSERT INTO SHIPPER
    (Phone, Email, LicenseID)
VALUES ('5555025099', 'luisD@gmail.com', 1),
       ('5551236454', 'ryanD@gmail.com', 2),
       ('5551622423', 'stevenD@gmail.com', 3),
       ('5552341132', 'braulioD@gmail.com', 4);


INSERT INTO PACKAGE
    (Type, PackageID, Dimensions, Weight)
VALUES ('BOX', 1, '5x5', 2.5),
       ('CARD', 2, '5x5', 0.23),
       ('BOX', 3, '5x4', 6.55),
       ('BOX', 4, '3x5', 3.31),
       ('BOX', 5, '15x25', 31.00),
       ('CARD', 6, '5x5', 0.11);


INSERT INTO DELIVERY
(ArrivalDate, ArrivalTime, DeliveryID, ShippingSpeed, ToAddress, FromAddress, PackageID)
VALUES ('2020-08-10', '00:00:00', 1, 'FAST', '5666 E 11th St 85301', '5351 E 11th St 85301', 1),
       ('2020-11-23', '00:00:00', 2, 'SLOW', '3112 W 15th St 85313', '3134 W 15th St 85313', 2),
       ('2020-03-14', '00:00:00', 3, 'SLOW', '1231 N 20th St 85112', '1123 N 20th St 85112', 3),
       ('2020-03-12', '00:00:00', 4, 'SLOW', '1121 E 11th St 85301', '5512 E 11th St 85301', 4);


INSERT INTO DELIVERY_ROUTE
(StartTime, EndTime, RouteID, RouteNo)
VALUES ('07:00:00', '14:00:00', 1, 1),
       ('07:30:00', '14:30:00', 2, 2),
       ('08:00:00', '15:00:00', 3, 3),
       ('08:30:00', '15:30:00', 4, 4),
       ('09:00:00', '16:00:00', 5, 5),
       ('09:30:00', '16:30:00', 6, 6),
       ('10:00:00', '17:00:00', 7, 7);


INSERT INTO VEHICLE
(VehicleID, VehicleType, Capacity)
VALUES (1, 'VAN', 2.5),
       (2, 'TRUCK', 5.5),
       (3, 'TRUCK', 5.5),
       (4, 'VAN', 2.5),
       (5, 'VAN', 2.5);


INSERT INTO RECEIVES
(ToAddress, DeliveryID)
VALUES ('5666 E 11th St 85301', 1),
       ('3112 W 15th St 85313', 2),
       ('1231 N 20th St 85112', 3),
       ('1121 E 11th St 85301', 4);


INSERT INTO SENDS
(FromAddress, DeliveryID)
VALUES ('5351 E 11th St 85301', 1),
       ('3134 W 15th St 85313', 2),
       ('1123 N 20th St 85112', 3),
       ('5512 E 11th St 85301', 4);


INSERT INTO DRIVES
(VehicleID, LicenseID)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4);


INSERT INTO CARRIES
(DeliveryID, VehicleID)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4);


INSERT INTO AT
(DeliveryID, RouteID)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4);


INSERT INTO THROUGH
(VehicleID, RouteID)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4);


INSERT INTO HAS_A
(DeliveryID, PackageID)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4);