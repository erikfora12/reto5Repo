package erik.main.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservations")
public class reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer idReservation;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startDate;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date devolutionDate;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"messages","reservations"})
    private client client;



    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("bikes")
    private bike bike;

    private String score;

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public erik.main.entity.client getClient() {
        return client;
    }

    public void setClient(erik.main.entity.client client) {
        this.client = client;
    }

    public erik.main.entity.bike getBike() {
        return bike;
    }

    public void setBike(erik.main.entity.bike bike) {
        this.bike = bike;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
