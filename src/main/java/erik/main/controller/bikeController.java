package erik.main.controller;

import erik.main.entity.bike;
import erik.main.entity.category;
import erik.main.service.bikeService;
import erik.main.service.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
