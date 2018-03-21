CREATE TABLE exam
(
    id bigint NOT NULL auto_increment,
    date datetime,
    subject varchar(255),
    lecturer_id bigint,
    session_id bigint,
    PRIMARY KEY (id),
    FOREIGN KEY (lecturer_id)
        REFERENCES lecturer (id)
        ON DELETE CASCADE,
    FOREIGN KEY (session_id)
        REFERENCES session (id)
        ON DELETE CASCADE
);

CREATE INDEX sess
    ON exam
    (date, subject);