create table USER
(
    Email       varchar(30)     NOT NULL,
    Password    varchar(30)   DEFAULT ' '  NOT NULL,
    First       varchar(15)   DEFAULT ' '   NOT NULL,
    Last        varchar(15)   DEFAULT ' '  NOT NULL,
    Phone       varchar(15)     NOT NULL,

    PRIMARY KEY (Email)
);

create table RECEIVER
(
    Phone        varchar(15)    NOT NULL,
    Email        varchar(30)    NOT NULL,
    ToAddress    varchar(30)    NOT NULL,
    PRIMARY KEY (ToAddress),
    FOREIGN KEY (Email) References USER (Email)
);

create table SENDER
(
    Phone       varchar(15)    NOT NULL,
    Email        varchar(30)    NOT NULL,
    FromAddress    varchar(30)    NOT NULL,
    PRIMARY KEY (FromAddress),
    FOREIGN KEY (Email) References USER (Email)
);

create table SHIPPER
(
    Phone        varchar(15)    NOT NULL,
    Email        varchar(30)    NOT NULL,
    LicenseId    varchar(10)    NOT NULL,
    PRIMARY KEY (LicenseId),
    FOREIGN KEY (Email) References USER (Email)
);


create table PACKAGE
(
    Type        varchar(10)    NOT NULL,
    PackageID    int        NOT NULL,
    Dimensions    varchar(10)        NOT NULL,
    Weight     double      NOT NULL,
    PRIMARY KEY (PackageID)
);

create table DELIVERY
(
    ArrivalDate        date        NOT NULL,
    ArrivalTime        time        NOT NULL,
    DeliveryID        int             NOT NULL,
    ShippingSpeed    varchar(10)    NOT NULL,
    ToAddress        varchar(30)    NOT NULL,
    FromAddress        varchar(30)    NOT NULL,
    PackageID         int        NOT NULL,
    PRIMARY KEY (DeliveryID),
    FOREIGN KEY (ToAddress) References RECEIVER (ToAddress),
    FOREIGN KEY (FromAddress) References SENDER (FromAddress),
    FOREIGN KEY (PackageID) References PACKAGE (PackageID)
);


create table DELIVERY_ROUTE
(
    StartTime    TIME    NULL,
    EndTime    TIME    NULL,
    RouteID    int    NOT NULL,
    RouteNo    int    NOT NULL,
    PRIMARY KEY (RouteID)
);

create table VEHICLE
(
    VehicleID    int        NOT NULL,
    VehicleType    varchar(10)    NULL,
    Capacity    int             NULL,
    PRIMARY KEY (VehicleID)
);

create table RECEIVES
(
    ToAddress    varchar(30)    NOT NULL,
    DeliveryID    int        NOT NULL,
    PRIMARY KEY (ToAddress),
    FOREIGN KEY (ToAddress) References RECEIVER (ToAddress),
    FOREIGN KEY (DeliveryID) References DELIVERY (DeliveryID)
);

create table SENDS
(
    FromAddress    varchar(30)    NOT NULL,
    DeliveryID    int        NOT NULL,
    FOREIGN KEY (FromAddress) References SENDER (FromAddress),
    FOREIGN KEY (DeliveryID) References DELIVERY (DeliveryID)
);

create table DRIVES
(
    VehicleID    int        NOT NULL,
    LicenseID     varchar(10)    NOT NULL,
    FOREIGN KEY (VehicleID) References VEHICLE (VehicleID),
    FOREIGN KEY (LicenseID) References SHIPPER (LicenseID)
);

create table CARRIES
(
    DeliveryID    int    NOT NULL,
    VehicleID    int    NOT NULL,
    FOREIGN KEY (DeliveryID) References DELIVERY (DeliveryID),
    FOREIGN KEY (VehicleID) References VEHICLE (VehicleID)
);

create table AT
(
    DeliveryID    int    NOT NULL,
    RouteID    int    NOT NULL,
    FOREIGN KEY (DeliveryID) References DELIVERY (DeliveryID),
    FOREIGN KEY (RouteID) References DELIVERY_ROUTE (RouteID)
);


create table THROUGH
(
    VehicleID    int    NOT NULL,
    RouteID    int    NOT NULL,
    FOREIGN KEY (VehicleID) References VEHICLE (VehicleID),
    FOREIGN KEY (RouteID) References DELIVERY_ROUTE (RouteID)
);


create table HAS_A
(
    DeliveryID int NOT NULL,
    PackageID  int NOT NULL,
    FOREIGN KEY (DeliveryID) References DELIVERY (DeliveryID),
    FOREIGN KEY (PackageID) References PACKAGE (PackageID)
);
