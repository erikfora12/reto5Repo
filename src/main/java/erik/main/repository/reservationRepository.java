package erik.main.repository;

import erik.main.entity.reservation;
import erik.main.repository.CrudRepositories.reservationCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class reservationRepository {
    @Autowired
    reservationCrudRepository resvRp;

    public List<reservation> getAll(){ return(List<reservation>) resvRp.findAll();}
    public Optional<reservation> find(int id){ return (Optional<reservation>) resvRp.findById(id);}
    public  reservation save(reservation c) { return (reservation) resvRp.save(c);}
    public  void delete(int id){ resvRp.deleteById(id);}
}
