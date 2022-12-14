package erik.main.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bikes")
public class bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private  String name;
    private String brand;
    private Integer year;

    private String description;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "category")
    @JsonIgnoreProperties("bikes")
    private category category;


    @OneToMany(cascade = {CascadeType.MERGE},mappedBy = "bike")
    @JsonIgnoreProperties({"bike","client"})
    private List<message> messages;

    @OneToMany(cascade = {CascadeType.MERGE})
    @JsonIgnoreProperties("bike")
    private List<reservation> reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public erik.main.entity.category getCategory() {
        return category;
    }

    public void setCategory(erik.main.entity.category category) {
        this.category = category;
    }

    public List<message> getMessages() {
        return messages;
    }

    public void setMessages(List<message> messages) {
        this.messages = messages;
    }

    public List<reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<reservation> reservations) {
        this.reservations = reservations;
    }
}
