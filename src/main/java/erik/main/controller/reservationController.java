package erik.main.controller;


import erik.main.entity.category;
import erik.main.entity.reservation;
import erik.main.repository.clientCounter;
import erik.main.service.reservationService;

import erik.main.service.statusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*",maxAge = 600)
@RestController
@RequestMapping("api/Reservation")
public class reservationController {
    @Autowired
    reservationService reservServ;

    @GetMapping("/all")
    public List<reservation> getAll(){
        return reservServ.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public reservation save(@RequestBody reservation b){
        return  reservServ.save(b);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public reservation update(@RequestBody reservation c){
        return  reservServ.Update(c);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id){
        reservServ.delete(id);
    }

    @GetMapping("/report-clients")
    public  List<clientCounter>getReservationsReportClients(){
            return reservServ.getTopClient();
    }
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public  List<reservation> getReservationReportDates(@PathVariable("dateOne")String dateOne,@PathVariable("dateTwo")String dateTwo){
           return  reservServ.timeReservationInform(dateOne,dateTwo);
    }
    @GetMapping("/report-status")
    public statusService getStatusReport(){
        return  reservServ.getStatusReport();
    }
}
