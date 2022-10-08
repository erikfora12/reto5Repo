package erik.main.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "bikes")
public class bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer bikesId;
    @Column(name = "brand")
    private String brand;
    @Column(name = "year")
    private Integer year;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "category")
    @JsonIgnoreProperties("bikes")
    private category category;


    public Integer getBikesId() {
        return bikesId;
    }

    public void setBikesId(Integer bikesId) {
        this.bikesId = bikesId;
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

    public erik.main.entity.category getCategory() {
        return category;
    }

    public void setCategory(erik.main.entity.category category) {
        this.category = category;
    }


}
