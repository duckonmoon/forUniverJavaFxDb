DELIMITER //
CREATE PROCEDURE GetAllExpelledStudent(in exp boolean)
LANGUAGE SQL
DETERMINISTIC
  SQL SECURITY DEFINER
  BEGIN
    SELECT * FROM student where expelled = exp;
  END //