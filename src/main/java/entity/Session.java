package entity;

import org.hibernate.annotations.Check;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Check(constraints = "enddate >= startdate")
public class Session extends BaseEntity {
    @Column(name = "startdate")
    private Date startDate;

    @Column(name = "enddate")
    private Date endDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
