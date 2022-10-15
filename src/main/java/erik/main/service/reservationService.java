package erik.main.service;

import erik.main.entity.reservation;
import erik.main.repository.clientCounter;
import erik.main.repository.reservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
                if(c.getStartDate()!=null){
                    Co.get().setStartDate(c.getDevolutionDate());
                }
                if(c.getDevolutionDate()!=null){
                    Co.get().setDevolutionDate(c.getDevolutionDate());
                }
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

    public statusService  getStatusReport(){
        List<reservation> completed = resvRp.findAllStatus("completed");
        List<reservation> cancelled = resvRp.findAllStatus("canceled");

        return new statusService(completed.size(),cancelled.size());
    }

    public  List<reservation> timeReservationInform(String d1, String d2){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();

        try {
           a = parser.parse(d1);
           b = parser.parse(d2);
        }catch (ParseException e){
            e.printStackTrace();
        }
        if (a.before(b)){
            return resvRp.findAllByDates(a,b);
        }else{
            return new ArrayList<>();
        }
    }

    public List<clientCounter> getTopClient(){
           return resvRp.getTopClient();
    }
}
