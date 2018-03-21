CREATE TABLE session
(
    id bigint NOT NULL auto_increment,
    enddate date,
    startdate date,
	PRIMARY KEY (id),
	CHECK (enddate >= startdate)
)