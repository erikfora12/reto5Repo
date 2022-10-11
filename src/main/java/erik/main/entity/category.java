package erik.main.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "category")
public class category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private  String name;
    private  String description;

    @OneToMany(cascade = {CascadeType.ALL})
    @JsonIgnoreProperties("category")
    private List<bike> bikes;


    public Integer getId() {
        return id;
    }

    public void setId(Integer categoryId) {
        this.id = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<bike> getBikes() {
        return bikes;
    }

    public void setBikes(List<bike> bikes) {
        this.bikes = bikes;
    }


}
