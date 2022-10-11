package erik.main.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


@Entity
@Table(name = "messages")
public class message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdMessage;

    private String  messageText;



    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties("client")
    private client client;


    @ManyToOne (cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("bikes")
    private  bike bike;






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
