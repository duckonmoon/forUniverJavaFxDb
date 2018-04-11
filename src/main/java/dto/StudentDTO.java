package dto;

public class StudentDTO {
    private Boolean expelled;
    private String name;
    private String surname;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
}
