package entity;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Check(constraints = "mark > 0 AND mark <= 5")
public class Result extends BaseEntity implements Serializable {
    @Column(nullable = false)
    private Boolean commision1;
    @Column(nullable = false)
    private Boolean commision2;
    @Column(nullable = false)
    private Integer mark;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;


    public Boolean getCommision1() {
        return commision1;
    }

    public void setCommision1(Boolean commision1) {
        this.commision1 = commision1;
    }

    public Boolean getCommision2() {
        return commision2;
    }

    public void setCommision2(Boolean commision2) {
        this.commision2 = commision2;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    @Override
    public String toString() {
        return String.format("Result : id = %d, student = %d, exam = %s, mark = %d, commision1 = %b,  commision2 = %b",
                getId(), student.getIdentical_number(), exam.getSubject(),mark, commision1, commision2);
    }
}
