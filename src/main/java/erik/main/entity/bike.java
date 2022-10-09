package erik.main.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bikes")
public class bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "year")
    private Integer year;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "category")
    @JsonIgnoreProperties("bikes")
    private category category;


    @Column(name = "name")
    private  String name;
    @Column(name = "description")
    private String description;

    @OneToMany(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "messages")
    @JsonIgnoreProperties("messages")
    private List<message> messages;

    @OneToMany(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "reservations")
    @JsonIgnoreProperties("reservations")
    private List<reservation> reservations;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer bikesId) {
        this.id = bikesId;
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

    public void setYear(Integer year) {
        this.year = year;
    }

    public erik.main.entity.category getCategory() {
        return category;
    }

    public void setCategory(erik.main.entity.category category) {
        this.category = category;
    }


}
