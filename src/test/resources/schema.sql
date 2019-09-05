CREATE TABLE public.cars
(
    car_model VARCHAR(50) NOT NULL,
    manufacture_year INT NOT NULL,
    license_plate VARCHAR(20) NOT NULL,
    assignee VARCHAR(50),
    PRIMARY KEY (license_plate)
);