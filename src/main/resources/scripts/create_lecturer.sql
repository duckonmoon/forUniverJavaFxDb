CREATE TABLE lecturer
(
    id bigint NOT NULL auto_increment,
    name varchar(255),
    surname varchar(255),
	PRIMARY KEY (id)
);

CREATE INDEX lectur
    ON lecturer 
    (name, surname);