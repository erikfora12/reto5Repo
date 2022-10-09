package erik.main.controller;


import erik.main.entity.reservation;
import erik.main.service.reservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
