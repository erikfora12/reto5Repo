package erik.main.entity;


import javax.persistence.*;

@Entity
@Table(name = "messages")
public class message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdMessage;
    private String  messageText;



}
