package erik.main.repository;

import erik.main.entity.client;
import erik.main.entity.reservation;
import erik.main.repository.CrudRepositories.reservationCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.ArrayList;
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

    public  List<reservation> findAllStatus(String status)
    {
        return resvRp.findAllByStatus(status);
    }

    public  List<reservation>  findAllByDates(Date d1, Date d2){
        return  resvRp.findAllByStartDateAfterAndStartDateBefore(d1,d2);
    }

    public List<clientCounter> getTopClient(){
        List<clientCounter> ls = new ArrayList<>();
        List<Object[]> report = resvRp.countOfTotalClientByReservation();
        for (int i = 0;i< report.size();i++){
            ls.add(new clientCounter((Long)report.get(i)[1],(client) report.get(i)[0]));
        }
        return  ls;
    }


  }
