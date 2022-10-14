package erik.main.service;

import erik.main.entity.message;
import erik.main.repository.messageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class messageService {
    @Autowired
    messageRepository msgRp;


    public List<message> getAll(){
        return msgRp.getAll();
    }

    public message save(message c){
        if(c.getIdMessage() == null){
            return msgRp.save(c);
        }else{
            Optional<message> Co = msgRp.find(c.getIdMessage());
            if (Co.isPresent()){
                return c;
            }else{
                return msgRp.save(c);
            }
        }

    }

    public message Update(message c) {
        if (c.getIdMessage() != null) {
            Optional<message> Co = msgRp.find(c.getIdMessage());
            if(Co.isPresent()){
                if(c.getMessageText()!=null){
                    Co.get().setMessageText(c.getMessageText());
                }

                msgRp.save(Co.get());
                return Co.get();
            }else{ return c; }
        }else{ return c; }
    }

    public  boolean delete(int id){
        boolean flag =false;
        Optional <message> c = msgRp.find(id);

        if (c.isPresent()) {
            msgRp.delete(id);
            flag =true;
        }

        return  flag;
    }
}
