package erik.main.repository;


import erik.main.entity.client;
import erik.main.repository.CrudRepositories.clientCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class clientRepository {
    @Autowired
    clientCrudRepository clientRp;

    public List<client> getAll(){ return(List<client>) clientRp.findAll();}
    public Optional<client> find(int id){ return (Optional<client>)clientRp.findById(id);}
    public  client save(client c) { return (client) clientRp.save(c);}
    public  void delete(int id){ clientRp.deleteById(id);}
}
