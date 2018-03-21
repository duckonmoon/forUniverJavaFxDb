CREATE TABLE student
(
    id bigint NOT NULL auto_increment,
    expelled boolean NOT NULL,
    name varchar(255),
    surname varchar(255),
    identical_number integer,
	PRIMARY KEY (id),
    UNIQUE (identical_number)
);

CREATE INDEX stud
    ON student
    (name, surname);