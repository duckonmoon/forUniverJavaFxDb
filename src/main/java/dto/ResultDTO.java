package dto;

import java.io.Serializable;

public class ResultDTO implements Serializable {
    private Boolean commision1;

    private Boolean commision2;

    private Integer mark;

    private Long student;

    private String exam;

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Long getStudent() {
        return student;
    }

    public void setStudent(Long student) {
        this.student = student;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }
}
