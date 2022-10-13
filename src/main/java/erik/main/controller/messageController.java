package erik.main.controller;


import erik.main.entity.category;
import erik.main.entity.message;
import erik.main.service.messageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*",maxAge = 600)
@RestController
@RequestMapping("api/Message")
public class messageController {

    @Autowired
    messageService msgSvc;

    @GetMapping("/all")
    public List<message> getAll(){
        return msgSvc.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public message save(@RequestBody message c){
        return  msgSvc.save(c);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public message update(@RequestBody message c){
        return  msgSvc.Update(c);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id){
        msgSvc.delete(id);
    }

}
