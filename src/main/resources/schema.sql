CREATE TABLE public.pizzas
(
    id integer auto_increment PRIMARY KEY NOT NULL,
    name VARCHAR(50) NOT NULL,
    description varchar(100) NOT NULL,
    price double precision NOT NULL
);