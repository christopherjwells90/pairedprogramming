--START TRANSACTION;

-- DROP TABLE IF EXISTS pet;
-- DROP TABLE IF EXISTS owner;
-- DROP TABLE IF EXISTS procedure;
-- DROP TABLE IF EXISTS invoice;

CREATE TABLE procedure (
    procedure_id serial,
    procedure_name varchar(100) NOT NULL,
    constraint pk_procedure primary key (procedure_id)
);
CREATE TABLE pet 
(
    pet_id serial,
    procedure_id int NOT NULL,
    pet_name varchar(50) NOT NULL,
    pet_type varchar(50) NOT NULL,
    pet_age int NOT NULL,

    constraint pk_pet primary key (pet_id),
    constraint fk_pet_procedure FOREIGN KEY (procedure_id) REFERENCES procedure (procedure_id)
);
CREATE TABLE owner (
    customer_id serial,
    pet_id int NOT NULL,
    first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    address varchar(50) NOT NULL,
    zipcode char(6), 
    constraint pk_owner primary key (customer_id),
    constraint fk_owner_pet FOREIGN KEY (pet_id) REFERENCES pet (pet_id)
);
CREATE TABLE invoice (
    invoice_id serial,
    procedure_id int NOT NULL,
    pet_id int NOT NULL,
    customer_id int NOT NULL,
    visit_date date NOT NULL,
    constraint pk_invoice primary key (invoice_id),
    constraint fk_invoice_procedure FOREIGN KEY (procedure_id) REFERENCES procedure (procedure_id),
    constraint fk_invoice_pet FOREIGN KEY (pet_id) REFERENCES pet (pet_id),
    constraint fk_invoice_owner FOREIGN KEY (customer_id) REFERENCES owner (customer_id)
);



--ROLLBACK;