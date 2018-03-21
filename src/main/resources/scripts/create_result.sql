CREATE TABLE result
(
    id bigint NOT NULL auto_increment,
    commision1 boolean NOT NULL,
    commision2 boolean NOT NULL,
    mark integer NOT NULL,
    exam_id bigint,
    student_id bigint,
    PRIMARY KEY (id),
    foreign key (exam_id) references exam(id),
    foreign key (student_id) references student(id),
    CHECK (mark > 0 AND mark <= 5)
);