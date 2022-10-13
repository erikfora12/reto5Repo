package erik.main.controller;

import erik.main.entity.bike;
import erik.main.service.bikeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/Bike")
public class bikeController {
    @Autowired
    bikeService bikeServ;

    @GetMapping("/all")
    public List<bike> getAll(){
        return bikeServ.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public bike save(@RequestBody bike b){
        return  bikeServ.save(b);
    }
}
