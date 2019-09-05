USE carfleet;

CREATE TABLE public.cars
(
    car_model text NOT NULL,
    manufacture_year bigint NOT NULL,
    license_plate text NOT NULL,
    assignee text,
    CONSTRAINT license_plate_pkey PRIMARY KEY (license_plate)
)