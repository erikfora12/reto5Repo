package erik.main.repository;

import erik.main.entity.bike;
import erik.main.repository.CrudRepositories.bikesCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class bikeRepository {
    @Autowired
    bikesCrudRepository BikesRp;
    public List<bike> getAll(){ return(List<bike>) BikesRp.findAll();}
    public Optional<bike> find(int id){ return (Optional<bike>)BikesRp.findById(id);}
    public bike save(bike c) { return (bike) BikesRp.save(c);}
    public  void delete(int id){ BikesRp.deleteById(id);}
}
