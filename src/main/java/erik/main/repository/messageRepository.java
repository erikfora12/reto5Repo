package erik.main.repository;

import erik.main.entity.message;
import erik.main.repository.CrudRepositories.messageCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class messageRepository {

    @Autowired
    messageCrudRepository msgRp;

    public List<message> getAll(){ return(List<message>) msgRp.findAll();}
    public Optional<message> find(int id){ return (Optional<message>) msgRp.findById(id);}
    public  message save(message c) { return (message) msgRp.save(c);}
    public  void delete(int id){ msgRp.deleteById(id);}

}
