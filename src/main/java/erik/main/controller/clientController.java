package erik.main.controller;

import erik.main.entity.category;
import erik.main.entity.client;
import erik.main.service.clientSevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*",maxAge = 600)
@RestController
@RequestMapping("api/Client")
public class clientController {

    @Autowired
    clientSevice cliServ;

    @GetMapping("/all")
    public List<client> getAll(){
        return cliServ.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public client save(@RequestBody client c){
        return  cliServ.save(c);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public client update(@RequestBody client c){
        return  cliServ.Update(c);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id){
        cliServ.delete(id);
    }

}
