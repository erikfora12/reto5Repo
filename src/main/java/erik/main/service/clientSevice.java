package erik.main.service;

import erik.main.entity.client;
import erik.main.repository.clientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class clientSevice {
    @Autowired
    clientRepository clientRp;

    public List<client> getAll(){
        return clientRp.getAll();
    }

    public client save(client c){
        if(c.getIdClient() == null){
            return clientRp.save(c);
        }else{
            Optional<client> Co = clientRp.find(c.getIdClient());
            if (Co.isPresent()){
                return c;
            }else{
                return clientRp.save(c);
            }
        }

    }

    public client Update(client c) {
        if (c.getIdClient() != null) {
            Optional<client> Co = clientRp.find(c.getIdClient());
            if(Co.isPresent()){
                if(c.getName()!=null){
                    Co.get().setName(c.getName());
                }
                if(c.getAge()!=null){
                    Co.get().setAge(c.getAge());
                }
                if(c.getEmail()!=null){
                    Co.get().setEmail(c.getEmail());
                }
                if(c.getPassword()!=null){
                    Co.get().setPassword(c.getPassword());
                }
                clientRp.save(Co.get());
                return Co.get();
            }else{ return c; }
        }else{ return c; }
    }

    public  boolean delete(int id){
        boolean flag =false;
        Optional <client> c = clientRp.find(id);

        if (c.isPresent()) {
            clientRp.delete(id);
            flag =true;
        }

        return  flag;
    }

}
