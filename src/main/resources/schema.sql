DROP TABLE IF EXISTS car;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS motorcycle;
DROP TABLE IF EXISTS truck;
DROP TABLE IF EXISTS vehicle;
DROP TABLE IF EXISTS vehicle_sale;
DROP TABLE IF EXISTS vehicle_buyer;

CREATE TABLE IF NOT EXISTS car
(
    id              BIGINT       NOT NULL,
    number_of_doors VARCHAR(255) NULL,
    color           VARCHAR(255) NULL,
    v8engine        BIT(1)       NOT NULL,
    CONSTRAINT pk_car PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS employee
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(255)          NULL,
    email    VARCHAR(255)          NULL,
    password VARCHAR(255)          NULL,
    CONSTRAINT pk_employee PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS motorcycle
(
    id             BIGINT       NOT NULL,
    off_road       BIT(1)       NOT NULL,
    cubic_capacity INT          NOT NULL,
    category       VARCHAR(255) NULL,
    CONSTRAINT pk_motorcycle PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS truck
(
    id             BIGINT NOT NULL,
    load_capacity  INT    NULL,
    number_axle    INT    NULL,
    has_cargo_body BIT(1) NULL,
    CONSTRAINT pk_truck PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS vehicle
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    brand           VARCHAR(255)          NULL,
    year            INT                   NOT NULL,
    fuel_type       VARCHAR(255)          NULL,
    base_price      DOUBLE                NULL,
    total_price     DOUBLE                NULL,
    vehicle_sale_id BIGINT                NULL,
    CONSTRAINT pk_vehicle PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS vehicle_buyer
(
    id      BIGINT AUTO_INCREMENT NOT NULL,
    name    VARCHAR(255)          NULL,
    address VARCHAR(255)          NULL,
    phone   VARCHAR(255)          NULL,
    CONSTRAINT pk_vehicle_buyer PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS vehicle_sale
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    purchase_date    datetime              NULL,
    vehicle_buyer_id BIGINT                NULL,
    total_cost       DOUBLE                NOT NULL,
    CONSTRAINT pk_vehicle_sale PRIMARY KEY (id)
);

ALTER TABLE car
    ADD CONSTRAINT FK_CAR_ON_ID FOREIGN KEY (id) REFERENCES vehicle (id);

ALTER TABLE motorcycle
    ADD CONSTRAINT FK_MOTORCYCLE_ON_ID FOREIGN KEY (id) REFERENCES vehicle (id);

ALTER TABLE truck
    ADD CONSTRAINT FK_TRUCK_ON_ID FOREIGN KEY (id) REFERENCES vehicle (id);

ALTER TABLE vehicle
    ADD CONSTRAINT FK_VEHICLE_ON_VEHICLE_SALE FOREIGN KEY (vehicle_sale_id) REFERENCES vehicle_sale (id);

ALTER TABLE vehicle_sale
    ADD CONSTRAINT FK_VEHICLE_SALE_ON_VEHICLE_BUYER FOREIGN KEY (vehicle_buyer_id) REFERENCES vehicle_buyer (id);