package entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Student extends BaseEntity {
    private Boolean expelled;
    private String name;
    private String surname;
    @Column(unique = true)
    private Long identical_number;

    public Boolean getExpelled() {
        return expelled;
    }

    public void setExpelled(Boolean expelled) {
        this.expelled = expelled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getIdentical_number() {
        return identical_number;
    }

    public void setIdentical_number(Long identical_number) {
        this.identical_number = identical_number;
    }
}
