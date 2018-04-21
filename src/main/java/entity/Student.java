package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@NamedStoredProcedureQuery(
        name="GetAllExpelledStudent",
        procedureName="GetAllExpelledStudent",
        resultClasses = { Student.class },
        parameters={
                @StoredProcedureParameter(name="exp", type=Boolean.class, mode=ParameterMode.IN)
        }
)
@Entity
public class Student extends BaseEntity implements Serializable {
    private Boolean expelled;
    private String name;
    private String surname;
    @Column(unique = true)
    private Long identical_number;
    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "student",orphanRemoval = true)
    private Set<Result> results;

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

    public Set<Result> getResults() {
        return results;
    }

    public void setResults(Set<Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return String.format("Student : id = %d, name = %s, surname = %s, identical number = %s, is Expelled = %b", getId(), name, surname, identical_number, expelled);
    }
}
