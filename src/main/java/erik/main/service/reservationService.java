package erik.main.service;

import erik.main.entity.reservation;
import erik.main.repository.reservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class reservationService {
    @Autowired
    reservationRepository resvRp;


    public List<reservation> getAll(){
        return resvRp.getAll();
    }

    public reservation save(reservation c){
        if(c.getIdReservation() == null){
            return resvRp.save(c);
        }else{
            Optional<reservation> Co = resvRp.find(c.getIdReservation());
            if (Co.isPresent()){
                return c;
            }else{
                return resvRp.save(c);
            }
        }

    }

    public reservation Update(reservation c) {
        if (c.getIdReservation() != null) {
            Optional<reservation> Co = resvRp.find(c.getIdReservation());
            if(Co.isPresent()){
                resvRp.save(Co.get());
                return Co.get();
            }else{ return c; }
        }else{ return c; }
    }

    public  boolean delete(int id){
        boolean flag =false;
        Optional <reservation> c = resvRp.find(id);

        if (c.isPresent()) {
            resvRp.delete(id);
            flag =true;
        }

        return  flag;
    }

}
