package dto;

import java.io.Serializable;
import java.util.Date;

public class ExamDTO implements Serializable {
    private Date endSession;

    private Date startSession;

    private String lecturer;

    private Date date;

    private String subject;

    private Integer id;

    public Date getEndSession() {
        return endSession;
    }

    public void setEndSession(Date endSession) {
        this.endSession = endSession;
    }

    public Date getStartSession() {
        return startSession;
    }

    public void setStartSession(Date startSession) {
        this.startSession = startSession;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
