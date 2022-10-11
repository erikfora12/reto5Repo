package erik.main.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;


@Entity
@Table(name = "messages")
@JsonPropertyOrder({"IdMessage","messageText","bike","client"})
public class message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdMessage;
    private String  messageText;


    @ManyToOne (cascade = {CascadeType.MERGE})
    @JoinColumn(name = "bike")
    @JsonIgnoreProperties({"messages","reservations"})
    private  bike bike;


    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "client")
    @JsonIgnoreProperties({"messages","reservations"})
    private client client;

    public Integer getIdMessage() {
        return IdMessage;
    }

    public void setIdMessage(Integer idMessage) {
        IdMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public erik.main.entity.bike getBike() {
        return bike;
    }

    public void setBike(erik.main.entity.bike bike) {
        this.bike = bike;
    }

    public erik.main.entity.client getClient() {
        return client;
    }

    public void setClient(erik.main.entity.client client) {
        this.client = client;
    }
}
