package entity;

import org.hibernate.annotations.Check;

import javax.persistence.*;

@Entity
@Check(constraints = "mark > 0 AND mark <= 5")
public class Result extends BaseEntity {
    @Column(nullable = false)
    private Boolean commision1;
    @Column(nullable = false)
    private Boolean commision2;
    @Column(nullable = false)
    private Integer mark;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;

}
